package gameon.models.DTO;

import java.time.LocalDateTime;

public class OrdemProduto {
	private int id;
	private int quantidade;
	private Ordem ordem;
	private Produto produto;
	private LocalDateTime criadoEm;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public Ordem getOrdem() {
		return ordem;
	}
	public void setOrdem(Ordem ordem) {
		this.ordem = ordem;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public LocalDateTime getCriadoEm() {
		return criadoEm;
	}
	public void setCriadoEm(LocalDateTime criadoEm) {
		this.criadoEm = criadoEm;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrdemProdutoDTO [id=");
		builder.append(id);
		builder.append(", quantidade=");
		builder.append(quantidade);
		builder.append(", ordem=");
		builder.append(ordem);
		builder.append(", produto=");
		builder.append(produto);
		builder.append(", criadoEm=");
		builder.append(criadoEm);
		builder.append("]");
		return builder.toString();
	}
	
	
}
