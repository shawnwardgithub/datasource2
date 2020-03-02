package BiaoDaShiDemo;

/**
 * Created by lijiahe on 2018/5/7.
 */
public class MyCharStack {
    private char[] Values;

    private int maxSize;

    private int topIndex;

    public MyCharStack(){
        this.maxSize=16;
        this.Values=new char[16];
        topIndex=-1;
    }

    //压入数据
    public char pushData(char in){
        if(topIndex<maxSize-1&&topIndex>=-1){
            Values[++topIndex]=in;
            return '1';
        }else{
            //对现有的栈进行扩容
        }
        return '0';
    }
    //弹栈
    public char popData(){
        return Values[topIndex--];
    }
    //遍历所有书数据
    public void BLallData(){
        for(char i: Values){
            System.out.println("栈中的数据"+i);
        }
    }
    //判断栈是否为空
    public boolean judgeStackIsEmpty(){
        return (topIndex==-1);
    }
    //判断指针是不是满了
    public boolean judgeStackIsFull(){
        return (topIndex==maxSize-1);
    }
}
