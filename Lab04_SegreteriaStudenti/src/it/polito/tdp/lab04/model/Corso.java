package it.polito.tdp.lab04.model;

import java.util.LinkedList;
import java.util.List;

public class Corso {

	private String codice;
	private int crediti;
	private String nome;
	private int pd;
	private List <Studente> studentiIscritti;
	
	public Corso(String codice, int crediti, String nome, int pd) {
		super();
		this.codice = codice;
		this.crediti = crediti;
		this.nome = nome;
		this.pd = pd;
		
		studentiIscritti= new LinkedList<Studente>();
	}

	/**
	 * @return the codice
	 */
	public String getCodice() {
		return codice;
	}

	/**
	 * @param codice the codice to set
	 */
	public void setCodice(String codice) {
		this.codice = codice;
	}

	/**
	 * @return the crediti
	 */
	public int getCrediti() {
		return crediti;
	}

	/**
	 * @param crediti the crediti to set
	 */
	public void setCrediti(int crediti) {
		this.crediti = crediti;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the pd
	 */
	public int getPd() {
		return pd;
	}

	/**
	 * @param pd the pd to set
	 */
	public void setPd(int pd) {
		this.pd = pd;
	}
	
	public void aggiungiStudente(Studente s){
		studentiIscritti.add(s);
	}
	public List<Studente> getIscritti(){
		return studentiIscritti;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codice == null) ? 0 : codice.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Corso other = (Corso) obj;
		if (codice == null) {
			if (other.codice != null)
				return false;
		} else if (!codice.equals(other.codice))
			return false;
		return true;
	}
	
	
	
}
