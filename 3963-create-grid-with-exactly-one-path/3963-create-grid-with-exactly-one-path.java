import java.util.Arrays;

class Solution {
    public String[] createGrid(int m, int n) {
        char[][] str = new char[m][n]; 
        
        for (int i = 0; i < m; i++) {
            Arrays.fill(str[i], '#');
        }
        
        for (int i = 0; i < m; i++) {
            str[i][0] = '.';
        }
        
        for (int j = 0; j < n; j++) {
            str[m - 1][j] = '.';
        }
        
        String[] result = new String[m];
        for (int i = 0; i < m; i++) {
            result[i] = new String(str[i]);
        }
        
        return result;
    }
}
