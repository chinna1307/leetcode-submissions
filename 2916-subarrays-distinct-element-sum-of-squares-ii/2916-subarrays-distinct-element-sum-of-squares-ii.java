import java.util.HashMap;
import java.util.Map;

class Solution {
    private static final int MOD = 1_000_000_007;

    // Segment Tree structure nodes represented as flattened arrays
    private long[] sum;
    private long[] sqSum;
    private long[] lazy;

    private void pushDown(int node, int start, int end) {
        if (lazy[node] == 0) {
            return;
        }

        long lazyVal = lazy[node];
        int mid = start + (end - start) / 2;
        int leftChild = 2 * node;
        int rightChild = 2 * node + 1;

        // Update left child
        long leftLen = mid - start + 1;
        sqSum[leftChild] = (sqSum[leftChild] + 2 * lazyVal * sum[leftChild] % MOD + lazyVal * lazyVal % MOD * leftLen % MOD) % MOD;
        sum[leftChild] = (sum[leftChild] + lazyVal * leftLen) % MOD;
        lazy[leftChild] = (lazy[leftChild] + lazyVal) % MOD;

        // Update right child
        long rightLen = end - mid;
        sqSum[rightChild] = (sqSum[rightChild] + 2 * lazyVal * sum[rightChild] % MOD + lazyVal * lazyVal % MOD * rightLen % MOD) % MOD;
        sum[rightChild] = (sum[rightChild] + lazyVal * rightLen) % MOD;
        lazy[rightChild] = (lazy[rightChild] + lazyVal) % MOD;

        // Clear current node lazy status
        lazy[node] = 0;
    }

    private void updateRange(int node, int start, int end, int l, int r, long val) {
        if (r < start || end < l) {
            return;
        }

        if (l <= start && end <= r) {
            long length = end - start + 1;
            sqSum[node] = (sqSum[node] + 2 * val * sum[node] % MOD + val * val % MOD * length % MOD) % MOD;
            sum[node] = (sum[node] + val * length) % MOD;
            lazy[node] = (lazy[node] + val) % MOD;
            return;
        }

        pushDown(node, start, end);
        int mid = start + (end - start) / 2;
        updateRange(2 * node, start, mid, l, r, val);
        updateRange(2 * node + 1, mid + 1, end, l, r, val);

        sum[node] = (sum[2 * node] + sum[2 * node + 1]) % MOD;
        sqSum[node] = (sqSum[2 * node] + sqSum[2 * node + 1]) % MOD;
    }

    public int sumCounts(int[] nums) {
        int n = nums.length;
        
        // Allocate space for the 4 * N segment tree structure
        sum = new long[4 * n];
        sqSum = new long[4 * n];
        lazy = new long[4 * n];

        Map<Integer, Integer> lastOccurrence = new HashMap<>();
        long totalAns = 0;

        for (int j = 0; j < n; j++) {
            // Find the last index where nums[j] appeared. Default to -1 if it's new.
            int leftBound = lastOccurrence.getOrDefault(nums[j], -1) + 1;
            int rightBound = j;

            // Increment the distinct element value for this updated range segment
            updateRange(1, 0, n - 1, leftBound, rightBound, 1);

            // sqSum[1] stores the total sum of squares for all subarrays ending at index j
            totalAns = (totalAns + sqSum[1]) % MOD;

            // Track current position mapping
            lastOccurrence.put(nums[j], j);
        }

        return (int) totalAns;
    }
}
