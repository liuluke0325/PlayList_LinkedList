import java.util.ArrayList;

public class Album {

    private String albumName;
    private String singerName;
    private ArrayList<Song> songArrayList;


    public Album(String albumName, String singerName) {
        this.albumName = albumName;
        this.singerName = singerName;
        this.songArrayList = new ArrayList<Song>();
    }


    public boolean addSong(String songName, String duration) {
        if (findSong(songName) >= 0) {
            System.out.println("Error: Song Already in the Album");
            return false;
        } else {
            songArrayList.add(new Song(songName, duration));
            return true;
        }
    }

    public int findSong(String songName) {

        for (int i = 0; i < songArrayList.size(); i++) {
            if (songArrayList.get(i).getTitle().equals(songName)) {
                return i;
            }
        }

        return -1; // if can not find return -1
    }

    public Song getSong(String songName){
        int songIndex = findSong(songName);
        if (songIndex >= 0) {
            return songArrayList.get(songIndex);
        } else {
            System.out.println("Can not find the song");
            return null;
        }
    }

    public String getAlbumName() {
        return albumName;
    }

    public String getSingerName() {
        return singerName;
    }

    public ArrayList<Song> getSongArrayList() {
        return songArrayList;
    }

    public void displaySong(){
        System.out.println("Display all song in the " + this.albumName);
        if (songArrayList.isEmpty()){
            System.out.println("\tNo song in the " + this.albumName);
        }else{
            for(int i = 0; i <songArrayList.size(); i++){
                System.out.println("\t"+(i+1)+". " + songArrayList.get(i).getTitle()+". Duration : " + songArrayList.get(i).getDuration() );

            }
        }


    }
}



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
