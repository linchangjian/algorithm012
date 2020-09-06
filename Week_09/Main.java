import java.util.*;

public class Main {

    public static void main(String[] args) {


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



    class Solution {

        public int firstUniqChar(String s) {
            HashMap<Character, Integer> count = new HashMap<Character, Integer>();
            int n = s.length();
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                count.put(c, count.getOrDefault(c, 0) + 1);
            }

            // find the index
            for (int i = 0; i < n; i++) {
                if (count.get(s.charAt(i)) == 1)
                    return i;
            }
            return -1;
        }


        public String reverseStr(String s, int k) {
            char[] a = s.toCharArray();
            for (int start = 0; start < a.length; start += 2 * k) {
                int i = start, j = Math.min(start + k - 1, a.length - 1);
                while (i < j) {
                    char tmp = a[i];
                    a[i++] = a[j];
                    a[j--] = tmp;
                }
            }
            return new String(a);
        }
    }


}
