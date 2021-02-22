import java.util.Stack;

/*
 * @lc app=leetcode.cn id=150 lang=java
 *
 * [150] 逆波兰表达式求值
 */

// @lc code=start
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            try {
                int a = Integer.parseInt(s);
                stack.push(a);
            } catch (NumberFormatException e) {
                int a2 = stack.pop();
                int a1 = stack.pop();
                int res = 0;
                switch (s.charAt(0)) {
                    case '+':
                        res = a1 + a2;
                        break;
                    case '-':
                        res = a1 - a2;
                        break;
                    case '*':
                        res = a1 * a2;
                        break;
                    case '/':
                        res = a1 / a2;
                        break;
                }
                stack.push(res);
            }
        }
        return stack.peek();
    }
}
// @lc code=end
