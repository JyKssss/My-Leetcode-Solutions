package Tree;

import java.util.List;
import java.util.TreeSet;

public class lc648 {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (String word : dictionary) {
            trie.insert(word);
        }
        StringBuilder stringBuilder = new StringBuilder();
        String[] words = sentence.split(" ");
        for (String word : words) {
            String root = trie.findRoot(word);
            stringBuilder.append(root);
            stringBuilder.append(" ");
        }
        String res = stringBuilder.toString().trim();
        return res;
    }

    class Trie {
        Node root;

        public Trie() {
            this.root = new Node();
        }

        public void insert(String word) {
            Node curNode = root;
            for (int i = 0; i < word.length(); i++) {
                char curChar = word.charAt(i);
                if (curNode.getChild(curChar) == null) {
                    curNode.children[curChar - 'a'] = new Node();
                }
                curNode = curNode.getChild(curChar);
            }
            curNode.isEnd = true;
        }

        public String findRoot(String word) {
            Node curNode = root;
            for (int i = 0; i < word.length(); i++) {
                char curChar = word.charAt(i);
                curNode = curNode.getChild(curChar);
                if (curNode == null) {
                    return word;
                } else if (curNode.isEnd) {
                    return word.substring(0, i + 1);
                }
            }
            return word;
        }
    }

    class Node {
        boolean isEnd;
        Node[] children;

        public Node() {
            this.children = new Node[26];
        }

        public Node getChild(char key) {
            return children[key - 'a'];
        }
    }

    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        List[] a = new List[2];
    }
}
