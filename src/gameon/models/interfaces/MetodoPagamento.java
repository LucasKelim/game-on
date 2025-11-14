package gameon.models.interfaces;

import gameon.models.DTO.Ordem;

public interface MetodoPagamento {
	public boolean processarPagamento(Ordem ordem);
	public String descricao();
}
