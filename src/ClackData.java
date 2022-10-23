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
    public String getUserName(){
        return this.userName;
    }
    public Date getDate(){
        return this.date;
    }
    public abstract String getData();
    protected String encrypt(String inputStringToEncrypt, String key){
        int keyLength = key.length();
        int stringLength = inputStringToEncrypt.length();
        char[] charArray = new char[stringLength];
        charArray = inputStringToEncrypt.toCharArray();
        int[] charAsNumArray = new int[stringLength];

        for(int i = 0; i < stringLength; i++){
            charAsNumArray[i] = (int)charArray[i] + keyLength;
            charArray[i] = (char)charAsNumArray[i];
        }
        String encryptedString = String.valueOf(charArray);
        return encryptedString;
    }

    protected String decrypt(String inputStringToDecrypt, String key){
        int keyLength = key.length();
        int stringLength = inputStringToDecrypt.length();
        char[] charArray = new char[stringLength];
        charArray = inputStringToDecrypt.toCharArray();
        int[] charAsNumArray = new int[stringLength];

        for(int i = 0; i < stringLength; i++){
            charAsNumArray[i] = (int)charArray[i] - keyLength;
            charArray[i] = (char)charAsNumArray[i];
        }

        String decryptedString = String.valueOf(charArray);
        return decryptedString;
    }

}
