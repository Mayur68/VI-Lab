/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partb7;

import java.util.*;

/**
 *
 * @author mayur
 */
public class PartB7 {

    public static void main(String[] args) {
        LinkedList<Integer> flist = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        char choice;
        int pos, fpos, lpos;
        do {
            System.out.println("Menu:");
            System.out.println("a. Insert Elements at Specified Position");
            System.out.println("b. Swap Two Elements");
            System.out.println("c. Iterate LinkedList in Reverse Order");
            System.out.println("d. Compare Two LinkedLists");
            System.out.println("e. Convert LinkedList to ArrayList");
            System.out.println("f. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.next().charAt(0);
            switch (choice) {
                case 'a':
                    if (flist.size() > 0) {
                        System.out.println("Element in the list: " + flist);
                    } else {
                        System.out.println("List is empty");
                    }
                    System.out.print("Enter the position: ");
                    pos = scanner.nextInt();
                    if (pos < 0) {
                        System.out.println("Enter a positive position number.");
                    } else if (flist.size() > 0 && pos <= flist.size() + 1 || (pos == 1)) {
                        System.out.print("Enter the number: ");
                        int num = scanner.nextInt();
                        flist.add(pos - 1, num);
                        System.out.println("Element " + num + " is inserted at position " + pos);
                    } else {
                        System.out.println("Enter a proper position value.");
                    }
                    break;
                case 'b':
                    System.out.print("Original list is " + flist);
                    System.out.print("Enter the position of the element to be swapped: ");
                    System.out.print("First element position: ");
                    fpos = scanner.nextInt();
                    System.out.print("Last element position: ");
                    lpos = scanner.nextInt();
                    if (fpos < 0 && lpos <= 0) {
                        System.out.println("Error: use positive values for position.");
                    } else if ((fpos > flist.size()) && (lpos > flist.size())) {
                        System.out.println("Error: enter proper values for position.");
                    } else {
                        int n1 = flist.get(fpos - 1);
                        int n2 = flist.get(lpos - 1);
                        flist.set(lpos - 1, n1);
                        flist.set(fpos - 1, n2);
                        System.out.println("Element is swapped.");
                        System.out.println("New list is " + flist);
                    }
                    break;
                case 'c':
                    System.out.print("Original list is " + flist);
                    System.out.print("Reversed list is ");
                    System.out.print("[");
                    for (Iterator it = flist.descendingIterator(); it.hasNext();) {
                        System.out.print(it.next() + " ");
                    }
                    System.out.print("]");
                    break;
                case 'd':
                    LinkedList<Integer> slist = (LinkedList<Integer>) flist.clone();
                    if (flist.equals(slist)) {
                        System.out.println("Lists are equal.");
                    } else {
                        System.out.println("Lists are not equal.");
                    }
                    break;
                case 'e':
                    ArrayList<Integer> alst = new ArrayList<>(flist);
                    System.out.println("Elements of the array list are " + alst);
                    break;
                case 'f':
                    System.out.println("Thank you.");
                    return;
                default:
                    System.out.println("Wrong choice. Please try again.");
            }
        } while (true);
    }

}
