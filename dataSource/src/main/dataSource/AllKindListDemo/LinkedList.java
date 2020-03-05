package dataSource.AllKindListDemo;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * @author weidongzhengxin
 * @date 3/5/2020 10:28 AM
 */
public class LinkedList {
    private Link head;
    private int nSize;

    private LinkedList(){
        this.head = null;
        this.nSize = 0;
    }

    private boolean addFirst(int data){
        //从头部插
        Link newHeader = new Link();
        newHeader.setData(data);
        newHeader.setNext(this.head);
        this.head = newHeader;
        nSize++;
        return true;
    }
    private Link removeFirst(int data){
      if(isEmpty()){
          System.out.println("空链表！");
          return null;
      }
       this.head = this.head.getNext();
       nSize--;
      return this.head;
    }

    private boolean isEmpty(){
        return head == null;
    }

    private boolean addSort(int data){
        Link link = new Link();
        link.setData(data);
        Link current = head;
        Link previous = null;
        while (current!=null && data > current.getData()){
              previous = current;
              current = current.getNext();
        }
        if(previous == null){
            head = link;
        }else{
            previous.setNext(link);
        }
            link.setNext(current);
    nSize++;
    return true;
    }

    //查找某个节点
    private Link find(int data){
        Link current = head;
        while(current.getData()!=data){
            if(current.getNext()==null){
                return null;
            }else{
                current = current.getNext();
            }
        }
        return current;
    }
    //删除某个节点
    private Link removerSort(int data){
       Link current = head;
       Link previous = head;
       while(current.getData()!=data){
           if(current.getNext()==null){
               return null;
           }
           previous = current;
           current = current.getNext();
       }
       if(current == head){
           head = head.getNext();
       }
       previous.setNext(current.getNext());
       nSize--;
       return current;
    }

    public static void main(String[] args) {

    }

}
