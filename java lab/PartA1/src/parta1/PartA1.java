/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parta1;

import java.util.Scanner;

/**
 *
 * @author mayur
 */
public class PartA1 {

    private enum Units {
        ZERO(""), ONE("ONE"), TWO("TWO"), THREE("THREE"), FOUR("FOUR"), FIVE("FIVE"), SIX("SIX"),
        SEVEN("SEVEN"), EIGHT("EIGHT"), NINE("NINE");
        private final String word;

        Units(String word) {
            this.word = word;
        }

        public String getWord() {
            return word;
        }
    }

    private enum Teens {
        TEN("TEN"), ELEVEN("ELEVEN"), TWELVE("TWELVE"), THIRTEEN("THIRTEEN"),
        FOURTEEN("FOURTEEN"),
        FIFTEEN("FIFTEEN"), SIXTEEN("SIXTEEN"), SEVENTEEN("SEVENTEEN"), EIGHTEEN("EIGHTEEN"),
        NINETEEN("NINETEEN");
        private final String word;

        Teens(String word) {
            this.word = word;
        }

        public String getWord() {
            return word;
        }
    }

    private enum Tens {
        TWENTY("TWENTY"), THIRTY("THIRTY"), FORTY("FORTY"), FIFTY("FIFTY"), SIXTY("SIXTY"),
        SEVENTY("SEVENTY"), EIGHTY("EIGHTY"), NINETY("NINETY");
        private final String word;

        Tens(String word) {
            this.word = word;
        }

        public String getWord() {
            return word;
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter the number:");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        System.out.println(convertToWords(number));
    }

    public static String convertToWords(int number) {
        if (number == 0) {
            return "ZERO";
        }
        if (number < 0 || number > 99999) {
            return "Number out of range";
        }
        String word = "";
        if (number / 1000 > 0) {
            word += convertToWords(number / 1000) + " THOUSAND ";
            number %= 1000;
        }
        if (number / 100 > 0) {
            word += Units.values()[number / 100].getWord() + " HUNDRED ";
            number %= 100;
        }
        if (number >= 20) {
            word += Tens.values()[(number / 10) - 2].getWord() + " ";
            number %= 10;
        } else if (number >= 10) {
            word += Teens.values()[number - 10].getWord() + " ";
            number = 0;
        }
        if (number > 0) {
            word += Units.values()[number].getWord();
        }
        return word.trim();
    }
}
