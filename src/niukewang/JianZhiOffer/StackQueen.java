package niukewang.JianZhiOffer;

import java.util.Stack;

/**
 * @author forward
 * 题5:用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * 该题已通过，解题思路如下：
 * 在没有操作的时候，应该保持所有数据都在stack1，stack2是空的
 * 进队列，这个操作比较简单，直接进行stack1的进栈操作就可以了
 * 出队列，比较复杂，因为出队列要出的是stack1最底部的数据，所以首先要把stack1所有数据先出栈，在进栈到stack2
 *      这样的操作之后stack2中存放的就是反向的数据，这时stack2最顶部的数据就是要出队列的数据，stack2做出栈操作，即可
 *      完成以后将stack2的数据重新转移到stack1中
 */
public class StackQueen {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        while (!stack1.empty()){
            stack2.push(stack1.pop());
        }
        int popNum = stack2.pop();
        while (!stack2.empty()){
            stack1.push(stack2.pop());
        }
        return popNum;
    }
}
