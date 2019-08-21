/**
 * BrandBigData.com Inc. 
 * Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion.string;

/**
 *
 *
 *
 * @author wangcong
 * @version $Id: VowelCounter.java, v0.1 8/21/19 4:28 PM wangcong Exp $$
 */
public class VowelCounter {


    public static void countCharacterType(String word) {

        int vowels = 0, consonant = 0, specialChar = 0, digit = 0;

        for (int i = 0; i < word.length(); i++) {

            char ch = word.charAt(i);

            if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                ch = Character.toLowerCase(ch);

                if (ch == 'a' || ch == 'e' || ch == 'i' ||
                        ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    consonant++;
                }

            } else if (ch >= '0' && ch <= '9') {
                digit++;
            } else {
                specialChar++;
            }

        }

        System.out.println("Vowels: " + vowels);
        System.out.println("Consonant: " + consonant);
        System.out.println("Digit: " + digit);
        System.out.println("Special Character: " + specialChar);

    }


    public static void main(String[] args) {

        String str = "geeks for geeks121";
        countCharacterType(str);

    }


}
