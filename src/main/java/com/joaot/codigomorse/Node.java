package com.joaot.codigomorse;
// Classe Node com letra e filhos left/right
public class Node {
    public char letra;
    public Node left;
    public Node right;

    public Node(char letra) {
        this.letra = letra;
        this.left = null;
        this.right = null;
    }
}
