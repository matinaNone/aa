package suanfa;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by wangnan01 on 2019/8/29.
 *  有大中小括号组合起来的字符串是否有效 () {[]}
 */

public class StackBracketString {

    //依次判断法，如果是左括号，则压入栈，如果是右括号，则和栈顶元素比较是否配对，如果配对则弹出栈，继续下一个字符；如果不配对则报错
    static boolean isValid1(String s){
        Stack<String> stringStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            String cur = String.valueOf(s.charAt(i));
            if("(".equals(cur) || "[".equals(cur) || "{".equals(cur)){
                stringStack.push(cur);
            }
            else if( (")".equals(cur) && !stringStack.isEmpty() && "(".equals(stringStack.peek()))
                    || ("]".equals(cur) && !stringStack.isEmpty() && "[".equals(stringStack.peek()))
                    || ("}".equals(cur) && !stringStack.isEmpty() && "{".equals(stringStack.peek()))){
                stringStack.pop();
            }else {
                return false;
            }

        }
        return stringStack.isEmpty();
    }
    //key-value 判断法
    static boolean isValid2(String s){
        Stack<String> stringStack = new Stack<>();
        HashMap<String, String> map = new HashMap<>();
        map.put("}","{");
        map.put("]","[");
        map.put(")","(");
        for (int i = 0; i < s.length(); i++){
            String cur = String.valueOf(s.charAt(i));
            if(map.containsValue(cur)){
                stringStack.push(cur);
            }
            else if( !stringStack.isEmpty() && stringStack.peek().equals(map.get(cur))){
                stringStack.pop();
            }else {
                return false;
            }
        }
        return stringStack.isEmpty();
    }


    public static void main(String[] args) {
        String s = "[]{a}c[({b})]";
        System.out.println(isValid2(s));
    }
}
