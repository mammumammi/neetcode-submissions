class Solution {
    private class TrieNode{
        TrieNode[] children = new TrieNode[26];
        String word = null;
    }
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode root = buildTrie(words);

        int row = board.length;
        int col = board[0].length;

        for (int r =0;r<row;r++){
            for (int c = 0;c<col;c++){
                dfs(r,c,board,root,result);
            }
        }
        return result;
    }

    private void dfs(int r,int c,char[][] board,TrieNode current,List<String> result){
        if (r<0 || r>=board.length || c<0 || c>=board[0].length) return;

        char ch = board[r][c];

        if (ch == '#' || current.children[ch - 'a'] == null) return;

        current = current.children[ch - 'a'];
        if (current.word != null){
            result.add(current.word);
            current.word = null;
        }

        board[r][c] = '#';

        dfs(r+1,c,board,current,result);
        dfs(r-1,c,board,current,result);
        dfs(r,c+1,board,current,result);
        dfs(r,c-1,board,current,result);

        board[r][c] = ch;


    }

    private TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        for (String w:words){
            TrieNode current = root;
            for(int i =0;i<w.length();i++){
                int index = w.charAt(i) - 'a';
                if (current.children[index] == null ){
                    current.children[index] = new TrieNode();
                }
                current = current.children[index];
            }
            current.word = w;
        }
        return root;
    }
}
