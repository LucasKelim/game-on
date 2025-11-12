package gameon.models.enums;

public enum TipoMovimentacao {
	SAIDA("Saída"),
	ENTRADA("Entrada"),
	AJUSTE("Ajuste");
	
	private final String descricao;
	
	private TipoMovimentacao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
