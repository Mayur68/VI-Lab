/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package parta4;

/**
 *
 * @author mayur
 */
import java.util.Scanner;

public class PartA4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string:");
        String input = sc.nextLine();
        String swappedString = swapPairsInEvenWords(input);
        System.out.println("Swapped string: " + swappedString);
        String toggledString = toggleCharacters(input);
        System.out.println("Toggled string: " + toggledString);
        sc.close();
    }

    public static String swapPairsInEvenWords(String input) {
        StringBuilder result = new StringBuilder();
        String[] words = input.split("\\s+");
        for (String word : words) {
            if (word.length() % 2 == 0) {
                StringBuilder swappedWord = new StringBuilder();
                for (int i = 0; i < word.length() - 1; i += 2) {
                    swappedWord.append(word.charAt(i + 1)).append(word.charAt(i));
                }
                word = swappedWord.toString();
                result.append(word).append(" ");
            }
        }
        return result.toString().trim();
    }

    public static String toggleCharacters(String input) {
        StringBuilder result = new StringBuilder();
        for (char ch : input.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                result.append(Character.toUpperCase(ch));
            } else if (Character.isUpperCase(ch)) {
                result.append(Character.toLowerCase(ch));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }
}
