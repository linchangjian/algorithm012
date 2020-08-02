import java.util.*;

public class Main {

    public static void main(String[] args) {
        int [] changes = {5,5,5,10,20};
        boolean b = lemonadeChange(changes);
        System.out.println(b);
        printArray(changes);

        System.out.println();
        char [][] lands = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
            };
        int i = numIslands(lands);
        System.out.println("岛屿数量 ："+i);
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

    static void dfs(char[][] grid, int r, int c){
        int nr = grid.length;
        int nc = grid[0].length;
        if (r < 0 || c < 0 || r >= nr || c > nc || grid[r][c] == '0'){
            return;
        }
        grid[r][c] = '0';
        dfs(grid,r - 1,c);
        dfs(grid,r + 1 ,c);
        dfs(grid,r,c - 1);
        dfs(grid,r,c + 1);
    }

    /**
     * 问题1：乍一看，数量统计有点模糊
     * @param grid
     * @return
     */
    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0){
            return 0;
        }
        int nr = grid.length;//一维长度
        int nc = grid[0].length;//二维长度
        int numIslands = 0;//统计岛屿数量
        for (int r = 0; r < nr ; r++){
            for (int c = 0; c < nc ; c++){
                if (grid[r][c] == '1'){
                    numIslands++;
                    dfs(grid,r,c);
                }
            }
        }

        return numIslands;
    }

    public static boolean lemonadeChange(int[] bills) {
        int five = 0 , ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            }else if(bill == 10){
                if (five == 0){
                    return false;
                }
                five--;
                ten++;
            } else {
                if (five > 0 && ten > 0){
                    five--;
                    ten--;
                }else if (five >=3 ){
                    five -= 3;
                }else {
                    return false;
                }
            }
        }
        return true;
    }



}
