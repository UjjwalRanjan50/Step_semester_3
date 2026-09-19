package encapsulation.assignment_problems;

public class Playlist {
    private String[] songs;
    private int count;

    public Playlist(int capacity) {
        songs = new String[capacity];
        count = 0;
    }

    public void addSong(String title) {
        if (count < songs.length) {
            songs[count++] = title;
        } else {
            System.out.println("Playlist is full.");
        }
    }

    public String[] getSongs() {
        String[] copy = new String[count];
        for (int i = 0; i < count; i++) {
            copy[i] = songs[i];
        }
        return copy;
    }

    public int getSongCount() {
        return count;
    }
}
