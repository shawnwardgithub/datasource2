package BaseTree;

import java.util.Currency;

/**
 * Created by lijiahe on 2018/3/30.
 */
public class BinaryTree {
    private TreeNode root;
    public BinaryTree(){
        root=null;
    }
    //根据给定的key去遍历查找节点
    public TreeNode findCurrentNode(int key){
        TreeNode currentNode=root;
        while(currentNode.key!=key){
            if(key<currentNode.key){
                currentNode=currentNode.leftNode;
            }else if(key>=currentNode.key){
                currentNode=currentNode.rightNode;
            }
            if(currentNode==null){
                return null;
            }
        }
        return  currentNode;
    }
    //给树插入节点
    public void insertCurrentNode(TreeNode treeNode){
        if(root==null){
            root=treeNode;
        }else{
            TreeNode currentNode=root;
            TreeNode parentNode;
            while (true){
                parentNode=currentNode;
                if(treeNode.key<currentNode.key){
                    if(currentNode.leftNode==null){
                        currentNode.leftNode=treeNode;
                        treeNode.parent=parentNode;
                        return;
                    }else{
                        currentNode=currentNode.leftNode;
                    }
                }else{
                    //currentNode=currentNode.rightNode;
                    if(currentNode.rightNode==null){
                        currentNode.rightNode=treeNode;
                        treeNode.parent=parentNode;
                        return;
                    }else{
                        currentNode=currentNode.rightNode;

                    }
                }

            }
        }
    }
    //前序，中序，后序遍历二叉树
    public void traverse(int traverseType) {
        switch(traverseType)
        {
            case 1: System.out.println("Preorder traversal:");
                preOrder(root);//前向遍历
                break;
            case 2: System.out.println("Inorder traversal:");
                inOrder(root);//中向遍历
                break;
            case 3: System.out.println("Postorder traversal:");
                postOrder(root);//后向遍历
                break;
            default: System.out.println("Inorder traversal:");
                inOrder(root);
                break;
        }
        System.out.println("");
    }

    //先序遍历   根-左-右
    public void preOrder(TreeNode root){
         if(root!=null){
             System.out.println(root.key+":"+root.value);
             preOrder(root.leftNode);
             preOrder(root.rightNode);
         }

    }
     //中序遍历  左-根-右
    public void inOrder(TreeNode root){
        if(root!=null){
            inOrder(root.leftNode);
            System.out.println(root.key+":"+root.value);
            inOrder(root.rightNode);
        }
    }
     //后序遍历  左--右--根
    public void postOrder(TreeNode root){
        if(root!=null){
            postOrder(root.leftNode);
            postOrder(root.rightNode);
            System.out.println(root.key+":"+root.value);
        }
    }
    //遍历寻找最大值
    public double MaxValueFind(){
        double dd=0.0;

        return dd;
    }
    //寻找最大值的节点
    public TreeNode FindMaxNode(){
        TreeNode currentNode=root;
        TreeNode parentNode=root;
        if(currentNode!=null){
            parentNode=currentNode;
            currentNode=currentNode.rightNode;
        }
        return  parentNode;
    }
    //寻找最小值的节点
    public TreeNode FindMinNode(){
        TreeNode currentNode=root;
        TreeNode parentNode =root;
        if(currentNode!=null){
            parentNode=currentNode;
            currentNode=currentNode.leftNode;
        }
        return  parentNode;
    }
    //删除某个节点
    //删除节点时的可能性
    //1. 该节点没有子节点（简单）
    //2. 该节点有一个子节点（还行）
    //3. 该节点有两个子节点（复杂）
    //删除节点的时间复杂度为O(logN)
    public boolean modfitySomeNode(int key){
        TreeNode currentNode=root;

        boolean isLeftTreeNode=true;

        if(currentNode==null){
            return false;
        }

        while (currentNode.key!=key) {

            if (key < currentNode.key) {
                isLeftTreeNode = true;
                currentNode = currentNode.leftNode;

            } else {
                isLeftTreeNode = false;
                currentNode = currentNode.rightNode;
            }

            if (currentNode == null) {
                return false;
            }
        }
            //找到了要删除的节点，下面开始删除
            //1. 要删除的节点没有子节点,直接将其父节点的左子节点或者右子节点赋为null即可
            if(currentNode.leftNode==null&&currentNode.rightNode==null){
                return  deleteNoNode(currentNode,isLeftTreeNode);
            }
            //3. 要删除的节点有两个子节点
            else if(currentNode.leftNode!=null&&currentNode.rightNode!=null){
                return  deleteTwoNode(currentNode,isLeftTreeNode);
            }
            //2. 要删除的节点有一个子节点，直接将其砍断，将其子节点与其父节点连起来即可，要考虑特殊情况就是删除根节点，因为根节点没有父节点
            else{
                return   deleteOneNode(currentNode,isLeftTreeNode);
            }

    }
    //删除的没有子节点
    public boolean deleteNoNode(TreeNode currentNode,boolean isLeftTreeNode){
        if(currentNode==root){
            root=null;
            return  true;
        }
        if(isLeftTreeNode){
            currentNode.parent.leftNode=null;
        }else{
            currentNode.parent.rightNode=null;
        }
        return true;
    }
    //删除的有一个子节点
    public boolean deleteOneNode(TreeNode currentNode,boolean isLeftTreeNode){
        //当前删除的节点不存在左子树，仅有右子树
        if(currentNode.leftNode==null){
           //如果当前删除节点是根节点
            if(currentNode==root){
                root=currentNode.rightNode;
                root.parent=null;
                return true;
            }
            //如果当前删除节点是父级的左分支
            if(isLeftTreeNode){
                 //do：删除节点的父级的左子树是删除节点的右子树
                 currentNode.parent.leftNode=currentNode.rightNode;
            }else{
                 //do：删除节点的父级的右子树是删除节点的左子树
                 currentNode.parent.rightNode=currentNode.rightNode;
            }
            currentNode.rightNode.parent=currentNode.parent;
        }
        //当前删除的节点仅存在左子树,
        else{
            //同上个分支
            if(currentNode==root){
                root=currentNode.leftNode;
                root.parent=null;
                return true;
            }
            //如果当前删除节点是父级的左分支
            if(isLeftTreeNode){
                currentNode.parent.leftNode=currentNode.leftNode;
            }
            else{
                currentNode.parent.rightNode=currentNode.leftNode;
            }
            currentNode.leftNode.parent=currentNode.parent;
        }
        return  true;
    }

    //删除的有两个子节点
    public boolean deleteTwoNode(TreeNode currentNode,boolean isLeftTreeNode){
        //获取被删除节点的后继节点
        TreeNode successor = getSucccessor(currentNode);
        //被删节点是根节点
        if(currentNode==root){
            successor.leftNode=root.leftNode;
            successor.rightNode=root.rightNode;
            successor.parent=null;
            root=successor;
        }
        else if(isLeftTreeNode){
            currentNode.parent.leftNode=successor;
        }
        else{
            currentNode.parent.rightNode=successor;
        }
        successor.leftNode=currentNode.leftNode;
        return  true;
    }

    ////获得要删除节点的后继节点（中序遍历的下一个节点）
    //中序遍历: 左 -根 -右
    public TreeNode getSucccessor(TreeNode delnode){
         TreeNode successor=delnode;
         //中序遍历获取删除节点的右子节点
         TreeNode treeNode=successor.rightNode;
         while (treeNode!=null){
             //当删除节点的右子节点不为空，则把后继节点指定为删除节点的右子节点
             //
             successor=treeNode;
             treeNode=treeNode.leftNode;
         }
         if(successor!=delnode.rightNode){
             successor.parent.leftNode=successor.rightNode;
             if(successor.rightNode!=null){
                 ////删除后续节点在原来的位置
                 successor.rightNode.parent=successor.parent;
             }
             //将后续节点放到正确位置，与右边连上
             successor.rightNode=delnode.rightNode;
         }
         return successor;
    }
    public static void main(String[] args) {
        BinaryTree v=new BinaryTree();
        v.insertCurrentNode(new TreeNode(31,"value31"));
        v.insertCurrentNode(new TreeNode(27,"value27"));
        v.insertCurrentNode(new TreeNode(41,"value41"));
        v.insertCurrentNode(new TreeNode(21,"value21"));
        v.insertCurrentNode(new TreeNode(19,"value19"));
        v.insertCurrentNode(new TreeNode(23,"value23"));
        v.insertCurrentNode(new TreeNode(28,"value28"));
        v.insertCurrentNode(new TreeNode(29,"value29"));
        v.insertCurrentNode(new TreeNode(41,"value41"));
        v.insertCurrentNode(new TreeNode(33,"value33"));
        v.insertCurrentNode(new TreeNode(51,"value51"));
        v.insertCurrentNode(new TreeNode(32,"value32"));
        v.insertCurrentNode(new TreeNode(39,"value39"));
        v.insertCurrentNode(new TreeNode(53,"value53"));
        v.traverse(1);
       // System.out.println(v.findCurrentNode(15).value);
    }




}
