## 丑数最快解题思路

错误记录：for (int i = 0; i < n; i++) 角标初识值获取错误记录，这里要小心
快速理解题目：这个题目快速理解的核心就是要计算的值跟前面的值有关系，只是这些值的规律就是跟2、3、5有关系，什么质因子就是新的概念，这个如果不理解也不影响解题。
五毒神掌：题目不理解也没关系，可以直接上代码，一遍代码后题目就完全理解了，然后先抄一遍，接着自己来一遍，规律就掌握了
解题步骤：
1，初始化三个指针
2，初始化需要的组数，这里长度是可以设置的，因为是确定的大小就可以解题，减少空间使用
3，数组的第一个值要初始化为1，这样就有了一个循环启动值
4，开始写for循环，for循环是要从第二个数开始算的，因为第一个值是确定的了，所以 int = 1 （这个知识点是可以复用的，一些题目的初始值都是知道的，这个条件要利用起来）
5，开始编写状态方程，也就是能推算出第二个值的方法，就是：int n2 = dp[a] * 2 , n3 = dp[b] * 3, n5 = dp[c] * 5 ，规律很强的，动手写一遍就知道了。
6，开始对比计算出来的值，取三个里面最小的一个
7，判断取到的是a b c指针中那个的值，这个值需要++；
8，返回数组中第n-1个值，因为循环就是在这里结束的，这个没什么好说



```
class Solution {
   public int nthUglyNumber(int n){
            //这里有一个1690的判断，题目里面有的限制
           int a = 0,b = 0 ,c = 0;
           int [] dp = new int[n];
           dp[0] = 1;
           for (int i = 1; i < n; i++){
               int n2 = dp[a] * 2 , n3 = dp[b] * 3, n5 = dp[c] * 5;
               dp[i] = Math.min(Math.min(n2,n3),n5);
               if (dp[i] == n2) a++;
               if (dp[i] == n3) b++;
               if (dp[i] == n5) c++;
           }
           return dp[n - 1];
       }
}


```

## 前 K 个高频元素学习笔记
解题思路
解题步骤：
1，定义hashmap count，用于统计每个数的数量；数（key）：数量（value）
2，定义一个优先队列当堆用，大数在堆顶
3，持续取出count中的key存到堆中，同时判断k值控制size
4，最后倒序存到结果数组中，结束返回

复用抽取：
1，hashmap获取值对应的个数
2，优先队列当堆用

自问自答：
1，为什么要用堆？
堆的特性：
2，为什么不能直接用堆输出有序的最终结果？

```
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
            HashMap<Integer,Integer> count = new HashMap<>();
            for (int n : nums){
                count.put(n, count.getOrDefault(n,0) + 1);
            }
            PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1 ,n2)-> count.get(n1) - count.get(n2));

            for (int n : count.keySet()){
                heap.add(n);
                if (heap.size() > k){
                    heap.poll();
                }
            }
            int [] result = new int[heap.size()];
            int i = heap.size() - 1;

            while (!heap.isEmpty()){
                result[i] = heap.poll();
                i--;
            }

            return result;

        }
}


```

## 本周总结

解题技巧：升维度，一维数组解决不了的问题，可以考虑二维空间  ，二维不行三维

加深理解：

1，图是特殊的树

2，树映射生活场景，生活中面临很多种选择，每一个都是岔路口，或则是很多事情的解决方案其实
也是一种数，都是可以产生划分的，还有就是阶层、层级等。这说明数据结构都是可以映射到生活中各种各种的使用场景





