package arrays.arraylists.linkedlists;

import java.util.ArrayList;


public class Album {
   
    private ArrayList<Song>album1 ;
    private String albumName;

    public Album(String albumName) {
        this.album1 = new ArrayList<Song>();
        this.albumName = albumName;
    }

    public String getAlbumName() {
        return albumName;
    }
   
    /* public void addSong() {
        System.out.println("set song name");
        String newName = scanner.nextLine();
        System.out.println("set duration");
        int newDuration = scanner.nextInt();
        Song newSong = new Song(newName, newDuration);
        album1.add(newSong);  //THIS TYPE OF CALLING CAN'T BE DEFINED HERE COZ MAIN WON'T HAVE "album1" HENCE
                              // WE NEED TO DEFINE IT THERE WITH AN LOCAL ALBUM OBJECT ATTACHED TO IT
    }*/

    public void addSong(String newName,int newDuration) {
        if(findSong(newName)==null){
        album1.add(new Song(newName, newDuration));
        }
    }

    public void printAlbum(){
        for(int i=0;i<album1.size();i++){
            System.out.println((i+1)+"."+album1.get(i).getTitle());
        }
    }

    public Song findSong(String songTitle) {
        for(int i=0;i<album1.size();i++){
            if(album1.get(i).getTitle().equals(songTitle)){
                Song foundSong = album1.get(i);
                return foundSong;
            }
        }
        return null;
        
    }
}