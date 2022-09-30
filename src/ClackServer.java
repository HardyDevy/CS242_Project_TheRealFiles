public class ClackServer {
    int port;
    boolean closeConnection;
    //dataToReceiveFromClient
    //dataToSendToClient

    ClackServer(int port){
        this.port = port;
        //dataToReceiveFromClient = null;
        //dataToSendToClient = null;
    }
    ClackServer(){
        this(7000);
    }
    public void start(){}
    public void receiveData(){}
    public void sendData(){}
    public int getPort(){
        return this.port;
    }

    // Need To Implement hashCode and add dataToReceiveFromClient and dataToSendToClient to equals and toString
    public int hashCode(){
        return 696969;
    }
    public boolean equals(Object other){
        ClackServer otherClackServer = (ClackServer)other;
        return (this.port == otherClackServer.port && this.closeConnection == otherClackServer.closeConnection);
    }
    public String toString(){
        return ("Port: " + this.port);
    }
}
