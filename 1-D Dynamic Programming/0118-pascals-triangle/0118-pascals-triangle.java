class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for(int j = 0;j <= i; j++) {
                if(i == j || j == 0) {
                    row.add(1);
                } else {
                    int leftAbove = list.get(i - 1).get(j - 1);
                    int rightAbove = list.get(i - 1).get(j);
                    row.add(leftAbove + rightAbove);
                }
            }
            list.add(row);
        }
        return list;
    }
}