package br.com.stefanini.maratonadev.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import br.com.stefanini.maratonadev.dto.AluguelDeCarroDto;
import br.com.stefanini.maratonadev.model.AluguelDeCarro;
import br.com.stefanini.maratonadev.service.AluguelDeCarroService;

@Path("AluguelDeCarro")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AluguelDeCarroRest {
	
	@Inject
	AluguelDeCarroService service;
	
	@POST
	@Operation(summary = "Cadastrar Aluguel de Carro",
			description = "Cadastrar um novo AluguelDeCarro")
	@APIResponse(responseCode = "201",
	description="AluguelDeCarro",
	content = {
			@Content(mediaType = "application/json",
					schema = @Schema(implementation = AluguelDeCarroDto.class))
			}
		)
	
		public Response cadastrar(AluguelDeCarroDto AluguelDeCarrodto) {
		AluguelDeCarro AluguelDeCarro = AluguelDeCarrodto.toAluguel();
		return Response
				.status(Response.Status.CREATED)
				.entity(service.cadastrar(AluguelDeCarro))
				.build();
	}
}
