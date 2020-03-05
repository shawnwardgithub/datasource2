package dataSource.AllKindListDemo;

/**
 * @author weidongzhengxin
 * @date 3/5/2020 4:39 PM
 */
public class DoublyLinkedList {
    //头节点
    private Node first;
    //尾节点
    private Node last;

    private int nSize;

    private boolean isEmpty(){
        return first == null;
    }

    private DoublyLinkedList(){
        this.first = null;
        this.last = null;
        nSize = 0;
    }

    //头部增加节点
    private Node insertFirst(int data){
        Node node = new Node();
        node.setData(data);
        node.setPrevious(null);
        node.setNext(null);
        if(isEmpty()){
            last = node;
        }else{
            node.setNext(first);
            first.setPrevious(node);
        }
        first = node;
        nSize++;
        return node;
    }

    //尾部增加节点
    private Node insertLast(int data){
        Node node = new Node();
        node.setData(data);
        if(isEmpty()){
            first = node;
        }else{
            node.setPrevious(last);
            last.setNext(node);
        }
        last = node;
        nSize++;
        return node;
    }
    //删除首节点
    private Node removeFirst(){
        if(isEmpty()){
            System.out.println("该链表为空");
            return null;
        }
        Node node = first;
        if(node.getNext()==null){
            last = null;
        }else{
            first.getNext().setPrevious(null);
        }
        first = first.getNext();
        nSize--;
        return node;
    }
    //删除末节点
    private Node removeLast(){
         if(isEmpty()){
             System.out.println("链表为空");
         }

    }

}
