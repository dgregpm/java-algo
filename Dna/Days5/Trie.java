import utils.TrieNode;
import utils.ArrayListX;
import utils.StackX;
import java.util.Arrays;

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
            curr = kids[c - 'a'];
            if(curr == null){
                curr = new TrieNode(c);
                kids[c - 'a'] = curr;
            }
            kids = curr.getChildren();
            if(i == item.length() - 1)
                curr.setWord(true);
        }
    }
    
    public void delete(String item) {
        StackX<Character> nodes = new StackX<>();
        StackX<TrieNode[]> children = new StackX<>();

        TrieNode curr = null;
        TrieNode[] kids = root.getChildren();
        for (int i = 0; i < item.length(); i++) {
            char c = item.charAt(i);
            curr = kids[c - 'a'];
            if(curr == null)
                return;
            nodes.push(c);
            children.push(kids);
            kids = curr.getChildren();
            if(i == item.length() - 1)
                curr.setWord(false);
        }

        while(nodes.size() > 0){
            char c = nodes.pop();
            kids = children.pop();
            curr = kids[c - 'a'];
           
            if(curr.getChildCount() == 0 && !curr.isWord()){
                System.out.println("About to delete: " + kids[c - 'a']);
                kids[c - 'a'] = null;
            } else
                break;
        }
    }
    
    public ArrayListX<String> find(String partial) {
        ArrayListX<String> path = new ArrayListX<>();
        TrieNode[] kids = root.getChildren();
        TrieNode curr = new TrieNode(' ');
        for (int i = 0; i < partial.length(); i++) {
           char c = partial.charAt(i);
           curr = kids[c - 'a'];
           if(curr == null)  
               return path;
           kids = curr.getChildren(); 
        }
        StringBuilder sb = new StringBuilder(partial);
        search(curr,sb,path);
        return path;
    }

    public ArrayListX<String> printAll(){
        ArrayListX<String> path = new ArrayListX<>();
        StringBuilder sb = new StringBuilder();
        search(root,sb,path);
        return path;
    }

    private void search(TrieNode curr, StringBuilder word, ArrayListX<String> path){
        if(curr.isWord())
            path.append(word.toString());

        TrieNode[] kids = curr.getChildren();
        for (int i = 0; i < kids.length; i++) {
            if(kids[i] != null){
                curr = kids[i];
                char c = curr.getChar();
                word.append(c);
                search(curr,word,path);
                word.deleteCharAt(word.length() - 1);
            }
        }
    }
}


