package br.com.rafaelvicio.siscorp.api.rest;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.rafaelvicio.siscorp.model.CEP;
import br.com.rafaelvicio.siscorp.service.CEPService;

@Named
@Path("cep")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CEPRest {
	
	@Inject
	private CEPService CEPService;
	
	@POST
	@Path("/")
	public Response cadastrar(CEP cep) {
		CEPService.cadastrar(cep);
		return Response.ok().build();
	}

	@GET
	@Path("/")
	public List<CEP> listarPessoas() {
		return CEPService.listar();
	}
	
	@GET
	@Path("{id}")
	public CEP buscaPorId(@PathParam("id") Long id) {
		return CEPService.buscarPorId(id);
	}
	
	@DELETE
	@Path("{id}")
	public void removePorId(@PathParam("id") Long id) {
		CEPService.removePorId(id);
	}
	
	@PUT
	@Path("{id}")
	public void atualiza(@PathParam("id") Long id, CEP cep) {
		CEPService.atualiza(id, cep);
	}

}
