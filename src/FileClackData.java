import javax.xml.crypto.Data;

public class FileClackData extends ClackData {
    String fileName;
    String fileContents;

    FileClackData(String userName, String fileName, int type) {
        super(userName,type);
        this.fileName = fileName;
        this.fileContents = null;
    }
    FileClackData(){
        super();
        // what to put for filename
        this.fileName = null;
    }
    public void setFileName(String fileName){
        this.fileName = fileName;
    }
    public String getFileName(){
        return this.fileName;
    }
  //  public abstract Data getData();
    public void readFileContents(){};
    public void writeFileContents(){};

    public boolean equals(Object other){
        FileClackData otherFileClackData = (FileClackData) other;
        return this.userName == otherFileClackData.userName &&
                this.fileName == otherFileClackData.fileName &&
                this.type == otherFileClackData.type;
    }
    public int hashCode(){
        int result = 5;
        result = 17 * result + userName.hashCode();
        result = 17 * result + fileName.hashCode();
        result = 17 * result + type;
        return result;
    }
    public String toString(){
        return "The Username is: " + this.userName + '\n' +
                "The file name is: " + this.fileName + '\n' +
                "The type is: " + this.type + '\n';
    }
}
