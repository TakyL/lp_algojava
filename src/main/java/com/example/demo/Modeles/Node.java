package com.example.demo.Modeles;

// Class containing left and right child
// of current node and key value
class Node
{
    String key;
    Node left, right;

    public Node(String morseLetter)
    {

        key = morseLetter;
        left = right = null;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

}
