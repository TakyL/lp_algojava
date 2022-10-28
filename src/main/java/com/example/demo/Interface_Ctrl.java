package com.example.demo;

import com.example.demo.Modeles.BinaryTree;
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

import static com.example.demo.Modeles.BinaryTree.getBinaryTree;
import static com.example.demo.Modeles.BinaryTree.translateUsingBinaryTree;

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
        lbl_erreur.setText(" ");
        if(saisie.getText().trim() != null)
        {
                //Utilise la liste
           if(MethodeDefault()==true)    saisie.setText(CreationObjetConv().ConversionMorseVersMots(saisie.getText()).trim());
            else
           {
               BinaryTree tree = getBinaryTree(CreationObjetConv());
               saisie.setText(translateUsingBinaryTree(tree, saisie.getText()));    //Morse vers texte
           }
        }
    }

    @FXML
    protected void Conv_TvM(){  //Texte Vers Morse
        lbl_erreur.setText(" ");
        if(saisie.getText().trim() != null)
        {
                //Utilise la liste
            if(MethodeDefault() == true)saisie.setText(CreationObjetConv().ConversionMotsVersMorse(saisie.getText()).trim());
            else lbl_erreur.setText(("Il est impossible de traduire dans ce sens avec l'arbre"));
        }
    }

    public Conversion CreationObjetConv()   //Créer un objet conversion et le renvoie
    {
        Fichier f1 = new  Fichier("src/main/java/com/example/demo/Texte/ref.txt");
        Liste liste0 = f1.FichierToListe();	//R�cup�re toute la liste de conversion
        Conversion c0 = new Conversion(liste0);
        return c0;
    }

    public boolean MethodeDefault() //Determine si la liste ou l'arbre est utilisé: true si oui sinon non
    {
        if(radio_arbre.isSelected())    //Si le radio button arbre est choisie
        {
            radio_liste.setSelected(false); //Prévention si la liste est coché en même temps que l'arbre
            return false;
        }

        else {  //Si la liste est selectionné
            radio_arbre.setSelected(false); //Prévention si la liste est coché en même temps que l'arbre
            return true;
        }
        //return !radio_arbre.isSelected(); Version simplifié
    }



}