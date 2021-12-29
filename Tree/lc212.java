package Tree;

import java.util.ArrayList;
import java.util.List;

public class lc212 {
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        List<String> result = new ArrayList<>();
        boolean[][] visited= new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                findWord(board, visited, trie.root, i, j, board.length, board[0].length, result);
            }
        }
        return result;
    }

    public void findWord(char[][] board, boolean[][] visited, TrieNode node ,int r, int c, int R, int C, List<String> result) {
        if (r < 0 || c < 0 || r >= R || c >= C || visited[r][c]) {
            return;
        }
        if (node.childList[board[r][c] - 'a'] == null) {
            return;
        }
        node = node.childList[board[r][c] - 'a'];
        visited[r][c] = true;
        if (node.isEnd) {
            result.add(node.val);
            node.isEnd = false;
        }
        findWord(board, visited, node, r + 1, c, R, C, result);
        findWord(board, visited, node, r - 1, c, R, C, result);
        findWord(board, visited, node, r, c + 1, R, C, result);
        findWord(board, visited, node, r, c - 1, R, C, result);
        visited[r][c] = false;
    }

    private class Trie {
        TrieNode root;
        public Trie() {
            this.root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode curNode = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (curNode.childList[c - 'a'] == null) {
                    curNode.childList[c - 'a'] = new TrieNode();
                }
                curNode = curNode.childList[c - 'a'];
            }
            curNode.isEnd = true;
            curNode.val = word;
        }
    }

    private class TrieNode {
        String val;
        TrieNode[] childList;
        boolean isEnd;

        public TrieNode() {
            this.childList = new TrieNode[26];
            this.isEnd = false;
        }
    }
}
