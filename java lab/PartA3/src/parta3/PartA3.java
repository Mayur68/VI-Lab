/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parta3;

import java.util.*;

/**
 *
 * @author mayur
 */
public class PartA3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add elements");
            System.out.println("2. Sort elements");
            System.out.println("3. Replace an element with another");
            System.out.println("4. Remove an element");
            System.out.println("5. Display all elements");
            System.out.println("6. Add an element between two elements");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter number of elements to add: ");
                    int n = scanner.nextInt();
                    System.out.println("Enter elements:");
                    for (int i = 0; i < n; i++) {
                        arrayList.add(scanner.nextInt());
                    }
                    break;
                case 2:
                    Collections.sort(arrayList);
                    System.out.println("Elements sorted successfully.");
                    break;
                case 3:
                    System.out.print("Enter the index of the element to replace: ");
                    int index = scanner.nextInt();
                    if (index >= 0 && index < arrayList.size()) {
                        System.out.print("Enter the new element: ");
                        int newValue = scanner.nextInt();
                        arrayList.set(index, newValue);
                        System.out.println("Element replaced successfully.");
                    } else {
                        System.out.println("Invalid index.");
                    }
                    break;
                case 4:
                    System.out.print("Enter the element to remove: ");
                    int elementToRemove = scanner.nextInt();
                    arrayList.remove((Integer) elementToRemove);
                    System.out.println("Element removed successfully.");
                    break;
                case 5:
                    System.out.println("Elements in the ArrayList:");
                    for (int element : arrayList) {
                        System.out.print(element + " ");
                    }
                    System.out.println();
                    break;
                case 6:
                    System.out.print("Enter the index after which to add the element: ");
                    int addIndex = scanner.nextInt();
                    if (addIndex >= 0 && addIndex < arrayList.size()) {
                        System.out.print("Enter the element to add: ");
                        int newElement = scanner.nextInt();
                        arrayList.add(addIndex + 1, newElement);
                        System.out.println("Element added successfully.");
                    } else {
                        System.out.println("Invalid index.");
                    }
                    break;
                case 7:
                    System.out.println("Exiting program...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

    }
}
