package dataSource.GraphDemo;

/**
 * @author weidongzhengxin
 * @date 3/8/2020 5:15 PM
 */
public class Vertex {//顶点类

    public char label;
    public boolean wasVisited;
    public Vertex(char lab){
        this.label = lab;
        this.wasVisited = false;
    }
}
