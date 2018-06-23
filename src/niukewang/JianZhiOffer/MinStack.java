package niukewang.JianZhiOffer;

import java.util.Stack;

/**
 * 题目20
 *
 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 */
public class MinStack {
    Stack<Integer> mainStack = new Stack<>();
    Stack<Integer> tempStack = new Stack<>();
    public void push(int node) {
        mainStack.push(node);
    }

    public void pop() {
        mainStack.pop();
    }

    public int top() {
        return mainStack.peek();
    }

    public int min() {
        int minNum = mainStack.peek();
        while (!mainStack.empty()){
            if (minNum>mainStack.peek()){
                minNum = mainStack.peek();
            }
            tempStack.push(mainStack.pop());
        }
        while (!tempStack.empty()){
            mainStack.push(tempStack.pop());
        }
        return minNum;
    }
}
