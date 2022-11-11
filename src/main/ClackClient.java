package main;
 import java.io.*;
 import java.net.ServerSocket;
 import java.net.Socket;
 import java.util.InputMismatchException;
 import java.util.Scanner;
 import data.ClackData;
 import data.FileClackData;
 import data.MessageClackData;

 import static data.ClackData.*;
 import static data.FileClackData.*;

public class ClackClient {
    public String userName;
    public String hostName;
    public static final int DEFAULT_PORT = 6969;
    public int port;
    public boolean closeConnection = false;
    public Scanner inFromStd;
    protected static final String DEFAULTKEY = "SLAYGIRLBOSSBOSSSLAY";
    ClackData dataToSendToServer;
    ClackData dataToReceiveFromServer;
//    ClackData dataToReceiveFromServer = null;
//    ClackData dataToSendToServer = null;

    ObjectOutputStream outToServer;
    ObjectInputStream inFromServer;
//    ObjectOutputStream outToServer = null;
//    ObjectInputStream inFromServer = null;


    public ClackClient(String userName, String hostName, int port) {
        if (userName != null)
            this.userName = userName;
        else throw new IllegalArgumentException("User Name is not acceptable");
        if (hostName != null)
            this.hostName = hostName;
        else throw new IllegalArgumentException("Host Name is not acceptable");
        if (!(port < 1024))
            this.port = port;
        else throw new IllegalArgumentException("Port is not acceptable");


    }


    public ClackClient(String userName, String hostName) {
        this(userName, hostName, DEFAULT_PORT);
    }

    public ClackClient(String userName) {
        this(userName, "localhost");
    }

    public ClackClient() {
        this("anon");
    }

    public void start() {
        inFromStd = new Scanner(System.in);

        try {

            Socket skt = new Socket(hostName, port);
           // Socket skt = new Socket(hostName, DEFAULT_PORT);
            System.out.println("test");
            // PrintWriter outToServer = new PrintWriter(skt.getOutputStream(), true);
            // BufferedReader inFromServer = new BufferedReader(new InputStreamReader(skt.getInputStream()));
            ObjectOutputStream outToServer = new ObjectOutputStream(skt.getOutputStream());
            ObjectInputStream inFromServer = new ObjectInputStream(skt.getInputStream());

            while (!closeConnection) {
                readClientData();
                if (inFromStd == null) {
                    System.out.println("No input detected");
                } else {
                    sendData();
                    receiveData();
                    printData();


                    // outToServer.println("From Server: Echo--" + inFromStd);
                }

                dataToReceiveFromServer = dataToSendToServer;
                //  printData();
            }
            inFromStd.close();
            outToServer.close();
            inFromServer.close();
            skt.close();


        } catch (IOException ioe) {
            System.err.println("Try that again");

        }
    }

    public void readClientData() {
        System.out.println("Input desired choice");
        String nextString = inFromStd.next();
        try {
            if (nextString.equals("DONE")) {
                closeConnection = true;
            } else if (nextString.equals("LISTUSERS")) { //nothing rn
                // else if (inFromStd.equals(CONSTANT_LOGOUT )) { // nothing rn

            } else if (nextString.equals("SENDFILE")) {
                String filename = inFromStd.next();
                dataToSendToServer = new FileClackData(userName, filename, CONSTANT_SENDFILE);
                try {
                    ((FileClackData) this.dataToSendToServer).readFileContents(DEFAULTKEY);
                } catch (IOException ioe) {
                    System.err.println("IO Exception");
                }
            } else {
                String message = nextString + this.inFromStd.nextLine();
                // dataToSendToServer = new MessageClackData();

                // String message = inFromStd.next();
                this.dataToSendToServer = new MessageClackData(userName, message, DEFAULTKEY, ClackData.CONSTANT_SENDMESSAGE);
            }

        } catch (InputMismatchException ime) {
            System.err.println("Did not enter integer.");
        }
    }

    public void sendData() {
        try {
            outToServer.writeObject(dataToSendToServer);
        } catch (IOException ioe) {
            System.err.println("IO Exception");
        }
    }

    public void receiveData() {
        try {
            ClackData dataToReceiveFromServer = (ClackData) inFromServer.readObject();
        } catch (IOException ioe) {
            System.err.println("IO Exception");
        } catch (ClassNotFoundException cnfe) {
            System.err.println("class not found");
        }
    }
    // inFromServer();

    public void printData() {

//            if (this.dataToReceiveFromServer != null) {
//                System.out.println("From: " + this.dataToReceiveFromServer.getUserName());
//                System.out.println("Date: " + this.dataToReceiveFromServer.getDate());
//                System.out.println("Data: " + this.dataToReceiveFromServer.getData(DEFAULTKEY));
//                System.out.println();
//            }
        System.out.println(dataToReceiveFromServer);
    }

    ;


    public String getUserName() {
        return this.userName;
    }

    public String getHostName() {
        return this.hostName;
    }

    public int getPort() {
        return this.port;
    }

    public int hashCode() {
        int result = 5;
        result = 17 * result + this.userName.hashCode();
        result = 17 * result + this.hostName.hashCode();
        result = 17 * result + this.port;
        return result;
    }

    public boolean equals(Object other) {
        ClackClient otherClackClient = (ClackClient) other;
        return (this.userName == otherClackClient.userName && this.hostName == otherClackClient.hostName && this.port == otherClackClient.port);
    }

    public String toString() {
        return ("Username: " + this.userName + '\n' + "Host Name: " + this.hostName + '\n' + "Port: " + this.port);
    }

    public static void main(String args[]) {
        ClackClient obj= new ClackClient();
        obj.start();

    }
}



