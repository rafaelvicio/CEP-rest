package br.com.rafaelvicio.siscorp.util;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RequestScoped
public class Persistence {
	
	  @PersistenceContext
	  private EntityManager entityManager;

	  public EntityManager getEntityManager() {
		  return entityManager;
	  }

}
