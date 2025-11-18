package gameon.models.DTO;

import java.time.LocalDateTime;
import java.util.List;

public class CarrinhoDTO {
	private int id;
	private Cliente cliente;
	private List<CarrinhoProdutoDTO> produtos;
	private LocalDateTime criadoEm;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<CarrinhoProdutoDTO> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<CarrinhoProdutoDTO> produtos) {
		this.produtos = produtos;
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
		builder.append("CarrinhoDTO [id=");
		builder.append(id);
		builder.append(", cliente=");
		builder.append(cliente);
		builder.append(", produtos=");
		builder.append(produtos);
		builder.append(", criadoEm=");
		builder.append(criadoEm);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
