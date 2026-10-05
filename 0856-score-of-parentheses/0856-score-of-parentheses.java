class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int currentScore = 0;

        for(char c : s.toCharArray()) {
            if(c == '(') {
                stack.push(currentScore);
                currentScore = 0;
            } else {
                int innerScore = Math.max(2 * currentScore, 1);
                currentScore = stack.pop() + innerScore;
            }
        }
        return currentScore;
    }
}