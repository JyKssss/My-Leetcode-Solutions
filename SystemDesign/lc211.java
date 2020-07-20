package SystemDesign;

public class lc211 {
}
class WordDictionary {
    TreeNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        this.root=new TreeNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
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
            if (i==word.length()-1)curNode.setEnd(true);
        }
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        TreeNode curNode=root;
        return searchHelper(word, 0, curNode);
    }

    public boolean searchHelper(String word, int index, TreeNode curNode){
        boolean exist=false;
        char cur=word.charAt(index);
        if (index==word.length()-1){
            if (cur!='.'){
                return curNode.containsChar(cur)&&curNode.getNode(cur).getEnd();
            }
            else {
                for (int i = 0; i < curNode.links.length; i++) {
                    if (curNode.links[i]!=null && curNode.links[i].getEnd()){
                        return true;
                    }
                }
                return false;
            }
        }


        if (cur!='.'){
            if (curNode.containsChar(cur)){
                exist=searchHelper(word, index+1, curNode.getNode(cur));
            }
            else exist=false;
        }
        else {
            for (int i = 0; i < curNode.links.length; i++) {
                if (curNode.links[i]!=null && searchHelper(word, index+1, curNode.links[i])){
                    exist=true;
                }
            }
        }
        return exist;
    }

    private class TreeNode{
        private boolean isEnd;
        TreeNode[] links;

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
}

