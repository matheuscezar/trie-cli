/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trie.model;

import java.util.ArrayList;
import trie.Trie;


/**
 *
 * @author Suporte
 */


public class TrieNode {

    boolean isWord;
    ArrayList<TrieNode> children;
    String text;
    String palavraFinal;

    public boolean IsWord() {
        return isWord;
    }

    public String getPalavraFinal() {
        return palavraFinal;
    }
    
    
    
    public TrieNode(String text){
        this.text = text;
        children = new ArrayList();
    }

    public TrieNode() {
        children = new ArrayList();
    }

    public String getText() {
        return text;
    }
   
    public void inserirCaractere(String caractere, boolean isWord){
        if(trie.Trie.CURRENT_NODE.buscarCaractere(caractere)){
            //System.out.println("Caractere já cadastrado");
        } else {
            trie.Trie.CURRENT_NODE.children.add(new TrieNode(caractere));
            trie.Trie.CURRENT_NODE = trie.Trie.CURRENT_NODE.children.
                    get(trie.Trie.CURRENT_NODE.children.size()-1);      
        }
        if(isWord){
                trie.Trie.CURRENT_NODE.isWord = true;
                trie.Trie.CURRENT_NODE.palavraFinal = trie.Trie.PALAVRA;
            }
    }

    public boolean buscarCaractere(String caractere) {
        for (int i = 0; i < trie.Trie.CURRENT_NODE.children.size(); i++) {
            String aux = trie.Trie.CURRENT_NODE.children.get(i).text;
            if(caractere.equals(aux)) {
                trie.Trie.CURRENT_NODE = trie.Trie.CURRENT_NODE.children.get(i);
                return true;
            }
        }
        return false;
    }

    public void autocompletar(TrieNode currentNode) {
        for (int i = 0; i < currentNode.children.size(); i++) {
            if(currentNode.children.get(i).isWord) trie.Trie.SUGESTOES.add(currentNode.children.get(i).palavraFinal);
            TrieNode newCurrentNode = currentNode.children.get(i);
            currentNode.children.get(i).autocompletar(newCurrentNode);
        }
    }

}
    


