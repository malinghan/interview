package geektime;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author : linghan.ma
 * @Package geektime
 * @Description:
 * @date Date : 2020年02月19日 6:11 PM
 **/
public class StackSolution {
        // Hash table that takes care of the mappings.
        private HashMap<Character, Character> mappings;

        // Initialize hash map with mappings. This simply makes the code easier to read.
        //初始化hash map,使得左右括号能够合理的映射
        public StackSolution() {
            this.mappings = new HashMap<Character, Character>();
            this.mappings.put(')', '(');
            this.mappings.put('}', '{');
            this.mappings.put(']', '[');
        }

        public boolean isValid(String s) {

            // Initialize a stack to be used in the algorithm.
            // 初始化一个stack
            Stack<Character> stack = new Stack<Character>();

            //从头遍历字符串
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                // If the current character is a closing bracket.
                //如果当前字符是一个右括号
                if (this.mappings.containsKey(c)) {

                    // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
                    //获取栈顶元素，如果是空，则压入'#',并返回
                    char topElement = stack.empty() ? '#' : stack.pop();

                    // If the mapping for this bracket doesn't match the stack's top element, return false.
                    //如果栈顶元素和当前字符不匹配则返回false
                    if (topElement != this.mappings.get(c)) {
                        return false;
                    }
                } else {
                    // If it was an opening bracket, push to the stack.
                    //如果是一个左括号则压入1栈
                    stack.push(c);
                }
            }

            // If the stack still contains elements, then it is an invalid expression.
            // 如果此时栈不为空,也说明这个一个无效字符串
            return stack.isEmpty();
        }

}
