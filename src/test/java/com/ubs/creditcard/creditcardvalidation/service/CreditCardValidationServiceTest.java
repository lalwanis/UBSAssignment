package com.ubs.creditcard.creditcardvalidation.service;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static com.ubs.creditcard.creditcardvalidation.helper.ValidationMessage.IN_VALID_MESSAGE;
import static com.ubs.creditcard.creditcardvalidation.helper.ValidationMessage.VALID_MESSAGE;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CreditCardValidationServiceTest {

    @Autowired
    private CreditCardValidationService creditCardValidationService;


    private String validCardNumberWithNoSpace= "5555555555554444";

    private String inValidCardNumberWithSpace = "1234 5678 9012 3456";

    private String invalidWithSpecialCharacter = "D%£DW fFDRERE";

    @Test
    void validateCreditCardUsingLuhnAlgoWithValidCard() {
        String output = creditCardValidationService.validateCreditCardUsingLuhnAlgo(validCardNumberWithNoSpace);
        assertEquals(output,VALID_MESSAGE);
    }

    @Test
    void validateCreditCardUsingLuhnAlgoWithInValidCard() {
        String output = creditCardValidationService.validateCreditCardUsingLuhnAlgo(inValidCardNumberWithSpace);
        assertEquals(output,IN_VALID_MESSAGE);
    }

    @Test
    void validateCreditCardUsingLuhnAlgoWithInValidAndJunkChar() {
        String output = creditCardValidationService.validateCreditCardUsingLuhnAlgo(invalidWithSpecialCharacter);
        assertEquals(output,IN_VALID_MESSAGE);
    }
}