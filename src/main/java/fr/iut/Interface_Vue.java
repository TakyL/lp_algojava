package fr.iut;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Interface_Vue extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("interface_principale.fxml"));    //Récupère le fichier fxml
        Scene scene = new Scene(fxmlLoader.load(), 600, 480);//Charge la fenetre
        stage.setTitle("Traducteur code morse et texte");//Nom de la fenetre
        stage.setScene(scene);
        stage.show();//Affiche la fenetre
    }

    public static void main(String[] args) {
        launch(args);
    }//Lance la fenetre
}