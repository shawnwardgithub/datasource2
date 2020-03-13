package dataSource.GraphDemo;

/**
 * @author weidongzhengxin
 * @date 3/8/2020 8:10 PM
 */
public class StackX {
    private final int size = 20;
    private int[] stack;
    private int top;
    public StackX(){
        stack = new int[size];
        top = -1;
    }

    public void push(int j){
        stack[++top] = j;
    }

    public int pop(){
        return stack[top--];
    }

    public int peek(){
        return stack[top];
    }

    public boolean isEmpty(){
        return (top == -1);
    }

}
