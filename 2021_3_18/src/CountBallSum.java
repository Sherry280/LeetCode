import java.util.*;

public class CountBallSum {
    /**
     * 查找兄弟单词：
     *
     *
     */
    public static boolean isBrother(String target,String cur){
        //相同或者字符串的长度不一样的就不算是是兄弟单词
        if(target.equals(cur)||target.length()!=cur.length()){
            return false;
        }
        //都先转换成为字符数组，排序，因为如果是兄弟字符串的话，排序后的相同位置应该也是相同的
        char[] targetArray = target.toCharArray();
        char[] curArray = cur.toCharArray();
        Arrays.sort(targetArray);
        Arrays.sort(curArray);
        for(int i=0;i<targetArray.length;i++){
            if(targetArray[i]!=curArray[i]){
                return false;
            }
        }
        return true;
    }
    public static void process(String[] dict,String target,int brotherIndex){
        ArrayList<String> list=new ArrayList<>();
        Arrays.sort(dict);
        for(String cur:dict){
            if(isBrother(target,cur)){
                list.add(cur);
            }
        }
        System.out.println(list.size());
        if(brotherIndex<=list.size()&&list.size()>0){
            System.out.println(list.get(brotherIndex-1));
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            String[] dict=new String[n];
            for(int i=0;i<n;i++){
                dict[i]=sc.next();
            }
            String target=sc.next();
            int brotherIndex=sc.nextInt();

            process(dict,target,brotherIndex);
            sc.nextLine();

        }

    }
    /**
     * 有两框乒乓球，A和B，判断A中是否包含B中所有球的种类，并且A中的兵乓球的种类不少于B中每个种类的数目
     * 才能输出Yes，否则输出No
     */
    public static void main1(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String A=sc.nextLine();
            char[] A1 = A.toCharArray();
            String B=sc.nextLine();
            char[] B1 = B.toCharArray();

            Map<Character,Integer> mapA=new HashMap<>();
            Map<Character,Integer> mapB=new HashMap<>();

            for(Character ak:mapA.keySet()){
                if(ak==null){
                    mapA.put(ak,1);
                }
                mapA.put(ak,mapA.get(ak)+1);

            }
            for(Character ak:mapB.keySet()){
                if(ak==null){
                    mapB.put(ak,1);
                }
                mapB.put(ak,mapA.get(ak)+1);

            }
            for(Map.Entry<Character,Integer> c:mapB.entrySet()){
                Integer value = c.getValue();
                Character key = c.getKey();
                for(Map.Entry<Character,Integer> a:mapA.entrySet()){
                    Character aa=a.getKey();
                    Integer av=a.getValue();
                    if(key.equals(aa)&&value<=av){
                        System.out.println("Yes");
                    }
                }
                System.out.println("No");
            }
        }
        sc.close();

    }
}
