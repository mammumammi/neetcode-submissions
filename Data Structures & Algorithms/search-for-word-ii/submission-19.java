class Solution {
    class Trie{
        boolean isEnd;
        String word;
        Trie[] children;

        public Trie(){
            isEnd = false;
            children = new Trie[26];
        }

        public void addWord(String word){
            Trie current = this;

            for (int i = 0;i<word.length();i++){
                char ch = word.charAt(i);

                if (current.children[ch - 'a'] == null)
                    current.children[ch - 'a'] = new Trie();

                current = current.children[ch - 'a'];
            }
            current.isEnd = true;
            current.word = word;
        }
    }
    List<String> result = new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
        
        Trie trie = new Trie();

        for (String word:words)
            trie.addWord(word);

        
        for (int i = 0;i<board.length;i++){
            for (int j = 0;j<board[0].length;j++){
                dfs(i,j,board,trie);
            }
        }

        return result;

    }

    private void dfs(int i,int j,char[][] board,Trie current){
        if (i < 0 || i >= board.length || j < 0 || j >=board[0].length || board[i][j] == '#'){
            return;
        }
        //base conditions
        char ch = board[i][j];

        if (current.children[ch - 'a'] == null) return;

        current = current.children[ch - 'a'];
        if (current.isEnd){
            result.add(current.word);
            current.isEnd = false;
        }
        board[i][j] = '#';

        dfs(i+1,j,board,current);
        dfs(i-1,j,board,current);
        dfs(i,j+1,board,current);
        dfs(i,j-1,board,current);

        board[i][j] = ch;
    }

}
