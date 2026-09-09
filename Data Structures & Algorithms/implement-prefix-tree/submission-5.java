class PrefixTree {
    boolean isEnd;
    String word;
    PrefixTree[] children;
    public PrefixTree() {
        this.isEnd = false;
        this.children = new PrefixTree[26];
    }

    public void insert(String word) {
        PrefixTree curr = this;
        for (int i = 0;i<word.length();i++){
            char ch = word.charAt(i);

            if (curr.children[ch - 'a'] == null){
                curr.children[ch - 'a'] = new PrefixTree();
            }
            curr = curr.children[ch-'a'];
        }
        curr.word = word;
        curr.isEnd = true;
    }

    public boolean search(String word) {
        PrefixTree curr = this;

        for (int i = 0;i<word.length();i++){
            char ch = word.charAt(i);

            if (curr.children[ch-'a'] == null) return false;
            else{
                curr = curr.children[ch - 'a'];
            }
        }
        if (curr.isEnd)
        return true;
        
        return false;
    }

    public boolean startsWith(String prefix) {
        PrefixTree curr = this;

        for (int i = 0;i<prefix.length();i++){
            char ch = prefix.charAt(i);

            if (curr.children[ch - 'a'] == null) return false;
            else curr = curr.children[ch - 'a'];
        }
        return true;
    }
}
