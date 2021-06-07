package Math;

public class lc421 {
    Trie root=new Trie();
    int bitUpper=30;

    public int findMaximumXOR(int[] nums) {
        int res=0;
        for (int i = 1; i < nums.length; i++) {
            insert(nums[i-1],root);
            res=Math.max(res, findMax(nums[i], root));
        }
        return res;
    }

    private int findMax(int num, Trie root){
        int res=0,bit;
        Trie node=root;
        for (int i = bitUpper; i >= 0; i--) {
            bit=(num>>i)&1;
            if (bit==0){
                if (node.right1!=null){
                    res=res*2+1;
                    node=node.right1;
                }
                else {
                    res=res*2;
                    node=node.left0;
                }
            }
            else {
                if (node.left0!=null){
                    res=res*2+1;
                    node=node.left0;
                }
                else {
                    res=res*2;
                    node=node.right1;
                }
            }
        }
        return res;
    }

    private void insert(int num, Trie root){
        int bit;
        Trie node=root;
        for (int i = bitUpper; i >= 0; i--) {
            bit=(num >> i)&1;
            if (bit==0){
                if (node.left0==null){
                    node.left0=new Trie();
                }
                node=node.left0;
            }
            else {
                if (node.right1==null){
                    node.right1=new Trie();
                }
                node=node.right1;
            }
        }
    }

    class Trie{
        Trie left0;
        Trie right1;

    }
}
