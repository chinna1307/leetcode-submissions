class Solution {
    public boolean isValid(String s) {
        Stack<Character> result = new Stack<>();

        for(char c : s.toCharArray()) {
            if(c == '(' || c == '{' || c == '[') {
                result.push(c);
            } else {
                if(result.isEmpty()) {
                    return false;
                }

                char ch = result.peek();
                if((c == ')' && ch == '(') || (c == '}' && ch == '{') || (c == ']' && ch == '[')) {
                    result.pop();
                } else {
                    return false;
                }
            }
        }
        return result.isEmpty();
    }
}