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
import java.rmi.registry.*;

public class SimpleInterestServer {

    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        SimpleInterestImpl si = new SimpleInterestImpl();
        Registry reg = LocateRegistry.createRegistry(18888);
        reg.bind("SI", si);
        System.out.println("Server is started.....");
    }

}
