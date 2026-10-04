class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> result = new Stack<>();
        for(String c : tokens) {
            if(c.equals("+")) {
                result.push(result.pop() + result.pop());
            } else if(c.equals("*")) {
                result.push(result.pop() * result.pop());
            } else if(c.equals("-")) {
                int a = result.pop();
                int b = result.pop();
                result.push(b - a);
            } else if(c.equals("/")) {
                int a = result.pop();
                int b = result.pop();
                result.push(b / a);
            } else {
                result.push(Integer.parseInt(c));
            }
        }
        return result.pop();
    }
}