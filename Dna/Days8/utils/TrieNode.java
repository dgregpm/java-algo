package utils;

public class TrieNode {
    private char c;
    private boolean word;
    private TrieNode[] children;

    public TrieNode(char c){
        this.c = c;
        this.children = new TrieNode[26];
    }

    public char getChar(){
        return this.c;
    }

    public TrieNode[] getChildren(){
        return this.children;
    }

    public boolean isWord(){
        return this.word;
    }

    public void setIsWord(boolean w){
        this.word = w;
    }

    public int childrenCount(){
        int cnt = 0;
        for (int i = 0; i < children.length; i++) {
            if(this.children[i] != null)
                cnt++;
        }
        return cnt;
    }

    @Override
    public String toString(){
        return Character.toString(this.c);
    }
}
