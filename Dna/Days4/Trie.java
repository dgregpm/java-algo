import utils.ArrayListX;
import utils.TrieNode;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode(' ');
    }

    public void insert(String item) {
        TrieNode[] kids = root.getChildren();
        TrieNode node = null;
        for (int i = 0; i < item.length(); i++) {
            char c = item.charAt(i);
            if(kids[c - 'a'] != null)
                node = kids[c - 'a'];
            else{
                node = new TrieNode(c);
                kids[c - 'a'] = node;
            }
            kids = node.getChildren();
            if(i == item.length() - 1)
                node.setIsWord(true);
        }
    }
    
    public void delete(String item) {
        
    }
    
    public ArrayListX<String> find(String partial) {
        TrieNode[] kids = root.getChildren();
        TrieNode node = null;
        for (int i = 0; i < partial.length(); i++) {
            char c = partial.charAt(i);
            if(kids[c - 'a'] == null)
                return null;
            else
                node = kids[c - 'a'];

            kids = node.getChildren();
        }
        StringBuilder sb = new StringBuilder(partial);
        ArrayListX<String> path = new ArrayListX<>();
        walk(node,path,sb);
        return path;
    }

    public void walk(TrieNode curr, ArrayListX<String> path, StringBuilder sb){
        if(curr.getIsWord()){
            path.append(sb.toString());
        }
        TrieNode[] kids = curr.getChildren();
        TrieNode node = null;
        for (int i = 0; i < kids.length; i++) {
            if(kids[i] != null){
                node = kids[i];
                sb.append(node.getChar());
                walk(node,path,sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
