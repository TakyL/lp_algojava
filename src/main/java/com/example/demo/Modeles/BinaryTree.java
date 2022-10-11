package com.example.demo.Modeles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

// A Java program to introduce Binary Tree
class BinaryTree {

    // Root of Binary Tree
    Node root;
    public static boolean flag = false;

    BinaryTree() { root = null; }

    public String searchNodeFromLetterCode(BinaryTree tree, String value) {
        switch (value) {
            case "." -> {
                return tree.root.left.key;
            }
            case ".." -> {
                return tree.root.left.left.key;
            }
            case "..." -> {
                return tree.root.left.left.left.key;
            }
            case "..-" -> {
                return tree.root.left.left.right.key;
            }
            case "...." -> {
                return tree.root.left.left.left.left.key;
            }
            case "...-" -> {
                return tree.root.left.left.left.right.key;
            }
            case "..-." -> {
                return tree.root.left.left.right.left.key;
            }
            case ".-" -> {
                return tree.root.left.right.key;
            }
            case ".-." -> {
                return tree.root.left.right.left.key;
            }
            case ".-.." -> {
                return tree.root.left.right.left.left.key;
            }
            case ".--" -> {
                return tree.root.left.right.right.key;
            }
            case ".--." -> {
                return tree.root.left.right.right.left.key;
            }
            case ".---" -> {
                return tree.root.left.right.right.right.key;
            }
            case "-" -> {
                return tree.root.right.key;
            }
            case "-." -> {
                return tree.root.right.left.key;
            }
            case "-.." -> {
                return tree.root.right.left.left.key;
            }
            case "-..." -> {
                return tree.root.right.left.left.left.key;
            }
            case "-..-" -> {
                return tree.root.right.left.left.right.key;
            }
            case "-.-" -> {
                return tree.root.right.left.right.key;
            }
            case "-.-." -> {
                return tree.root.right.left.right.left.key;
            }
            case "-.--" -> {
                return tree.root.right.left.right.right.key;
            }
            case "--" -> {
                return tree.root.right.right.key;
            }
            case "--." -> {
                return tree.root.right.right.left.key;
            }
            case "--.." -> {
                return tree.root.right.right.left.left.key;
            }
            case "--.-" -> {
                return tree.root.right.right.left.right.key;
            }
            case "---" -> {
                return tree.root.right.right.right.key;
            }
        }

        return null;
    }

    public static void main(String[] args)
    {
        Fichier f1 = new  Fichier("src/main/java/com/example/demo/Texte/ref.txt");


        Liste liste0 = f1.FichierToListe();	//R�cup�re toute la liste de conversion
        //Liste de conversion de base .
        Conversion Trouveur = new Conversion(liste0);
        //System.out.println(Trouveur.recherchemot(".--"));

        BinaryTree tree = getBinaryTree(Trouveur);

        System.out.println(tree.searchNodeFromLetterCode(tree,"--.."));

        //hugo in morsecode
        String string =".... ..- --. ---";

        translateUsingBinaryTree(tree, string);


    }

    private static void translateUsingBinaryTree(BinaryTree tree, String hugo) {
        AtomicReference<String> result = new AtomicReference<>("");
        ArrayList<String> wordArrayList = new ArrayList<>(Arrays.asList(hugo.split(" ")));
        System.out.println(wordArrayList);
        wordArrayList.forEach(s -> {
                System.out.println(s);
                System.out.println(tree.searchNodeFromLetterCode(tree,s));
                result.set(result + tree.searchNodeFromLetterCode(tree, s));
            System.out.println(result.get());

        });
    }

    private static BinaryTree getBinaryTree(Conversion Trouveur) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node("root");
        // Each left child represents a "dot" in the code, and each right child represents a "dash."
        // create blank nodes left side of the tree

        tree.root.left = new Node(Trouveur.recherchemot("."));
        tree.root.left.left = new Node(Trouveur.recherchemot(".."));
        tree.root.left.left.left = new Node(Trouveur.recherchemot("..."));
        tree.root.left.left.right = new Node(Trouveur.recherchemot("..-"));
        tree.root.left.left.left.left = new Node(Trouveur.recherchemot("...."));
        tree.root.left.left.left.right = new Node(Trouveur.recherchemot("...-"));
        tree.root.left.left.right.left = new Node(Trouveur.recherchemot("..-."));
        //FIXME Je n'existe pas dans les 26 lettres
        //tree.root.left.left.right.right = new Node("..--", Trouveur.recherchemot("..--"));
        tree.root.left.right = new Node(Trouveur.recherchemot(".-"));
        tree.root.left.right.left = new Node(Trouveur.recherchemot(".-."));
        tree.root.left.right.left.left = new Node(Trouveur.recherchemot(".-.."));
        //FIXME Je n'existe pas dans les 26 lettres
        //tree.root.left.right.left.right = new Node(".-.-", Trouveur.recherchemot(".-.-"));
        tree.root.left.right.right = new Node(Trouveur.recherchemot(".--"));
        tree.root.left.right.right.left = new Node(Trouveur.recherchemot(".--."));
        tree.root.left.right.right.right = new Node(Trouveur.recherchemot(".---"));
        // create blank nodes right side of the tree
        tree.root.right = new Node(Trouveur.recherchemot("-"));
        tree.root.right.left = new Node(Trouveur.recherchemot("-."));
        tree.root.right.left.left = new Node(Trouveur.recherchemot("-.."));
        tree.root.right.left.left.left = new Node(Trouveur.recherchemot("-..."));
        tree.root.right.left.left.right = new Node(Trouveur.recherchemot("-..-"));
        tree.root.right.left.right = new Node(Trouveur.recherchemot("-.-"));
        tree.root.right.left.right.left = new Node(Trouveur.recherchemot("-.-."));
        tree.root.right.left.right.right = new Node(Trouveur.recherchemot("-.--"));
        tree.root.right.right = new Node(Trouveur.recherchemot("--"));
        tree.root.right.right.left = new Node(Trouveur.recherchemot("--."));
        tree.root.right.right.left.left = new Node(Trouveur.recherchemot("--.."));
        tree.root.right.right.left.right = new Node(Trouveur.recherchemot("--.-"));
        tree.root.right.right.right = new Node(Trouveur.recherchemot("---"));
        //FIXME Je n'existe pas dans les 26 lettres
        //tree.root.right.right.right.left = new Node("---.", Trouveur.recherchemot("---."));
        //tree.root.right.right.right.right = new Node("----", Trouveur.recherchemot("----"));
        return tree;
    }
}
