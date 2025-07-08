package com;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MusicPlayer player = new MusicPlayer();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n========= MUSIC PLAYER MENU =========");
            System.out.println("1. Add New Song");
            System.out.println("2. Update Existing Song");
            System.out.println("3. Delete Song");
            System.out.println("4. Display All Songs");
            System.out.println("5. Create New Playlist");
            System.out.println("6. Add Song to Playlist");
            System.out.println("7. Display All Playlists");
            System.out.println("8. Display Songs in Playlist");
            System.out.println("9. Play Song in Playlist");
            System.out.println("10. Pause Song in Playlist");
            System.out.println("11. Stop Song in Playlist");
            System.out.println("12. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Song ID: ");
                    int id = sc.nextInt(); 
                    sc.nextLine();
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Artist: ");
                    String artist = sc.nextLine();
                    System.out.print("Enter Duration (in mins): ");
                    double duration = sc.nextDouble(); sc.nextLine();
                    player.addSong(new Song(id, title, artist, duration));
                }
                case 2 -> {
                    System.out.print("Enter Title of Song to Update: ");
                    String oldTitle = sc.nextLine();
                    System.out.print("Enter New Song ID: ");
                    int newId = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter New Title: ");
                    String newTitle = sc.nextLine();
                    System.out.print("Enter New Artist: ");
                    String newArtist = sc.nextLine();
                    System.out.print("Enter New Duration: ");
                    double newDuration = sc.nextDouble(); sc.nextLine();
                    player.updateSong(oldTitle, new Song(newId, newTitle, newArtist, newDuration));
                }
                case 3 -> {
                    System.out.print("Enter Song Title to Delete: ");
                    String delTitle = sc.nextLine();
                    player.deleteSong(delTitle);
                }
                case 4 -> player.displayAllSongs();
                case 5 -> {
                    System.out.print("Enter Playlist Name: ");
                    String playlistName = sc.nextLine();
                    player.createPlayList(playlistName);
                }
                case 6 -> {
                    System.out.print("Enter Playlist Name: ");
                    String pname = sc.nextLine();
                    System.out.print("Enter Song Title to Add: ");
                    String songTitle = sc.nextLine();
                    Song found = player.getAllSongs().stream()
                        .filter(song -> song.getTitle().equalsIgnoreCase(songTitle))
                        .findFirst().orElse(null);
                    if (found != null) {
                        player.addSongToPlaylist(pname, found);
                    } else {
                        System.out.println("Song not found.");
                    }
                }
                case 7 -> player.displayAllPlaylists();
                case 8 -> {
                    System.out.print("Enter Playlist Name: ");
                    String pname = sc.nextLine();
                    Playlist pl = player.getPlaylist(pname);
                    if (pl != null) pl.displaySong();
                    else System.out.println("Playlist not found.");
                }
                case 9 -> {
                    System.out.print("Enter PlayList name Title to Play: ");
                    String title = sc.nextLine();
                    Playlist pl = player.getPlaylist(title);
                    if (pl != null) pl.play(title);
                    else System.out.println("Song not found in any playlist.");
                }
                case 10 -> {
                    System.out.print("Enter Song Title to Pause: ");
                    String title = sc.nextLine();
                    Playlist pl = player.getPlaylist(title);
                    if (pl != null) pl.pause(title);
                    else System.out.println("Song not found in any playlist.");
                }
                case 11 -> {
                    System.out.print("Enter Song Title to Stop: ");
                    String title = sc.nextLine();
                    Playlist pl = player.getPlaylist(title);
                    if (pl != null) pl.stop(title);
                    else System.out.println("Song not found in any playlist.");
                }
                case 12 -> {
                    System.out.println("Exiting Music Player...");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
    
}
