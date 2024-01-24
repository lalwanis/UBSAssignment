package com.ubs.creditcard.creditcardvalidation.controller;

import com.ubs.creditcard.creditcardvalidation.service.CreditCardValidationService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ubs.creditcard.creditcardvalidation.helper.Helper.*;

@RestController
@RequestMapping("/validation")
@Slf4j
public class ValidationController {

    @Autowired
    CreditCardValidationService creditCardValidationService;

    /**
     * Validating  bunch of cards
     * @param cards
     * @return Map of Card with validated Message
     */
    @PostMapping(path = "/cards", produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String,String> checkCardNumber(@RequestBody List<String> cards) {
        log.info("validating all the  cards");
        Map<String,String> cardWithCheckedStatus = new HashMap<>();
        if(cards!=null) {
            cards.forEach(
                    c-> {
                        String checkedStatus = getValidation(c);
                        cardWithCheckedStatus.putIfAbsent(c,checkedStatus);
                    }
            );
        }
        return cardWithCheckedStatus;
    }


    /**
     * Validating one card at a time
     * @param inputCard
     * @return Validated Message
     */
    @GetMapping(path = "/card={card}", produces= MediaType.ALL_VALUE)
    @ResponseBody
    public String checkCardNumber(@PathVariable("card") String inputCard) {

        String validation = getValidation(inputCard);
        if (validation == null)
            return "Error: Enter 16 digit Credit Card Number in xxxx xxxx xxxx xxxx or xxxx-xxxx-xxxx-xxxx  or xxxxxxxxxxxxxxxx format";

        return validation;
    }

    /**
     * Validates the card using Luhn's algorithm
     * @param inputCard
     * @return validation message
     */
    private String getValidation(String inputCard) {
        log.info("Card to validate:"+ inputCard);
        inputCard = inputCard !=null? inputCard.trim():"";

        //Check if it is a valid creditcard number format with number and space or -  or just the number only
        if(!( isCreditCardNumberInCorrectFormat(inputCard) || isSixteenDigitInput(inputCard))){
            return null;
        }

        // Remove spaces and non-digit characters
        String cleanedNumber = getCleanedNumber(inputCard);

        log.info("cleaned and formatted card number :"+ cleanedNumber);

        String validation = creditCardValidationService.validateCreditCardUsingLuhnAlgo(cleanedNumber);
        return validation;
    }


}
