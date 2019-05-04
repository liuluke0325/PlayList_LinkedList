import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        LinkedList<Song>  playList = new LinkedList<Song>();
        Album firstAlbum = new Album("firstAlbum","Luke" );
        Album secondAlbum = new Album("secondAlbum", "Eva");
        firstAlbum.displaySong();
        firstAlbum.addSong("luke11", "3 min");
        firstAlbum.addSong("luke22", "3.5 min");
        firstAlbum.addSong("luke33", "4 min");
        firstAlbum.displaySong();
        secondAlbum.displaySong();
        secondAlbum.addSong("eva11","2 min");
        secondAlbum.addSong("eva22","2.2 min");
        secondAlbum.addSong("eva33","3 min");
        secondAlbum.addSong("eva44","1.7 min");
        secondAlbum.displaySong();
        addPlayList(playList, secondAlbum, "eva55");
        addPlayList(playList, secondAlbum, "eva44");
        addPlayList(playList, firstAlbum, "eva44");
        addPlayList(playList, firstAlbum, "luke33");
        addPlayList(playList, firstAlbum, "luke11");
        addPlayList(playList, firstAlbum, "luke22");
        addPlayList(playList, secondAlbum, "eva11");
        addPlayList(playList, secondAlbum, "eva22");
        displaySong(playList);
        controlSystem(playList);
    }


    public static boolean addPlayList(LinkedList list , Album albumName, String songName){
        Song song = albumName.getSong(songName);
        if (song == null){
            System.out.println("\tError: "+songName + " is not in the " + albumName.getAlbumName());
            return false;
        }
        list.add(song);
        System.out.println(songName + " added into playlist");
        return true;

    }

    public static void displaySong(LinkedList<Song> list){
//        ListIterator displaylist = list.listIterator();
        Iterator<Song> displaylist = list.iterator();
        System.out.println(list.size() + " in the playlist");

        for (int i = 1; displaylist.hasNext() ; i++){
            Song song = displaylist.next();
            System.out.println("\t"+ i + ". " + song.getTitle()+ " " +song.getDuration() );
        }
        System.out.println("End of the list");
    }





    public static void menu(){

        System.out.println("----------------------------------");
        System.out.println("1. Skip forward to the next song");
        System.out.println("2. Skip backwards to a previous song");
        System.out.println("3. Replay the current song");
        System.out.println("4. List the songs in the playlist");
        System.out.println("5. Delete current song");
        System.out.println("0. Quit");
        System.out.println("----------------------------------");

    }




    public static void controlSystem ( LinkedList<Song>  list ){
        ListIterator<Song>  playlistIterator = list.listIterator();
        Scanner scanner =  new Scanner(System.in);
        boolean flag = true;
        boolean forward = true;
        if (list.isEmpty()) {
            System.out.println("****************************************");
            System.out.println("No song inside the playlist");
            System.out.println("****************************************");
        }else {
            System.out.println("****************************************");
            System.out.println("Now Playing... " + playlistIterator.next().toString());
            System.out.println("****************************************");
        }



        do {
            menu();
            System.out.print("Please enter number : ");
            int select = scanner.nextInt();
            scanner.nextLine();

            switch(select){

                case 1:
                    if (!forward){
                        if(playlistIterator.hasNext()){
                            playlistIterator.next();
                        }
                        forward = true;
                    }
                    if(playlistIterator.hasNext()){
                        System.out.println("****************************************");
                        System.out.println("Now playing......" + playlistIterator.next().toString() );
                        System.out.println("****************************************");
                    }else{
                        System.out.println("****************************************");
                        System.out.println("End of the list");
                        System.out.println("****************************************");
                    }
                    break;
                case 2:


                    if (forward){
                        if(playlistIterator.hasPrevious()){
                            playlistIterator.previous();
                        }
                        forward = false;
                    }

                    if(playlistIterator.hasPrevious()){
                        System.out.println("****************************************");
                        System.out.println("Now playing......" + playlistIterator.previous().toString() );
                        System.out.println("****************************************");
                    }else{
                        System.out.println("****************************************");
                        System.out.println("First of the list");
                        System.out.println("****************************************");
                    }




                    break;


                case 3:

                    if (forward){
                        System.out.println("****************************************");
                        System.out.println("Now playing......" + playlistIterator.previous().toString() );
                        System.out.println("****************************************");
                        forward = false;
                    }else {
                        System.out.println("****************************************");
                        System.out.println("Now playing......" + playlistIterator.next().toString() );
                        System.out.println("****************************************");
                        forward = true;
                    }

                    break;

                case 4:
                    displaySong(list);
                    break;
                case 5 :
                    if (list.size()>0){
                    playlistIterator.remove();

                    if (playlistIterator.hasNext()){
                        System.out.println("Playing the next song "+playlistIterator.next().toString());
                    }else if(playlistIterator.hasPrevious()){
                        System.out.println("Playing the last song "+playlistIterator.previous().toString());
                    }else{
                        System.out.println("No more in the playlist");
                    }
                    }

                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("****************************************");
                    System.out.println("Wrong Number");
                    System.out.println("****************************************");
            }

        }while(flag);



    }











}//endofclass








// Create a program that implements a playlist for songs
// Create a Song class having Title and Duration for a song.
// The program will have an Album class containing a list of songs.
// The albums will be stored in an ArrayList
// Songs from different albums can be added to the playlist and will appear in the list in the order
// they are added.
// Once the songs have been added to the playlist, create a menu of options to:-
// Quit,Skip forward to the next song, skip backwards to a previous song.  Replay the current song.
// List the songs in the playlist

// A song must exist in an album before it can be added to the playlist (so you can only play songs that
// you own).

// Hint:  To replay a song, consider what happened when we went back and forth from a city before we
// started tracking the direction we were going.
// As an optional extra, provide an option to remove the current song from the playlist
// (hint: listiterator.remove()

