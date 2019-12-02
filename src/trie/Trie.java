/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trie;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import trie.model.FileUtils;
import trie.model.TrieNode;

/**
 *
 * @author Suporte
 */
public class Trie {

    /**
     * @param args the command line arguments
     */
    public static final TrieNode ROOT = new TrieNode();
    public static TrieNode CURRENT_NODE;
    public static TrieNode CURRENT_NODE_AUX;
    public static String PALAVRA;
    public static ArrayList<String> SUGESTOES;

    public static void main(String[] args) {
        SUGESTOES = new ArrayList();
        FileUtils file = new FileUtils();
        CURRENT_NODE = ROOT;
        try {
            file.leitor(args[0]);

        } catch (IOException ex) {
            System.out.println("Erro na abertura do arquivo: " + ex.getMessage());
        }

        String prefix = args[1];
        CURRENT_NODE = ROOT;
        char[] prefixChar = prefix.toCharArray();
        for (int i = 0; i < prefixChar.length; i++) {
            CURRENT_NODE.buscarCaractere(String.valueOf(prefixChar[i]));

        }
        if (CURRENT_NODE.IsWord()) {
            SUGESTOES.add(CURRENT_NODE.getPalavraFinal());
        }
        CURRENT_NODE.autocompletar(CURRENT_NODE);
        try {
            for (int i = 0; i < Integer.parseInt(args[2]); i++) {
                System.out.println(SUGESTOES.get(i));
            }
        } catch (Exception e) {
            for (int i = 0; i < SUGESTOES.size(); i++) {
                System.out.println(SUGESTOES.get(i));
            }
        }

    }
}
