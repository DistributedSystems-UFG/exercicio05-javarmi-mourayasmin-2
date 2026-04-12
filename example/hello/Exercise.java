package example.hello;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Exercise extends Remote{
    String sayRunning() throws RemoteException;
    int sayRunningPort(int port) throws RemoteException;
}
