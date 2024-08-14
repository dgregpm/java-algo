package utils;

public class TrieNode {
    private char c;
    private boolean word;
    private TrieNode[] children;

    public TrieNode(char c){
        this.c = c;
        this.children = new TrieNode[26];
    }

    @Override
    public String toString(){
        return Character.toString(c);
    }

    public char getChar(){
        return this.c;
    }

    public TrieNode[] getChildren(){
        return this.children;
    }

    public int getChildCount(){
        int cnt = 0;
        for (int i = 0; i < this.children.length; i++) {
            if(this.children[i] != null)
                cnt++;
        }
        return cnt;
    }

    public boolean isWord(){
        return this.word;
    }

    public void setWord(boolean b){
        this.word = b;
    }
}
