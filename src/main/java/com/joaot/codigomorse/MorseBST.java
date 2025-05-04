package com.joaot.codigomorse;

import java.util.HashMap;
import java.util.Map;

public class MorseBST {
    Node root;
    private Map<Character, String> morseMap;

    public MorseBST() {
        root = new Node(' ');
        morseMap = new HashMap<>();
        construirArvoreMorse();
    }

    public void construirArvoreMorse() {
        String[][] morseTable = {
                {"A", ".-"},    {"B", "-..."},  {"C", "-.-."},  {"D", "-.."},   {"E", "."},
                {"F", "..-."},  {"G", "--."},   {"H", "...."},  {"I", ".."},    {"J", ".---"},
                {"K", "-.-"},   {"L", ".-.."},  {"M", "--"},    {"N", "-."},    {"O", "---"},
                {"P", ".--."},  {"Q", "--.-"},  {"R", ".-."},   {"S", "..."},   {"T", "-"},
                {"U", "..-"},   {"V", "...-"},  {"W", ".--"},   {"X", "-..-"},  {"Y", "-.--"},
                {"Z", "--.."},  {"1", ".----"}, {"2", "..---"}, {"3", "...--"}, {"4", "....-"},
                {"5", "....."}, {"6", "-...."}, {"7", "--..."}, {"8", "---.."}, {"9", "----."},
                {"0", "-----"}
        };

        for (String[] par : morseTable) {
            char letra = par[0].charAt(0);
            String morse = par[1];
            insert(letra, morse);
            morseMap.put(letra, morse);
        }
    }

    public void insert(char letra, String morseCode) {
        Node atual = root;
        for (char c : morseCode.toCharArray()) {
            if (c == '.') {
                if (atual.left == null) atual.left = new Node(' ');
                atual = atual.left;
            } else if (c == '-') {
                if (atual.right == null) atual.right = new Node(' ');
                atual = atual.right;
            }
        }
        atual.letra = letra;
    }

    public String decodificarFrase(String morseFrase) {
        StringBuilder resultado = new StringBuilder();
        String[] letras = morseFrase.trim().split(" ");
        for (String codigo : letras) {
            resultado.append(decodificarLetra(codigo));
        }
        return resultado.toString();
    }

    private char decodificarLetra(String codigo) {
        Node atual = root;
        for (char c : codigo.toCharArray()) {
            if (c == '.') {
                if (atual.left != null) atual = atual.left;
                else return '?';
            } else if (c == '-') {
                if (atual.right != null) atual = atual.right;
                else return '?';
            }
        }
        return atual.letra;
    }

    public String codificarTexto(String texto) {
        StringBuilder resultado = new StringBuilder();
        for (char c : texto.toUpperCase().toCharArray()) {
            if (morseMap.containsKey(c)) {
                resultado.append(morseMap.get(c)).append(" ");
            }
        }
        return resultado.toString().trim();
    }

    // NOVO MÉTODO para exibir a árvore em ordem (in-order)
    public String imprimirEmOrdem() {
        StringBuilder sb = new StringBuilder();
        imprimirEmOrdem(root, sb);
        return sb.toString();
    }

    private void imprimirEmOrdem(Node node, StringBuilder sb) {
        if (node != null) {
            imprimirEmOrdem(node.left, sb);
            if (node.letra != ' ') sb.append(node.letra).append(" ");
            imprimirEmOrdem(node.right, sb);
        }
    }
}
