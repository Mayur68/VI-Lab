/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partb8;

/**
 *
 * @author mayur
 */
public class studentview {

    public void displayResult(String rNo, String sName, int m1, int m2, int m3, String result, String grade) {
        System.out.println("..............................................................");
        System.out.println("RollNo\tName\t\tMark1\tMark2\tMark3\tResult\tGrade");
        System.out.println(".......................................................");
        System.out.println(rNo + "\t" + sName + "\t\t" + m1 + "\t" + m2 + "\t" + m3 + "\t" + result + "\t" + grade);
        System.out.println("..................................................................");

    }

}
