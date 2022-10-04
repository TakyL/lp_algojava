package com.example.demo;

import com.example.demo.Modeles.Conversion;
import com.example.demo.Modeles.Fichier;
import com.example.demo.Modeles.Liste;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
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

    @FXML
    private RadioButton radio_arbre;

    @FXML
    private RadioButton radio_liste;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) { //Au lancement de la fenetre
        lbl_erreur.setText("");
        radio_liste.setSelected(true);
    }

    @FXML
    protected void Conv_Mvt(){  //Morse vers texte
        if(saisie.getText().trim() != null)
        {
               saisie.setText(CreationObjetConv().ConversionMorseVersMots(saisie.getText()).trim());
        }
    }

    @FXML
    protected void Conv_TvM(){  //Texte Vers Morse
        if(saisie.getText().trim() != null)
        {

            saisie.setText(CreationObjetConv().ConversionMotsVersMorse(saisie.getText()).trim());
        }
    };

    public Conversion CreationObjetConv()   //Créer un objet conversion et le renvoie
    {
        Fichier f1 = new  Fichier("src/main/java/com/example/demo/Texte/ref.txt");
        Liste liste0 = f1.FichierToListe();	//R�cup�re toute la liste de conversion
        Conversion c0 = new Conversion(liste0);
        return c0;
    }



}