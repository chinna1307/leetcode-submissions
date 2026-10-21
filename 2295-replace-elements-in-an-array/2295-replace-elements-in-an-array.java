class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0;i < nums.length;i++) {
            map.put(nums[i], i);
        }

        for(int[] ops : operations) {
            int oldVal = ops[0];
            int newVal = ops[1];

            int index = map.get(oldVal);
            nums[index] = newVal;

            map.remove(oldVal);
            map.put(newVal, index);
        }

        return nums;
    }
}