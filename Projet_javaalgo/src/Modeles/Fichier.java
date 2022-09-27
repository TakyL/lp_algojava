package Modeles;
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
	
	public String[] FichierToTableauMots() //Renvoie un tableau qui contient tous les mots à traduire dont les espaces
	{
		
		String [] tab= new String [CompteurMotfichier()];
		Scanner scan;
		try {
			scan = new Scanner(new File(urlfichier));
		
		int index=0;
		  while (scan.hasNextLine()) {
	 
	            tab = scan.nextLine().split(" ");
	            index++;
	        }
	        scan.close();
		    
            for(int i=0;i<tab.length;i++){
                System.out.print(tab[i]+"|");
            }

	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

			return tab;
}
	/*
ex: Bonjour la mouche => 
0=> Bonjour
1=> ESPACE
2=> la
3=> ESPACE
4=>mouche 
*/

	public int CompteurMotfichier()	//COmpte le nb de mot pour obtenir la taille du tableau à réaliser
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
