package com.app.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="prodotti")
public class Prodotto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column
	private String nome;
	
	@Column
	private String descrizione;
	
	@Column
	private int prezzo;
	
	@ManyToOne
	@JoinColumn(name="id_categoria", referencedColumnName="id")
	private Categoria categoria;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "prodotti_listini", 
	joinColumns = @JoinColumn(name="id_prodotto"),
	inverseJoinColumns =  @JoinColumn(name = "id_listinod")
	)
	List<Listino> listini = new ArrayList<Listino>();

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

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public int getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Prodotto [id=" + id + ", nome=" + nome + ", descrizione=" + descrizione + ", prezzo=" + prezzo
				+ ", categoria=" + categoria + "]";
	}
	
	
}
