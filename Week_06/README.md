
## 最小路径和


```
    public static int minPathSum(int[][] grid){
        if (grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int rows = grid.length , columns = grid[0].length;
        int [][] dp = new int[rows][columns];
        dp[0][0] =  grid[0][0];
        for (int i = 1 ; i < rows; i++){
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1;j < columns; j++){
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1 ; i < rows ; i++){
            for (int j = 1; j < columns; j++){
                dp[i][j] = Math.min(dp[i - 1][j],dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[rows - 1][columns - 1];
    }

```

## 最大正方形


```
public static int maximalSquare(char[][] matrix) {
        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxSide;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int[][] dp = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        int maxSquare = maxSide * maxSide;
        return maxSquare;
    }

```

## 本周总结


总体来说，动态规划，是需要一些初始值的，那么xy轴都优先算出数值总和，后续方程根据前面算出来的值比对计算出之前的最小值
加上当前位置的值，就可以得到当前位置的最小路径和。

这道题给我最大的启发就是，动态规划的算法总是需要一些“启动值”的，这些启动值，可以是一些已知条件，也可以是算出来的一些初始值
这个题目就是给的一些已知数值，然后根据已知数值算出动态规划的“启动值”。

积累：

- 递归模板
- MIT动态规划步骤
