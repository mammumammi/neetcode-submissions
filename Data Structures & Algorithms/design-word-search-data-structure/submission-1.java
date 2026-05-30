class WordDictionary {
    private class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isEndofWord = false;
    }
    private TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode current = root;

        for (int i =0;i<word.length();i++){
            char ch = word.charAt(i);
            int index = ch - 'a';

            if (current.children[index] == null) current.children[index] = new TrieNode();

            current = current.children[index];
        }

        current.isEndofWord = true;
    }

    public boolean search(String word) {
        return dfs(word,0,root);
    }

    private boolean dfs(String word,int index,TrieNode current){
        if (index == word.length()) return current.isEndofWord;

        char ch = word.charAt(index);

        if (ch == '.'){
            for (int i =0;i<26;i++){
                if (current.children[i]!=null && dfs(word,index + 1,current.children[i]))
                return true;
            }
            return false;
        }
        else {
            int cIndex = ch - 'a';
            if (current.children[cIndex] == null) return false;

            return dfs(word,index + 1,current.children[cIndex]);
        }
    }
}
