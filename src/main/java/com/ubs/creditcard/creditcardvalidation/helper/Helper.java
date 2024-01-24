package com.ubs.creditcard.creditcardvalidation.helper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Helper {

    /**
     * adding a private constructor to avoid it being instantiated
     */
    private Helper(){

    }

    /**
     * Verify if the entered value is 16 digit long
     * @param input
     * @return true or false based on the validation
     */
    public static boolean isSixteenDigitInput(String input) {
        return input != null && input.matches("\\d{16}");
    }

    /**
     * Removes any non numeric characters from the credit card example: spaces and hypen
     * @param creditCardNumber
     * @return valid 16 digit credit card number with no space or spl character
     */
    public static String getCleanedNumber(String creditCardNumber) {
        String cleanedNumber = creditCardNumber.replaceAll("[^\\d]", "");
        return cleanedNumber;
    }

    /**
     * Verifies if the credit card is entered either in xxxx xxxx xxxx xxxx or xxxx-xxxx-xxxx-xxxx format
     * @param creditCardNumber
     * @return true or false
     */
    public static boolean isCreditCardNumberInCorrectFormat(String creditCardNumber) {
        // Define a regular expression pattern for a generic credit card number
        String pattern = "^(\\d{4}[\\s-]){3}\\d{4}$";

        // Check if the credit card number matches the pattern
        return creditCardNumber.matches(pattern);
    }
}
