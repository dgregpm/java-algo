package utils;

public class TrieNode {
    private char c;
    private TrieNode[] children;
    private boolean word;

    public TrieNode(char c){
        this.c = c;
        this.children = new TrieNode[26];
        this.word = false;
    }

    public char getChar(){
        return this.c;
    }

    public boolean isWord(){
        return this.word;
    }

    public void setWord(boolean w){
        this.word = w;
    }

    public TrieNode[] getChildren(){
        return this.children;
    }

    public int childrenCount(){
        int cnt = 0;
        for (int i = 0; i < this.children.length; i++) {
            if(this.children[i] != null)
                cnt++;
        }
        return cnt;
    }

    @Override
    public String toString(){
        return Character.toString(c);
    }
}
