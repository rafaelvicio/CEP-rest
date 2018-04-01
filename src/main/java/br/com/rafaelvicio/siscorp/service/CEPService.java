package br.com.rafaelvicio.siscorp.service;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.rafaelvicio.siscorp.dao.CEPDao;
import br.com.rafaelvicio.siscorp.model.CEP;

@Named
@RequestScoped
public class CEPService {

	@Inject
	private CEPDao CEPDAo;
	
	public void cadastrar(CEP cep) {
		CEPDAo.cadastrar(cep);
	}
	
	public List<CEP> listar() {
		return CEPDAo.listar();
	}
	
	public CEP buscarPorId(Long idCep) {
		return CEPDAo.buscarPorId(idCep);
	}
	
	public void removePorId(Long idCep) {
		CEPDAo.removePorId(idCep);
	}
	
	public void atualiza(Long id, CEP cep) {
		CEPDAo.atualiza(id, cep);
	}

}
