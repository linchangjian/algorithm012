
## 1122. 数组的相对排序


```
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

```



## 231. 2的幂
```
  public boolean isPowerOfTwo(int n) {
            if (n == 0) return false;
            while (n % 2 == 0) n /= 2;
            return n == 1;
        }


```

## 本周总结

 - 位运算的核心是可以优化很多计算机的运行性能，学会是必要的，熟练也是必要的
 - 本周练习比较少，后期需补课，持续五毒，才是王道
