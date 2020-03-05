package dataSource.AllKindListDemo;

/**
 * @author weidongzhengxin
 * @date 3/5/2020 4:40 PM
 */
public class Node {

    private Node previous;
    private Node next;
    private int data;

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
