package dataSource.AllKindListDemo;

import java.util.List;

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
             return null;
         }
         Node node = last;
         if(node.getPrevious()==null){
              first = null;
         }else{
              last.getPrevious().setNext(null);
         }
         last = last.getPrevious();
         nSize--;
         return node;
    }

    //指定key然后插入
    private Node addAfter(int key,int data){
             //查找到对应的key所在的node
             Node current = first;
             while(first.getData()!=key){
                if(first.getNext()==null){
                    System.out.println("没有找到插入的位置");
                    return null;
                }
            }
             //如果是最后一个节点
            if(current==last){
               return  insertLast(data);
            }else{
                Node newLink = new Node();
                newLink.setNext(current.getNext());
                current.getNext().setPrevious(newLink);
                newLink.setPrevious(current);
                current.setNext(newLink);
                nSize--;
            }
            return null;
    }
    //删除指定位置的节点
    private Node deleteNode(int key){
        //删除指定位置的节点
        Node current = first;
        while (current.getData()!=key){
            current = current.getNext();
            if(current == null){
                System.out.println("不存在该节点!");
                return null;
            }
        }
        if(current == first){
            removeFirst();
        }else if(current == last){
            removeLast();
        }else{
            current.getPrevious().setNext(current.getNext());
            current.getNext().setPrevious(current.getPrevious());
            nSize--;
        }
        return current;
    }

    //从头到尾遍历链表
    public void displayForward(){
        System.out.println("List(first --> last):");
        Node current = first;
        while (current != null){
             System.out.println(current.getData());
             current = current.getNext();
        }
        System.out.println("----------------------");
    }

    //从尾到头遍历链表
    public void displayBackward(){
        System.out.println("List(last --> first)");
        Node current = last;
        while (current != null){
            System.out.println(current.getData());
            current = current.getPrevious();
        }
        System.out.println("-------------------------");
    }

    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.insertLast(1);
        doublyLinkedList.insertLast(2);
        doublyLinkedList.displayForward();

        doublyLinkedList.removeLast();

        doublyLinkedList.addAfter(1,9);

        doublyLinkedList.displayForward();

    }


}
