package video.domain;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Marco extends JFrame{
	
	//Constructor de clase: Invocar met�dos heredados de clase JFrame
	public Marco() {
		Lamina lamina = new Lamina();
		
		//Establecer tama�o del marco
		setSize(500, 300);
		
		//Posici�n marco en el centro de la pantalla
		setLocationRelativeTo(null);
		
		//Terminar ejecuci�n programa al cerrar marco
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Cambiar tama�o del marco
		setResizable(false);
		
		setTitle("VIDEOS");
		
		//A�adir objeto lamina al marco
		add(lamina);
		
		//Establecer visivilidad del marco
		setVisible(true);
		
		
		
	}
}