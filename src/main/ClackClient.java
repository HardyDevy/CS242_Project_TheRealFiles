package main;
 import java.io.IOException;
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
        public static final int DEFAULT_PORT = 7000;
        public int port;
        public boolean closeConnection;
        public  Scanner inFromStd;
        protected static final String DEFAULTKEY = "SLAYGIRLBOSSBOSSSLAY";
    ClackData dataToSendToServer = null;
    ClackData dataToReceiveFromServer = null;


    public ClackClient(String userName, String hostName, int port){
        if(userName != null)
            this.userName = userName;
        else  throw new IllegalArgumentException("User Name is not acceptable");
        if(hostName != null)
            this.hostName = hostName;
        else  throw new IllegalArgumentException("Host Name is not acceptable");
        if(!(port < 1024))
            this.port = port;
        else  throw new IllegalArgumentException("Port is not acceptable");


    }


        public ClackClient(String userName, String hostName){
            this(userName, hostName, 7000);
        }
      public ClackClient(String userName){
            this(userName, "localhost");
        }
       public ClackClient(){
            this("anon");
        }
        public void start() {
            inFromStd = new Scanner(System.in);
            while (!closeConnection) {
                readClientData();
                dataToReceiveFromServer = dataToSendToServer;
                printData();
            }
            inFromStd.close();
        }

    public void readClientData() {
        System.out.println("Input desired choice");
        String nextString = inFromStd.next();
         try {
        if (nextString.equals("DONE")) {
            closeConnection = true;
            System.out.println(closeConnection);
        } else if (nextString.equals("LISTUSERS")) { //nothing rn
            // else if (inFromStd.equals(CONSTANT_LOGOUT )) { // nothing rn

        } else if (nextString.equals("SENDFILE")) {
            String filename = inFromStd.next();
            dataToSendToServer = new FileClackData(userName, filename, CONSTANT_SENDFILE);
            try {
                ((FileClackData) this.dataToSendToServer).readFileContents();
            } catch (IOException ioe) {
                System.err.println("IO Exception");
            }
        } else {

            String message = nextString + inFromStd.nextLine();
           // dataToSendToServer = new MessageClackData();

            // String message = inFromStd.next();
            dataToSendToServer = new MessageClackData(userName, message, CONSTANT_SENDMESSAGE);
        }

        } catch(InputMismatchException ime)
    {
        System.err.println("Did not enter integer.");
    }
       }
        public void sendData(){}
        public void receiveData(){}
        public void printData(){
        System.out.println(dataToReceiveFromServer);
    };




        public String getUserName(){
            return this.userName;
        }
        public String getHostName(){
            return this.hostName;
        }
        public int getPort(){
            return this.port;
        }
        public int hashCode(){
            int result = 5;
            result = 17 * result + this.userName.hashCode();
            result = 17 * result + this.hostName.hashCode();
            result = 17 * result + this.port;
            return result;
        }
        public boolean equals(Object other){
            ClackClient otherClackClient = (ClackClient)other;
            return (this.userName == otherClackClient.userName && this.hostName == otherClackClient.hostName && this.port == otherClackClient.port);
        }
        public String toString(){
            return ("Username: " + this.userName + '\n' + "Host Name: " + this.hostName + '\n' +  "Port: " + this.port);
        }
    }

