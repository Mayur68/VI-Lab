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

public interface SimpleInterest extends Remote {

    double computeSI(double p, double t, double r) throws RemoteException;
}
