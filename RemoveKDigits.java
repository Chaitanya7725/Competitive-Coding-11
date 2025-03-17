import java.util.Stack;

// TC: O(n) as all the characters in the string are evaluated
// SC: O(n) as Stack is used for storing the characters

// Runs successfully on leetcode
// The following approach is the monotonic stack approach if the current character is 
// less than the top stack element, then the character is popped, decrement the k.
// leading zeros case is also handled
public class RemoveKDigits {
    public static void main(String[] args) {
        System.out.println(removeKdigits("1432219", 3)); // 1219
        System.out.println(removeKdigits("10200", 1)); // 200
        System.out.println(removeKdigits("10", 2)); // 0
    }

    public static String removeKdigits(String num, int k) {
        if (num.length() == k)
            return "0";
        Stack<Character> stack = new Stack<>();
        for (char ch : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peek() > ch) {
                stack.pop();
                k--;
            }
            stack.push(ch);
        }
        while (k-- > 0) {
            stack.pop();
        }
        boolean status = true;
        StringBuilder sb = new StringBuilder();
        for (char ch : stack) {
            if (ch == '0' && status)
                continue;
            status = false;
            sb.append(ch);
        }
        return sb.length() != 0 ? sb.toString() : "0";
    }
}
