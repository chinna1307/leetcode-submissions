import java.util.ArrayList;
import java.util.List;

class Solution {
    private static final int MOD = 1_000_000_007;
    private int[][] table;

    public int numOfWays(int[] nums) {
        int n = nums.length;
        
        // Precompute combinations using Pascal's Triangle
        table = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            table[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                table[i][j] = (table[i - 1][j - 1] + table[i - 1][j]) % MOD;
            }
        }
        
        // Convert array to List for easier sub-list construction
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        
        // Subtract 1 to exclude the original array layout itself
        return (dfs(list) - 1 + MOD) % MOD;
    }

    private int dfs(List<Integer> list) {
        // Base case: 2 or fewer elements have only 1 valid arrangement
        if (list.size() <= 2) {
            return 1;
        }
        
        int root = list.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        
        // Partition elements into left and right subtrees
        for (int i = 1; i < list.size(); i++) {
            int val = list.get(i);
            if (val < root) {
                left.add(val);
            } else {
                right.add(val);
            }
        }
        
        // Calculate subproblem solutions
        long leftWays = dfs(left);
        long rightWays = dfs(right);
        
        // Fetch combination from precomputed Pascal's table
        long comb = table[left.size() + right.size()][left.size()];
        
        // Chain the ways together: (comb * leftWays * rightWays) % MOD
        long totalWays = (comb * leftWays) % MOD;
        totalWays = (totalWays * rightWays) % MOD;
        
        return (int) totalWays;
    }
}
