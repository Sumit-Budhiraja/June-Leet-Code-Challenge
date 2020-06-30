public class Solution {
class TrieNode {
    // Initialize your data structure here.
    TrieNode[] children = new TrieNode[26];
    String word = "";
    public TrieNode() {

    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode node = root;
        for(char ch : word.toCharArray()){
            if(node.children[ch - 'a'] == null){
                node.children[ch-'a'] = new TrieNode();
            }   
            node = node.children[ch - 'a'];
        }

        node.word = word;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = root;
        for(char ch : word.toCharArray()){
            if(node.children[ch - 'a'] == null) return false;
            node = node.children[ch - 'a'];
        }
        return node.word.equals(word);
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(char ch : prefix.toCharArray()){
            if(node.children[ch - 'a'] == null) return false;
            node = node.children[ch - 'a'];
        }
        return true;
    }
}

    private Trie dict = new Trie();
    private Set<String> res = new HashSet<>();
    public List<String> findWords(char[][] board, String[] words) {
        if(board == null || board.length == 0 || board[0].length == 0) return new ArrayList<String>(res);
        for(String s : words){
            dict.insert(s);
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i =0 ; i< board.length; i++){
            for(int j =0; j< board[0].length; j++){
                dfs(board, visited, i, j, "");
            }
        }

        return new ArrayList<String>(res);
    }

    private void dfs(char[][] board, boolean[][] visited, int x, int y, String current){
        if(x < 0 || y < 0 || x >= board.length || y >= board[0].length || visited[x][y]) return;

        current += board[x][y];
        if(!dict.startsWith(current)) return;
        if(dict.search(current)){
            res.add(current);
        }
        visited[x][y] = true;

        dfs(board, visited, x+1, y, current);
        dfs(board, visited, x-1, y, current);
        dfs(board, visited, x, y+1, current);
        dfs(board, visited, x, y-1, current);

        visited[x][y] = false;
    }

}