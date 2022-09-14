import java.util.ArrayList;
import java.util.Collections;

public class MediaRentalManager implements MediaRentalInt{

    private Customer customer = new Customer();
    private ArrayList<Customer> customerList = new ArrayList<>();
    private ArrayList<Media> mediaList = new ArrayList<>();

    private int value=2;//plan limit default is 2

    MediaRentalManager() {

    }

    @Override
    public void addCustomer(String name, String address, String plan) {//good
        Customer c = new Customer(name,address,plan);
        customerList.add(c);
    }

    @Override
    public void setLimitedPlanLimit(int value) {//good
        this.value = value;
    }

    @Override
    public String getAllCustomersInfo() {//good
      Collections.sort(customerList);
        StringBuilder allInfo= new StringBuilder();
        for(Customer c: customerList) {
            allInfo.append("\n").append(c.toString());
        }
        return allInfo.toString();
    }



    @Override
    public void addMovie(String title, int copiesAvailable, String rating) {

        if((!mediaList.contains(title))&&(rating=="DR"||rating=="HR"||rating=="AC")) {
            Movie m = new Movie(title, copiesAvailable, rating);
            mediaList.add(m);
        }
        else if(mediaList.contains(title))
            System.out.println("Title already present in database.");
        else
            System.out.println("Wrong rating entered for "+title);
    }

    @Override
    public void addGame(String title, int copiesAvailable, double weight) {
        if(mediaList.contains(title))
            System.out.println("Title already present in database.");
        else {
            Game g = new Game(title, copiesAvailable, weight);
            mediaList.add(g);
        }
    }

    @Override
    public void addAlbum(String title, int copiesAvailable, String artist, String songs) {
        ArrayList<String> songList= new ArrayList<>();
        if(mediaList.contains(title))
            System.out.println("Title already present in database.");
        else if(songs.contains(",")){

               String[] s = songs.split(",");
                for(int i=0;i<s.length;i++)
                    songList.add(s[i]);
                    String song="";
                for( String s1: s){
                    song+=","+s1;
                }
            Album a = new Album(title, copiesAvailable, artist,song);
            mediaList.add(a);
            }



        }
         @Override
         public String getAllMediaInfo () {//good
             Collections.sort(mediaList);
             StringBuilder allInfo= new StringBuilder();
            for(Media m: mediaList)
                allInfo.append("\n").append(m);
            return allInfo.toString();
          }// OVERRIDE IN MEDIA



        @Override
       public boolean addToCart (String customerName, String mediaTitle) {

            for (Customer c : customerList) {
                if (c.getName().equalsIgnoreCase(customerName)) {
                    if (c.getWantsToRent().contains(mediaTitle)) {// if the customer's cart doesn't already have the media title addToCart will be allowed
                        System.out.println();
                        System.out.println("Title " + mediaTitle + " Already Present in " + c.getName() + "'s cart");
                        return false;
                    } else {
                        c.getWantsToRent().add(mediaTitle);
                         for (Media m : mediaList) {
                            if (m.getTitle().equalsIgnoreCase(mediaTitle)) {
                                 m.setCopiesAvailable(m.getCopiesAvailable() - 1);
                                System.out.println("worked");
                                return true;

                            }
                        }
                     }
                }
            }
            return false;
        }

        @Override
        public boolean removeFromCart (String customerName, String mediaTitle) {
            for (Customer c : customerList) {
                if (c.getName().compareToIgnoreCase(customerName) == 1) {//can also use default equalsTo method
                    ArrayList<String> cart = c.getWantsToRent();
                    if (cart.contains(mediaTitle)) {// if the customer's cart has  the media title removeFromCart will be possible(true)
                        cart.remove(mediaTitle);
                        System.out.println("worked");
                        return true;
                    }
                }
            }
            System.out.println("didn't work");
                return false;
        }


    @Override
        public boolean returnMedia (String customerName, String mediaTitle) {
            for (Customer c : customerList) {
                if (c.getName().equalsIgnoreCase(customerName)) {
                    ArrayList<String> rented = c.getRented();
                    if (rented.contains(mediaTitle)) {
                        rented.remove(mediaTitle);
                        for (Media m : mediaList) {
                            if (m.getTitle().equals(mediaTitle)) {
                                m.setCopiesAvailable(m.getCopiesAvailable() + 1);//adds to the number of copies for the specific title
                                return true;
                            }
                        }
                    }
                }
            }
            return false;
        }

                @Override
                public String processRequests () {//incomplete
               /*   StringBuilder requests= new StringBuilder();
                Collections.sort(customerList);
                for(Customer c: customerList){
                   ArrayList<String> cart = c.getWantsToRent();
                   ArrayList<String> rented = c.getRented();
                   if(c.getPlan().equalsIgnoreCase("LIMITED")) {
                       if (c.getRented().size() >= value) {
                           requests.append("\n The customer" + c.getName() + "has reached the limit of his cart");
                       }
                       else{
                           for(int i=0;i<value;i++){

                                   for(int j = 0;j<c.getWantsToRent().size();i++){
                                     if(removeFromCart(c.getName(),c.getWantsToRent().get(j))){
                                         requests.append("\n Media title ("+c.getWantsToRent().get(j)+") removed from "+c.getName()+"'s cart" );
                                         i--;
                                     }
                                   if(addToCart(c.getName(),c.getWantsToRent().get(j))){
                                       requests.append("\n Sending media title ("+c.getWantsToRent().get(j)+") to "+c.getName());
                                       break;
                                   }


                               }
                               break;
                           }
                       }
                   }

                }*/
                    return null;//return requests.toString();//
                }

        @Override
        public ArrayList<String> searchMedia (String title, String rating, String artist, String songs){//complete
        ArrayList<String> searched= new ArrayList<>();
            if(title == null &&rating == null && artist == null && songs == null){//everything
                for(Media m: mediaList)
                        searched.add(m.getTitle());
                }

           else if(title != null && rating == null && artist == null && songs == null){//games
                for(Media m: mediaList){
                    if(m.getTitle()==title)
                        searched.add(m.getTitle());

                }
            }
            else if(title == null && rating != null && artist == null && songs == null){//movies
                for(Media m: mediaList){
                    if((((Movie)m).getRating())==rating)
                        searched.add(m.getTitle());
                }
            }
            else if(title != null && rating != null && artist == null && songs == null){//movies
                for(Media m: mediaList){
                    if(m.getTitle()==title &&(((Movie)m).getRating())==rating)
                        searched.add(m.getTitle());
                }
            }
            else if(title != null && rating == null && artist != null && songs != null){//albums
                for(Media m: mediaList){
                    if(m.getTitle()==title &&(((Album)m).getArtist())==artist &&((((Album)m).getSongs())==songs ||(((Album)m).getSongs()).contains(songs)))
                        searched.add(m.getTitle());
                }
            }
            else if(title == null && rating == null && artist != null && songs != null){//albums
                for(Media m: mediaList){
                    if((((Album)m).getArtist())==artist &&((((Album)m).getSongs())==songs ||(((Album)m).getSongs()).contains(songs)))
                        searched.add(m.getTitle());
                }
            }
            else if(title == null && rating == null && artist != null && songs == null){//albums
                for(Media m: mediaList){
                    if((((Album)m).getArtist())==artist)
                        searched.add(m.getTitle());
                }
            }
            else if(title == null && rating == null && artist == null && songs != null){//albums
                for(Media m: mediaList){
                    if((((Album)m).getSongs())==songs ||(((Album)m).getSongs()).contains(songs))
                        searched.add(m.getTitle());
                }
            }
            else if(title != null && rating == null && artist == null && songs != null){//albums
                for(Media m: mediaList){
                    if(m.getTitle()==title &&((((Album)m).getSongs())==songs ||(((Album)m).getSongs()).contains(songs)))
                        searched.add(m.getTitle());
                }
            }
            else if(title != null && rating == null && artist != null && songs == null){//albums
                for(Media m: mediaList){
                    if(m.getTitle()==title &&(((Album)m).getArtist())==artist)
                        searched.add(m.getTitle());
                }
            }


            Collections.sort(searched);
                return searched;
            }







}

