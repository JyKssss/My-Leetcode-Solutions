package Tree;

import java.util.*;

public class lc538 {
    public TreeNode convertBST(TreeNode root) {
        HashSet<Integer>set=new HashSet<>();
        HashMap<Integer,Integer>map=new HashMap<>();
        List<Integer>nums=new ArrayList<>();
        dfs(set, root);
        for(Integer n:set)nums.add(n);
        Collections.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        int sum=0;
        for(Integer n: nums){
            sum+=n;
            map.put(n, sum);
        }
        dfs(map, root);
        return root;
    }
    public void dfs(HashSet<Integer>set,TreeNode node){
        if (node!=null){
            set.add(node.val);
            dfs(set,node.left);
            dfs(set,node.right);
        }
        else return;
    }

    public void dfs(HashMap<Integer,Integer>map,TreeNode node){
        if (node!=null){
            node.val=map.get(node.val);
            dfs(map, node.left);
            dfs(map, node.right);
        }
        else return;
    }

    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }

    int sum=0;
    public TreeNode convertBST2(TreeNode root) {

        if (root!=null){
            convertBST2(root.right);
            sum+=root.val;
            root.val=sum;
            convertBST2(root.left);
        }
        return root;
    }
}
