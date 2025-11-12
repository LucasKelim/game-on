package gameon.models.DTO;

public class AdminDTO extends UsuarioDTO {
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AdminDTO [");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}	
}
