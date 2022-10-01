package com.example.demo.Modeles;

public class main {
	public static void main(String args[])	//Main fx
	{
		/*
			Une liste(aka le dico) sera crée à partir du fichier ref.txt
			Cette liste contiendra toutes les ref de l'alphabet et son équivalent en morse
			La conversion pourra se faire à l'aide de la classe conversion qui prend comme argument une liste( dans notre cas ça sera toujours le dico aka liste0)
					-Pour l'instant c'est c0
			La classe conversion contient les méthodes permettant de convertir les mots en morse[cpc] et inversement

			Le reste de la procédure algo reste encore à convenir mais on peut penser à un tableau qui sera ensuite concat dans un string et qui sera afficher dans LabelArea

			Un fichier de test sera chargé au lancement de l'application
		 */

		Fichier f1 = new  Fichier("src/main/java/com/example/demo/Texte/ref.txt");

		//f1.LectureFichier();
		Liste liste0 = f1.FichierToListe();	//R�cup�re toute la liste de conversion
		Conversion c0 = new Conversion(liste0);	//Liste de conversion de base .  
		c0.recherchecode("e");	//Liste de conversion.recherchercode(caract�re)
		liste0.afficher_position();
		//liste0.afficher_position();
		//liste0.RetourneAuDebut();
		String mot = "Patate";
		for(int i=0; i<=mot.length();i++)
		{
			System.out.println(c0.recherchecode(String.valueOf(mot.charAt(i)).toLowerCase()));
			liste0.afficher_position();
		}
		//f0.FichierToTableauMots();


	
	
	//CodeMorse c0 = new CodeMorse(".-");
	Lettre l0 = new Lettre("a",".-");
	//Liste l0 = new Liste()

	//c0.ConversionCodeToLettre();

	}

}
