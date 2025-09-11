import java.util.Stack;

class Solution {
    public int minRemovalsToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        int removals = 0;

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                st.push(c);
            } else {
                if (!st.isEmpty() && isMatching(st.peek(), c)) {
                    st.pop(); // valid match
                } else {
                    removals++; // extra closing bracket
                }
            }
        }

        // Add remaining unmatched openings
        removals += st.size();

        return removals;
    }

    private boolean isMatching(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '{' && close == '}') ||
               (open == '[' && close == ']');
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.minRemovalsToMakeValid("())"));   // 1
        System.out.println(sol.minRemovalsToMakeValid("(]"));    // 2
        System.out.println(sol.minRemovalsToMakeValid("((("));   // 3
        System.out.println(sol.minRemovalsToMakeValid("{[()]}")); // 0 (already valid)
    }
}
