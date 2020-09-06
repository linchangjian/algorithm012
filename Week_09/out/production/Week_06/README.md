
## 岛屿数量

这个题目主要还是要练习dfs，这道题目有个点，就是乍一看这个计数的逻辑不是很好懂，
慢慢分析，就知道遍历以后0的操作主要就是避免下次遍历到，达到计数的作用，这里有个
想法，如果题目要求不允许修改原来数据的内容，应该怎么操作呢？那应该就涉及到数据还原的逻辑。

```
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

```

## 柠檬水找零

逻辑算法，主要是枚举好收入的5、10找零枚举情况

```
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

```

## 本周总结

dfs、bfs，学习搜索的使用，这次用岛屿的题目进行练习，体会到这个算法的好处。
以后涉及到搜索的题目，可以优先看看这些算法能不能用上，让这个内化成个人的算法库。

课程中的模板起到很好的学习作用，帮助快速提升做题能力，还是需要多练。
