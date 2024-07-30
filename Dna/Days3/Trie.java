import utils.TrieNode;
import utils.ArrayListX;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String item) {
        
        TrieNode[] kids = root.children;
        TrieNode curr;
        for (int i = 0; i < item.length(); i++) {
            char c = item.charAt(i);
           // System.out.println((c - 'a'));
            if(kids[c - 'a'] != null){
                curr = kids[c - 'a'];
            } else {
                curr = new TrieNode(c);
                kids[c - 'a'] = curr;
            }

            kids = curr.children;
            if(i == item.length() - 1)
                curr.setIsWord(true);
        }
    }
    
    public void delete(String item) {
        
    }
    
    public ArrayListX<String> find(String partial) {
        ArrayListX<String> result = new ArrayListX<>();
        TrieNode[] kids = root.children;
        TrieNode curr;
        StringBuilder sb = new StringBuilder(partial);
        for (int i = 0; i < partial.length(); i++) {
            char c = partial.charAt(i);
            if(kids[c - 'a'] != null){
                curr = kids[c - 'a'];
            } else
                return result;
            kids = curr.children;
            if(i == partial.length() - 1)
                walk(result,curr,sb);
        }
        return result;
    }

    private void walk(ArrayListX<String> result, TrieNode curr, StringBuilder sb){
        if(curr.isWord()){
            result.append(sb.toString());
        }
                    

        TrieNode[] kids = curr.children;
        TrieNode node;
        for (int i = 0; i < kids.length; i++) {
            if(kids[i] != null){
                node = kids[i];
                sb.append(node.getChar());

                //System.out.println("Node c: " + node.getChar() + ", SB: " + sb.toString());
                walk(result,node,sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        //System.out.println(sb.toString());
    }
}
