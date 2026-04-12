package example.hello;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

    private Client() {}

    public static void main(String[] args) {

        System.out.println("Initiating client");
        
        String host = (args.length < 1) ? null : args[0];
        try {
            //Registry registry = LocateRegistry.getRegistry(host);
            //System.out.println("Registry has been located");
            //Hello stub = (Hello) registry.lookup("Hello");

            Hello stub = (Hello) Naming.lookup("rmi://" + host + "/MyHello"); 
            System.out.println("Found server");
            String response = stub.sayHello();
            System.out.println("Response: " + response);

            Exercise exercise = (Exercise) Naming.lookup("rmi://" + host + "/SecondService");

            int result = stub.soma(100,1000);
            System.out.println("Response from soma: " + result);

            int result1 = stub.multiplier(3, 2);
            System.out.println("Response from multiplier: " + result1);

            double result2 = stub.divider(100, 2);
            System.out.println("Response from divider: " + result2);

            int result3 = exercise.sayRunningPort(5679);
            System.out.println("Running port is: " + result3);

            String result4 = exercise.sayRunning();
            System.out.println(result4);

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
