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
		//c0.recherchecode("e");	//Liste de conversion.recherchercode(caract�re)
		//liste0.afficher_position(); // What is this shit ??
		//liste0.RetourneAuDebut();
		String mot = "patate";
		Conversion Trouveur = new Conversion(liste0);
		System.out.println(Trouveur.recherchemot(".--"));
		//liste0.Lettre_ref.getCode();
//		for(int i=0; i<mot.length();i++)
//		{
//			//System.out.println(c0.recherchecode(String.valueOf(mot.charAt(i)).toLowerCase()));
//			System.out.println(mot.charAt(i));
//			c0.recherchecode(String.valueOf(mot.charAt(i)));
//		}
		//f0.FichierToTableauMots();


	
	
	//CodeMorse c0 = new CodeMorse(".-");
	Lettre l0 = new Lettre("a",".-");
	//Liste l0 = new Liste()

	//c0.ConversionCodeToLettre();

		BinaryTree tree = new BinaryTree();
		// TODO : Pour chaques noeuds, try de getLettre(".") (ex ...) comme ça si dico existe pas on met null et basta
		// create root
		tree.root = new Node("root",null);
		// Each left child represents a "dot" in the code, and each right child represents a "dash."
		// create blank nodes left side of the tree

			tree.root.left = new Node(".", Trouveur.recherchemot("."));
			tree.root.left.left = new Node("..", Trouveur.recherchemot(".."));
			tree.root.left.left.left = new Node("...", Trouveur.recherchemot("..."));
			tree.root.left.left.right = new Node("..-", Trouveur.recherchemot("..-"));
			tree.root.left.left.left.left = new Node("....", Trouveur.recherchemot("...."));
			tree.root.left.left.left.right = new Node("...-", Trouveur.recherchemot("...-"));
			tree.root.left.left.right.left = new Node("..-.", Trouveur.recherchemot("..-."));
			//FIXME Je n'existe pas dans les 26 lettres
			//tree.root.left.left.right.right = new Node("..--", Trouveur.recherchemot("..--"));
			//
			tree.root.left.right = new Node(".-", Trouveur.recherchemot(".-"));
			tree.root.left.right.left = new Node(".-.", Trouveur.recherchemot(".-."));
			tree.root.left.right.left.left = new Node(".-..", Trouveur.recherchemot(".-.."));
			//FIXME Je n'existe pas dans les 26 lettres
			//tree.root.left.right.left.right = new Node(".-.-", Trouveur.recherchemot(".-.-"));
			tree.root.left.right.right = new Node(".--", Trouveur.recherchemot(".--"));
			tree.root.left.right.right.left = new Node(".--.", Trouveur.recherchemot(".--."));
			tree.root.left.right.right.right = new Node(".---", Trouveur.recherchemot(".---"));
			// create blank nodes right side of the tree
			tree.root.right = new Node("-", Trouveur.recherchemot("-"));
			tree.root.right.left = new Node("-.", Trouveur.recherchemot("-."));
			tree.root.right.left.left = new Node("-..", Trouveur.recherchemot("-.."));
			tree.root.right.left.left.left = new Node("-...", Trouveur.recherchemot("-..."));
			tree.root.right.left.left.right = new Node("-..-", Trouveur.recherchemot("-..-"));
			tree.root.right.left.right = new Node("-.-", Trouveur.recherchemot("-.-"));
			tree.root.right.left.right.left = new Node("-.-.", Trouveur.recherchemot("-.-."));
			tree.root.right.left.right.right = new Node("-.--", Trouveur.recherchemot("-.--"));
			//
			tree.root.right.right = new Node("--", Trouveur.recherchemot("--"));
			tree.root.right.right.left = new Node("--.", Trouveur.recherchemot("--."));
			//FIXME Je suis focntionnel pour recherchemot mais recherchecode(z) non
			tree.root.right.right.left.left = new Node("--..", Trouveur.recherchemot("--.."));
			tree.root.right.right.left.right = new Node("--.-", Trouveur.recherchemot("--.-"));
			tree.root.right.right.right = new Node("---", Trouveur.recherchemot("---"));
			//FIXME Je n'existe pas dans les 26 lettres
			//tree.root.right.right.right.left = new Node("---.", Trouveur.recherchemot("---."));
			//tree.root.right.right.right.right = new Node("----", Trouveur.recherchemot("----"));
			tree.searchNodeFromMorseCode(tree.root, "-.--");


	}

}
