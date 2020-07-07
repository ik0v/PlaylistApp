public class Song {

    private String name;
    private double duration;
    private String durAsString;


    public Song(String name, double duration) {
        this.name = name;
        this.duration = duration;
        String durationAsString = String.valueOf(duration);
        this.durAsString = durationAsString.replace(".",":");

    }

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return "\'" + name + "' " + durAsString;
    }
}
