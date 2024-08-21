import utils.TrieNode;
import utils.ArrayListX;
import java.util.Arrays;
import utils.StackX;

public class Trie {
    private TrieNode root; 

    public Trie() {
        root = new TrieNode(' ');
    }

    public void insert(String item) {
        TrieNode[] kids = root.getChildren();
        TrieNode curr = null;
        for (int i = 0; i < item.length(); i++) {
            char c = item.charAt(i);
            if(kids[c - 'a'] == null){
                curr = new TrieNode(c);
                kids[c - 'a'] = curr;
            }
            else
                curr = kids[c - 'a'];
            kids = curr.getChildren();
            if(i == item.length() - 1)
                curr.setWord(true);
        }
    }
    
    public void delete(String item) {
        StackX<TrieNode[]> trace = new StackX<>();
        TrieNode[] kids = root.getChildren();
        TrieNode curr = null;
        for (int i = 0; i < item.length(); i++) {
            trace.push(kids);
            char c = item.charAt(i);
            if(kids[c - 'a'] == null)
                return;
            else
                curr = kids[c - 'a'];
            kids = curr.getChildren();
        }
        curr.setWord(false);
        for (int i = item.length() - 1; i >= 0; i--) {
            char c = item.charAt(i);
            kids = trace.pop();
            curr = kids[c - 'a'];
            if(curr.childrenCount() == 0 && curr.isWord() == false)
                kids[c - 'a'] = null;
            else
                return;
        }
    }
    
    public ArrayListX<String> find(String partial) {
        ArrayListX<String> words = new ArrayListX<>();
        TrieNode[] kids = root.getChildren();
        //System.out.println(Arrays.toString(kids));
        TrieNode curr = null;
        for (int i = 0; i < partial.length(); i++) {
            char c = partial.charAt(i);
            if(kids[c - 'a'] == null)
                return words;
            else
                curr = kids[c - 'a'];
            kids = curr.getChildren();
        }
        StringBuilder sb = new StringBuilder(partial);
        search(curr,words,sb);
        return words;
    }

    private void search(TrieNode curr, ArrayListX<String> words, StringBuilder sb){
        if(curr.isWord())
            words.append(sb.toString());
        
        TrieNode[] kids = curr.getChildren();
        for (int i = 0; i < kids.length; i++) {
            if(kids[i] != null){
                curr = kids[i];
                sb.append(curr.getChar());
                search(curr,words,sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public ArrayListX<String> printAll(){
        System.out.println(root.childrenCount());
        ArrayListX<String> words = new ArrayListX<>();
        StringBuilder sb = new StringBuilder();
        search(root,words,sb);
        return words;
    }
}
