package com;

public interface Playable {
	
	public void play(String title);
	
	public void play(int songId);
	
	public void pause(String title);
	
	public void pause(int songId);
	
	public void stop(String title);
	public void stop(int songId);

}
