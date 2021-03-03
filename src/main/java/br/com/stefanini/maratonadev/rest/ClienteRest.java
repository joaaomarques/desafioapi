package br.com.stefanini.maratonadev.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import br.com.stefanini.maratonadev.dto.ClienteDto;
import br.com.stefanini.maratonadev.model.Cliente;
import br.com.stefanini.maratonadev.service.ClienteService;

@Path("cliente")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClienteRest {
	
	@Inject
	ClienteService service;
	
	@GET
    @Operation(summary = "Listar clientes",
            description = "Lista de clientes com nome, cpf, email, endereço e contato")
	@APIResponse(responseCode = "201",
    description = "cliente",
    content = {
            @Content(mediaType =  "application/json",
                    schema = @Schema(implementation = ClienteDto.class))
		}
	)
	
	public Response listar() {
		return Response
				.status(Response.Status.OK)
				.entity(service.listar())
				.build();
	}
	@POST
	@Operation(summary = "Cadastrar Cliente",
			description = "Cadastrar um novo cliente")
	@APIResponse(responseCode = "201",
	description="cliente",
	content = {
			@Content(mediaType = "application/json",
					schema = @Schema(implementation = ClienteDto.class))
			}
		)
	
		public Response cadastrar(ClienteDto clientedto) {
		Cliente cliente = clientedto.toCliente();
		return Response
				.status(Response.Status.CREATED)
				.entity(service.cadastrar(cliente))
				.build();
	}
}
