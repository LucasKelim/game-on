package gameon.models.enums;

public enum OrdemStatus {
    PENDENTE("Pendente"),
    PAGO("Pago"),
    ENVIADO("Enviado"),
    ENTREGUE("Entregue"),
    CANCELADO("Cancelado");
	
	private final String descricao;
    
    OrdemStatus(String descricao) {
    	this.descricao = descricao;
    }
    
    public String getDescricao() {
    	return descricao;
    }
}
