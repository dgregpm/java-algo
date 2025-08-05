import utils.TrieNode;
import utils.StackX;
import utils.HashMapX;

public class Trie {
    private TrieNode root;
    private int count;

    public Trie() {
        this.root = new TrieNode(' ');
    }

    public Trie insert(String item) {
        HashMapX<Character,TrieNode> kids = root.getChildren();
        TrieNode curr = null;
        for (int i = 0; i < item.length(); i++) {
            char c = item.charAt(i);
            curr = kids.get(c); 
            if(curr == null){
                curr = new TrieNode(c);
                kids.set(c,curr);
            }
            kids = curr.getChildren();
            if(i == item.length() - 1)
                curr.setIsWord(true);
        }
        this.count++;
        return this;
    }
    
    public Trie delete(String item) {
        StackX<HashMapX<Character,TrieNode>> trace = new StackX<>();
        HashMapX<Character,TrieNode> kids = root.getChildren();
        TrieNode curr = null;
        for (int i = 0; i < item.length(); i++) {
            char c = item.charAt(i);
            curr = kids.get(c);
            if(curr == null)
                return this;
            trace.push(kids);
            kids = curr.getChildren();
            if(i == item.length() - 1){
                if(curr.isWord()){
                    curr.setIsWord(false);
                    this.count--;
                }
            }
        }
        for (int i = item.length() - 1; i >= 0; i--) {
            char c = item.charAt(i);
            kids = trace.pop();
            curr = kids.get(c);
            if(curr.isWord() || curr.getChildren().size() > 0)
                break;
            kids.delete(c);
        }
        return this;
    }

    public int wordCount(){
        return this.count;
    }

    @Override
    public String toString(){
        StackX<String> words = new StackX<>();
        StringBuilder sb = new StringBuilder();
        this.search(words,root,sb);
        return words.reverse().toString();
    }
    
    public StackX<String> find(String partial) {
        HashMapX<Character,TrieNode> kids = root.getChildren();
        TrieNode curr = null;
        StackX<String> words = new StackX<>();
        for (int i = 0; i < partial.length(); i++) {
            char c = partial.charAt(i);
            curr = kids.get(c);
            if(curr == null)
                return words;
            kids = curr.getChildren();
        }
        StringBuilder sb = new StringBuilder(partial);
        search(words,curr,sb);
        return words;
    }

    private void search(StackX<String> words, TrieNode curr, StringBuilder sb){
        if(curr.isWord())
            words.push(sb.toString());
        HashMapX<Character,TrieNode> kids = curr.getChildren();
        Object[] chArr = kids.keys();
        for (int i = 0; i < chArr.length; i++) {
            Character ch = (Character)chArr[i];
            curr = kids.get(ch);
            sb.append(curr.getChar());
            search(words,curr,sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
