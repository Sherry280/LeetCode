package Day20;

import java.util.Arrays;

public class ThirdWords {
    /**
     * 找出数组中第k大的数字(使用快排的思想）
     */
    public static void swap(int[] array,int index1,int index2){
        int tmp=array[index1];
        array[index1]=array[index2];
        array[index2]=tmp;
    }
    public static int partition(int[] array,int lowIndex,int highIndex){
        int leftIndex=lowIndex;
        int rightIndex=highIndex;
        //作为基准值的是最左边的一个数
        int key=array[lowIndex];
        while(leftIndex<rightIndex){
            while(leftIndex<rightIndex&&array[rightIndex]>=key){
                rightIndex--;
            }
            while(leftIndex<rightIndex&&array[leftIndex]<=key){
                leftIndex++;
            }
            //否则就进行交换
            swap(array,leftIndex,rightIndex);


        }
        swap(array,lowIndex,leftIndex);
        return leftIndex;




    }
    public static void quickSortInternal(int[] array,int lowIndex,int rightIndex){
        int size=rightIndex-lowIndex+1;
        if(size<=1){
            return ;
        }
        //对左右两个区间分别进行排序
        int keyIndex=partition(array,lowIndex,rightIndex);
        quickSortInternal(array,lowIndex,keyIndex-1);
        quickSortInternal(array,keyIndex+1,rightIndex);
    }
    public static void quickSort(int[] array){
        quickSortInternal(array,0,array.length-1);

    }
    public static  int findKth2(int[] a, int n, int K) {
        //利用快排先进行数组元素的排序
        quickSort(a);
        return a[n-K];


    }
    public static  int findKth(int[] a, int n, int K) {
        if(K>n){
            return 0;
        }
        Arrays.sort(a);
        return a[n-K];

    }
    public static void main(String[] args) {
        int[] array={1,4,6,3,7,8};
        int n=6;
        int k=3;
        System.out.println(findKth2(array, n, k));


    }
}
