public class ClackServer {
    private static final int DEFAULT_PORT = 7000;
    int port;
    boolean closeConnection;
    public ClackData dataToReceiveFromClient;
    public ClackData dataToSendToClient;

    ClackServer(int port){
        this.port = port;
        //dataToReceiveFromClient = null;
        //dataToSendToClient = null;
    }
    ClackServer(){
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
