package SystemDesign;

public class lc208 {
}
class Trie {
    TreeNode root;
    /** Initialize your data structure here. */
    public Trie() {
        this.root=new TreeNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TreeNode curNode=root;
        for (int i = 0; i < word.length(); i++) {
            char cur=word.charAt(i);
            if (curNode.containsChar(cur)){
                curNode=curNode.getNode(cur);
            }
            else {
                curNode.insertChar(cur, new TreeNode());
                curNode=curNode.getNode(cur);
            }
            if (i==word.length()-1){
                curNode.setEnd(true);
            }
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TreeNode curNode=root;
        for (int i = 0; i < word.length(); i++) {
            char cur=word.charAt(i);
            if (curNode.containsChar(cur)){
                curNode=curNode.getNode(cur);
            }
            else return false;
        }

        return curNode.getEnd();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TreeNode curNode=root;
        for (int i = 0; i < prefix.length(); i++) {
            char cur=prefix.charAt(i);
            if (curNode.containsChar(cur)){
                curNode=curNode.getNode(cur);
            }
            else return false;
        }

        return true;
    }


}
class TreeNode{
    private boolean isEnd;
    private TreeNode[] links;

    public TreeNode() {
        this.links=new TreeNode[26];
        isEnd=false;
    }
    public void setEnd(boolean end) {
        isEnd = end;
    }
    public boolean getEnd(){
        return isEnd;
    }
    public void insertChar(char a , TreeNode node){
        links[a-'a']=node;
    }
    public boolean containsChar(char a){
        return links[a-'a']!=null;
    }
    public TreeNode getNode(char a){
        return links[a-'a'];
    }
}