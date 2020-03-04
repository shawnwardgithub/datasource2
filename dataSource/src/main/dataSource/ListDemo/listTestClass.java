package dataSource.ListDemo;

import java.util.Arrays;
import java.util.List;

/**
 * @author weidongzhengxin
 * @date 2/29/2020 6:47 PM
 */
public class listTestClass {

    //创建正向链表的方法
    public Node creatCommonListWithHead(List<Integer> src){
        if(src.isEmpty()){
            return null;
        }
        Node firstNode = new Node(src.get(0));
        Node header = creatCommonListWithHead(src.subList(1,src.size()));
        firstNode.setNext(header);
        return firstNode;
    }

    //链表反转的方法
    public Node reverCommonListBeforeHeader(Node node){
        if(node==null){
            return null;
        }
        if(node.getNext()==null){
            return node;
        }
        Node headNode = reverCommonListBeforeHeader(node.getNext());
        node.getNext().setNext(node);
        node.setNext(null);
        return headNode;
    }






    public static void main(String[] args) {
        listTestClass listTestClass = new listTestClass();
        Node node = listTestClass.creatCommonListWithHead(Arrays.asList(1,2,3,4,5));
        System.out.println(node);
        //反转列表
        System.out.println(listTestClass.reverCommonListBeforeHeader(node));
    }


}
