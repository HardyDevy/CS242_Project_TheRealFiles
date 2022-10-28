package main;
import data.ClackData;
    public class ClackServer {
        int port;
        private static final int DEFAULT_PORT = 7000;
        boolean closeConnection;
        public ClackData dataToReceiveFromClient;
        public ClackData dataToSendToClient;



        public ClackServer(int port){
            this.port = port;
            //dataToReceiveFromClient = null;
            //dataToSendToClient = null;
        }
       public ClackServer(){
            this(DEFAULT_PORT);
        }
        public void start(){}
        public void receiveData(){}
        public void sendData(){}
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
    }


