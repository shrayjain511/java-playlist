package arrays.arraylists.linkedlists;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static playlist myPlaylist = new playlist("myPlaylist");

    public static void main(String[] args) {
        
        boolean run = true;
        Collections myCollection = new Collections("my collection");
        Album album1 = myCollection.addAlbum("Ed Sheeran");
        album1.addSong("i don't care", 4);
        album1.addSong("happier", 5);
        album1.addSong("shape of you", 5);
        album1.addSong("lego house", 6);
        album1.addSong("perfect", 5);
        Album album2 = myCollection.addAlbum("Taylor Swift");
        album2.addSong("Blank Space", 5);
        album2.addSong("Cardigan", 4);
        album2.addSong("Me", 5);
        album2.addSong("Red", 5);
        album2.addSong("August", 6);
        myPlaylist.addSong(myCollection,"Taylor Swift", "Cardigan");
        myPlaylist.addSong(myCollection,"Ed Sheeran", "happier");
        myPlaylist.addSong(myCollection,"Taylor Swift", "Red");
        myPlaylist.addSong(myCollection,"Ed Sheeran", "lego house");
        myPlaylist.addSong(myCollection,"Ed Sheeran", "perfect");

        while (run) {
            System.out.println("choose an action\n");
            printOptions();
            int key = scanner.nextInt();
            switch (key) {
                case 1:
                    myPlaylist.forwardSong(myPlaylist);
                    break;
                case 2:
                    myPlaylist.previousSong(myPlaylist);
                    break;
                case 3:
                    myPlaylist.replaySong(myPlaylist);
                    break;
                case 4:
                    myPlaylist.play(myPlaylist);
                    break;
                case 5:
                    run = false;
                    break;
                case 6:
                    printOptions();
                default:
                    System.out.println("enter correct value");
            }  
        }
        
       // System.out.println("do you wish to continue? (y/n)");
        //run = scanner.next().charAt(0); // IMPORTANT FEATURE: how to input a single character
    }

	public static void printOptions() {
        System.out.println("1.skip to next song\n2.skip back to previous song\n3.replay the current song\n4.play all the songs\n5.quit\n6.print menu options");
                
    }
    

}