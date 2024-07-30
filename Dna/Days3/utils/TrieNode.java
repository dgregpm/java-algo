package utils;

public class TrieNode {
    private boolean word;
    public TrieNode[] children = new TrieNode[26];
    private char c;

    public TrieNode(){}

    public TrieNode(char c){
        this.c = c;
    }

    public boolean isWord(){
        return this.word;
    }

    public void setIsWord(boolean w){
        this.word = w;
    }

    public char getChar(){
        return this.c;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder(this.c);
        return sb.toString();
    }

    public void setChar(char c){
        this.c = c;
    }
}
