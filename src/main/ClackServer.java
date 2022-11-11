package main;
import data.ClackData;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ClackServer {
    int port;
    private static final int DEFAULT_PORT = 6969;
    boolean closeConnection;
    public ClackData dataToReceiveFromClient;
    public ClackData dataToSendToClient;
    ObjectOutputStream outToClient = null;
    ObjectInputStream inFromClient = null;


    public ClackServer(int port) {
        if (port < 1024)
            throw new IllegalArgumentException("Port Number must be greater than 1024.");
        else
            this.port = port;
        //dataToReceiveFromClient = null;
        //dataToSendToClient = null;

    }

    public ClackServer() {
        this(DEFAULT_PORT);
    }

    public void start() {
        try {
            ServerSocket sskt = new ServerSocket(port);
            System.out.println("Waiting to accept client");
            Socket clientSkt = sskt.accept();
            System.out.println("accepted");
            ObjectOutputStream outToClient = new ObjectOutputStream(clientSkt.getOutputStream());
            ObjectInputStream inFromClient = new ObjectInputStream(clientSkt.getInputStream());

    receiveData();
    dataToSendToClient = dataToReceiveFromClient;
    sendData();

            sskt.close();
            clientSkt.close();
            outToClient.close();
            inFromClient.close();
        }catch (IOException ioe)
        { System.err.println("IO Exception occurred");
        }

}
    public void sendData() {
        try {
            outToClient.writeObject(dataToSendToClient);
        } catch (IOException ioe) {
            System.err.println("IO Exception");
        }
    }
    public void receiveData(){
        try {
            dataToReceiveFromClient = (ClackData)inFromClient.readObject();
        } catch (IOException ioe){System.err.println("IO Exception");
        }catch(ClassNotFoundException cnfe) {
            System.err.println("class not found");
        }
    }
        public int getPort(){
            return this.port;
        }


        public int hashCode(){
            return 17 * (1 + this.port);
        }
        public boolean equals(Object other){
            ClackServer otherClackServer = (ClackServer)other;
            return (this.port == otherClackServer.port && this.closeConnection == otherClackServer.closeConnection);
        }
        public String toString(){
            return ("Port: " + this.port);
        }

    public static void main(String args[]) {
        ClackServer obj= new ClackServer();
        obj.start();

    }
    }


