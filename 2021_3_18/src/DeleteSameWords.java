import java.util.*;

public class DeleteSameWords {
    public static void main2(String[] args) {
        Scanner sc=new Scanner(System.in);
        Map<String,Integer> map=new LinkedHashMap<>();
        while(sc.hasNext()){
            String s=sc.next();//输入路径
            int n=sc.nextInt();//输入行号
            String[] ss = s.split("\\\\");

            String road=ss[ss.length-1];
            if(road.length()>=16){
                road=road.substring(road.length()-16);
            }
            //遍历分割后的文件路径，如果map中不存在，则记录为1，如果有的话，则记录+1
            String key=road+" "+n;
            if(map.containsKey(key)){
                map.put(key,map.get(key)+1);
            }else{
                map.put(key,1);
            }



        }
        int count=0;
        for(String b:map.keySet()){
            count++;
            if(count>map.size()-8){
                System.out.println(b+" "+map.get(b));
            }
        }
    }
    /**
     * 返回数组中出现次数超过一半以上的数字
     *
     */
    public static int MoreThanHalfNum_Solution2(int [] array) {
        int time=1;
        int tmp=array[0];
        for(int i=0;i<array.length;i++){
            if(time==0){
                tmp=array[i];
                time=0;
            }else{
                if(tmp==array[i]){
                    time++;
                }else{
                    time--;
                }
            }
        }
        //计算数组中tmp出现的次数
        time=0;
        for(int i=0;i<array.length;i++){
            if(tmp==array[i]){
                time++;
            }
        }
        return time>=(array.length/2)?tmp:0;


    }
    public static int MoreThanHalfNum_Solution(int [] array) {
        if(array==null||array.length==0){
            return 0;
        }
        if(array.length==1){
            return array[0];
        }
        int sum=0;
        Arrays.sort(array);
        int tmp=array[array.length/2];
        //遍历中间的那个元素的次数是否超过数组元素的一半
        for (int value : array) {
            if (value == tmp) {
                sum++;
            }

        }
        if(sum>(array.length/2))
            return tmp;
        return 0;



    }

    public static void main(String[] args) {
        int[] array={1,2,3,2,2,4,5,2};
        System.out.println(MoreThanHalfNum_Solution2(array));

    }
}
