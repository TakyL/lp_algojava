module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;




    exports fr.iut.vue;
    opens fr.iut.vue to javafx.fxml;
    exports fr.iut.controleur;
    opens fr.iut.controleur to javafx.fxml;


}