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
        public int[] relativeSortArray(int[] arr1, int[] arr2) {

            int[] temp = new int[1001];
            for (int i : arr1) {
                temp[i]++;
            }
            int index = 0;

            for (int i : arr2) {
                while (temp[i]>0){
                    arr1[index++]=i;
                    temp[i]--;
                }
            }

            for (int i = 0; i < temp.length; i++) {
                while (temp[i]>0){
                    arr1[index++] = i;
                    temp[i]--;
                }
            }

            return arr1;
        }

        public boolean isPowerOfTwo(int n) {
            if (n == 0) return false;
            while (n % 2 == 0) n /= 2;
            return n == 1;
        }



    }


}
