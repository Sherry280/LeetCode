package Day25;

import java.util.jar.JarOutputStream;

public class TestDemo1 {
    public static void main(String[] args) {
        //基本数据类型都是直接用==来判断当前对象的值是否相等
        //只有引用类型才会去关注是否存在对象的值是否相等还是对象的地址
        //引用类型存在的坑还比较多
        String a="1"+"2"+"3";
        String b="123";
        System.out.println(a==b);
        System.out.println(a.equals(b));

//        String b=new String("123");
//        String a="123";
//        System.out.println(a==b);
//        System.out.println(a.equals(b));


//        Integer a=128;
//        Integer b=128;
//        System.out.println(a==b);
    }
}
