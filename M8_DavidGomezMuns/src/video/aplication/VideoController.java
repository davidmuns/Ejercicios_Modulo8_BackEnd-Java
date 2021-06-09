package video.aplication;

import java.util.ArrayList;
import javax.swing.JOptionPane;

import video.domain.Fecha;
import video.domain.Tag;
import video.domain.Usuario;
import video.domain.Video;
import video.persistence.Repository;
import video.utilities.CampoVacio;

public class VideoController {

	private Repository repository;
	private Usuario usuario;
	private ArrayList<Video> misVideos;
	private static VideoController instance = new VideoController();
	private String nombre, apellido, password;
	
	private VideoController() {
		repository = Repository.getInstance(); 
		misVideos = new ArrayList<Video>();
	}
	
	public static VideoController getInstance() {
		return instance;
	}
	
	private void capturarDatosUsuario() throws CampoVacio {
		nombre = JOptionPane.showInputDialog("Introduce tu nombre");
		if(nombre == null) throw new CampoVacio();
		
		apellido = JOptionPane.showInputDialog("Introduce tu apellido");
		if(apellido == null) throw new CampoVacio();
		
		password = JOptionPane.showInputDialog("Introduce una contraseña");
		if(password == null) throw new CampoVacio();
		
	}
	
	public void crearUsuario() throws CampoVacio {
		
		capturarDatosUsuario();
		
		if(nombre.equals("") || apellido.equals("") || password.equals("")) {
			throw new CampoVacio();
		}else {
			usuario = new Usuario(nombre, apellido, password);
			repository.addUsuario(usuario);
			JOptionPane.showMessageDialog(null, "Usuario creado:\n-Nombre: " + nombre + "\n-Apellido: " + apellido);
		}
	}
	
	public void verificarUsuario () throws CampoVacio {
		
		capturarDatosUsuario();
		
		for(int i = 0; i < repository.getUsers().size(); i++) {
			if(repository.getUsers().get(i).getNombre().equalsIgnoreCase(nombre) &&
			   repository.getUsers().get(i).getApellido().equalsIgnoreCase(apellido) &&
			   repository.getUsers().get(i).getPassword().equalsIgnoreCase(password)) 
			{
				usuario = repository.getUsers().get(i);
				try {
				crearVideo();
				}catch(CampoVacio e) {
					JOptionPane.showMessageDialog(null, "No se pueden dejar campos vacios.");
					e.printStackTrace();
				}			
				break;
			}
			usuario = null;			
		}
		if(usuario == null) throw new CampoVacio();
	}

	public void crearVideo() throws CampoVacio {
		String titulo = JOptionPane.showInputDialog("Introduce titulo video");
		if(titulo == null) throw new CampoVacio();
		
		if(titulo.equals("")) throw new CampoVacio();
			else
				repository.addVideo(new Video(usuario, titulo));
	}
	
	public void subirVideo() throws CampoVacio {
		ProcesoCargaVideo procesoCarga = new ProcesoCargaVideo();
		String fechaSubida = Fecha.fechaActualStringFormat();
		String tituloVideo = JOptionPane.showInputDialog("Introduce titulo video");
		
		boolean existe = false;
		if(tituloVideo == null || tituloVideo.equals("")) {
			throw new CampoVacio();
		}else {
			for (int i = 0; i < repository.getVideos().size(); i++) {
				if (repository.getVideos().get(i).getTitulo().equalsIgnoreCase(tituloVideo)) {
					procesoCarga.cargar(i);
					repository.getVideos().get(i).setFechaSubida(fechaSubida);
					existe = true;
				}
			}
		}
		if(existe) JOptionPane.showMessageDialog(null, "Hemos publicado el video \"" + tituloVideo + "\" con fecha " + fechaSubida);
			else JOptionPane.showMessageDialog(null, "El video no existe.");
	}

	public void crearTag() throws CampoVacio {
		
		String tituloVideo = JOptionPane.showInputDialog("Introduce titulo video");
		if(tituloVideo == null) throw new CampoVacio();
		
		
		String textoTag = JOptionPane.showInputDialog("Introduce texto etiqueta");
		if(textoTag == null) throw new CampoVacio();
		
		if(tituloVideo.equals("") || textoTag.equals("")) {
			throw new CampoVacio();
		}else {
			for (int i = 0; i < repository.getVideos().size(); i++) {
				if (repository.getVideos().get(i).getTitulo().equalsIgnoreCase(tituloVideo)) {
					repository.getVideos().get(i).addTag(new Tag(textoTag));
				}
			}
		}
	}
	
	public void crearLista() throws CampoVacio {
		boolean existe = false;
		String password = JOptionPane.showInputDialog("Introduce tu clave personal: ");
		if(password == null) throw new CampoVacio();
		
		if(password.equals("")) {
			throw new CampoVacio();
		}else {
			for (int i = 0; i < repository.getVideos().size(); i++) {
				if (repository.getVideos().get(i).getUsuario().getPassword().equalsIgnoreCase(password)) {
					existe = true;
					misVideos.add(repository.getVideos().get(i));
				}
			}
		}
		if (existe == false) {
			JOptionPane.showMessageDialog(null, "No hemos encontrado ningún video.");
		}else {
			for(Video v: misVideos) {
				System.out.println(v);			
			}
			misVideos.clear();
			System.out.println("*****");
		}
		
	}

}
