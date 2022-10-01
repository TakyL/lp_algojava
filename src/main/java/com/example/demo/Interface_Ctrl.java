package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class Interface_Ctrl {


    @FXML
    private Button btn_TvM; //Texte vers Morse

    @FXML
    private Button btn_MvT; //Morse vers Texte
    @FXML
    private TextArea saisie;    //Sasie utilisateur et resultat

    @FXML
    protected void Conv_Mvt(){}

    @FXML
    protected void Conv_TvM(){};

}