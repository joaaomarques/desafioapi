package br.com.stefanini.maratonadev.dto;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import br.com.stefanini.maratonadev.model.Cliente;
import br.com.stefanini.maratonadev.model.Endereco;

public class ClienteDto {

	@NotNull
	@Size(min = 3, max = 100)
	private String nome;

	@NotNull
	@Pattern(regexp = "(\\(?\\d{2}\\)?\\s)?(\\d{4,5}\\-\\d{4})", message = "Cpf permite somente números")
	@Column(unique=true)
	private String cpf;

	private EnderecoDto endereco;

	@Email
	private String email;

	@NotNull
	@Pattern(regexp = "[789][0-9]{9}", message = "Telefone de contato deve ser válido")
	private String contato;

	public Cliente toCliente() {
		Cliente cliente = new Cliente();
		cliente.setEmail(this.email);
		cliente.setCpf(this.cpf);
		cliente.setContato(this.contato);
		cliente.setNome(this.nome);
		 
		Endereco endereco = new Endereco();
		endereco.setBairro(this.endereco.getBairro());
		endereco.setCep(this.endereco.getCep());
		endereco.setCidade(this.endereco.getCidade());
		endereco.setComplemento(this.endereco.getComplemento());
		endereco.setLogradouro(this.endereco.getLogradouro());
		endereco.setUf(this.endereco.getUf());
		
		cliente.setEndereco(endereco);
		
		return cliente;
	}
	
	

	public EnderecoDto getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoDto endereco) {
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

}
