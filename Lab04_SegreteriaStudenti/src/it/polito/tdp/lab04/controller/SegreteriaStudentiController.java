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
    	comboCorso.getItems().addAll(model.getCorsi());   	
    	
    }

    @FXML
    void doCercaCorsi(ActionEvent event) {

    	Studente s=model.getStudente(Integer.parseInt(txtMatricola.getText().trim()));
    	if(s!=null){
    		for(Corso c : model.getCorsiFrequentati(s)){
        		txtResult.appendText(c.toString()+"\n");
        	}
    		
    	}else{
    		txtResult.setText("Studente non trovato");
    	}
    }

    @FXML
    void doCercaIscrittiCorso(ActionEvent event) {

    	
    	Corso c= comboCorso.getValue();
    	if(c!=null){
    	for(Studente s: model.getIscritti(c) ){
    		txtResult.appendText(s.toString()+"\n");
    	}}else
    	{
    		txtResult.setText("Inserire Corso!");
    	}
    	
    }

    @FXML
    void doCercaNome(ActionEvent event) {

    	Studente s=model.getStudente(Integer.parseInt(txtMatricola.getText().trim()));
    	if(s!=null){
    	txtNome.setText(s.getNome());
    	txtCognome.setText(s.getCognome());
    	}else{
    		txtResult.setText("Studente non trovato");
    	}
    }

    @FXML
    void doIscrivi(ActionEvent event) {

    	
    }

    @FXML
    void doReset(ActionEvent event) {

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
