import java.util.ArrayList;

public class Driver {
    public static void main(String[] args){//incomplete
        testAddingCustomers();
        testAddingMedia();
        testingAddingToCart();
        testingRemovingFromCart();
        testProcessingRequestsOne();
        testProcessingRequestsTwo();
        testReturnMedia();
        testSearchMedia();
    }
       public static void testAddingCustomers(){
        try {
           MediaRentalManager m = new MediaRentalManager();
           m.addCustomer("Bob", "bob@gmail.com", "LIMITED");
           m.addCustomer("Bill", "bob@gmail.com", "LIMITED");
           m.addCustomer("Joe", "bob@gmail.com", "UNLIMITED");
           System.out.println(m.getAllCustomersInfo());
       }catch(Exception ex){
           System.out.println("ERROR");
       }
       }
        public static void testAddingMedia() {

            MediaRentalManager m = new MediaRentalManager();
            m.addAlbum("Silk Sonic", 4, "B Mars", "music1, music 2, music 3");
            m.addAlbum("No Sonic", 4, "BMars", "music1, music 2, music 3");
            m.addAlbum("Black Sonic", 4, "Br Mars", "music1, music 2, music 3");
            m.addMovie("Titanic", 1, "AC");
            m.addGame("CoD2", 30, 12);
            System.out.println(m.getAllMediaInfo());
        }

        public static void testingAddingToCart(){
            System.out.println("--------------------add to cart--------------------");
            MediaRentalManager m= new MediaRentalManager();
            m.addAlbum("Silk Sonic", 4, "B Mars", "music1, music 2, music 3");
            m.addAlbum("No Sonic", 4, "BMars", "music1, music 2, music 3");
            m.addAlbum("Black Sonic", 4, "Br Mars", "music1, music 2, music 3");
            m.addMovie("Titanic", 1, "AC");
            m.addGame("CoD2", 30, 12);
            m.addCustomer("Bob", "bob@gmail.com", "LIMITED");

            System.out.println(m.addToCart("Bob","CoD2"));
        }

        public static void testingRemovingFromCart(){
            try {

                MediaRentalManager m= new MediaRentalManager();
                m.addToCart("Bob","Silk Sonic");
                 m.removeFromCart("Bob","Silk Sonic");

            }catch(Exception ex) {
                System.out.println("ERROR");
                }
        }
        public static void testProcessingRequestsOne(){


            MediaRentalManager m= new MediaRentalManager();

          //  ArrayList<String> cart = new ArrayList<>();

                  // cart.add("Silk Sonic");
                 /*   m.addCustomer("Bob", "bob@gmail.com", "LIMITED");
                    m.addCustomer("Bill", "bob@gmail.com", "LIMITED");
                    m.addCustomer("Joe", "bob@gmail.com", "UNLIMITED");
                    m.addAlbum("Silk Sonic", 4, "B Mars", "music1, music 2, music 3");
                    m.addAlbum("No Sonic", 4, "BMars", "music1, music 2, music 3");
                    m.addAlbum("Black Sonic", 4, "Br Mars", "music1, music 2, music 3");
                    m.addMovie("Titanic", 1, "AC");
                    m.addGame("CoD2", 30, 12);
                    m.addToCart("Bob","Silk Sonic");
                    m.addToCart("Bob","Titanic");
                    m.removeFromCart("Bob","Silk Sonic");*/
                    System.out.println(m.processRequests());

        }
        public static void testProcessingRequestsTwo(){
                try {

            MediaRentalManager m= new MediaRentalManager();
            m.processRequests();
                }catch(Exception ex) {
                    System.out.println("ERROR");
                }
        }
        public static void testReturnMedia(){
                try {

            MediaRentalManager m= new MediaRentalManager();
            m.returnMedia("Bob", "Silk Sonic");
        }catch(Exception ex) {
        System.out.println("ERROR");
    }
        }
        public static void testSearchMedia(){
                try {
            MediaRentalManager m= new MediaRentalManager();
            m.addAlbum("Silk Sonic", 4, "B Mars", "music1, music 2, music 3");
            m.addAlbum("No Sonic", 4, "BMars", "music1, music 2, music 3");
            m.addAlbum("Black Sonic", 4, "Br Mars", "music1, music 2, music 3");
            m.addMovie("Titanic", 1, "AC");
            m.addGame("CoD2", 30, 12);
           ArrayList<String> s= m.searchMedia("Silk Sonic",null,"B Mars","music1");
                    System.out.println("----------------------------------------SEARCHED MEDIA----------------------------------------");
           for(String s1:s) {
               System.out.println(s1);
           }
        }catch(Exception ex) {
        System.out.println("ERROR");
    }
        }

}
