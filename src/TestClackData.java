public class TestClackData {
    public static void main (String args[]) {

        MessageClackData data1 = new MessageClackData("larks", "Enter Message Here", 2);
        MessageClackData dataa = new MessageClackData("larks", "Enter Message Here", 2);
        MessageClackData datab = new MessageClackData("nope", "Enter Message Here", 2);
        FileClackData data2 = new FileClackData("larks", "Enter File Name Here", 2);
        FileClackData datay = new FileClackData("larks", "Enter File Name Here", 2);
        FileClackData dataz = new FileClackData("nope", "Enter File Name Here", 2);
//test printing
//        System.out.println("Current username is " + data1.getUserName());
//        System.out.println("Current file name is " + data2.getFileName());
//        System.out.println("Current message is " + data1.getData());
//        System.out.println("Current type is " + data1.getType());
//        System.out.println("Set date is " + data1.getDate());
////test equals
//        System.out.println(data1.equals(dataa));
//        System.out.println(data1.equals(datab));
//        System.out.println(data2.equals(datay));
//        System.out.println(data2.equals(dataz));
////test to string
//        System.out.println(data1.toString());
//        System.out.println(data2.toString());
////hashcode
//        System.out.println(data1.hashCode());
//        System.out.println(data2.hashCode());

//Encryption
        System.out.println("\nMessage: HELLO, WORLD!");
        System.out.print("Encrypted: ");
        System.out.print(data2.encrypt("HELLO, WORLD!", "ABC"));
        System.out.print("\nDecrypted: ");
        System.out.print(data2.decrypt(data2.encrypt("HELLO, WORLD!", "ABC"), "ABC"));
    }
    }