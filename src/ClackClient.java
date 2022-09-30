public class ClackClient {
    public String userName;
    public String hostName;
    public int port;
    public boolean closeConnection;
    //dataToSendToServer
    //dataToReceiveFromServer

    public ClackClient(String userName, String hostName, int port){
        this.userName = userName;
        this.hostName = hostName;
        this.port = port;
        //dataToSendToServer = null;
        //dataToRecieveFromServer = null;
    }
    public ClackClient(String userName, String hostName){
        this(userName, hostName, 7000);
    }
    ClackClient(String userName){
        this(userName, "localhost");
    }
    ClackClient(){
        this("anon");
    }
    public void start(){}
    public void readClientData(){}
    public void sendData(){}
    public void receiveData(){}
    public void printData(){}
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
        return ("Username: " + this.userName + "Host Name: " + this.hostName + "Port: " + this.port);
    }
}
