package br.com.rafaelvicio.siscorp.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Query;
import javax.transaction.Transactional;

import br.com.rafaelvicio.siscorp.model.CEP;
import br.com.rafaelvicio.siscorp.util.Persistence;

@Named
@RequestScoped
public class CEPDao {

	@Inject
	private Persistence persistence;

	@Transactional
	public void cadastrar(CEP cep) {
		persistence.getEntityManager().persist(cep);
	}

	public List<CEP> listar() {
		String queryString = "SELECT c FROM CEP c";
		Query query = persistence.getEntityManager().createQuery(queryString);

		return query.getResultList();

	}
	
	public CEP buscarPorId(Long idCep) {
		String queryString = "SELECT c FROM CEP c WHERE c.id = :idCep";
		Query query = persistence.getEntityManager().createQuery(queryString);
		
		query.setParameter("idCep", idCep);
		return (CEP) query.getSingleResult();
	}
	
	@Transactional
	public void removePorId(Long idCep) {
		String queryString = "DELETE FROM CEP c WHERE c.id = :idCep";
		Query query = persistence.getEntityManager().createQuery(queryString);
		query.setParameter("idCep", idCep);
		query.executeUpdate();
	}
	
	@Transactional
	public void atualiza(Long id, CEP cep) {
		String queryString = "UPDATE CEP SET cep = :cCep, endereco = :cEndereco WHERE id = :cId";
		Query query = persistence.getEntityManager().createQuery(queryString);
		
		query.setParameter("cId", id);
		query.setParameter("cCep", cep.getCep());
		query.setParameter("cEndereco", cep.getEndereco());
		
		query.executeUpdate();
	}

}
