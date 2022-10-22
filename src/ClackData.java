import java.util.Date;

public abstract class ClackData {
    public static MessageClackData CONSTANT_LISTUSERS;
    public static MessageClackData CONSTANT_LOGOUT;
    public static MessageClackData CONSTANT_SENDMESSAGE;
    public static FileClackData CONSTANT_SENDFILE;
    public String userName;
    public int type;
    public Date date;

    public ClackData(String userName, int type) {
        this.userName = userName;
        this.type = type;
        this.date = new Date();
    }
    public ClackData(int type){
        this("Anon", type);
    }

    public ClackData(){
        this("Anon", 5);
    }


    public int getType(){
        return this.type;
    }
    public String getuserName(){
        return this.userName;
    }
    public Date getDate(){
        return this.date;
    }

    //public abstract Data getData(){}
}
