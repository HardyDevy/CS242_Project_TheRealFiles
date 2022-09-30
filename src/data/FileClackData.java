package data;

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
        return fileName;
    }



public Data getData() {
    return null;
}
//public readFileContents(){};
//public writeFileContents(){};

    public boolean equals(FileClackData otherFile){
        return this.userName == otherFile.userName &&
                this.fileName == otherFile.fileName &&
                this.type == otherFile.type;
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

