/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package parta3;

import java.util.*;

/**
 *
 * @author mayur
 */
public class PartA3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Scanner scr = new Scanner(System.in);
        while (true) {
            System.out.println("MENU");
            System.out.println("1. ADD ELEMENT");
            System.out.println("2. SORT ELEMENT");
            System.out.println("3. REPLACE AN ELEMENT");
            System.out.println("4. REMOVE AN ELEMENT");
            System.out.println("5. DISPLAY ALL ELEMENT");
            System.out.println("7. EXIT");
            System.out.println("choose an operation");

            int choice = scr.nextInt();

            switch (choice) {
                case 1:
                    addElement(arrayList, scr);
                    break;
                case 2:
                    sortElement(arrayList, scr);
                    break;
                case 3:
                    replaceElement(arrayList, scr);
                    break;
                case 4:
                    removeElement(arrayList, scr);
                    break;
                case 5:
                    displayElement(arrayList, scr);
                    break;
                case 6:
                    addElementBetween(arrayList, scr);
                    break;
                case 7:
                    System.out.println("Exiting program");
                    System.exit(0);
                default:
                    System.out.println("Envalid choice!...");
            }
        }
    }

    private static void addElement(ArrayList<Integer> arrayList, Scanner scr) {
        System.out.println("Enter the number of elements to add: ");
        int count = scr.nextInt();
        System.out.println("Enter the element: ");
        for (int i = 0; i < count; i++) {
            int element = scr.nextInt();
            arrayList.add(element);
        }
        System.out.println("Element added successfully");
    }

    private static void sortElement(ArrayList<Integer> arrayList, Scanner scr) {

        Collections.sort(arrayList);
        System.out.println("Element added successfully");
    }

    private static void removeElement(ArrayList<Integer> arrayList, Scanner scr) {
        System.out.println("Enter the elements to remove: ");
        int element = scr.nextInt();
        System.out.println("Enter the element: ");
        arrayList.remove(Integer.valueOf(element));
        System.out.println("Element removed successfully");
    }

    private static void replaceElement(ArrayList<Integer> arrayList, Scanner scr) {
        System.out.println("Enter the index of element to replace: ");
        int index = scr.nextInt();
        System.out.println("Enter the new element: ");
        int element = scr.nextInt();
        arrayList.set(index, element);
        System.out.println("Element replaced successfully");
    }

    private static void displayElement(ArrayList<Integer> arrayList, Scanner scr) {
        System.out.println("Elements in the array List: ");
        arrayList.forEach((element) -> {
            System.out.println(element + " ");
        });
        System.out.println();
    }

    private static void addElementBetween(ArrayList<Integer> arrayList, Scanner scr) {
        System.out.println("Elements in the index after which the element to add: ");
        int index = scr.nextInt();
        System.out.println("Enter the element to add: ");
        int element = scr.nextInt();
        arrayList.add(index + 1, element);
        System.out.println("Element added Successfully");
    }
}
