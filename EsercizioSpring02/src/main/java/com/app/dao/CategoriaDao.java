package com.app.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.app.model.Categoria;

@Repository
@Transactional
public class CategoriaDao implements IDao<Categoria> {
	
	@PersistenceContext
	EntityManager em;
	
	@Override
	public void inserimento(Categoria o) {
		em.persist(o);
		em.flush();
		em.clear();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Categoria> visualizzaTutti() {
		return (ArrayList<Categoria>)em.createQuery("from categoria").getResultList();
	}

	@Override
	public Categoria cercaConId(int id) {
		return (Categoria)em.find(Categoria.class, id);
	}

	@Override
	public void modifica(Categoria o) {
		em.merge(o);
		em.flush();
		em.clear();
		
	}

	@Override
	public void cancella(Categoria o) {
		em.remove(em.merge(o));
		em.flush();
		
	}

}
