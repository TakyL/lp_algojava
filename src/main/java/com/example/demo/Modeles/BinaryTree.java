package com.example.demo.Modeles;

import java.util.Objects;

// A Java program to introduce Binary Tree
class BinaryTree {

    // Root of Binary Tree
    Node root;
    public static boolean flag = false;
    // Constructors
    BinaryTree(String key, String letter) {
        assert false;
        root = new Node(key,letter); }

    BinaryTree() { root = null; }

    //searchNodeFromMorseCode() will search for the particular node in the binary tree
    public void searchNodeFromMorseCode(Node temp, String value){
        //Check whether tree is empty
        if(root == null){
            System.out.println("Tree is empty");
        }
        else{
            //If value is found in the given binary tree then, set the flag to true
            //System.out.println(temp.key);
            if(Objects.equals(temp.key, value)){
                flag = true;
                System.out.println(temp.key+" "+temp.getLetter());
                return;
            }
            //Search in left subtree
            if(!flag && temp.left != null){
                searchNodeFromMorseCode(temp.left, value);
            }
            //Search in right subtree
            if(!flag && temp.right != null){
                searchNodeFromMorseCode(temp.right, value);
            }
        }
    }
    public Node searchNodeFromLetterCode(Node temp, String value) {
        //Check whether tree is empty
        String result = temp.getKey();
        System.out.println("START");
        System.out.println(result);
        //System.out.println(temp.key);
        //System.out.println(temp.letter);


        if (root == null) {
            System.out.println("Tree is empty");
        } else {
            //If value is found in the given binary tree then, set the flag to true
            if (Objects.equals(temp.letter, value)) {
                flag = true;
                System.out.println(temp.letter + " " + temp.getKey());
                result = temp.getKey();
                this.root.key= temp.key;
                this.root.letter=temp.letter;
                this.root.right=null;
                this.root.left=null;

            }
            //Search in left subtree
            if (!flag && temp.left != null) {
                System.out.println("left");
                searchNodeFromLetterCode(temp.left, value);
            }
            //Search in right subtree
            if (!flag && temp.right != null) {
                System.out.println("right");
                searchNodeFromLetterCode(temp.right, value);
            }
        }
        System.out.println("END");
        System.out.println(result);
        return this.root;

    }

    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();
        // create root
        tree.root = new Node("root","root");
        // Each left child represents a "dot" in the code, and each right child represents a "dash."
        // create blank nodes left side of the tree
        tree.root.left = new Node(".","a");
        tree.root.left.left = new Node("..","z");
        tree.root.left.left.left = new Node("...","x");
        tree.root.left.left.right = new Node("..-","e");
        tree.root.left.left.left.left = new Node("....","c");
        tree.root.left.left.left.right = new Node("...-",null);
        tree.root.left.left.right.left = new Node("..-.",null);
        tree.root.left.left.right.right = new Node("..--",null);

        tree.root.left.right = new Node(".-",null);
        tree.root.left.right.left = new Node(".-.",null);
        tree.root.left.right.left.left = new Node(".-..",null);
        tree.root.left.right.left.right = new Node(".-.-",null);
        tree.root.left.right.right = new Node(".--",null);
        tree.root.left.right.right.left = new Node(".--.",null);
        tree.root.left.right.right.right = new Node(".---",null);

        // create blank nodes right side of the tree
        tree.root.right = new Node("-","p");
        tree.root.right.left = new Node("-.",null);
        tree.root.right.left.left = new Node("-..","d");
        tree.root.right.left.left.left = new Node("-...",null);
        tree.root.right.left.left.right = new Node("-..-",null);
        tree.root.right.left.right = new Node("-.-",null);
        tree.root.right.left.right.left = new Node("-.-.",null);
        tree.root.right.left.right.right = new Node("-.--",null);

        tree.root.right.right = new Node("--",null);
        tree.root.right.right.left = new Node("--.","j");
        tree.root.right.right.left.left = new Node("--..",null);
        tree.root.right.right.left.right = new Node("--.-",null);
        tree.root.right.right.right = new Node("---",null);
        tree.root.right.right.right.left = new Node("---.",null);
        tree.root.right.right.right.right = new Node("----","b");

        //TODO Pour chaques traduction, un arbre est a génerer
        //tree.searchNodeFromMorseCode(tree.root, ".--");
        //tree.searchNodeFromLetterCode(tree.root,"j");
        //System.out.println(tree.searchNodeFromLetterCode(tree.root,"j").key);
        String yes = tree.searchNodeFromLetterCode(tree.root,"d").key;
        System.out.println("----------------");
        System.out.println(yes);
        //System.out.println(tree.searchNodeFromLetterCode(tree.root,"j").letter);

        //La lettre est trouvé, ton terminal affiche : a .

        if(flag)
            //Si la recherche de la lettre "a" dans les noeuds de l'arbre est trouver, je suis notifié
            System.out.println("Element is present in the binary tree");
        else
            System.out.println("Element is not present in the binary tree");


    }
}
