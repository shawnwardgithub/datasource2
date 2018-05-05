package BaseTree;

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
                    currentNode=currentNode.leftNode;
                    if(currentNode==null){
                        currentNode.leftNode=treeNode;
                        treeNode.parent=parentNode;
                        return;
                    }
                }else{
                    currentNode=currentNode.rightNode;
                    if(currentNode==null){
                        currentNode.rightNode=treeNode;
                        treeNode.parent=parentNode;
                        return;
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
            inOrder(root.leftNode);
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
    public void DeleteSomeNode(){
       //删除节点




    }


    //修改某个节点
    //修改节点时的可能性
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

        while (currentNode.key!=key){

            if(key<currentNode.key){
                isLeftTreeNode=true;
                currentNode=currentNode.leftNode;

            }else{
                isLeftTreeNode=false;
                currentNode=currentNode.rightNode;
            }

            if(currentNode==null){
                return false;
            }
            //找到了要删除的节点，下面开始删除
            //1. 要删除的节点没有子节点,直接将其父节点的左子节点或者右子节点赋为null即可
            if(currentNode.leftNode==null&&currentNode.rightNode==null){
                deleteNoNode(currentNode,isLeftTreeNode);
            }
            //3. 要删除的节点有两个子节点
            else if(currentNode.leftNode!=null&&currentNode.rightNode!=null){
                deleteTwoNode(currentNode,isLeftTreeNode);
            }
            //2. 要删除的节点有一个子节点，直接将其砍断，将其子节点与其父节点连起来即可，要考虑特殊情况就是删除根节点，因为根节点没有父节点
            else{
                deleteOneNode(currentNode,isLeftTreeNode);
            }

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
    //删除的有两个子节点
    public boolean deleteTwoNode(TreeNode currentNode,boolean isLeftTreeNode){
       return  true;
    }
    //删除的有一个子节点
    public boolean deleteOneNode(TreeNode currentNode,boolean isLeftTreeNode){
        if(currentNode.leftNode==null){

        }


    }




    public static void main(String[] args) {
        BinaryTree v=new BinaryTree();
        v.insertCurrentNode(new TreeNode(1,"test1"));
        v.insertCurrentNode(new TreeNode(7,"test1"));
        v.insertCurrentNode(new TreeNode(4,"test1"));

        System.out.println(v.findCurrentNode(1).value);
    }




}
