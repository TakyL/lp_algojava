package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class Interface_Ctrl  implements Initializable{

    @FXML
    private Label lbl_erreur;

    @FXML
    private Button btn_TvM; //Texte vers Morse

    @FXML
    private Button btn_MvT; //Morse vers Texte
    @FXML
    private TextArea saisie;    //Sasie utilisateur et resultat

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        lbl_erreur.setText("");
    }

    @FXML
    protected void Conv_Mvt(){}

    @FXML
    protected void Conv_TvM(){};



}