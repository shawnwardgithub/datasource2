package BaseTree;

/**
 * 创建一个基本的树节点
 */
public class TreeNode {

    public int key;

    public Object value;


    public TreeNode parent;

    public TreeNode leftNode;


    public TreeNode rightNode;

    public TreeNode(int key,Object value){
       this.key=key;
       this.value=value;
    }

}
