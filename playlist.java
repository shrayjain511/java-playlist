package arrays.arraylists.linkedlists;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class playlist {
    private LinkedList <Song> play1;
    private String playlistName;
    boolean forward = true;

    public String getPlaylistName() {
        return playlistName;
    }

    public LinkedList<Song> getPlay1() {
        return play1;
    }

    public playlist(String playlistName) {
        this.playlistName = playlistName;
        this.play1 = new LinkedList<Song>();
    }


    public void addSong(Collections collection,String albumName, String songName) {
        Album selectedAlbum = collection.findAlbum(albumName);
        if(selectedAlbum!=null){
           Song selectedSong = selectedAlbum.findSong(songName);
           if(selectedSong!=null){
               play1.add(selectedSong);
           }else{
               System.out.println("song not found in album "+selectedAlbum.getAlbumName());
           }
        }
        else{
            System.out.println("album not found");
        }
    }

    public void play(playlist playlist) {
        Iterator <Song> i = playlist.getPlay1().iterator();
        while(i.hasNext()){
            System.out.println("now playing "+i.next().toString());
        }
    }

    public void forwardSong(playlist playlist) {
        ListIterator <Song> i = playlist.getPlay1().listIterator();
        if(!forward){
            if(i.hasNext())
            i.next();
            forward = true;
        }
        if(i.hasNext()){
            System.out.println("now playing "+i.next().toString());
        }else{
            System.out.println("you have reached end of the playlist");
            forward = false;
        }
        
    }

    public void previousSong(playlist playlist){
        ListIterator <Song> li = playlist.getPlay1().listIterator();
        if(!forward){
            if(li.hasPrevious())
                li.previous();
            forward = false;
        }
        if(li.hasPrevious()){
            System.out.println("now playing "+li.previous().toString());
        }else{
            System.out.println("you are at the start of the playlist");
            forward = true;
        }
        
    }

    public void replaySong(playlist playlist){
        ListIterator <Song> li = playlist.getPlay1().listIterator();
        if(forward){
            if(li.hasPrevious()){
            System.out.println("now replaying "+li.previous().toString());
            forward = false;
            }else{
            System.out.println("you are at the start of the list");
            }
        }else{
            if(li.hasNext()){
                System.out.println("now playing "+li.next().toString());
                forward = true;
            }else{
                System.out.println("you have reached the end of the list");
            }
        }
    }

    public void removeSong(){
        ListIterator <Song> li = play1.listIterator();
        li.previous();
        li.remove();
    }


}
class Collections {
    private ArrayList<Album> albums;
    private String collectionName;

    public Collections(String collectionName) {
        this.collectionName = collectionName;
        this.albums = new ArrayList<Album>();
    }

    public String getCollectionName() {
        return collectionName;
    }
    public Album addAlbum(String newAlbumName) {
        Album newAlbum = new Album(newAlbumName);
        albums.add(newAlbum);
        return newAlbum;
    }
    public void printAlbums() {
        for(int i=0;i<albums.size();i++){
            System.out.println((i+1)+" . "+albums.get(i).getAlbumName());
        
        }
    }

    public Album findAlbum(String albumName) {
        for(int i=0;i<albums.size();i++){
            if(albums.get(i).getAlbumName().equals(albumName)){
                Album foundAlbum = albums.get(i);
                return foundAlbum;
            }
        }
        return null;
        
    }
}