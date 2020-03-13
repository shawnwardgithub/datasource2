package dataSource.GraphDemo;

/**
 * @author weidongzhengxin
 * @date 3/8/2020 9:28 PM
 */
public class QueueX {
    private final int size = 20;
    private int[] queArray;
    private int front;
    private int rear;

    public QueueX(){
        queArray = new int[size];
        front = 0;
        rear = -1;
    }

    public void insert(int j){
        if(rear == size-1){
            rear = -1;
        }
        queArray[++rear] = j;
    }

    public int remove(){
        int temp = queArray[front++];
        if(front==size){
            front = 0;
        }
        return temp;
    }

    public boolean isEmpty(){
        return (rear+1==front
        ||front+size-1==rear);
    }

}
