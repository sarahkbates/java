package udemy_exercises.songs;

import java.util.*;

class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;
    private static ArrayList<Album> albums = new ArrayList<Album>();

    public Album(String name, String artist){
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }

    public boolean addSong(String title, double duration){
        if(findSong(title) == null){
            this.songs.add(new Song(title, duration));
            return true;
        }
        return false;
    }

    private Song findSong(String title){
        for(Song checkedSong: this.songs){
            if(checkedSong.getTitle().equals(title)){
                return checkedSong;
            }
        }
        return null;
    }

    public boolean addToPlaylist(int trackNumber, LinkedList<Song> playlist){
        int index = trackNumber - 1;
        if((index >= 0) && (index <= this.songs.size())){
            playlist.add(this.songs.get(index));
            return true;
        }
        System.out.println("This slbum does not have a track " + trackNumber);
        return false;
    }

    public boolean addToPlaylist(String title, LinkedList <Song> playlist){
        Song checkedSong = findSong(title);
        if (checkedSong != null){
            playlist.add(checkedSong);
            return true;
        }
        System.out.println("The song " + title + " is not in this album.");
        return false;
    }

    public static void main(String[] args){
        Album album = new Album("Manic", "Halsey");
        album.addSong("Ashley", 3.06);
        album.addSong("clementine", 3.55);
        album.addSong("Graveyard", 3.02);
        album.addSong("You Should Be Sad", 3.26);
        album.addSong("Forever...(is a long time)", 2.48);
        album.addSong("Dominic's Interlude", 1.17);
        album.addSong("I HATE EVERYBODY", 2.51);
        album.addSong("3am", 3.22);
        album.addSong("Without Me", 3.22);
        album.addSong("Finally // Beautiful Stranger", 3.41);
        album.addSong("Alanis' Interlude", 2.41);
        album.addSong("killing boys", 2.23);
        album.addSong("SUGA's Interlude", 2.18);
        album.addSong("More", 2.33);
        album.addSong("Still Learning", 3.32);
        album.addSong("929", 2.55);
        albums.add(album);

        album = new Album("American Teen", "Khalid");
        album.addSong("American Teen", 4.11);
        album.addSong("Young Dumb & Broke", 3.23);
        album.addSong("Location", 3.39);
        album.addSong("Another Sad Love Song", 4.05);
        album.addSong("Saved", 3.27);
        album.addSong("Coaster", 3.19);
        album.addSong("8TEEN", 3.49);
        album.addSong("Let's Go", 3.25);
        album.addSong("Hopeless", 2.48);
        album.addSong("Cold Blooded", 3.28);
        album.addSong("Winter", 4.02);
        album.addSong("Therapy", 4.18);
        album.addSong("Keep Me", 4.36);
        album.addSong("Shot Down", 3.27);
        album.addSong("Angles", 2.51);
        albums.add(album);

        LinkedList<Song> playlist = new LinkedList<Song>();
        albums.get(0).addToPlaylist("929", playlist);
        albums.get(0).addToPlaylist("clementine", playlist);
        albums.get(0).addToPlaylist("Gasoline", playlist); // shouldn't work
        albums.get(0).addToPlaylist(5, playlist);
        albums.get(1).addToPlaylist(1, playlist);
        albums.get(1).addToPlaylist(6, playlist);
        albums.get(1).addToPlaylist(7, playlist);
        albums.get(1).addToPlaylist(21, playlist); // There is no track 21

        play(playlist);

    }

    private static void stop(){
        System.out.println("Playlist complete.");
    }

    private static void play(LinkedList<Song> playlist){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playlist.listIterator();
        if(playlist.size() == 0){
            System.out.println("No songs in playlist.");
            return;
        } else{
            System.out.println("Npw playing " + listIterator.next().toString());
            printMenu();
        }
        while(!quit){
            int action = scanner.nextInt();
            scanner.nextLine();

            switch(action){
                case 0:
                    stop();
                    quit = true;
                    break;
                case 1:
                    if(!forward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now playing " + listIterator.next().toString());
                    } else{
                        System.out.println("We have reached the end of the playlist.");
                        forward = false;
                    }
                    break;
                case 2:
                    if(forward) {
                        if(listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("We are at the start of the playlist");
                        forward = true;
                    }
                    break;
                case 3:
                    if(forward) {
                        if(listIterator.hasPrevious()) {
                            System.out.println("Now replaying " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("We are at the start of the list");
                        }
                    } else {
                        if(listIterator.hasNext()) {
                            System.out.println("Now replaying " + listIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("We have reached the end of the list");
                        }
                    }
                    break;
                case 4:
                    printList(playlist);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if(playlist.size() > 0) {
                        listIterator.remove();
                        if(listIterator.hasNext()) {
                            System.out.println("Now playing " + listIterator.next());
                        } else if (listIterator.hasPrevious()) {
                            System.out.println("Now playing " + listIterator.previous());
                        } else {
                            System.out.println("The playlist is now empty");
                        }
                    }
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Available actions:\npress");
        System.out.println("0 - to quit\n" +
                "1 - to play next song\n" +
                "2 - to play previous song\n" +
                "3 - to replay current song\n" +
                "4 - to list songs in playlist\n" +
                "5 - to print available actions\n" +
                "6 - to remove current song\n");
    }

    private static void printList(LinkedList<Song> playList) {
        Iterator<Song> iterator = playList.iterator();
        System.out.println("==========================");
        while ((iterator.hasNext())) {
            System.out.println(iterator.next());
        }
        System.out.println("==========================");
    }


}

/*
**Song Player w/ Java Classes**
     - **Album class** 
       - Playlist of **Songs**.
       - addPlayist() (songs must appear in the list in the order by which they were added)
       - stop()
       - nextSong()
       - previousSong()
       - repeatSong()
       - showPlaylist()
       - removePlaylist()
     - **A song must exist in an album before it can be added to the playlist (so you can only play songs that you own.)**
*/