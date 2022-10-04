package com.example.demo.Modeles;

// Class containing left and right child
// of current node and key value
class Node
{
    String key;
    String letter;
    Node left, right;

    public Node(String morseCode ,String morseLetter)
    {
        key = morseCode;
        left = right = null;
        letter = morseLetter;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public String getLetter() {
        return letter;
    }
}
