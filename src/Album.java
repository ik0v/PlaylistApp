import java.util.ArrayList;

public class Album {
    private String name;
    private ArrayList<Song> songs;

    public Album(String name) {
        this.name = name;
        songs = new ArrayList<Song>();
    }

    public void addSong(String name, double duration) {
        if(checkSong(name)) {
            System.out.println("Track '" + name + "' already is in album " + this.name); // validation for name
            return;
        } if(duration%1 >= 0.60) {      // kind of validation for amount of seconds, 59 maks.
            System.out.println("Track '" + name + "' have 60 or more seconds in length");
            return;
        } else {
            songs.add(new Song(name, duration));
        }
    }

    public boolean checkSong(String name) {
        for(Song i: songs) {
            if(name.equals(i.getName())) return true;
        }
        return false;
    }

    public Song getSong(int i) {
        if(i >=0 && i < songs.size()) return songs.get(i);
        return null;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    @Override
    public String toString() {
        String result = "Album \'" + name + "\', song list:";
        for(Song i: songs) {
            result += "\n " + i;
        }
        return result;
    }
}
