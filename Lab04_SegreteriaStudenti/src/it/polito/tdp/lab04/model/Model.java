package it.polito.tdp.lab04.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.DAO.*;

public class Model {

	//List <Corso> corsi;

	public Model() {
		
		//corsi= new LinkedList<Corso>();
	}
	
	public List<Corso> getCorsi(){
		CorsoDAO cdao= new CorsoDAO();
		return cdao.getTuttiICorsi();
	}
	
	public Studente getStudente(int matricola){
		StudenteDAO sdao= new StudenteDAO();
		Studente s= new Studente(matricola, "", "","");
	     sdao.getStudente(s);
	 return s;
	}
	
	public List<Studente> getIscritti(Corso c){
		CorsoDAO cdao= new CorsoDAO();
		cdao.getStudentiIscrittiAlCorso(c);
		return c.getIscritti();
	}
	public List<Corso> getCorsiFrequentati(Studente s){
		StudenteDAO sdao = new StudenteDAO();
		sdao.setCorsi(s);
		return s.corsiFrequentati;
	}
	public boolean studenteIsIscrittoCorso(Studente s, Corso c){
		
		IscrizioneDAO idao= new IscrizioneDAO();
		return idao.getIsIscritto(s, c);
	}

	public boolean iscrivi(Studente s){
		StudenteDAO sdao= new StudenteDAO();
		return sdao.aggiungiStudente(s);
	}
}
