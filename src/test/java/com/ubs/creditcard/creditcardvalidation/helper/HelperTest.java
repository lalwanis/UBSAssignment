package com.ubs.creditcard.creditcardvalidation.helper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class HelperTest {

        private String validCardNumberWithSpace="5555 5555 5555 4444";
        private String validCardNumberWithHypen= "5555-5555-5555-4444";
        private String validCardNumberWithNoSpace= "5555555555554444";

        private String inValidCardNumberWithSpace = "1234 5678 9012 3456";
        private String inValidCardNumberWithHypen = "1234-5678-9012-3456";
        private String inValidCardNumberWithNoSpace = "1234567890123456";

        private String invalidWithSpecialCharacter = "D%£DW fFDRERE";


    @Test
    void getCleanedNumberWithNoSpace() {
        String output = Helper.getCleanedNumber(validCardNumberWithNoSpace);
        assertEquals(output,validCardNumberWithNoSpace);
    }

    @Test
    void getCleanedNumberWithSpace() {
        String output = Helper.getCleanedNumber(validCardNumberWithSpace);
        assertEquals(output,validCardNumberWithNoSpace);
    }

    @Test
    void getCleanedNumberWithInvalidCard() {
        String output = Helper.getCleanedNumber(inValidCardNumberWithHypen);
        assertEquals(output,inValidCardNumberWithNoSpace);
    }

    @Test
    void getCleanedNumberWithSpecialCharacter() {
        String output = Helper.getCleanedNumber(invalidWithSpecialCharacter);
        assertEquals(output,"");
    }

    @Test
    void getCleanedNumberWithHypen() {
        String output = Helper.getCleanedNumber(validCardNumberWithHypen);
        assertEquals(output,validCardNumberWithNoSpace);
    }

    @Test
    void isValidCreditCardFormatWithInvalidCardWithSpace() {
        boolean output = Helper.isCreditCardNumberInCorrectFormat(inValidCardNumberWithSpace);
        assertTrue(output);
    }

    @Test
    void isValidCreditCardFormatWithValidCardWithSpace() {
        boolean output = Helper.isCreditCardNumberInCorrectFormat(validCardNumberWithSpace);
        assertTrue(output);
    }

    @Test
    void isValidCreditCardFormatWithSpecialCharacter() {
        boolean output = Helper.isCreditCardNumberInCorrectFormat(invalidWithSpecialCharacter);
        assertFalse(output);
    }
}