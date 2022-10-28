package data;

import javax.xml.crypto.Data;

public class MessageClackData extends ClackData{
    //data.MessageClackData
    private String message;

    public final int CONSTANT_LOGOUT = 1;
    public final int CONSTANT_SENDMESSAGE =2;
    public MessageClackData(String userName, String message, String key, int type){
        super(userName, type);
        this.message = message;
    }



   public MessageClackData(String userName, String message, int type){
       super(userName, type);
       this.message = message;
   }

    public MessageClackData(){
       this("Anon","Error",5);
    }



    public String getMessage(){
        return message;
    }
    public String getData(){
       return message;
   };
    public String getData(String key){
        decrypt(message, key);
        return message;
    };


    public boolean equals(Object other){
        MessageClackData otherMessage = (MessageClackData) other;
       return this.userName == otherMessage.userName &&
               this.message == otherMessage.message &&
               this.type == otherMessage.type;
    }

    public int hashCode(){
        int result = 5;
        result = 17 * result + userName.hashCode();
        result = 17 * result + message.hashCode();
        result = 17 * result + type;
        return result;

    }

    public String toString() { return this.message;}


}
