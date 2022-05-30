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
        System.out.printf("%s = %d\n", suffixExpresion, calculate(list));

        System.out.print("(30+4)*5-6 = ");
        String polandNotation = getPolandNotation("(30+4)*5-6");
        System.out.println(polandNotation);
        System.out.println("使用逆波兰表达式计算后缀表达式：");
        List<String> strings = toListWithNoSpace(polandNotation);
        System.out.printf("%s = %d\n", polandNotation, calculate(strings));
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

    /**
     * 将中缀表达式转成后缀表达式（逆波兰表达式）
     *
     * @param expression
     * @return
     */
    public static String getPolandNotation(String expression) {
        //符号栈
        Stack<String> symbolStack = new Stack<>();
        //中间结果栈
        Stack<String> middleStack = new Stack<>();

        List<String> elements = stringToList(expression);
        for (String element : elements) {
            if ("(".equals(element)) {
                //左括号,直接压入符号栈
                symbolStack.push(element);
            } else if (")".equals(element)) {
                //右括号，依次弹出栈顶的符号压入中间结果栈
                while (true) {
                    if (symbolStack.isEmpty()) {
                        break;
                    }
                    String topSymbol = symbolStack.pop();
                    if ("(".equals(topSymbol)) {
                        break;
                    } else {
                        middleStack.push(topSymbol);
                    }
                }
            } else if (!isOper(element.charAt(0))) {
                //数字
                middleStack.push(element);
            } else {
                int curLevel = priority(element.charAt(0));
                while (true) {
                    //运算符
                    if (symbolStack.empty() || "(".equals(symbolStack.peek()) || curLevel > priority(symbolStack.peek().charAt(0))) {
                        symbolStack.push(element);
                        break;
                    }
                    //如果没有栈顶的优先级高，则弹出并压入中间结果栈中
                    middleStack.push(symbolStack.pop());
                }
            }
        }
        //将符号栈中的元素都压入中间结果栈
        while (!symbolStack.empty()) {
            middleStack.push(symbolStack.pop());
        }
        //依次弹出中间栈的元素，逆序即为中缀表达式的后缀表达式
        Stack<String> temp = new Stack<>();
        while (!middleStack.isEmpty()) {
            temp.push(middleStack.pop());
        }
        StringBuilder builder = new StringBuilder();
        while (!temp.isEmpty()) {
            String pop = temp.pop();
            if (!" ".equals(pop)) {
                builder.append(pop).append(" ");
            }
        }
        return builder.toString();
    }

    /**
     * 将中缀表达式拆分成List
     *
     * @param expression
     * @return
     */
    public static List<String> stringToList(String expression) {
        int index = 0;
        String abc = "";
        char cur = ' ';
        List<String> res = new ArrayList<>();
        while (index < expression.length()) {
            cur = expression.charAt(index);
            if (cur == '(' || cur == ')') {
                res.add("" + cur);
            } else {
                if (isOper(cur)) {
                    res.add("" + cur);
                } else {
                    abc += cur;
                    if (index == expression.length() - 1) {
                        res.add(abc);
                    } else {
                        char next = expression.charAt(index + 1);
                        if (isOper(next) || next == ')' || next == '(') {
                            res.add(abc);
                            abc = "";
                        }
                    }
                }
            }
            index++;
        }
        return res;
    }

    /**
     * 返回操作符的优先级
     *
     * @param oper 运算符
     * @return
     */
    public static int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    /**
     * 将后缀表达式转成List
     *
     * @param polandNotation
     * @return
     */
    private static List<String> toListWithNoSpace(String polandNotation) {
        List<String> list = new ArrayList<>();
        String temp = "";
        int index = 0;
        while (true) {
            if (index == polandNotation.length() - 1) {
                break;
            }
            char cur = polandNotation.charAt(index);
            if (' ' == cur) {
                index++;
                continue;
            }
            temp += cur;
            char next = polandNotation.charAt(index + 1);
            if (isOper(next) || ' ' == next) {
                list.add(temp);
                temp = "";
            }
            index++;
        }
        return list;
    }

}
