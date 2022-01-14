package BOJ;

import java.util.Scanner;
import java.util.Stack;

public class Main_2504_괄호의값_Important {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        Stack<String> stack = new Stack<String>();

        boolean isAble = true;
        for(int i=0; i < str.length(); i++) {
            String c = str.substring(i, i+1);

            // 여는 괄호일 경우 본인의 닫는 괄호를 스택에 저장한다.
            if("(".equals(c)) {
                stack.push(")");
                continue;
            }

            if("[".equals(c)) {
                stack.push("]");
                continue;
            }

            // 닫는 괄호일경우 까다롭다.
            // 스택이 빌때까지 계속 꺼낸다.
            // 아직 짝이 안됐는데 스택이 비어있다면 isAble은 false가 된다.
            // 숫자 혹은 본인과 맞는 괄호가 아닌게 나온다면 isAble은 false가 된다.
            // 숫자가 나오면 숫자는 계속 합한다.
            // 본인에 맞는 괄호가 나오면 본인 괄호 크기에 맞게 위에 합한 수를 곱을 한뒤 그 값을 스택에 PUSH 한다.
            int num = 0;
            while(true) {
                // 아직본인 괄호가 나오지 않았는데 스택이 비었다는 뜻 유효하지 않은 괄호 문자열
                if(stack.isEmpty()) {
                    isAble = false;
                    break;
                }

                if(isNumber(stack.peek())) {
                    num += Integer.parseInt(stack.pop());
                }else {
                    if(isVPS(c, stack.peek())) {
                        stack.pop();
                        int t = (")".equals(c)) ? 2:3;

                        if(num == 0) {
                            stack.push(String.valueOf(t));
                        }else {
                            stack.push(String.valueOf(t*num));
                        }
                        break;
                    }else {
                        isAble = false;
                        break;
                    }
                }
            }
            if(!isAble) break;
        }

        int result = 0;

        // 스택이 빌때까지 POP한다.
        //정상적인 괄호 문자열이라면 스택에는 숫자만 들어 있어야 한다.
        while(!stack.isEmpty()) {
            if(isNumber(stack.peek())) {
                result += Integer.parseInt(stack.pop());
            }else {
                isAble = false;
                break;
            }
        }

        if(isAble) System.out.println(result);
        else System.out.println(0);
    }

    public static boolean isVPS(String c, String target) {
        if(c.equals(target)) return true;
        return false;
    }

    // 두 괄호가 아니면 무조건 숫자이다.
    public static boolean isNumber(String str) {
        if(str.equals(")") || str.equals("]")) return false;
        return true;
    }
}
