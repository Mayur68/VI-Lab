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
import java.rmi.*;
import java.rmi.server.*;

public class SimpleInterestImpl extends UnicastRemoteObject implements SimpleInterest {

    public SimpleInterestImpl() throws RemoteException {
        super();
    }

    @Override
    public double computeSI(double p, double t, double r) throws RemoteException {
        return (p * t * r / 100);
    }
}
