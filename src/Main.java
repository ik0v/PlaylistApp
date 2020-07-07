import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Album album1 = new Album("Classic songs");
        Album album2 = new Album("Pop music");

        album1.addSong("classic1", 2.41);
        album1.addSong("classic2", 1.37);
        album1.addSong("classic1", 5.21); // trying to add song with same name, error generated
        album1.addSong("classic3", 4.15);
        album1.addSong("classic4", 2.65); // trying to add song with 65 seconds, error generated

        album2.addSong("pop1", 3.01);
        album2.addSong("pop2", 2.49);
        album2.addSong("pop3", 2.17);

//        System.out.println(album1.toString()); - option to see all tracks in album 1, commented out by default
//        System.out.println(album2.toString()); - option to see all tracks in album 2, commented out by default

        LinkedList<Song> playlist = new LinkedList<Song>();

        addToPlaylist(album1.getSong(0), playlist);
        addToPlaylist(album1.getSong(1), playlist);
        addToPlaylist(album1.getSong(2), playlist);
        addToPlaylist(album2.getSong(0), playlist);
        addToPlaylist(album1.getSong(3), playlist); // trying to add non existing song, error generated

        usePlaylist(playlist);
    }

    public static void usePlaylist(LinkedList<Song> playlist) {
        ListIterator<Song> i = playlist.listIterator();
        Scanner scanner = new Scanner(System.in);
        boolean forward = true;
        if(playlist.isEmpty()) {
            System.out.println("No songs in playlist");
        } else {
            System.out.println("\nNow playing: " + i.next());
        }
        printMenu();
        int choose = scanner.nextInt();
        scanner.nextLine();
        while (choose!=0) {
            switch (choose) {
                case 1:
                    if(!forward) {
                        if(i.hasNext()) {
                            i.next();
                        }
                        forward = true;
                    }
                    if(i.hasNext()) System.out.println("Now playing: " + i.next());
                    else {
                        System.out.println("Reached the end of playlist");
                        forward = false;
                    }
                    break;
                case 2:
                    if(forward) {
                        if(i.hasPrevious()) {
                            i.previous();
                        }
                        forward = false;
                    }
                       if(i.hasPrevious()) System.out.println("Now playing: " + i.previous());
                    else {
                        System.out.println("Start of playlist, select go forward");
                        forward = true;
                    }
                    break;
                case 3:
                    if(!i.hasNext() && !forward) {
                        System.out.println("End of playlist, cant repeat");
                        break;
                    }
                    if(!i.hasPrevious() && forward) {
                        System.out.println("Start of playlist, cant repeat");
                        break;
                    }
                    if(!forward && i.hasNext()) {
                        i.next();
                        forward = true;
                    }
                    i.previous();
                    System.out.println("Replaying: " + i.next());
                    break;
                case 4:
                    printList(playlist);
                    break;
                case 5:
                    printMenu();
                    break;
                default:
                    System.out.println("Press 5 to see menu again");
            }
            choose = scanner.nextInt();
        }
    }

    public static void printMenu() {
        System.out.println("Choose from menu: "
                + "\n0. Quit"
                + "\n1. Play next song."
                + "\n2. Play previous song."
                + "\n3. Replay current song."
                + "\n4. List all songs in playlist."
                + "\n5. Print menu again.");
    }

    private static void printList(LinkedList<Song> playlist) {
        Iterator<Song> i= playlist.iterator();
        while(i.hasNext()) {
            System.out.println(i.next());
        }
        System.out.println("=========================");
    }

    private static void addToPlaylist(Song songToBeAdded, LinkedList<Song> playlist) {
        if (songToBeAdded != null) {
            playlist.add(songToBeAdded);
        } else {
            System.out.println("Please select valid track from album");
        }
    }

}
