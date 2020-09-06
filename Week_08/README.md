
## 1122. 数组的相对排序


```
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

```



## 231. 2的幂
```
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

```

## 本周总结

 - 字符串的操作经常会在工作中用到，需要多做多练
