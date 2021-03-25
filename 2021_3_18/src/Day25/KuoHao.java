package Day25;

import java.util.Deque;
import java.util.LinkedList;

public class KuoHao {
    //对成对出现的括号进行匹配
    //{}\[]\()
    public static boolean isVaild(String s){
        Deque<Character> stack=new LinkedList<>();
        for(char c:s.toCharArray()){
            switch (c){
                case '(':
                case '[':
                case '{':
                    //入栈
                    stack.push(c);
                    break;
                default:
                    if(stack.isEmpty()){
                        return false;
                    }
                    //取出栈顶元素
                    char ch=stack.pop();
                    if(!CompareBracket(ch,c)){
                        return false;
                    }
            }
        }
        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }

    }


    public  static boolean isVaild1(String s){
        Deque<Character> stack=new LinkedList<>();
        //遍历String字符串
        for(char ch:s.toCharArray()){
            switch(ch){
                case '(':
                case '[':
                case '{':
                    stack.push(ch);
                    break;
                default:
                    if(stack.isEmpty()){
                        return false;
                    }
                    //取出栈顶元素
                    char left=stack.pop();
                    //进行与右括号进行匹配
                    if(!CompareBracket(left,ch)){
                        return false;
                    }
            }
        }
        return stack.isEmpty();
    }
    public static boolean CompareBracket(char left,char right){
        if(left=='('&&right==')'){
            return true;
        }
        if(left=='{'&&right=='}'){
            return true;
        }
        return left == '[' && right == ']';
    }
    public static void main(String[] args) {
        String s="({[]})";
        System.out.println(isVaild(s));


    }
}
