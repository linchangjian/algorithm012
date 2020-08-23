import java.util.*;

public class Main {

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        boolean apple = trie.search("apple");   // 返回 true
        boolean app = trie.search("app");// 返回 false
        System.out.println(app +" "+ apple);
        trie.startsWith("app"); // 返回 true
        trie.insert("app");
        app = trie.search("app");     // 返回 true
        System.out.println(app +" "+ apple);

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


}
