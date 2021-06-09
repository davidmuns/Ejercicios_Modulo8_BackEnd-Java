package video.domain;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Marco extends JFrame{
	
	//Constructor de clase: Invocar metódos heredados de clase JFrame
	public Marco() {
		Lamina lamina = new Lamina();
		
		//Establecer tamaño del marco
		setSize(500, 300);
		
		//Posición marco en el centro de la pantalla
		setLocationRelativeTo(null);
		
		//Terminar ejecución programa al cerrar marco
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Cambiar tamaño del marco
		setResizable(false);
		
		setTitle("VIDEOS");
		
		//Añadir objeto lamina al marco
		add(lamina);
		
		//Establecer visivilidad del marco
		setVisible(true);
		
		
		
	}
}