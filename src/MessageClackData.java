import javax.xml.crypto.Data;

public class MessageClackData extends ClackData{
    private String message;

    MessageClackData( String userName, String message, String key, int type ){
        super(userName, type);
        this.message = encrypt(message, key);
    }
    public MessageClackData(String userName, String message, int type){
        super(userName, type);
        this.message = message;
    }
    public MessageClackData(){
        this("Anon","Error",5);
    }
    public String getData(){
        return this.message;
    }

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
    public String toString(){
        return this.message;
    }
}
