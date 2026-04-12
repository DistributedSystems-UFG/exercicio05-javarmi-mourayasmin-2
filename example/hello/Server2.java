package example.hello;

import java.rmi.Naming;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server2 {

    public Server2() {}

    public static void main(String args[]) {
        try {
            // Try to create registry, but ignore if it already exists
            try {
                LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            } catch (RemoteException e) {
                // Registry already exists, that's fine
            }
            Registry registry = LocateRegistry.getRegistry("localhost");

            ExerciseImplem obj = new ExerciseImplem(5679);  // Different port: 5679

            // Bind the remote object's stub in the registry with name "SecondService"
            Naming.rebind("SecondService", obj);

            System.err.println("Server2 ready");
        } catch (Exception e) {
            System.err.println("Server2 exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
