package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class StudenteDAO {

	public void getStudente(Studente s) {

		final String sql = "SELECT matricola,cognome, nome, CDS FROM studente WHERE matricola=?";

		
		//HashMap<Integer,Studente> studenti = new HashMap<Integer,Studente>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			
			st.setInt(1, s.getMatricola()); //al punto interrogativo sostituisco il codice
			ResultSet rs = st.executeQuery();

			if (rs.next()) {

				// Crea un nuovo JAVA Bean Corso
				// Aggiungi il nuovo Corso alla lista
				
				s.setNome(rs.getString("nome"));
				s.setCognome(rs.getString("cognome"));
				s.setCds(rs.getString("CDS"));
				
			}

			//conn.close();
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}


	}
	

	public void setCorsi(Studente s) {

		final String sql = "SELECT codins, crediti,nome, pd "+
		"FROM corso WHERE codins IN "+

        "(SELECT codins FROM iscrizione WHERE matricola=?);";

		
		//HashMap<Integer,Studente> studenti = new HashMap<Integer,Studente>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			
			st.setInt(1, s.getMatricola()); //al punto interrogativo sostituisco il codice
			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				Corso c= new Corso(rs.getString("codins"), rs.getInt("crediti"), rs.getString("nome"), rs.getInt("pd") );
				
				s.aggiungiCorso(c);
			}

			//conn.close();
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}


	}

}
