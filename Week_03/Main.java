import java.util.*;

public class Main {

    public static void main(String[] args) {

        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode4 = new TreeNode(4);;

        TreeNode treeNode0 = new TreeNode(0);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode2 = new TreeNode(2);
        treeNode2.left = treeNode7;
        treeNode2.right = treeNode4;
        TreeNode treeNode5 = new TreeNode(5);
        treeNode5.right = treeNode6;
        treeNode5.left = treeNode2;
        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.left = treeNode0;
        treeNode1.right = treeNode8;
        TreeNode treeNode3 = new TreeNode(3);
        treeNode3.left = treeNode5;
        treeNode3.right = treeNode1;

        TreeNode treeNode = new Solution().lowestCommonAncestor(treeNode3, treeNode5, treeNode1);
        System.out.println(treeNode.val + " " + treeNode.left.val +" "+treeNode.right.val);
        treeNode = new Solution().lowestCommonAncestor(treeNode3, treeNode5, treeNode4);
        System.out.println(treeNode.val + " " + treeNode.left.val +" "+treeNode.right.val);
        treeNode = new Solution().lowestCommonAncestor(treeNode3, treeNode8, treeNode0);
        System.out.println(treeNode.val + " " + treeNode.left.val +" "+treeNode.right.val);

        int [] arrays = new int[]{1,2,3};
        List<List<Integer>> permute = new Solution().permute(arrays);
        System.out.println(permute);
    }

    public static void printArray(int[] nums){
        if (nums == null){
            throw new NullPointerException("nums is null");
        }
        System.out.print("[");
        int index = 0;
        for (int num : nums) {
            index++;
            if (index == nums.length){
                System.out.print(num+"]");
            }else {
                System.out.print(num+",");
            }
        }
    }
  public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    //删除排序中的重复项
    static class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new LinkedList<>();

            List<Integer> output = new ArrayList<Integer>();
            for (int num : nums){
                output.add(num);
            }
            int n = nums.length;
            backtrack(n, output, res, 0);
            return res;

        }

        private void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
            if (first == n){
                res.add(new ArrayList<Integer>(output));
            }
            for (int i = first ; i < n; i++){
                Collections.swap(output,first,i);
                backtrack(n, output, res, first + 1);
                Collections.swap(output,first,i);
            }

        }

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {
                return null;
            }
            //要找的对象
            if(root == p || root == q){
                return root;
            }

            TreeNode left = lowestCommonAncestor(root.left, p , q);
            TreeNode right = lowestCommonAncestor(root.right,p , q);
            if (left != null && right != null){
                //p q 一个在左边、一个在右边
                return root;
            }
            if (left != null){
                //p q 都在左边
                return left;
            }
            if (right != null){
                //p q 都在右边
                return right;

            }
            return null;
        }

    }
}
