class Solution {
    public class TrieNode{
            boolean isEnd;
            TrieNode[] children;
            String word;

            public TrieNode(){
                isEnd = false;
                children = new TrieNode[26];
            }

            void addWord(String word){
                TrieNode current = this;
                for (int i = 0;i<word.length();i++){
                    char ch = word.charAt(i);
                    if (current.children[ch - 'a'] != null){
                        current = current.children[ch-'a'];
                        continue;
                    }
                    current.children[ch-'a'] = new TrieNode();
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
        for (String word: words){
            trie.addWord(word);
        }
        for (int i = 0;i<row;i++){
            for (int j = 0;j<col;j++){
                dfs(i,j,board,trie,res);
            }
        }

        return res;
    }

    public void dfs(int i,int j,char[][] board,TrieNode current,List<String> res){
        if (i < 0 || i >= board.length || j <0 || j >= board[0].length)
            return;
        char ch = board[i][j];
        if (ch == '#' || current.children[ch -'a'] == null) return;
        if (current.children[ch -'a'] != null){
            current = current.children[ch -'a'];
        }
        else return;

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
