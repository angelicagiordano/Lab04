package it.polito.tdp.lab04.controller;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import it.polito.tdp.lab04.model.*;

public class SegreteriaStudentiController {

	Model model;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Corso> comboCorso;

    @FXML
    private Button btnCercaIscrittiCorso;

    @FXML
    private TextField txtMatricola;

    @FXML
    private Button btnCercaNome;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtCognome;

    @FXML
    private Button btnCercaCorsi;

    @FXML
    private Button btnIscrivi;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;
    
    public void setModel(Model model){
    	this.model=model;
    	comboCorso.getItems().add(new Corso("",0,"",0));
    	comboCorso.getItems().addAll(model.getCorsi());   	
    	
    }

    @FXML
    void doCercaCorsi(ActionEvent event) {

    	if(!txtMatricola.getText().matches("[0-9]*") || comboCorso.getValue()==null){
    		txtResult.setText("Dati non validi");
    	}else{
    	Studente s=model.getStudente(Integer.parseInt(txtMatricola.getText().trim()));
    	Corso corso= comboCorso.getValue();
    	
    	
    	if(s.getNome().compareTo("")!=0 && (corso.getNome().compareTo("")==0|| comboCorso.getValue()==null)){
    		for(Corso c : model.getCorsiFrequentati(s)){
        		txtResult.appendText(c.toString()+"\n");
        	}
    		
    	}else{
    		
    		txtResult.setText("Studente non trovato");
    	}
    	if(s!=null && corso.getNome().compareTo("")!=0){
    		if(model.studenteIsIscrittoCorso(s, corso)){
    			txtResult.setText("Studente  iscritto al corso");
    		}else
    			txtResult.setText("Studente non iscritto al corso");
    	}}
    }

    @FXML
    void doCercaIscrittiCorso(ActionEvent event) {

    	
    	Corso c= comboCorso.getValue();
    	if(c!=null){
    	for(Studente s: model.getIscritti(c) ){
    		txtResult.appendText(s.toString()+"\n");
    		
    	}
    	if(txtResult.getText().compareTo("")==0){
    		txtResult.setText("Nessuno studente iscritto al corso!");
    	}
    	}else
    	{
    		txtResult.setText("Inserire Corso!");
    	}
    	
    }

    @FXML
    void doCercaNome(ActionEvent event) {

    	if(!txtMatricola.getText().matches("[0-9]*")){
    		txtResult.setText("Matricola non valida");
    	}else{
    	Studente s=model.getStudente(Integer.parseInt(txtMatricola.getText().trim()));
    	if(s.getNome().compareTo("")!=0 &&s.getCognome().compareTo("")!=0){
    	txtNome.setText(s.getNome());
    	txtCognome.setText(s.getCognome());
    	}else{
    		txtResult.setText("Studente non trovato!!");
    		
    		
    	}}
    }

    @FXML
    void doIscrivi(ActionEvent event) {

    	if(!txtMatricola.getText().matches("[0-9]*") || !txtNome.getText().matches("[a-zA-Z]*") || !txtCognome.getText().matches("[a-zA-Z]*") || comboCorso.getValue()==null){
    		txtResult.setText("Errore: inserire dati validi");
    	}else{
    		//Studente s= new Studente(Integer.parseInt(txtMatricola.getText().trim()), txtNome.getText(),txtCognome.getText(), "");
    		Corso c= comboCorso.getValue();
    		
    		Studente s=model.getStudente(Integer.parseInt(txtMatricola.getText().trim()));
        	if(s.getNome().compareTo("")!=0 &&s.getCognome().compareTo("")!=0){
        	txtNome.setText(s.getNome());
        	txtCognome.setText(s.getCognome());
        	if(model.iscrivi(s, c)){
            	
        		txtResult.setText("Studente iscritto");
        		}else
        			txtResult.setText("Studente non iscritto");
        	
        	}
        	else{
        		txtResult.setText("Studente non trovato!!");
        		
        		
        	}	}
    	
    		
    }

    @FXML
    void doReset(ActionEvent event) {

    	txtResult.clear();
    	txtMatricola.clear();
    	txtNome.clear();
    	txtCognome.clear();
    	
    }
    

    @FXML
    void initialize() {
    	//deve già avere tutto pronto per visualizzare a schermo
        assert comboCorso != null : "fx:id=\"comboCorso\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnCercaIscrittiCorso != null : "fx:id=\"btnCercaIscrittiCorso\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnCercaNome != null : "fx:id=\"btnCercaNome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnCercaCorsi != null : "fx:id=\"btnCercaCorsi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnIscrivi != null : "fx:id=\"btnIscrivi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";

            }
}
