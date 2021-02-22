import java.util.Stack;

/**
 * @author
 * @Description 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * @create 2021-02-22-11:46
 */
public class Task5 {
    public static void main(String[] args) {
        String s="([]{}()";
        System.out.println(isEffectiveStr(s));
    }
    public static boolean isEffectiveStr(String s){
        Stack<Character> stack=new Stack<>();
        stack.push(s.charAt(0));
        for (int i = 1; i <s.length() ; i++) {
            if(stack.isEmpty()){
                stack.push(s.charAt(i));
            }else{
                char top=stack.peek();
                switch(top){
                    case '(':
                        if(s.charAt(i)==')')
                            stack.pop();
                        else
                            stack.push(s.charAt(i));
                        break;
                    case '{':
                        if(s.charAt(i)=='}')
                            stack.pop();
                        else
                            stack.push(s.charAt(i));
                        break;
                    case '[':
                        if(s.charAt(i)==']')
                            stack.pop();
                        else
                            stack.push(s.charAt(i));
                        break;
                }
            }
        }
        if(stack.isEmpty())
            return true;
        else
            return false;
    }
}
