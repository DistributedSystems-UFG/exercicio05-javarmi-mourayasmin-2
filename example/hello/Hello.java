package example.hello;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hello extends Remote {
    String sayHello() throws RemoteException;
    int soma(int a, int b) throws RemoteException;
    int multiplier(int n1, int n2) throws RemoteException;
    double divider(int n1, int n2) throws RemoteException;
}
