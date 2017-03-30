import rmi.ServerImpl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

/**
 * Created by Norik on 30.03.2017.
 */
public class ServerMain {
    public static void main(String[] args) {
        try {
            ServerImpl server = new ServerImpl();
            Naming.rebind("rmi://localhost:1099/url",server);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
