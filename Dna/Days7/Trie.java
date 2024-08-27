import utils.TrieNode;
import utils.ArrayListX;
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
            if(kids[c - 'a'] != null)
                curr = kids[c - 'a'];
            else{
                curr = new TrieNode(c);
                kids[c - 'a'] = curr;
            }
            kids = curr.getChildren();
            if(i == item.length() - 1)
                curr.setWord(true);
        }
    }
    
    public void delete(String item) {
        TrieNode[] kids = root.getChildren();
        TrieNode curr = null;
        StackX<TrieNode[]> word = new StackX<>();
        for (int i = 0; i < item.length(); i++) {
            char c = item.charAt(i);
            if(kids[c - 'a'] == null)
                return;
            curr = kids[c - 'a'];
            word.push(kids);
            kids = curr.getChildren();
            if(i == item.length() - 1){
                if(!curr.isWord())
                    return;
                else
                    curr.setWord(false);
            }
        }

        for (int i = item.length() - 1; i >= 0; i--) {
            char c = item.charAt(i);
            kids = word.pop();
            curr = kids[c - 'a'];
            if(curr.isWord() || curr.getCount() > 0)
                return;
            else
                kids[c - 'a'] = null;
        }
    }
    
    public ArrayListX<String> find(String partial) {
        ArrayListX<String> words = new ArrayListX<>();
        TrieNode[] kids = root.getChildren();
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
        search(words,sb,curr);
        return words;
    }

    private void search(ArrayListX<String> words, StringBuilder sb, TrieNode curr){
        if(curr.isWord())
            words.append(sb.toString());

        TrieNode[] kids = curr.getChildren();
        for (int i = 0; i < kids.length; i++) {

            if(kids[i] != null){
                curr = kids[i];
                sb.append(curr.getChar());
                search(words,sb,curr);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public ArrayListX<String> printAll(){
        ArrayListX<String> words = new ArrayListX<>();
        StringBuilder sb = new StringBuilder();
        TrieNode curr = root;
        search(words,sb,curr);
        return words;
    }
}
