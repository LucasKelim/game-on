package gameon.models.DTO;

import java.time.LocalDateTime;

import gameon.models.enums.OrdemStatus;
import gameon.models.interfaces.MetodoPagamento;

public class OrdemDTO {
	private int id;
	private OrdemStatus status;
	private MetodoPagamento metodoPagamento;
	private double valorTotal;
	private ClienteDTO cliente;
	private EnderecoDTO endereco;
	private String assasOrdem;
	private LocalDateTime criadoEm;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public OrdemStatus getStatus() {
		return status;
	}
	public void setStatus(OrdemStatus status) {
		this.status = status;
	}
	public MetodoPagamento getMetodoPagamento() {
		return metodoPagamento;
	}
	public void setMetodoPagamento(MetodoPagamento metodoPagamento) {
		this.metodoPagamento = metodoPagamento;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public ClienteDTO getCliente() {
		return cliente;
	}
	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}
	public EnderecoDTO getEndereco() {
		return endereco;
	}
	public void setEndereco(EnderecoDTO endereco) {
		this.endereco = endereco;
	}
	public String getAssasOrdem() {
		return assasOrdem;
	}
	public void setAssasOrdem(String assasOrdem) {
		this.assasOrdem = assasOrdem;
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
		builder.append("OrdemDTO [id=");
		builder.append(id);
		builder.append(", status=");
		builder.append(status);
		builder.append(", metodoPagamento=");
		builder.append(metodoPagamento);
		builder.append(", valorTotal=");
		builder.append(valorTotal);
		builder.append(", cliente=");
		builder.append(cliente);
		builder.append(", endereco=");
		builder.append(endereco);
		builder.append(", assasOrdem=");
		builder.append(assasOrdem);
		builder.append(", criadoEm=");
		builder.append(criadoEm);
		builder.append("]");
		return builder.toString();
	}
	
	
}
