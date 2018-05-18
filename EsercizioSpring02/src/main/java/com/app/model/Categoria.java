package com.app.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="categorie")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column
	private String nome;
	
	@OneToMany(mappedBy="categoria", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	List<Prodotto> prodotti = new ArrayList<Prodotto>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Prodotto> getProdotti() {
		return prodotti;
	}

	public void setProdotti(List<Prodotto> prodotti) {
		this.prodotti = prodotti;
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nome=" + nome + ", prodotti=" + prodotti + "]";
	}
	
	
}
