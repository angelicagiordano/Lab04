package it.polito.tdp.lab04.model;

import java.util.LinkedList;
import java.util.List;

public class Studente {
	
	private int matricola;
	private String nome;
	private String cognome;
	private String cds;
	List <Corso> corsiFrequentati;
	public Studente(int matricola, String nome, String cognome, String cds) {
		
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
		this.cds=cds;
		corsiFrequentati = new LinkedList<Corso>();
	}
	/**
	 * @return the matricola
	 */
	public int getMatricola() {
		return matricola;
	}
	/**
	 * @param matricola the matricola to set
	 */
	public void setMatricola(int matricola) {
		this.matricola = matricola;
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
	 * @return the cognome
	 */
	public String getCognome() {
		return cognome;
	}
	/**
	 * @param cognome the cognome to set
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	/**
	 * @return the cds
	 */
	public String getCds() {
		return cds;
	}
	/**
	 * @param cds the cds to set
	 */
	public void setCds(String cds) {
		this.cds = cds;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return  matricola + "   " + nome + "   " + cognome + "   " + cds;
	}
	
	public void aggiungiCorso(Corso c){
		corsiFrequentati.add(c);
	}
	public List<Corso> getCorsi(){
		return corsiFrequentati;
	}
}
