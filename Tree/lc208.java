package Tree;

public class lc208 {
    class Trie {
        TrieNode root;

        private class TrieNode{
            TrieNode[] nodeList;
            boolean isEnd;

            public TrieNode() {
                this.nodeList = new TrieNode[26];
                this.isEnd = false;
            }

            public TrieNode[] getNodeList() {
                return nodeList;
            }

            public boolean isEnd() {
                return isEnd;
            }

            public void setEnd(boolean end) {
                isEnd = end;
            }
        }
        public Trie() {
            this.root=new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode curNode=root;
            for (int i = 0; i < word.length(); i++) {
                TrieNode[] childsList=curNode.getNodeList();
                char cur=word.charAt(i);
                if (childsList[cur-'a']!=null){
                    curNode=childsList[cur-'a'];
                }
                else {
                    childsList[cur-'a']=new TrieNode();
                    curNode=childsList[cur-'a'];
                }
            }
            curNode.setEnd(true);
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode curNode=root;
            for (int i = 0; i < word.length(); i++) {
                TrieNode[] childsList=curNode.getNodeList();
                char cur=word.charAt(i);
                if (childsList[cur-'a']!=null){
                    curNode=childsList[cur-'a'];
                }
                else {
                    return false;
                }
            }
            return curNode.isEnd();
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode curNode=root;
            for (int i = 0; i < prefix.length(); i++) {
                TrieNode[] childsList=curNode.getNodeList();
                char cur=prefix.charAt(i);
                if (childsList[cur-'a']!=null){
                    curNode=childsList[cur-'a'];
                }
                else {
                    return false;
                }
            }
            return true;
        }
    }
}
