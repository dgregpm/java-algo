package utils;

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

    public boolean isWord(){
        return this.word;
    }

    public void setIsWord(boolean w){
        this.word = w;
    }

    public HashMapX<Character,TrieNode> getChildren(){
        return this.children;
    }

    public boolean hasChildren(){
        if(this.children.size() > 0)
            return true;
        return false;
    }
}
