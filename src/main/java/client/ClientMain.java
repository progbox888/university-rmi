package client;

import dto.Course;
import dto.Student;
import rmi.Server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Created by Norik on 30.03.2017.
 */
public class ClientMain {
    public static void main(String[] args) {
        try {
            Server client = (Server) Naming.lookup("rmi://localhost:1099/url");
            client.deleteLecturer(1);
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
