package video.persistence;

import java.util.ArrayList;

import video.domain.Usuario;
import video.domain.Video;

public class Repository {
	private ArrayList<Usuario> usuarios;
	private ArrayList<Video> videos;
	private static Repository instance = new Repository();

	private Repository() {
		usuarios = new ArrayList<Usuario>();
		videos = new ArrayList<Video>();
	}

	public static Repository getInstance() {
		return instance;
	}
	
	public void addUsuario(Usuario usuario) {
		usuarios.add(usuario);
	}
	
	public void addVideo(Video video) {
		videos.add(video);
	}
	
	public ArrayList<Usuario> getUsers(){
		return usuarios;
	}
	
	public ArrayList<Video> getVideos() {
		return videos;
	}
	
}
