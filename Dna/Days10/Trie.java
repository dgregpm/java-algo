import utils.TrieNode;
import utils.ArrayListX;
import utils.HashMapX;
import utils.StackX;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode(' ');
    }

    public void insert(String item) {
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
    }
    
    public void delete(String item) {
        HashMapX<Character,TrieNode> kids = root.getChildren();
        TrieNode curr = null;
        StackX<HashMapX<Character,TrieNode>> words = new StackX<>();
        for (int i = 0; i < item.length(); i++) {
            char c = item.charAt(i);
            curr = kids.get(c);
            if(curr == null)
                return;
            words.push(kids);
            kids = curr.getChildren();
            if(i == item.length() - 1)
                curr.setIsWord(false);
        }

        for (int i = item.length() - 1; i >= 0; i--) {
            kids = words.pop();
            char c = item.charAt(i);
            curr = kids.get(c);
            if(curr.isWord() || curr.getChildren().size() > 0)
                return;
            else{
                kids.delete(c);
            }
        }
    }
    
    public ArrayListX<String> find(String partial) {
        ArrayListX<String> words = new ArrayListX<>();
        HashMapX<Character,TrieNode> kids = root.getChildren();
        TrieNode curr = null;
        for (int i = 0; i < partial.length(); i++) {
            char c = partial.charAt(i);
            curr = kids.get(c);
            if(curr == null)
                return words;
            kids = curr.getChildren();
        }
        StringBuilder sb = new StringBuilder(partial);
        search(curr,sb,words);
        return words;
    }

    public ArrayListX<String> printAll(){
        ArrayListX<String> words = new ArrayListX<>();
        StringBuilder sb = new StringBuilder();
        search(root,sb,words);
        return words;        
    }

    private void search(TrieNode curr, StringBuilder sb, ArrayListX<String> words){
        if(curr.isWord())
            words.append(sb.toString());
        
        HashMapX<Character,TrieNode> kids = curr.getChildren();
        Object[] letters = kids.keySet();
        for (int i = 0; i < letters.length; i++) {
            curr = kids.get((Character)letters[i]);
            sb.append(curr.getChar());
            search(curr,sb,words);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
