package com.example.demo.Modeles;
import java.io.*;
import java.util.Scanner;

public class Fichier {
	
	String  urlfichier ;	//Le fichier txt


	public Fichier(String  fichier) {
		super();
		this.urlfichier = fichier;
	}
	

	public void LectureFichier()
	{
		try {
			//File  f = new File("C:\\Users\\leduc41u\\eclipse-workspace\\projetjava_algo\\src\\projetjava_algo\\mot.txt");
			File f= new File(urlfichier);
			 Scanner sc = new Scanner(f);
			 
			    while (sc.hasNextLine())
			      System.out.println(sc.nextLine());
			  
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Liste FichierToListe() //Renvoie un tableau qui contient la liste de reference
	{
		
		//String [] tab= new String [CompteurMotfichier()];
		Liste ListeRef = new Liste();
		Scanner scan;
		try {
			scan = new Scanner(new File(urlfichier));
		
		
		  while (scan.hasNextLine()) {
			 String ligne= scan.next();
			 Lettre l = new Lettre(ligne.substring(0,1),ligne.substring(1));
			 //System.out.println("lettre"+l.getLettre());
			 ListeRef.inserer(l);
			 
	        }
		  	ListeRef.setLettre_ref(ListeRef.getSuivant().getLettre_ref());
	        scan.close();
		    
	        //ListeRef.afficher();
	        //ListeRef.AffichageFin();
	        //ListeRef.affichage();
	       

	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		 return ListeRef;
	}



	public int CompteurMotfichier()	//Compte le nb de mot pour obtenir la taille du tableau � r�aliser en fonction des espaces pr�sents dans le fichier
	{
	      File f1=new File(urlfichier); //Creation of File Descriptor for input file
	      String[] words=null;    //Intialize the word Array
	      int wc=0;     //Intialize word count to zero
	      try {
		
	      FileReader fr = new FileReader(f1);
		   //Creation of File Reader object
	      BufferedReader br = new BufferedReader(fr);    //Creation of BufferedReader object
	      String s;
	   
			while((s=br.readLine())!=null)    //Reading Content from the file
			  {
			     words=s.split(" ");   //Split the word using space
			     wc=wc+words.length;   //increase the word count for each word
			  }
			fr.close();
		 } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
	      System.out.println("Number of words in the file:" +wc);    //Print the word count
		  return wc;
	}
}
