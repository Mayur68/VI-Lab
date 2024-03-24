/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package parta4;

/**
 *
 * @author mayur
 */
public class PartA4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String input = "Hello Jithu47 good morning";
        System.out.println("Original string: " + input);

        String manipulatedString = manipulateString(input);
        System.out.println("Manipulated string: " + manipulatedString);
    }

    public static String manipulateString(String input) {
        StringBuilder result = new StringBuilder();
        String[] words = input.split("\\s+");

        for (String word : words) {
            if (word.length() % 2 == 0) {
                result.append(swapPairs(word)).append(" ");
            } else {
                result.append(toggleCase(word)).append(" ");
            }
        }

        return result.toString().trim();
    }

    public static String swapPairs(String word) {
        StringBuilder swappedWord = new StringBuilder();
        for (int i = 0; i < word.length() - 1; i += 2) {
            swappedWord.append(word.charAt(i + 1)).append(word.charAt(i));
        }
        if (word.length() % 2 != 0) {
            swappedWord.append(word.charAt(word.length() - 1));
        }
        return swappedWord.toString();
    }

    public static String toggleCase(String word) {
        StringBuilder toggledWord = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (Character.isUpperCase(c)) {
                toggledWord.append(Character.toLowerCase(c));
            } else if (Character.isLowerCase(c)) {
                toggledWord.append(Character.toUpperCase(c));
            } else {
                toggledWord.append(c);
            }
        }
        return toggledWord.toString();
    }

}
