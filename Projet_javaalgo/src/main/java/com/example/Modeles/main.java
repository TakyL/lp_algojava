package com.example.Modeles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class main {
	public static void main(String args[])	//Main fx
	{
		/*
		 * On aura une Liste qui contiendra toutes les lettres avec leur �quivalent en morse � partir d'un fichier txt [s�parateur]
		 * Ensuite on ouvre le fichier, on recup�re le tableau des mots [Tableau de string][fait]
		 * 	-> Boucle sur chaque mot
		 * 		->Chaque mot est d�compos� en lettre [soit dans la classe lettre soit dans la classe mot][� def]
		 * 		->Ensuite chaque lettre fait appel � une fonction de conversion qui renvoie soit le code morse soit l'inverse [classes lettre et code barre]
		 * 		->Le resultat est enrengistr� dans un tableau qui ensuite est affich� sur l'interface graphique
		 * 
		 */
		//Fichier f0 = new Fichier("C:\\\\Users\\\\leduc41u\\\\eclipse-workspace\\\\projetjava_algo\\\\src\\\\Texte\\\\mot.txt");
		
		Fichier f1 = new  Fichier("/Texte/ref.txt");
		
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
