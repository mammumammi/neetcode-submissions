class Solution {
    public class Trie{
        String word;
        Trie[] children;
        boolean isEnd;

        Trie(){
            this.isEnd = false;
            children = new Trie[26];
        }

        void addWord(String word){
            Trie current = this;

            for (int i = 0;i<word.length();i++){
                char ch = word.charAt(i);

                if (current.children[ch -'a'] == null) current.children[ch - 'a'] = new Trie();

                current = current.children[ch - 'a']; 
            }
            current.word = word;
            current.isEnd = true;
        }
    }
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();

        Trie trie = new Trie();

        for (String word: words) trie.addWord(word);

        for (int i = 0;i<board.length;i++){
            for (int j = 0;j<board[0].length;j++){
                dfs(i,j,board,trie,result);
            }
        }

        return result;
    }

    public void dfs(int i,int j,char[][] board,Trie current,List<String> result){
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '#') return;

        char ch = board[i][j];
        
        if (current.children[ch - 'a'] == null){
            return;
        }

        current = current.children[ch - 'a'];
        if (current.isEnd){
            result.add(current.word);
            current.isEnd = false;
        }
        board[i][j] = '#';

        dfs(i+1,j,board,current,result);
        dfs(i-1,j,board,current,result);
        dfs(i,j+1,board,current,result);
        dfs(i,j-1,board,current,result);

        board[i][j] = ch;
    }
}
