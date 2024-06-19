/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partb8;

import java.util.*;

/**
 *
 * @author mayur
 */
public class PartB8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String rNo, sName;
        int m1, m2, m3;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the roll no. :");
        rNo = in.nextLine();
        System.out.print("Enter the Name : ");
        sName = in.nextLine();
        System.out.print("Marks of Three Subjects ");
        m1 = in.nextInt();
        m2 = in.nextInt();
        m3 = in.nextInt();

        studentmodel sm = new studentmodel(rNo, sName, m1, m2, m3);
        studentview sv = new studentview();
        studentcontroller sc = new studentcontroller(sm, sv);
        sc.UpdateVeiw();

    }

}
