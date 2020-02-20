package geektime;

import java.util.Stack;

/**
 * @author : linghan.ma
 * @Package geektime
 * @Description:
 * @date Date : 2020年02月19日 9:20 PM
 **/
public class ResultRpn {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for (String s : tokens) {
            if (s.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (s.equals("-")) {
                stack.push(-stack.pop() + stack.pop());
            } else if (s.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (s.equals("/")) {
                int num1 = stack.pop();
                stack.push(stack.pop() / num1);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] tokens = {"2","3","+","4","*"};
        ResultRpn resultRpn = new ResultRpn();
        int res =  resultRpn.evalRPN(tokens);
        System.out.println(res);
    }

}
