package dataSource.ArrayDemo;

/**
 * @author weidongzhengxin
 * @date 3/2/2020 5:26 PM
 */
//有序数组
public class SortedArray {
    private int[] values;
    private int maxSize;
    private int nSize;//有多少项

    public SortedArray(int size){
        this.values = new int[size];
        this.maxSize = size;
        this.nSize = 0;
    }

    //二分查找法,获取下标
    public int find(int value){
        int lower = 0 ;
        int upper = nSize-1;
        int curr ;
        while(true){
            curr = (lower + upper)/2;
            if(values[curr]==value){
                return curr;
            }else if(lower > upper){
              return -1;
            }else{
                if(values[curr]<value){
                      lower = curr + 1;
                }else{
                       upper = curr - 1;
                }
            }
        }
    }
    //insert into new value
    public boolean insertValue(int value){
        //如果是满的禁止
        if(nSize == maxSize){
            return false;
        }
        //找准要插入的位置
        int i;
        for(i=0;i<nSize;i++){
             if(values[i]>value){
                 break;
             }
        }
        //将插入位置之后的数据往后移
        for(int j=nSize;j>i;j--){
            values[j] = values[j-1];
        }
        values[i] = value;
        nSize++;
        return true;
    }
    public boolean deleteValue(int value){
         //寻找到数据
        int current = find(value);
        if(current == -1){
            System.out.println("未找到数据");
            return false;
        }
        if(nSize == maxSize){
            //满的
            for(int i = current;i<nSize-1;i++){
                values[i] = values[i+1];
            }
            values[nSize-1] = 0;
        }else{
            for(int i = current;i<nSize;i++){
                values[i] = values[i+1];
            }
        }
         nSize--;
         return true;
    }

    public void display(){
        System.out.println("----------------------");
        for (int value : values) {
            System.out.println(value);
        }
    }

    public static void main(String[] args) {
        SortedArray sortedArray = new SortedArray(5);
        sortedArray.insertValue(1);
        sortedArray.insertValue(2);
        sortedArray.insertValue(3);
        sortedArray.insertValue(4);
        sortedArray.insertValue(5);
        sortedArray.display();

        //find
        System.out.println(sortedArray.find(3));


        sortedArray.deleteValue(3);
        sortedArray.display();

        sortedArray.deleteValue(2);
        sortedArray.display();

    }

}
