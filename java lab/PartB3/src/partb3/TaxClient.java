/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partb3;

/**
 *
 * @author mayur
 */
import java.rmi.*;
import java.util.*;
import java.rmi.registry.*;

public class TaxClient {

    public static void main(String args[]) throws RemoteException, NotBoundException {
        double d;
        Scanner sc = new Scanner(System.in);
        Registry reg = LocateRegistry.getRegistry(18888);
        tax t = (tax) reg.lookup("TaxServer");
        System.out.println("Enter the Income:");
        d = sc.nextDouble();
        System.out.println("The calculated tax amount is=" + t.calTax(d));
    }
}