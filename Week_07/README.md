
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

## 212. 单词搜索 II

Trie 树、回溯结合
```

public class TrieNode {
    HashMap<Character, TrieNode> childen = new HashMap<Character,TrieNode>();
    String word = null;
    public TrieNode(){

    }
}

class Solution {
        char[][] _board = null;
        ArrayList<String> _result = new ArrayList<>();
        public List<String> findWords(char[][] board, String[] words){
            TrieNode root = new TrieNode();
            for(String word : words) {
                TrieNode node = root;
                for (Character letter : word.toCharArray()){

                    if (node.childen.containsKey(letter)){
                        node = node.childen.get(letter);
                    }else {
                        TrieNode newNode = new TrieNode();
                        node.childen.put(letter, newNode);
                        node = newNode;
                    }

                }
                node.word = word;
            }
            this._board = board;


            for (int row = 0; row < board.length; ++row){
                for (int col = 0 ; col < board[row].length; ++col){
                    if (root.childen.containsKey(board[row][col])){
                        backtracking(row,col,root);
                    }
                }
            }
        return this._result;
        }

    private void backtracking(int row, int col, TrieNode parent) {
            Character letter = this._board[row][col];
            TrieNode currNode = parent.childen.get(letter);

            if (currNode.word != null){
                this._result.add(currNode.word);
                currNode.word = null;
            }
            this._board[row][col] = '#';
            int[] rawOffset = {-1,0,1,0};
            int[] colOffset = {0,1,0,-1};
            for (int i = 0 ; i < 4 ;i++){
                int newRow = row + rawOffset[i];
                int newCol = col + colOffset[i];
                if (newRow < 0 || newRow >= this._board.length || newCol < 0 || newCol >= this._board[0].length){
                    continue;
                }
                if (currNode.childen.containsKey(this._board[newRow][newCol])){
                    backtracking(newRow, newCol ,currNode);
                }
            }

            this._board[row][col] = letter;
            if (currNode.childen.isEmpty()){
                parent.childen.remove(letter);
            }
    }

}

```

## 本周总结

复习：二叉树DFS、BFS，二叉搜索树之前中后序遍历
Trie 树 基本特性：
1，节点本身不存完整单词

2，从根节点到某一节点，路径上经过的自字符连接起来，为该节点对应的字符串

3，每个节点的所有子节点路径都代表的字符不同

字典树理解：搜索问题处理，每个节点都是26空间（单词为例），就是根据单词长度的遍历去构建字典树。

并查集：组团、配对问题处理

