package video.domain;

public class Tag {

	private String textoTag;
	
	public Tag(String textoTag) {
		this.textoTag = textoTag;		
	}
	
	public String getTextoTag() {
		return textoTag;
	}
	public void setTextoTag(String textoTag) {
		this.textoTag = textoTag;
	}
	
	public String toString() {
		return textoTag;
	}
}
