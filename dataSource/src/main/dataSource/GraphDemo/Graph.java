package dataSource.GraphDemo;

/**
 * @author weidongzhengxin
 * @date 3/8/2020 9:43 PM
 */
public class Graph {
    private final int maxSize =20;
    //存储顶点的数组
    private Vertex vertexArray[];
    //存储是否有边界的矩阵数组, 0表示没有边界，1表示有边界
    private int adjmat[][];
    //顶点个数
    private int nVerts;
    //深度搜索时用来临时存储的栈
    private StackX stackX;
    //广度搜索时用来临时存储的队列
    private QueueX queueX;

    public Graph(){
        vertexArray = new Vertex[maxSize];
        adjmat = new int[maxSize][maxSize];
        nVerts = 0;
        for(int i =0;i<maxSize;i++){
            for(int j=0;j<maxSize;j++){
                adjmat[i][j] = 0;
            }
        }
        stackX = new StackX();
        queueX = new QueueX();
    }

    public void addVertex(char lab){
        vertexArray[nVerts++] = new Vertex(lab);
    }

    public void addEdge(int start,int end){
        adjmat[start][end] = 1;
    }

    public void displayVertex(int i){
        System.out.println(vertexArray[i].label);
    }

   public int getAdjUnvisitedVertex(int i){
        for(int j=0;j<maxSize;j++){
            if(adjmat[i][j]==1&& !vertexArray[i].wasVisited){
                return i;
            }
        }
        return -1;
   }


    /*
     * 深度优先搜索算法:做四件事
     * 1. 用peek()方法检查栈顶的顶点
     * 2. 试图找到这个顶点还未访问的邻节点
     * 3. 如果没有找到，出栈
     * 4. 如果找到这样的顶点，访问这个顶点，并把它放入栈
     * 深度优先算法类似于从树的跟逐个沿不同路径访问到不同的叶节点
     */
    public void depthFirstSearch(){
        //begin at vertex 0
        vertexArray[0].wasVisited = true;
        displayVertex(0);
        stackX.push(0);

        while (!stackX.isEmpty()){
            //get an unvisited vertex adjacent to stack top
            int v = getAdjUnvisitedVertex(stackX.peek());
            if(v==-1){
                stackX.pop();
            }else{
                //如果有下一个路径
                vertexArray[v].wasVisited=true;
                displayVertex(v);
                stackX.push(v);
            }
        }

        for (Vertex vertex : vertexArray) {
            vertex.wasVisited = false;
        }

    }

    /*
     * 广度优先搜索算法：做四件事
     * 1. 用remove()方法检查栈顶的顶点
     * 2. 试图找到这个顶点还未访问的邻节点
     * 3. 如果没有找到，该顶点出列
     * 4. 如果找到这样的顶点，访问这个顶点，并把它放入队列中
     * 深度优先算法中，好像表现的要尽快远离起始点，在广度优先算法中，要尽可能靠近起始点。
     * 它首先访问其实顶点的所有邻节点，然后再访问较远的区域。这种搜索不能用栈，而要用队列来实现。
     * 广度优先算法类似于从树的跟逐层往下访问直到底层
     */
   public void breadthFirstSearch(){
        vertexArray[0].wasVisited = true;
        displayVertex(0);
        queueX.insert(0);
        int v2;

        while (!queueX.isEmpty()){
           int v1 = queueX.remove();
            //until it has no unvisited neighbors
           while((v2 = getAdjUnvisitedVertex(v1))!=-1){
               vertexArray[v2].wasVisited=true;
               displayVertex(v2);
               queueX.insert(v2);
           }
        }

       for (Vertex vertex : vertexArray) {
           vertex.wasVisited = false;
       }

    }

    public void minSpanningTree() {
        vertexArray[0].wasVisited = true;
        stackX.push(0);
        while (!stackX.isEmpty()) {
            int currentVertex = stackX.peek();
            int v = getAdjUnvisitedVertex(currentVertex);
            if (v == -1) {
                stackX.pop();
            } else {
                vertexArray[v].wasVisited = true;
                stackX.push(v);
                displayVertex(currentVertex); //from currentV
                displayVertex(v); //to v
                System.out.print(" ");
            }
        }
        //stack is empty, so we're done
        for (int j = 0; j < nVerts; j++) {
            vertexArray[j].wasVisited = false;
        }
    }

}
