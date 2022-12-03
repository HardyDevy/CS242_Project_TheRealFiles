package main;

public class ClientSideServerListener implements Runnable{
    ClackClient client = new ClackClient();
    protected static final String DEFAULTKEY = "JHGJASKJ";
   public ClientSideServerListener(ClackClient client){
       this.client = client;
   }
   @Override
   public void run(){

               while (!client.getCloseConnection()) {
                   if(!client.doNOTERROR) {
                       client.receiveData();
                   }
                   if(!client.closeConnection) {
                       client.printData();
                       System.out.println("Input message: ");
                   }
               }

   }


}
