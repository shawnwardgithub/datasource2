package dataSource.ArrayDemo;

/**
 * @author weidongzhengxin
 * @date 3/2/2020 1:11 PM
 */
//普通数组
public class GenerateArray {
    private int[] values;
    private int maxSize;
    private int nsize;
    //初始化普通数组
    public GenerateArray(int maxSize){
        this.values = new int[maxSize];
        this.maxSize = maxSize;
        this.nsize = 0;
    }
    //插入数据
    public boolean insertValue(int value){
        if(maxSize==nsize){
            //容量已满
            System.out.println("数组已满");
            return false;
        }
        this.values[nsize] = value;
        nsize++;
        return true;
    }
    //查询是否存在该数据
    public int getCurrentValue(int value){
        int i;
        for(i=0;i<nsize;i++){
           if(values[i]==value){
               break;
           }
        }
        if(i==nsize){
            return -1;
        }else{
            return i;
        }
    }
    //删除某个数据
    public boolean deleteCurrentValue(int value){
        //定义要删除数值的下标
        int i;
        for(i=0;i<nsize;i++){
           if(values[i]==value){
               break;
           }
        }
        if(i==nsize){
            return false;
        }
        if(nsize == maxSize){
            for(int k = i;k<nsize-1;k++){
                this.values[k] = this.values[k+1];
            }
            values[nsize-1] = 0;
        }else{
            for(int k = i;k<nsize;k++){
                this.values[k] = this.values[k+1];
            }
        }
        nsize--;
        return true;
    }

    public void display(){
        System.out.println("-------------------");
        for (int value : this.values) {
            System.out.println(value);
        }
    }

    public static void main(String[] args) {
        GenerateArray generateArray = new GenerateArray(5);
        //generateArray.display();
        generateArray.insertValue(3);
        generateArray.insertValue(2);
        generateArray.insertValue(4);
        generateArray.display();
        System.out.println(generateArray.getCurrentValue(3));
        System.out.println(generateArray.getCurrentValue(2));

        //删除数据
        generateArray.deleteCurrentValue(2);
        generateArray.display();
    }
}
