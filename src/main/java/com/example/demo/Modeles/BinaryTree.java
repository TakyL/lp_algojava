package com.example.demo.Modeles;

import java.util.Objects;

// A Java program to introduce Binary Tree
class BinaryTree {

    // Root of Binary Tree
    Node root;
    public static boolean flag = false;
    // Constructors
    BinaryTree(String key) {
        assert false;
        root = new Node(key,root.letter); }

    BinaryTree() { root = null; }

    //searchNodeFromMorseCode() will search for the particular node in the binary tree
    public void searchNodeFromMorseCode(Node temp, String value){
        //Check whether tree is empty
        if(root == null){
            System.out.println("Tree is empty");
        }
        else{
            //If value is found in the given binary tree then, set the flag to true
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
    //TODO FIX Pour les lettres
    public void searchNodeFromLetterCode(Node temp, String value){
        //Check whether tree is empty
        if(root == null){
            System.out.println("Tree is empty");
        }
        else{
            //If value is found in the given binary tree then, set the flag to true
            if(Objects.equals(temp.letter, value)){
                flag = true;
                System.out.println(temp.letter+" "+temp.getKey());
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

    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();
        // TODO : Pour chaques noeuds, try de getLettre(".") (ex ...) comme ça si dico existe pas on met null et basta
        // create root
        tree.root = new Node("root",null);
        // Each left child represents a "dot" in the code, and each right child represents a "dash."
        // create blank nodes left side of the tree
        tree.root.left = new Node(".","a");
        tree.root.left.left = new Node("..",null);
        tree.root.left.left.left = new Node("...",null);
        tree.root.left.left.right = new Node("..-",null);
        tree.root.left.left.left.left = new Node("....",null);
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
        tree.root.right = new Node("-",null);
        tree.root.right.left = new Node("-.",null);
        tree.root.right.left.left = new Node("-..",null);
        tree.root.right.left.left.left = new Node("-...",null);
        tree.root.right.left.left.right = new Node("-..-",null);
        tree.root.right.left.right = new Node("-.-",null);
        tree.root.right.left.right.left = new Node("-.-.",null);
        tree.root.right.left.right.right = new Node("-.--",null);

        tree.root.right.right = new Node("--",null);
        tree.root.right.right.left = new Node("--.",null);
        tree.root.right.right.left.left = new Node("--..",null);
        tree.root.right.right.left.right = new Node("--.-",null);
        tree.root.right.right.right = new Node("---",null);
        tree.root.right.right.right.left = new Node("---.",null);
        tree.root.right.right.right.right = new Node("----",null);

        //tree.searchNodeFromMorseCode(tree.root, "--.");

        tree.searchNodeFromLetterCode(tree.root,"a");
        if(flag)
            System.out.println("Element is present in the binary tree");

        else
            System.out.println("Element is not present in the binary tree");


}
}
