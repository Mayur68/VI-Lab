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

public interface tax extends Remote {

    double calTax(double a) throws RemoteException;
}
