package com;

import java.util.ArrayList;
import java.util.List;

public class MusicPlayer {

	private ArrayList<Song> allSongs = new ArrayList<Song>();
	private ArrayList<Playlist> playlists =new ArrayList<>() ;
	
	
	
	public void addSong(Song song) {
		allSongs.add(song);
	}
	
	
	public void updateSong(String title,Song song1) {
		for(int i=0;i<allSongs.size();i++) {
			if(allSongs.get(i).getTitle().equalsIgnoreCase(title)) {
				allSongs.set(i,song1);
				return;
			}
		}
	}
	
	
	public void deleteSong(String title) {		
		allSongs.removeIf(song->song.getTitle().equalsIgnoreCase(title));
	}
	
	public void displayAllSongs() {
		if(allSongs.isEmpty()) {
			System.out.println("No songs in the library");
		}else {
			for(Song song:allSongs) {
				System.out.println(song);
			}
		}
	}
	
	public void createPlayList(String name) {
		playlists.add(new Playlist(playlists.size()+1,name));
	}
	
	public void deletePlayList(String name) {
		playlists.removeIf(playlist->playlist.getPlaylistName().equalsIgnoreCase(name));
	}
	
	 public void displayAllPlaylists() {
	        if (playlists.isEmpty()) {
	            System.out.println("No playlists found.");
	        } else {
	            for (Playlist playlist : playlists) {
	                System.out.println("Playlist: " + playlist.getPlaylistName());
	            }
	        }
	    }

	    public Playlist getPlaylist(String name) {
	        for (Playlist playlist : playlists) {
	            if (playlist.getPlaylistName().equalsIgnoreCase(name)) {
	                return playlist;
	            }
	        }
	        return null;
	    }

	    public void addSongToPlaylist(String playlistName, Song song) {
	        Playlist playlist = getPlaylist(playlistName);
	        if (playlist != null) {
	            playlist.addSong(song);
	        }
	    }

	    public void playPlaylist(String name) {
	        Playlist playlist = getPlaylist(name);
	        if (playlist != null) {
	            playlist.displaySong();
	        }
	    }

	    public List<Song> getAllSongs() {
	        return allSongs;
	    }
	
}
