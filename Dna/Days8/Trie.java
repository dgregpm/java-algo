import utils.TrieNode;
import utils.StackX;

public class Trie {
    private TrieNode root;

    public Trie() {
        this.root = new TrieNode(' ');
    }

    public void insert(String item) {
        TrieNode[] kids = root.getChildren();
        TrieNode curr = null;
        for (int i = 0; i < item.length(); i++) {
            char c = item.charAt(i);
            if(kids[c - 'a'] == null){
                curr = new TrieNode(c);
                kids[c - 'a'] = curr;
            } else 
                curr = kids[c - 'a'];
            kids = curr.getChildren();
            if(i == item.length() - 1)
                curr.setIsWord(true);
        }
    }
    
    public void delete(String item) {
        StackX<TrieNode[]> trash = new StackX<>();
        TrieNode[] kids = root.getChildren();
        for (int i = 0; i < item.length(); i++) {
            char c = item.charAt(i);
            if(kids[c - 'a'] == null)
                return;
            trash.push(kids);
            if(i == item.length() - 1)
                kids[c - 'a'].setIsWord(false);
            kids = kids[c - 'a'].getChildren();
        }

        for (int i = item.length() - 1; i >= 0; i--) {
            char c = item.charAt(i);
            kids = trash.pop();
            TrieNode curr = kids[c - 'a'];
            if(curr.isWord() || curr.childrenCount() > 0)
                return;
            kids[c - 'a'] = null;
        }
    }
    
    public StackX<String> find(String partial) {
        StackX<String> words = new StackX<>();
        TrieNode[] kids = this.root.getChildren();
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
        this.search(curr,sb,words);
        return words.reverse();
    }

    public StackX<String> printAll(){
        StackX<String> words = new StackX<>();
        StringBuilder sb = new StringBuilder();
        search(root,sb,words);
        return words.reverse();
    }

    private void search(TrieNode curr, StringBuilder sb, StackX<String> words){
        if(curr.isWord())
            words.push(sb.toString());

        TrieNode[] kids = curr.getChildren();
        for (int i = 0; i < kids.length; i++) {
            if(kids[i] != null){
                sb.append(kids[i].getChar());
                search(kids[i],sb,words);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
