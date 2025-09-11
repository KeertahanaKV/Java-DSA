import java.util.*;

class Solution {
    public String makeValid(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>(); // store indices of opening brackets
        Set<Integer> toRemove = new HashSet<>(); // indices to remove

        // First pass: handle extra closing brackets
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '{' || c == '[') {
                stack.push(i);
            } else if (c == ')' || c == '}' || c == ']') {
                if (!stack.isEmpty() && isMatching(s.charAt(stack.peek()), c)) {
                    stack.pop(); // matched
                } else {
                    toRemove.add(i); // extra closing
                }
            }
        }

        // Second pass: remove any leftover openings
        while (!stack.isEmpty()) {
            toRemove.add(stack.pop());
        }

        // Build final string without removed indices
        for (int i = 0; i < s.length(); i++) {
            if (!toRemove.contains(i)) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }

    private boolean isMatching(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '{' && close == '}') ||
               (open == '[' && close == ']');
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.makeValid("())"));    // "()"
        System.out.println(sol.makeValid("(]"));     // "" or "()"
        System.out.println(sol.makeValid("((("));    // ""
        System.out.println(sol.makeValid("{[()]}")); // "{[()]}"
        System.out.println(sol.makeValid("([)]"));   // "()" or "[]"
    }
}
