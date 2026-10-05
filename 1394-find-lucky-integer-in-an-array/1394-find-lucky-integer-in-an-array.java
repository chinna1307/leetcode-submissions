class Solution {
    public int findLucky(int[] arr) {
        int max = -1;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : arr){
            map.put(num, map.getOrDefault(num , 0) + 1);
        }
        for(int num : arr) {
            if(map.get(num) == num) {
                max = Math.max(num, max);
            }
        }
        return max;
    }
}