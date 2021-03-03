package br.com.stefanini.maratonadev.dao;

import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;

import br.com.stefanini.maratonadev.model.AluguelDeCarro;
import io.quarkus.panache.common.Parameters;

/**
 * @author danilodorgam
 * @version 0.1.0
 * @created 29/10/2020 on 18:30
 */
@RequestScoped
public class AluguelDeCarroDao {

	@Transactional
	public AluguelDeCarro cadastrar(AluguelDeCarro aluguelDeCarro) {
		AluguelDeCarro.persist(aluguelDeCarro);
		return aluguelDeCarro;
		
	}
	public long existeAluguel(Long clienteId){
		return AluguelDeCarro.count("cliente.id = :clienteId and status = :status", Parameters.with("clienteId", clienteId).and("status", true));
	}
}
