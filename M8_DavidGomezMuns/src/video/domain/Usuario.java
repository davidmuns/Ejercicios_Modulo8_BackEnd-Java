package video.domain;

public class Usuario {
	private String nombre;
	private String apellido;
	private String password;
	private String fechaRegistro;
	

	public Usuario(String nombre, String apellido, String password) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.password = password;
		fechaRegistro = Fecha.fechaActualStringFormat();	
	}
		
	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getPassword() {
		return password;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Usuario [nombre=" + nombre);
		sb.append(", apellido=" + apellido);
		sb.append(", password=" + password);
		sb.append(", fechaRegistro=" + fechaRegistro);
		sb.append("]");
		
		return sb.toString();
	}	
	
}
