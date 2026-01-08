package utils;

public class Trie {
    private TrieNode root;
    private int count;
    
    public Trie() {
        root = new TrieNode(' ');
    }

    public void insert(String item) {
        TrieNode curr = root;
        HashMapX<Character,TrieNode> kids = root.getChildren();
        for (int i = 0; i < item.length(); i++) {
            char c = item.charAt(i);
            if(kids.get(c) == null){
                curr = new TrieNode(c);
                kids.set(c,curr);
            } else {
                curr = kids.get(c);
            }
            kids = curr.getChildren();
            if(i == item.length() - 1)
                curr.setIsWord(true);
        }
        this.count++;
    }
    
    public void delete(String item) {
        StackX<HashMapX<Character,TrieNode>> nodes = new StackX<>();
        TrieNode curr = root;
        HashMapX<Character,TrieNode> kids = root.getChildren();
        for (int i = 0; i < item.length(); i++) {
            char c = item.charAt(i);
            curr = kids.get(c);
            if(curr == null)
                return;
            nodes.push(kids);
            kids = curr.getChildren();
            if(i == item.length() - 1){
                if(curr.isWord()){
                    curr.setIsWord(false);
                    count--;
                }
            }
        }
        for (int i = item.length() - 1; i >= 0; i--) {
            char c = item.charAt(i);
            kids = nodes.pop();
            curr = kids.get(c);
            if(!curr.isWord() && !curr.hasChildren()){
                kids.delete(c);
            } else {
                return;
            }
        }
    }

    @Override
    public String toString(){
        return this.find("").toString();
    }

    public int wordCount(){
        return this.count;
    }
    
    public ArrayListX<String> find(String partial) {
        ArrayListX<String> words = new ArrayListX<>();
        TrieNode curr = root;
        HashMapX<Character,TrieNode> kids = root.getChildren();
        for (int i = 0; i < partial.length(); i++) {
            char c = partial.charAt(i);
            curr = kids.get(c);
            if(curr == null)
                return words;
            kids = curr.getChildren();
        }
        StringBuilder sb = new StringBuilder(partial);
        walk(curr,sb,words);
        return words;        
    }

    private void walk(TrieNode curr, StringBuilder sb, ArrayListX<String> words){
        if(curr.isWord())
            words.add(sb.toString());

        HashMapX<Character,TrieNode> kids = curr.getChildren();
        Object[] letters = kids.keys();
        for (int i = 0; i < letters.length; i++) {
            Character c = (Character)letters[i];
            curr = kids.get(c);

            sb.append(curr.getChar());
            walk(curr,sb,words);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
