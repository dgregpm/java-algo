package utils;

public class TrieNode {
    private char c;
    private TrieNode[] children;
    private boolean isWord;

    public TrieNode(char c){
        this.c = c;
        children = new TrieNode[26];
    }

    public char getChar(){
        return this.c;
    }

    public TrieNode[] getChildren(){
        return this.children;
    }

    public String toString(){
        return String.valueOf(this.c);
    }

    public boolean getIsWord(){
        return this.isWord;
    }

    public void setIsWord(boolean w){
        this.isWord = w;
    }
}
