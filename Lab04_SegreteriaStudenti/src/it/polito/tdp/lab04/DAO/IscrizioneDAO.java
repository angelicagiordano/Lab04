package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class IscrizioneDAO {

	public boolean getIsIscritto(Studente s, Corso c) {

		final String sql = "SELECT * FROM iscrizione WHERE codins=? AND matricola=?";

		
		//HashMap<Integer,Studente> studenti = new HashMap<Integer,Studente>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			
			st.setString(1, c.getCodice()); //al punto interrogativo sostituisco il codice
			st.setInt(2, s.getMatricola());
			ResultSet rs = st.executeQuery();

			return rs.next();
			
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
}

	public boolean iscriviStudente(Studente s, Corso c) {

		final String sql = "INSERT INTO iscrizione ( matricola, codins) VALUES(?,?)";

		boolean res=false;
		//HashMap<Integer,Studente> studenti = new HashMap<Integer,Studente>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			
			st.setInt(1, s.getMatricola()); //al punto interrogativo sostituisco il codice
			st.setString(2, c.getCodice());
			
			
			int result = st.executeUpdate();

			conn.close();
			if (result==1) {

				// Crea un nuovo JAVA Bean Corso
				// Aggiungi il nuovo Corso alla lista
				
				res=true;
				
			}else{
				res=false;
			}

			return res;
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}

	}}
