package br.com.stefanini.maratonadev.model.parser;

import java.util.Objects;

import br.com.stefanini.maratonadev.dto.ClienteDto;
import br.com.stefanini.maratonadev.dto.EnderecoDto;
import br.com.stefanini.maratonadev.model.Cliente;
import br.com.stefanini.maratonadev.model.Endereco;

public class ClienteParser {
	
	public static ClienteParser get() {
		return new ClienteParser();
	}
	
	public ClienteDto dto(Cliente entidade) {
		ClienteDto dto = new ClienteDto();
		
		
		dto.setNome(entidade.getNome());
		dto.setCpf(entidade.getCpf());
		if(Objects.nonNull(entidade.getEndereco())) {
			EnderecoDto endereco = new EnderecoDto();
			endereco.setBairro(entidade.getEndereco().getBairro());
			endereco.setCep(entidade.getEndereco().getCep());
			endereco.setCidade(entidade.getEndereco().getCidade());
			endereco.setComplemento(entidade.getEndereco().getComplemento());
			endereco.setLogradouro(entidade.getEndereco().getLogradouro());
			endereco.setUf(entidade.getEndereco().getUf());
			dto.setEndereco(endereco);
		}
		
		dto.setEmail(entidade.getEmail());
		dto.setContato(entidade.getContato());
		return dto;
	}
}
