class Solution {
    public int minCost(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][][] visit = new boolean[n][m][1024];
        visit[0][0][grid[0][0]] = true;

        for(int i = 0;i < n;i++) {
            for(int j = 0;j < m;j++) {
                if(i == 0 && j == 0) {
                    continue;
                }
                if(i > 0) {
                    for(int k = 0;k < 1024;k++) {
                        if(visit[i - 1][j][k]){
                            int xor = k ^ grid[i][j];
                            visit[i][j][xor] = true;
                        }
                    }
                }
                if(j > 0) {
                    for(int k = 0;k < 1024;k++) {
                        if(visit[i][j - 1][k]){
                            int xor = k ^ grid[i][j];
                            visit[i][j][xor] = true;
                        }
                    }
                }
            }
        }

        for(int x = 0;x < 1024;x++){
            if(visit[n - 1][m - 1][x]){
                return x;
            }
        }
        return - 1;
    }
}