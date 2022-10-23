import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
    public String getData(){
        return this.fileContents;
    }
//    readFileContents (both of them) read one line at a time and probably shouldn't
    public void readFileContents() throws IOException{
        try{
            BufferedReader bufferedReader = new BufferedReader( new FileReader(fileName) );
            String contents;
            while ( (contents = bufferedReader.readLine()) != null ){
                fileContents = contents;
            }
            bufferedReader.close();
        } catch(FileNotFoundException fnfe) {
            System.err.println("File does not exist");
        } catch( IOException ioe) {
            System.err.println("IOException occurred");
        }
    };
    public void readFileContents(String key) throws IOException{
        try{
            BufferedReader bufferedReader = new BufferedReader( new FileReader(fileName) );
            String contents;
            while ( (contents = bufferedReader.readLine()) != null ){
                fileContents = encrypt(contents, key);
            }
            bufferedReader.close();
        } catch(FileNotFoundException fnfe) {
            System.err.println("File does not exist");
        } catch( IOException ioe) {
            System.err.println("IOException occurred");
        }
    };
    public void writeFileContents(){
        
    };
    public void writeFileContents(String key){

    };

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
