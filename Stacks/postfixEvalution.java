public int evalRPN(String[] tokens) {
    Stack<Integer> st = new Stack<>();

    for (String t : tokens) {
        if (isOperator(t)) {
            int b = st.pop();  // second
            int a = st.pop();  // first
            int res = apply(a, b, t);
            st.push(res);
        } else {
            st.push(Integer.parseInt(t));
        }
    }

    return st.pop();
}

private boolean isOperator(String t) {
    return t.equals("+") || t.equals("-") ||
           t.equals("*") || t.equals("/");
}

private int apply(int a, int b, String op) {
    switch (op) {
        case "+": return a + b;
        case "-": return a - b;
        case "*": return a * b;
        case "/": return a / b; // integer division
    }
    return 0;
}
