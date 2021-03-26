
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.jar.JarOutputStream;

//class TreeNode {
//    int val = 0;
//    TreeNode left = null;
//    TreeNode right = null;
//
//    public TreeNode(int val) {
//        this.val = val;
//    }
//
//}

public class PreorderTraversal {
    /**
     * 二叉树的前序遍历
     * 思路：创建一个List，把打印操作改为add操作即可
     */
    public static  List<Object> preorderTraversalTest(BuildTree root){
        List<Object> result=new ArrayList<>();
        if(root==null){
            return result;
        }
        result.add(root.val);
        preorderTraversalTest(root.lChild);
        preorderTraversalTest(root.rChild);
        return result;


    }
    //二叉树的层序遍历
    public static void levelOrderTraversal(BuildTree root){
        //队列的元素类型是树的节点
        Queue<BuildTree> queue=new LinkedList<>();
        if(root==null){
            return;
        }
        queue.add(root);
        while(!queue.isEmpty()){
            //层序遍历要经过的节点
            BuildTree node=queue.remove();
            System.out.println(node.val);
            if(node.lChild!=null){
                queue.add(node.lChild);
            }
            if(node.rChild!=null){
                queue.add(node.rChild);
            }

        }
    }

    //ceng
    public static void cengxu(BuildTree root){
        Queue<BuildTree> queue=new LinkedList<>();
        if(root==null){
            return;
        }
        queue.add(root);
        while(!queue.isEmpty()){
            BuildTree node=queue.remove();
            System.out.println(node.val);
            if(node.lChild!=null){
                queue.add(node.lChild);
            }
            if(node.rChild!=null){
                queue.add(node.rChild);
            }
        }

    }



    public static void main(String[] args) {
        Object[] array={1,5,7,8,9,55};
        BuildTree t=new BuildTree(array);
        t.createTree(array);
        levelOrderTraversal(t.root);//正确

        System.out.println(preorderTraversalTest(t.root));

    }
}
