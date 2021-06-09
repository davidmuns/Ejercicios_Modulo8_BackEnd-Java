package video.domain;

import java.util.ArrayList;

import video.utilities.EstadoVideo;

public class Video {
	private String titulo;
	private Usuario usuario;
	private String enlace;
	private Tag tag;
	private ArrayList<Tag> tags;
	private String fechaSubida;
	private EstadoVideo estado;
	
	public Video(Usuario usuario, String titulo) {
		this.usuario = usuario;
		this.titulo = titulo;
		this.enlace = "http://" + titulo.replace(" ", "") + "/" + usuario.getNombre() + usuario.getApellido();
		tags = new ArrayList<Tag>();
		estado = EstadoVideo.PRIVATE;
	}
	
	public void setEstado(EstadoVideo estado) {
		this.estado = estado;
	}
	
	public EstadoVideo getEstado() {
		return estado;
	}
	
	public void setFechaSubida(String fechaSubida) {
		this.fechaSubida = fechaSubida;
	}
	
	public String getFechaSubida() {
		return fechaSubida;
	}

	public String getTitulo() {
		return titulo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void addTag(Tag tag) {
		this.tag = tag;
		tags.add(this.tag);
	}

	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("Video [titulo=" + titulo);
		sb.append(", enlace=" + enlace);
		sb.append(", tags=" + tags);
		sb.append(", estado=" + estado);
		sb.append(", fechaSubida=" + fechaSubida);
		sb.append(", " + usuario);
		sb.append("]");

		return sb.toString();
	}
}
