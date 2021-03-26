import java.util.ArrayList;
import java.util.List;

public class BuildTree {
    public BuildTree root;
    public BuildTree lChild;
    public BuildTree rChild;
    public Object val;
    public List<BuildTree> datas;

    public BuildTree(){
        super();
    }
    public BuildTree(Object val){
        this(null,null,val);
    }

    public BuildTree( BuildTree lchild, BuildTree rchild,Object val) {
        super();
        this.lChild=lchild;
        this.rChild=rchild;
        this.val=val;
    }

    public void createTree(Object[] objs){
        datas=new ArrayList<BuildTree>();
        for(Object object:objs){
            datas.add(new BuildTree(object));
        }
        //将第一个作为根节点
        root=datas.get(0);
        for(int i=0;i<objs.length/2;i++){
            //数组在内存中的结构就是层序遍历的方式存放的
            datas.get(i).lChild=datas.get(i*2+1);
            if(i*2+2<datas.size()){
                //避免偶数的时候，下标越界
                datas.get(i).rChild=datas.get(i*2+2);
            }
        }
    }



}
