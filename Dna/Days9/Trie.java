import utils.TrieNode;
import utils.ArrayListX;
import utils.StackX;

public class Trie {
    private TrieNode root;


    public Trie() {
        this.root = new TrieNode('/');
    }

    public void insert(String item) {
        TrieNode[] kids = root.getChildren();
        TrieNode curr = null;
        for (int i = 0; i < item.length(); i++) {
            char c = item.charAt(i);
            if(kids[c - 'a'] == null){
                curr = kids[c - 'a'] = new TrieNode(c);
            } else {
                curr = kids[c - 'a'];                
            }
            kids = curr.getChildren();
            if(i == item.length() - 1)
                curr.setIsWord(true);
        }
    }
    
    public void delete(String item) {
        StackX<TrieNode[]> word = new StackX<>();
        TrieNode[] kids = root.getChildren();
        TrieNode curr = null;
        for (int i = 0; i < item.length(); i++) {
            char c = item.charAt(i);
            if(kids[c - 'a'] == null)
                return;
            curr = kids[c - 'a'];
            word.push(kids);
            kids = curr.getChildren();
            if(i == item.length() - 1)
                curr.setIsWord(false);
        }

        for (int i = item.length() - 1; i >= 0; i--) {
            char c = item.charAt(i);
            kids = word.pop();
            curr = kids[c - 'a'];
            if(!curr.isWord() && curr.childrenCount() == 0)
                kids[c - 'a'] = null;
            else
                return;
        }
    }
    
    public ArrayListX<String> find(String partial) {
        ArrayListX<String> words = new ArrayListX<>();
        if(partial == null || partial.length() == 0)
            return words;
        TrieNode[] kids = root.getChildren();
        TrieNode curr = null;
        for (int i = 0; i < partial.length(); i++) {
            char c = partial.charAt(i);
            if(kids[c - 'a'] == null)
                return words;
            curr = kids[c - 'a'];
            kids = curr.getChildren();
        }
        StringBuilder sb = new StringBuilder(partial);
        this.search(curr,sb,words);
        return words;
    }

    public ArrayListX<String> printAll(){
        ArrayListX<String> words = new ArrayListX<>();
        StringBuilder sb = new StringBuilder();
        this.search(root,sb,words);
        return words;
    }

    private void search(TrieNode curr, StringBuilder sb, ArrayListX<String> words){
        if(curr.isWord())
            words.append(sb.toString());

        TrieNode[] kids = curr.getChildren();
        for (int i = 0; i < kids.length; i++) {
            if(kids[i] != null){
                curr = kids[i];
                sb.append(curr.getChar());
                search(curr,sb,words);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
