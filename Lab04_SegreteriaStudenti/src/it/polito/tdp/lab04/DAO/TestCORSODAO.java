package it.polito.tdp.lab04.DAO;

import it.polito.tdp.lab04.model.Corso;

public class TestCORSODAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CorsoDAO c= new CorsoDAO();
		
		for(Corso corso :c.getTuttiICorsi()){
			System.out.println(corso.getNome()+"\n");
		}
		StudenteDAO s = new StudenteDAO();
		//Studente s= new Studente(146101,null,null)
	}

}
