package com.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 逆波兰表达式计算器
 */
public class PolandNotation {

    public static void main(String[] args) {
        //定义逆波兰表达式( 30 + 4 ) * 5 - 6   ====》 30 4 + 5 * 6 -
        String suffixExpresion = "30 4 + 5 * 6 -";
        List<String> list = toList(suffixExpresion);
        System.out.printf("%s = %d", suffixExpresion, calculate(list));
    }

    /**
     * 将逆波兰表达式转换成List
     *
     * @param suffixExpresion
     * @return
     */
    public static List<String> toList(String suffixExpresion) {
        String[] s = suffixExpresion.split(" ");
        return new ArrayList<>(Arrays.asList(s));
    }

    /**
     * 计算
     *
     * @param list
     * @return
     */
    public static int calculate(List<String> list) {
        Stack<String> stack = new Stack<>();

        for (String value : list) {
            if (value.matches("\\d+")) {
                stack.push(value);
            } else {
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int res = cal(num1, num2, value);
                stack.push("" + res);
            }
        }
        return Integer.parseInt(stack.pop());
    }


    /**
     * 判断是否是一个运算符
     *
     * @param oper
     * @return
     */
    public static boolean isOper(int oper) {
        return oper == '+' || oper == '-' || oper == '*' || oper == '/';
    }

    /**
     * 计算
     *
     * @param num1
     * @param num2
     * @param oper
     * @return
     */
    public static int cal(int num1, int num2, String oper) {
        int res = 0;
        switch (oper) {
            case "+":
                res = num1 + num2;
                break;
            case "-":
                //注意，因为Num2是先入的栈，所以它在前面
                res = num2 - num1;
                break;
            case "*":
                res = num1 * num2;
                break;
            case "/":
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }
}
