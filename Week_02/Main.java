import java.util.*;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.nthUglyNumber(10);
        System.out.println(i);

        int [] nums = new int[]{1,1,1,2,2,3};
        int k = 2;
        int [] result = solution.topKFrequent(nums, k);
        printArray(result);
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

    //删除排序中的重复项
    static class Solution {
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
}
