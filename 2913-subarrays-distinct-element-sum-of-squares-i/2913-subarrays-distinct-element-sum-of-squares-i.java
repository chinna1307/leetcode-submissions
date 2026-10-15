class Solution {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        int sumOfSquare = 0;

        for(int i = 0;i < n;i++) {
            boolean[] seen = new boolean[101];

            int distinctCount = 0;
            for(int j = i;j < n;j++) {
                int digit = nums.get(j);
                if(!seen[digit]) {
                    seen[digit] = true;
                    distinctCount++;
                }
                sumOfSquare += distinctCount * distinctCount;
            }
        }
        return sumOfSquare;
    }
}