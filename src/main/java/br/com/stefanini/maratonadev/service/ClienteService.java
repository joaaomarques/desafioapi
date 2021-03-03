package br.com.stefanini.maratonadev.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.stefanini.maratonadev.dao.ClienteDao;
import br.com.stefanini.maratonadev.dto.ClienteDto;
import br.com.stefanini.maratonadev.model.Cliente;
import br.com.stefanini.maratonadev.model.parser.ClienteParser;

@RequestScoped
public class ClienteService {
	
	@Inject
	ClienteDao dao;
	
	public List<ClienteDto> listar(){
		return dao.listar().stream().map(ClienteParser.get()::dto).collect(Collectors.toList());
	}

	public Cliente cadastrar(Cliente cliente) {
		return dao.cadastrar(cliente);
	}

	
	
	
}
