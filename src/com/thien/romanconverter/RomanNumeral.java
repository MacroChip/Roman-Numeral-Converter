package com.thien.romanconverter;

import org.junit.Test;

/**
 * Facilitates conversion from a Roman numeral to an Arabic number
 *
 * This class functions similar to Integer or Float, in that it has a useful static method for the purpose of the exercise
 */
public class RomanNumeral {
    /**
     * Turns a Roman numeral to an Arabic number
     * @param roman the Roman numeral that is to be converted into an Arabic number
     * @return the Arabic representation of the Roman numeral
     */
    public static int toArabic(String roman) {
        int answer = 0;

        int previousValue = Integer.MAX_VALUE; //arbitrary. Anything larger than 1000 works.
        for(int i = 0; i < roman.length(); i++) {
            char letter = roman.charAt(i);
            int value = charValue(letter);

            //the previous letter was smaller, thus readjust for subtraction
            if (previousValue < value) {
                value -= previousValue;       //delete me
                answer -= previousValue;
                answer += value;                       //change to answer += value - previous value
            }
            //add otherwise
            else {
                answer += value;
            }
            previousValue = value;
        }
        return answer;
    }

    /**
     * Helper method to turn a Roman character into its base 10 Arabic value
     * @param letter the Roman character
     * @return the Arabic value
     */
    private static int charValue(char letter) {
        switch (letter) {
            case 'M': return 1000;
            case 'D': return 500;
            case 'C': return 100;
            case 'L': return 50;
            case 'X': return 10;
            case 'V': return 5;
            case 'I': return 1;
            default: return 0;
        }
    }

    @Test
    public void testRomanConversion() {
        assert toArabic("I") == 1;
        assert toArabic("XCIX") == 99;
        assert toArabic("C") == 100;
        assert toArabic("CDXCIX") == 499;
        assert toArabic("DI") == 501;
        assert toArabic("MMMCMXCIX") == 3999;
    }
}
