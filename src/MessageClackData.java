import javax.xml.crypto.Data;

public class MessageClackData extends ClackData{
    //MessageClackData
    private String message;

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
    public Data getData(){
       return null;
   };


    public boolean equals(MessageClackData otherMessage){
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

    public String toString(){
        return "The Username is: " + this.userName + '\n' +
                "The message is: " + this.message + '\n' +
                "The type is: " + this.type + '\n';
    }


}
