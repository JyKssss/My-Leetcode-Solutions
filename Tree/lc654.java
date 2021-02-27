package Tree;

import javax.xml.soap.Node;

public class lc654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return generate(0, nums.length-1, nums);
    }

    public TreeNode generate(int l ,int r, int[] nums){
        if (l>r){
            return null;
        }
        else {
            int maxIndex=findMax(l, r, nums);
            TreeNode leftNode=generate(l, maxIndex-1, nums);
            TreeNode rightNode=generate(maxIndex+1, r, nums);
            TreeNode node=new TreeNode(nums[maxIndex],leftNode, rightNode);
            return node;
        }

    }

    public int findMax(int l ,int r, int[] nums){
        int max=-1,index=0;
        for (int i = l; i <=r ; i++) {
            if (nums[i]>max){
                max=nums[i];
                index=i;
            }
        }
        return index;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
