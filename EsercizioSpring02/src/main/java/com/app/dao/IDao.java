package com.app.dao;

import java.util.ArrayList;

public interface IDao<Object> {

	public void inserimento(Object o);
	
	public ArrayList<Object> visualizzaTutti();
	
	public Object cercaConId(int id);
	
	public void modifica(Object o);
	
	public void cancella(Object o);
}
