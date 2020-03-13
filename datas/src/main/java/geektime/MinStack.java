package geektime;

import java.lang.reflect.Array;
import java.util.Stack;

/**
 * @author : linghan.ma
 * @Package geektime
 * @Description:
 * @date Date : 2020年02月19日 6:29 PM
 **/
public class MinStack {
    private Stack<Integer> data;
    private Stack<Integer> min;

    /** initialize your data structure here. */
    public MinStack() {
        data = new Stack<Integer>();
        min = new Stack<Integer>();
    }

    public void push(int x) {
        if(data.isEmpty()){
            data.push(x);
            min.push(x);
        }else if(min.peek() >= x){
            data.push(x);
            min.push(x);
        }else {
            data.push(x);
        }
    }

    public void pop() {
        if(data.isEmpty()){
           return;
        }
        int i = data.pop();

        if(min.peek() == i){
            min.pop();
        }
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
          return min.peek();
    }

    public static void main(String[] args) {
          MinStack obj = new MinStack();
              obj.push(5);
        obj.push(6);
        obj.push(7);
        obj.push(4);
        obj.push(9);
        obj.push(3);
        obj.push(4);
        obj.push(3);
      obj.pop();
        obj.pop();
        obj.pop();
        obj.pop();
        obj.pop();
        obj.pop();
        obj.pop();
        obj.pop();
      int param_3 = obj.top();
      int param_4 = obj.getMin();
        System.out.println("param_3="+param_3);
        System.out.println("param_4="+param_4);
    }
}
