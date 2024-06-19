/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partb4;

/**
 *
 * @author mayur
 */
import java.rmi.registry.*;
import java.rmi.*;
import java.util.Scanner;

public class SimpleInterestClient {

    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry reg = LocateRegistry.getRegistry(18888);
        SimpleInterest si = (SimpleInterest) reg.lookup("SI");
        Scanner sc = new Scanner(System.in);
        double p, t, r;
        String ans = "n";
        do {
            System.out.println("Simple Interest Calculation");
            System.out.print("Principal: ");
            p = sc.nextDouble();
            System.out.print(" Time: ");
            t = sc.nextDouble();
            System.out.print("Rate: ");
            r = sc.nextDouble();
            System.out.println("Simple Interest is " + si.computeSI(p, t, r));
            System.out.println("Do you want to continue[y/n]?");
            sc.nextLine();
            ans = sc.nextLine();
        } while (ans.toLowerCase().charAt(0) == 'y');
    }
}
