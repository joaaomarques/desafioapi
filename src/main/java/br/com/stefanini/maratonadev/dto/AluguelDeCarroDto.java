package br.com.stefanini.maratonadev.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import br.com.stefanini.maratonadev.model.AluguelDeCarro;
import br.com.stefanini.maratonadev.model.Carro;
import br.com.stefanini.maratonadev.model.Cliente;

public class AluguelDeCarroDto {
	
	private BigDecimal preco;
	
	@NotNull
	private Long clienteId;
	
	@NotNull
	private String placa;
	
	
	public AluguelDeCarro toAluguel() {
		AluguelDeCarro alugueldecarro = new AluguelDeCarro();
		Carro carro =  new Carro();
		Cliente cliente = new Cliente();
		carro.setPlaca(placa);
		cliente.setId(clienteId);
		alugueldecarro.setCarro(carro);
		alugueldecarro.setCliente(cliente);
		alugueldecarro.setPreco(preco);
		alugueldecarro.setStatus(true);
		
		return alugueldecarro;
		
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	
}
