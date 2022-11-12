module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;



    opens fr.iut to javafx.fxml;
    exports fr.iut;
   // exports fr.iut.vue;
    //opens fr.iut.vue to javafx.fxml;
/*
   opens fr.iut.vue to javafx.fxml;
    exports fr.iut.vue;
    exports fr.iut.controler;
    opens fr.iut.controler to javafx.fxml;
    exports fr.iut.vue;
    opens fr.iut.vue to javafx.fxml;
    exports fr.iut;
    opens fr.iut to javafx.fxml;*/

}