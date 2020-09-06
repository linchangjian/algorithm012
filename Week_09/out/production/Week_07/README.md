
## 实现 Trie (前缀树)


```
   public class Trie {
   
       private boolean isEnd;
       private Trie[] next;
   
       public Trie(){
           isEnd = false;
           next = new Trie[26];
       }
   
       public void insert(String word) {
           if (word == null || word.length() == 0)
               return;
           Trie curr = this;
           char[] words = word.toCharArray();
           for (int i = 0 ; i < words.length; i++){
               int n = words[i] - 'a';
               if (curr.next[n] == null) curr.next[n] = new Trie();
               curr = curr.next[n];
           }
           curr.isEnd = true;
       }
   
       public boolean search(String word){
           Trie node = searchPrefix(word);
           return node != null && node.isEnd;
       }
       public boolean startsWith(String prefix){
           Trie node = searchPrefix(prefix);
           return node != null;
       }
   
       private Trie searchPrefix(String word) {
           Trie node = this;
           char[] words = word.toCharArray();
           for (int i = 0 ; i < words.length ; i++){
               node = node.next[words[i] - 'a'];
               if(node == null) return null;
           }
           return node;
       }
   }

```

## 


```


```

## 本周总结

复习：二叉树DFS、BFS，二叉搜索树之前中后序遍历
Trie 树 基本特性：
1，节点本身不存完整单词

2，从根节点到某一节点，路径上经过的自字符连接起来，为该节点对应的字符串

3，每个节点的所有子节点路径都代表的字符不同

 

