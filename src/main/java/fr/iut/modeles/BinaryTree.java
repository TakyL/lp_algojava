package fr.iut.modeles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
/**
 *Une Classe Java représentant les arbres binaire de Noeuds utilisé pour la traduction d'un Code Morse vers du Texte
 */
public class BinaryTree {

    // Root of Binary Tree
    Node root;

    public BinaryTree() { root = null; }



    /**
     * Implémentation dans un arbre binaire des traductions de chaques code morse en lettre
     * @param tree Arbre Binaire
     * @param value Code Morse
     * @return lettre équivalente au Code Morse
     */
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


    /**
     * Méthode permettant de convertir un code morse vers un texte
     * @param tree Arbre Binaire
     * @param morse Code Morse
     * @return Une Chaine de caractère qui contient la traduction du Code Morse
     */
    public static String translateUsingBinaryTree(BinaryTree tree, String morse) {
        AtomicReference<String> result = new AtomicReference<>("");
        ArrayList<String> wordArrayList = new ArrayList<>(Arrays.asList(morse.split(" ")));
        //System.out.println(wordArrayList);
        wordArrayList.forEach(s -> {
            result.set(result + tree.searchNodeFromLetterCode(tree, s));
            //System.out.println(s);System.out.println(tree.searchNodeFromLetterCode(tree,s));System.out.println(result.get());
        });
        return String.valueOf(result.get());
    }

    /**
     *Remplit notre arbre binaire en fonction de ref.txt (on remplit les valeurs des noeuds de l'arbre par une lettre).
     * @param Trouveur
     * @return tree (BinaryTree)
     */
    public static BinaryTree getBinaryTree(Conversion Trouveur) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node("root");
        // Chaque enfant du noeud a gauche représente un point, chaques enfant du noeud a droite représente un tiret.
        // créer la partie gauche de l'arbre
        tree.root.left = new Node(Trouveur.ConversionMorseVersMots("."));
        tree.root.left.left = new Node(Trouveur.ConversionMorseVersMots(".."));
        tree.root.left.left.left = new Node(Trouveur.ConversionMorseVersMots("..."));
        tree.root.left.left.right = new Node(Trouveur.ConversionMorseVersMots("..-"));
        tree.root.left.left.left.left = new Node(Trouveur.ConversionMorseVersMots("...."));
        tree.root.left.left.left.right = new Node(Trouveur.ConversionMorseVersMots("...-"));
        tree.root.left.left.right.left = new Node(Trouveur.ConversionMorseVersMots("..-."));
        tree.root.left.right = new Node(Trouveur.ConversionMorseVersMots(".-"));
        tree.root.left.right.left = new Node(Trouveur.ConversionMorseVersMots(".-."));
        tree.root.left.right.left.left = new Node(Trouveur.ConversionMorseVersMots(".-.."));
        tree.root.left.right.right = new Node(Trouveur.ConversionMorseVersMots(".--"));
        tree.root.left.right.right.left = new Node(Trouveur.ConversionMorseVersMots(".--."));
        tree.root.left.right.right.right = new Node(Trouveur.ConversionMorseVersMots(".---"));
        // créer la partie droite de l'arbre
        tree.root.right = new Node(Trouveur.ConversionMorseVersMots("-"));
        tree.root.right.left = new Node(Trouveur.ConversionMorseVersMots("-."));
        tree.root.right.left.left = new Node(Trouveur.ConversionMorseVersMots("-.."));
        tree.root.right.left.left.left = new Node(Trouveur.ConversionMorseVersMots("-..."));
        tree.root.right.left.left.right = new Node(Trouveur.ConversionMorseVersMots("-..-"));
        tree.root.right.left.right = new Node(Trouveur.ConversionMorseVersMots("-.-"));
        tree.root.right.left.right.left = new Node(Trouveur.ConversionMorseVersMots("-.-."));
        tree.root.right.left.right.right = new Node(Trouveur.ConversionMorseVersMots("-.--"));
        tree.root.right.right = new Node(Trouveur.ConversionMorseVersMots("--"));
        tree.root.right.right.left = new Node(Trouveur.ConversionMorseVersMots("--."));
        tree.root.right.right.left.left = new Node(Trouveur.ConversionMorseVersMots("--.."));
        tree.root.right.right.left.right = new Node(Trouveur.ConversionMorseVersMots("--.-"));
        tree.root.right.right.right = new Node(Trouveur.ConversionMorseVersMots("---"));
        return tree;
    }
}