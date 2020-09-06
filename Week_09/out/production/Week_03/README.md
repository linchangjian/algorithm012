
## 全排列
开始并没有什么好的思路，只是知道用树的状态来打通思路，递归中再通过循环的嵌套的方式枚举出来各类状态是眼前一亮的点，以后涉及到类似的树状态题目，代码应该大致类似，这次的解题主要还是参考官方的解题思路，以学习为主。

```
class Solution {
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
}

```

## 二叉树的最近公共祖先
解题思路
此处撰写解题思路

递归思想：找到最小可重复的部分；
递归模板：
1，设置递归终止条件（终结）
2，递归进入的参数以及返回参数的确认（处理当前层逻辑）
3，下探下一层
4，清理当前层

```
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
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


```

## 本周总结

递归思想：找到最小可重复的部分；

递归模板：
1，设置递归终止条件（终结）
2，递归进入的参数以及返回参数的确认（处理当前层逻辑）
3，下探下一层
4，清理当前层

全排列题目感悟:
递归主要的技巧就是找到可重复的子模块，这类功能是可以重复利用的，这个没有什么好说的，递归就是理解以后多练，就慢慢能理解到
参数的传递是怎么通过一层层返回的，最终获取到自己的结果，说白了，也是一个依赖关系，每一个可以重复的子模块都是有依赖关系的，
这样才能建立层层递归，也就是盗梦空间的每层都带去和带回不同的结果，最终演变到我们想要的结果。

全排列题目代码抒写眼前一亮：
看来一些跟树相关的状态题目，应该都是递归加一些循环找出各种状态的，换句话说，其实就看是几个维度的数据，维度越多，循环的嵌套就越多，
那么递归其实也是循环的一种，那就有可能是递归中还有递归，以后看到这类代码，估计就能看出个大概了，这个就是练习题的魅力呀，开拓视野
