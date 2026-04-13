package example.hello;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ExerciseImplem extends UnicastRemoteObject implements Exercise{
    public ExerciseImplem(int port) throws RemoteException {
        super(port);
    }

    public String sayRunning() {
        return "Server2 Running";
    }

    public int sayRunningPort(int port) {
        return port;
    }
}
