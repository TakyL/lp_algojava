package fr.iut.modeles;
import java.io.*;
import java.util.Scanner;

public class Fichier {

	final String  urlfichier ;	//Le fichier txt


	/**
	 * Crée un objet fichier en fonction d'un url saisie
	 * @param fichier Url du fichier de référence
	 */
	public Fichier(String  fichier) {
		super();
		this.urlfichier = fichier;
	}


	/**
	 * Lit le fichier ref.txt et crée un Objet Liste en fonction du contenu de ce fichier(Création du dictionnaire)
	 * @return Liste
	 */
	public Liste FichierToListe() //Lit un fichier texte et renvoie une liste à partir de ce fichier(dictionnaire)
	{

		Liste ListeRef = new Liste();	//Dico
		Scanner scan;
		try {
			scan = new Scanner(new File(urlfichier));


			while (scan.hasNextLine()) {	//Lis le fichier
				String ligne= scan.next();	//Récupère le contenu de la ligne
				Lettre l = new Lettre(ligne.substring(0,1),ligne.substring(1));	//Crée un objet Lettre ex:Lettre("e",".")
				//System.out.println("lettre"+l.getLettre());
				ListeRef.inserer(l);//Ajoute la lettre au dico

			}
			ListeRef.setLettre_ref(ListeRef.getSuivant().getLettre_ref());//Repointe le 1er élément de la liste

			scan.close();	//Fermeture du scanner
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		return ListeRef;
	}

}
