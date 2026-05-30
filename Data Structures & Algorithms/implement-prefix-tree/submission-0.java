class PrefixTree {
    private class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isEndofWord = false;
    }
    private TrieNode root;
    public PrefixTree() {
         root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;

        for (int i =0;i<word.length();i++){
            char ch = word.charAt(i);
            int index = ch - 'a';

            if (current.children[index] == null)
            current.children[index] = new TrieNode();

            current = current.children[index];
        }

        current.isEndofWord = true;
    }

    public boolean search(String word) {
        TrieNode current = root;

        for (int i =0;i<word.length();i++){
            char ch = word.charAt(i);
            int index = ch - 'a';

            if (current.children[index] == null){
                return false;
            }
            current = current.children[index];
        }
        return current.isEndofWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (int i =0;i<prefix.length();i++){
            char ch = prefix.charAt(i);
            int index = ch - 'a';

            if (current.children[index] == null){
                return false;
            }

            current = current.children[index]; 
        }
        return true;
    }
}
