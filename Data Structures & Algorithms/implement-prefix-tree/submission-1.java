class PrefixTree {
    PrefixTree[] children;
    boolean endOf;
    public PrefixTree() {
        children = new PrefixTree[26];
        endOf = false;
    }

    public void insert(String word) {
        PrefixTree current = this;

        for (int i = 0;i<word.length();i++){
            char ch = word.charAt(i);

            if (current.children[ch - 'a'] == null){
                current.children[ch - 'a'] = new PrefixTree();
            }

            current = current.children[ch - 'a'];
        }

        current.endOf = true;
    }

    public boolean search(String word) {
        PrefixTree current = this;

        for (int i = 0;i<word.length();i++){
            char ch = word.charAt(i);

            if (current.children[ch - 'a'] == null) return false;

            current = current.children[ch - 'a'];
        }

        if (current.endOf) return true;

        return false;
    }

    public boolean startsWith(String prefix) {
        PrefixTree current = this;

        for (int i = 0;i<prefix.length();i++){
            char ch = prefix.charAt(i);

            if (current.children[ch - 'a'] == null) return false;

            current = current.children[ch - 'a'];
        }

        return true;
    }
}
