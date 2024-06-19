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
import java.rmi.registry.*;

public class TaxServer {

    public static void main(String args[]) throws RemoteException {
        TaxImpl timpl = new TaxImpl();
        Registry reg = LocateRegistry.createRegistry(18888);
        reg.rebind("TaxServer", timpl);
        System.out.println("Server is running.......");
    }
}
