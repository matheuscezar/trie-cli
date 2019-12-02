/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trie.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Suporte
 */
public class FileUtils {
    
    
    public void leitor(String path) throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String linha = "";
        while (true) {
            if (linha != null) {
              trie.Trie.PALAVRA = linha;
              goToTrie(linha);
              trie.Trie.CURRENT_NODE = trie.Trie.ROOT;
            } else
                break;
            linha = buffRead.readLine();
        }
        buffRead.close();
    }

    private void goToTrie(String linha) {
            char[] linhaChar = linha.toCharArray();
            for(int i = 0; i < linhaChar.length; i++){
                if(i==(linhaChar.length-1)){
                    trie.Trie.CURRENT_NODE.inserirCaractere(String.valueOf(linhaChar[i]), true);
                }
                else{
                  trie.Trie.CURRENT_NODE.inserirCaractere(String.valueOf(linhaChar[i]), false);  
                }
            }
    }
 
    
}
