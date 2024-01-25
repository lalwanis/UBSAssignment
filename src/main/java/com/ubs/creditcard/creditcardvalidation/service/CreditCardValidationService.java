package com.ubs.creditcard.creditcardvalidation.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.ubs.creditcard.creditcardvalidation.helper.ValidationMessage.IN_VALID_MESSAGE;
import static com.ubs.creditcard.creditcardvalidation.helper.ValidationMessage.VALID_MESSAGE;

@Service
@Slf4j
public class CreditCardValidationService {


    /**
     * This method uses Luhn's Algorithm to verify if the credit card number is valid
     * @param creditCardNumber
     * @return Validated Message
     */
    public String validateCreditCardUsingLuhnAlgo(String creditCardNumber) {

        log.info("entering validateCreditCardUsingLuhnAlgo to verify card "+creditCardNumber);
        // Reverse the cleaned number
        String reversedNumber = new StringBuilder(creditCardNumber).reverse().toString();
        int sum = 0;
        for (int i = 0; i < reversedNumber.length(); i++) {
            int digit = Character.getNumericValue(reversedNumber.charAt(i));

            // Double every second digit
            if (i % 2 == 1) {
                digit *= 2;

                // Instead of adding the two digits if > 9 we can subtract 9 from the number to get the same result
                if (digit > 9) {
                    digit -= 9;
                }
            }

            sum += digit;
        }

        // The number is valid if the sum is a multiple of 10
        if (sum % 10 == 0) {
            return VALID_MESSAGE;
        } else {
            return IN_VALID_MESSAGE;
        }
    }


}

