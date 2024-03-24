/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package parta2;

import java.util.*;

/**
 *
 * @author mayur
 */
public class PartA2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        System.out.println("Enter the number of elemets");
        int n = scr.nextInt();

        List<Integer> numbers = new ArrayList<>();

        System.out.println("Enter the elemets");
        for (int i = 0; i < n; i++) {
            numbers.add(scr.nextInt());
        }

        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;

        for (Integer number : numbers) {
            if (number > max) {
                secondMax = max;
                max = number;
            } else if (number > secondMax && number != max) {
                secondMax = number;
            }

            if (number < min) {
                secondMin = min;
                min = number;
            } else if (number < secondMin && number != min) {
                secondMin = number;
            }
        }

        System.out.println("Second Maximum: " + secondMax);
        System.out.println("Second Minimum: " + secondMin);

        scr.close();
    }

}
