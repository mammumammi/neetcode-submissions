class Solution {
    public class TrieNode{
        String word;
        boolean isEnd;
        TrieNode[] children;

        public TrieNode(){
            isEnd = false;
            children = new TrieNode[26];
        }

        void addWord(String word){
            TrieNode current = this;
            for (int i = 0;i<word.length();i++){
                char ch = word.charAt(i);
                if (current.children[ch - 'a'] == null){
                    current.children[ch - 'a'] = new TrieNode();
                }
                current = current.children[ch - 'a'];
            }
            current.isEnd = true;
            current.word = word;
        }
    }
    public List<String> findWords(char[][] board, String[] words) {
        
        int row = board.length;
        int col = board[0].length;
        List<String> res = new ArrayList<>();
        TrieNode trie = new TrieNode();
        
        for (String word:words)
            trie.addWord(word);

        for (int i = 0;i<row;i++){
            for (int j = 0;j<col;j++){
                dfs(i,j,board,trie,res);
            }
        }

        return res;
    }

    public void dfs(int i,int j,char[][] board,TrieNode current,List<String> res){
        if (i < 0 || i>= board.length || j<0 || j>=board[0].length || board[i][j] == '#' ) return;
        char ch = board[i][j];

        if (current.children[ch-'a'] == null) return;
        
        current = current.children[ch - 'a'];
        if (current.isEnd){
            res.add(current.word);
            current.isEnd = false;
        }
        board[i][j] = '#';

        dfs(i+1,j,board,current,res);
        dfs(i-1,j,board,current,res);
        dfs(i,j+1,board,current,res);
        dfs(i,j-1,board,current,res);

        board[i][j] = ch;
    }
}
