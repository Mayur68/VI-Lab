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
import java.rmi.server.*;
import java.rmi.*;

public class TaxImpl extends UnicastRemoteObject implements tax {

    public TaxImpl() throws RemoteException {
    }

    public double calTax(double income) throws RemoteException {
        double t;
        if (income <= 300000) {
            t = 0.0;
        } else if (income > 300001 && income <= 600000) {
            t = 0.05f * (income - 300000);
        } else if (income > 600001 && income <= 900000) {
            t = 0.10f * (income - 600000);
        } else if (income > 900001 && income <= 1200000) {
            t = 0.15f * (income - 900000);
        } else if (income > 1200001 && income <= 1500000) {
            t = 0.20f * (income - 1200000);
        } else {
            t = 0.30f * (income - 1500000);
        }
        return t;
    }
}
