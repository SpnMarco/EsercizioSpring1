package com.app.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.app.model.Prodotto;

@Repository
@Transactional
public class ProdottoDao implements IDao<Prodotto> {
	
	@PersistenceContext
	EntityManager em;
	
	@Override
	public void inserimento(Prodotto o) {
		em.merge(o);
		em.flush();
		em.clear();
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Prodotto> visualizzaTutti() {
		return (ArrayList<Prodotto>)em.createQuery("from prodotto").getResultList();
	}

	@Override
	public Prodotto cercaConId(int id) {
		return (Prodotto)em.find(Prodotto.class, id);
	}

	@Override
	public void modifica(Prodotto o) {
		em.merge(o);
		em.flush();
		em.clear();
	}

	@Override
	public void cancella(Prodotto o) {
		em.remove(em.merge(o));
		em.flush();
	}

}
