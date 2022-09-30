import java.util.Date;

public abstract class ClackData {
    //ClackData
    public String userName;
    public int type;
    public Date date;

    public ClackData(String userName, int type) {
        this.userName = userName;
        this.type = type;
    };
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
