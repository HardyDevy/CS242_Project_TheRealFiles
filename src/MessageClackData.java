public abstract class MessageClackData extends ClackData{
    //MessageClackData
    private String message;

    public MessageClackData(String userName, String message, int type){
        super(userName, type);
        this.message = message;
    }
    public MessageClackData(){
        this("Anon","Error",5);
    }
    //public abstract Data getData();

    public int hashCode(){
            int result = 5;
            result = 17 * result + this.message.hashCode();
            return result;
    }
    public boolean equals(Object other){
        MessageClackData otherMessage = (MessageClackData) other;
        return this.userName == otherMessage.userName &&
                this.message == otherMessage.message &&
                this.type == otherMessage.type;
    }

    //toString(){}


}
