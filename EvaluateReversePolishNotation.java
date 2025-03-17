import java.util.Stack;

// TC: O(n) as all the strings in the array is traversed 
// SC: O(n) stack is considered as a extra space which is O(n)

// Run successfully on leetcode
// for every operator traversed, two pops are evaluated with the given sign. for number occured it is pushed in the stack
public class EvaluateReversePolishNotation {

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[] { "2", "1", "+", "3", "*" })); // 9
        System.out.println(evalRPN(new String[] { "4", "13", "5", "/", "+" })); // 6
        System.out
                .println(evalRPN(new String[] { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" })); // 22
    }

    public static int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0)
            return 0;

        Stack<String> stack = new Stack<>();
        String first = "";
        String second = "";
        for (String str : tokens) {
            if (!stack.isEmpty() && str.equals("+")) {
                stack.push(Integer.toString(Integer.parseInt(stack.pop()) + Integer.parseInt(stack.pop())));
            } else if (!stack.isEmpty() && str.equals("-")) {
                second = stack.pop();
                first = stack.pop();
                stack.push(Integer.toString(Integer.parseInt(first) - Integer.parseInt(second)));
            } else if (!stack.isEmpty() && str.equals("*")) {
                second = stack.pop();
                first = stack.pop();
                stack.push(Integer.toString(Integer.parseInt(first) * Integer.parseInt(second)));
            } else if (!stack.isEmpty() && str.equals("/")) {
                second = stack.pop();
                first = stack.pop();
                stack.push(Integer.toString(Integer.parseInt(first) / Integer.parseInt(second)));
            } else {
                stack.push(str);
            }
        }
        return Integer.parseInt(stack.peek());
    }
}