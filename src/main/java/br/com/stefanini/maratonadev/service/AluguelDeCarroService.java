package br.com.stefanini.maratonadev.service;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.BadRequestException;

import br.com.stefanini.maratonadev.dao.AluguelDeCarroDao;
import br.com.stefanini.maratonadev.dto.AluguelDeCarroDto;
import br.com.stefanini.maratonadev.model.AluguelDeCarro;

@RequestScoped
public class AluguelDeCarroService {
	
	@Inject
	AluguelDeCarroDao dao;
	

	public AluguelDeCarro cadastrar(AluguelDeCarro aluguelDeCarro) {
		long existeAluguel = dao.existeAluguel(aluguelDeCarro.getCliente().getId());
		if(existeAluguel > 0) {
			throw new BadRequestException("Este cliente já tem uma locação em andamento");
		}
		return dao.cadastrar(aluguelDeCarro);
		
	}

	
	
	
}
