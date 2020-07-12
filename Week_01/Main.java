import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
      int [] nums = new int[]{2, 7, 11, 15};
      Solution solution = new Solution();
      int[] ints = solution.twoSum(nums, 9);
      printArray(ints);
      System.out.println();
      nums = new int[]{1,2,3,4,5,6,7};
      int k = 3;
      solution.rotate(nums,k);
      printArray(nums);
      System.out.println();
      nums = new int[]{1,1,2};
      int len = solution.removeDuplicates(nums);
      System.out.print(len);
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
        public int removeDuplicates(int[] nums) {
            if(nums.length == 0) return 0;
            int i = 0;
            for (int j=1;j < nums.length;j++) {
                if(nums[i] != nums[j]) {
                    i++;
                    nums[i] = nums[j];
                }


            }
            return i + 1;
        }


        //旋转数组学习笔记
        public void rotate(int[] nums, int k) {
            k = k % nums.length;
            int count = 0;
            for(int start = 0 ; count  < nums.length; start++){
                int current = start;
                int prev = nums[start];
                do{
                    int next = (current + k) % nums.length;
                    int temp = nums[next];
                    nums[next] = prev;
                    prev = temp;
                    current = next;
                    count++;
                }while(start != current);
            }
        }

        //两数之和学习笔记
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();

            for(int i = 0; i < nums.length; i++){
                map.put(nums[i],i);
            }
            for(int i = 0; i < nums.length ;i++){
                int complement = target - nums[i];
                if(map.containsKey(complement) && map.get(complement) != i){
                    return new int[]{i,map.get(complement)};
                }
            }
            throw new IllegalArgumentException("No two sum solution");

        }


    }
}
