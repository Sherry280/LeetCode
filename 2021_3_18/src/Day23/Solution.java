package Day23;

import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class Solution {
    /**
     * 将一个数组元素按层序遍历的方式输出
     */
    public int[] clockwisePrint(int[][] mat, int n, int m) {
        Deque<Integer> deque=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                deque.add(mat[i][j]);
            }
        }
        int[] array=new int[n*m];
        Iterator it=deque.iterator();
        while(it.hasNext()){
            Integer element = deque.element();
            for(int i=0;i<n*m;i++) {
                array[i] = element;
            }
        }

        return array;


    }
}
