package dataSource.ListDemo;


/**
 * @author weidongzhengxin
 * @date 2/29/2020 6:46 PM
 */
public class Node {
    private final Integer value;
    private Node next;

    public Node(Integer value){
        this.value = value;
        this.next = null;
    }

    public Integer getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Node{");
        sb.append("value=").append(value);
        sb.append(", next=").append(next);
        sb.append('}');
        return sb.toString();
    }
}
