package video.domain;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import video.aplication.VideoController;
import video.persistence.Repository;
import video.utilities.CampoVacio;


@SuppressWarnings("serial")
public class Lamina extends JPanel {

	// Constructor de clase
	public Lamina() {
		setBackground(new Color(190, 50, 10));

		// Crear instancias de tipo JButton
		JButton crearUsuario = new JButton("Crear usuario");
		JButton crearVideo = new JButton("Crear video");
		JButton subirVideo = new JButton("Subir video");
		JButton imprimirVideos = new JButton("Imprimir todos los videos");
		JButton imprimirUsuarios = new JButton("Imprimir listado usuarios");
		JButton crearTag= new JButton("Crear tag");
		JButton misVideos = new JButton("Ver mis videos");

		// Añadir botons a Lamina
		add(crearUsuario);
		add(crearVideo);
		add(subirVideo);
		add(crearTag);
		add(misVideos);
		add(imprimirVideos);
		add(imprimirUsuarios);
		
		// Lanzar evento al pulsar boton
		crearUsuario.addActionListener(new LlamarMetodos(1));
		crearVideo.addActionListener(new LlamarMetodos(2));
		imprimirVideos.addActionListener(new LlamarMetodos(3));
		imprimirUsuarios.addActionListener(new LlamarMetodos(4));
		crearTag.addActionListener(new LlamarMetodos(5));
		misVideos.addActionListener(new LlamarMetodos(6));
		subirVideo.addActionListener(new LlamarMetodos(7));
	}// Fin constructor

}// Fin clase Lamina

//Clase que recibe eventos de botón
class LlamarMetodos implements ActionListener {
	private VideoController vc = VideoController.getInstance();
	private Repository repository = Repository.getInstance();
	private int opcion;

	// Constructor de clase
	public LlamarMetodos(int opcion) {
		this.opcion = opcion;
	}

	// Implementar método interface ActionListener
	public void actionPerformed(ActionEvent e) {
		// Invocar métodos clase VideController
		switch (opcion) {
		case 1:
			try {
				vc.crearUsuario();
			} catch (CampoVacio cv) {
				JOptionPane.showMessageDialog(null, "No se pueden dejar campos vacios.");
			} 
			break;
		case 2:

			if (repository.getUsers().size() != 0) {
				try {
					vc.verificarUsuario();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "El usuario no existe.");
					
				}
			} else {
					JOptionPane.showMessageDialog(null, "No hay ningún usuario registrado.");
				}
			break;
		case 3:
			if (repository.getVideos().size() != 0) {
				System.out.println("LISTA VIDEOS:");
				for(Video v: repository.getVideos()) {
					System.out.println(v);
				}
				System.out.println("*******");
			}else {
				JOptionPane.showMessageDialog(null, "No hay videos en la lista.");
			}
			break;
		case 4:
			if(repository.getUsers().size() != 0) {
				System.out.println("LISTA USUARIOS:");
				for(Usuario u: repository.getUsers()) {
					System.out.println(u);
				}
				System.out.println("*******");
			}else {
				JOptionPane.showMessageDialog(null, "No hay usuarios en la lista.");
			}
			break;		
		case 5:
			if(repository.getVideos().size() != 0) {
				try {
					vc.crearTag();
				} catch (CampoVacio cv) {				
					JOptionPane.showMessageDialog(null, "No se pueden dejar campos vacios.");
					
				}
			}else {
				JOptionPane.showMessageDialog(null, "No hay videos en la lista.");
			}
			break;		
		case 6:
			try {
				vc.crearLista();
			} catch (CampoVacio cv) {
				JOptionPane.showMessageDialog(null, "No se pueden dejar campos vacios.");
			}
			break;
		case 7:
			if(repository.getVideos().size() != 0) {
				try {
					vc.subirVideo();
				} catch (CampoVacio cv) {
					JOptionPane.showMessageDialog(null, "No se pueden dejar campos vacios.");			
				}
			}else {
				JOptionPane.showMessageDialog(null, "No hay videos en la lista.");
			}
			break;
		}
	}// Fin método actionPerformed()
}// Fin clase LlamarMetodos()
