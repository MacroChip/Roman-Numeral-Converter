package com.thien.romanconverter;

import java.io.File;
import java.util.Scanner;
import java.util.regex.*;

/**
 * A program to convert from Arabic numbers to Roman numerals and from Roman numerals to Arabic numbers.
 *
 */
public class RomanConverter {

    public static final int ARABIC_MAX = 3999;
    public static final int ARABIC_MIN = 1;

    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            final File input = new File(args[0]);
            scanner = new Scanner(input);
        } catch (Exception e) {
            System.out.println("File not found.");
            System.exit(1);
        }
        String nextLine = "";
        //regexes to distinguish Roman numerals from Arabic. Instructions state that input is valid, but I do check the Arabic range
        Pattern roman = Pattern.compile("^[IVXLCDM]*$");
        Pattern arabic = Pattern.compile("^\\d*$");
        while(scanner.hasNextLine()) {
            String converted = "";
            nextLine = scanner.nextLine();
            Matcher romanMatcher = roman.matcher(nextLine);
            Matcher arabicMatcher = arabic.matcher(nextLine);
            if (romanMatcher.matches()) {
                converted = "" + RomanNumeral.toArabic(nextLine);
            } else if (arabicMatcher.matches() && Integer.parseInt(nextLine) <= ARABIC_MAX && Integer.parseInt(nextLine) >= ARABIC_MIN) {
                converted = ArabicNumeral.toRoman(Integer.parseInt(nextLine));
            } else {
                converted = "Invalid input";
            }
            System.out.println(converted);
        }
        scanner.close();
    }
}
