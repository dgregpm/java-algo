package utils;
import java.util.Arrays;

public class TrieNode{
    private char c;
    private boolean word;
    private HashMapX<Character,TrieNode> children;

    public TrieNode(char c){
        this.c = c;
        this.children = new HashMapX<>();
    }

    public char getChar(){
        return this.c;
    
    }

    public HashMapX<Character,TrieNode> getChildren(){
        return this.children;
    }

    public boolean isWord(){
        return this.word;
    }

    public void setIsWord(boolean w){
        this.word = w;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        return sb.append("Char: " + this.c).toString(); //+ " Children: " + this.children).toString();
    }
}
