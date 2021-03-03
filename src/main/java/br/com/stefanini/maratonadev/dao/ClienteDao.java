package br.com.stefanini.maratonadev.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;

import br.com.stefanini.maratonadev.model.Cliente;
import io.quarkus.panache.common.Sort;

@RequestScoped
public class ClienteDao {
	
	public List<Cliente> listar(){
		return Cliente.listAll(Sort.by("nome","email").ascending());
	}
	@Transactional
	public Cliente cadastrar(Cliente cliente) {
		Cliente.persist(cliente);
		return cliente;
		
	}
}
