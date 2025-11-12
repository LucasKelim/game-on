package gameon.models.DTO;

import java.time.LocalDateTime;

import gameon.models.enums.TipoMovimentacao;

public class MovimentacaoDTO {
	private int id;
	private TipoMovimentacao movimentacao;
	private int quantidade;
	private ProdutoDTO produto;
	private LocalDateTime CriadoEm;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public TipoMovimentacao getMovimentacao() {
		return movimentacao;
	}
	
	public void setMovimentacao(TipoMovimentacao movimentacao) {
		this.movimentacao = movimentacao;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public ProdutoDTO getProduto() {
		return produto;
	}
	
	public void setProduto(ProdutoDTO produto) {
		this.produto = produto;
	}
	
	public LocalDateTime getCriadoEm() {
		return CriadoEm;
	}
	
	public void setCriadoEm(LocalDateTime criadoEm) {
		CriadoEm = criadoEm;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MovimentacaoDTO [id=");
		builder.append(id);
		builder.append(", movimentacao=");
		builder.append(movimentacao.getDescricao());
		builder.append(", quantidade=");
		builder.append(quantidade);
		builder.append(", produto=");
		builder.append(produto);
		builder.append(", CriadoEm=");
		builder.append(CriadoEm);
		builder.append("]");
		return builder.toString();
	}
	
	
}
