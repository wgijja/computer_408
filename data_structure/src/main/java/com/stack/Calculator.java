package com.stack;

/**
 * 计算器
 */
public class Calculator {

    public static void main(String[] args) {
        String expression = "300+2*50-6";
        //先创建两个栈，一个是数栈，一个符号栈
        ArrayStackTwo numStack = new ArrayStackTwo(10);
        ArrayStackTwo operStack = new ArrayStackTwo(10);
        //定义需要的相关变量
        int index = 0;
        int oper;
        int num1;
        int num2;
        int res;
        //用于保存每次扫描到的字符
        char cur=' ';
        //用于保存多位数
        String abc = "";
        //开始循环扫描表达式
        while (true) {
            if (index < expression.length()) {
                cur = expression.charAt(index);
                //判断是否是字符
                if (!operStack.isOper(cur)) {
                    abc += cur;
                    //如果是数据，则需要判断是否是多位数，如果是最后一位，则直接入栈
                    if (index == expression.length() - 1) {
                        numStack.push(Integer.parseInt(abc));
                    } else {
                        char next = expression.charAt(index + 1);
                        //如果后一位是符号，则入栈，如果不是符号，则直接下一次循环，因为下次循环一定会到再到这里来！perfect
                        if (operStack.isOper(next)) {
                            numStack.push(Integer.parseInt(abc));
                            abc = "";
                        }
                    }
                } else {
                    //判断当前符号栈是否为空
                    if (operStack.isEmpty()) {
                        operStack.push(cur);
                    } else {
                        //判断当前操作符和栈中的操作符的优先级
                        if (operStack.priority(cur) > operStack.priority(operStack.theTopValue())) {
                            operStack.push(cur);
                        } else {
                            num1 = numStack.pop();
                            num2 = numStack.pop();
                            oper = operStack.pop();
                            res = operStack.cal(num1, num2, oper);
                            numStack.push(res);
                            operStack.push(cur);
                        }
                    }
                }
                index++;
            } else {
                break;
            }
        }
        //循环结束后，再分别从两个线中取出数据并计算出最终的结果
        while (!operStack.isEmpty()) {
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = operStack.cal(num1, num2, oper);
            numStack.push(res);
        }
        System.out.printf("计算的结果为：%d", numStack.pop());
    }
}


class ArrayStackTwo {

    /**
     * 栈的大小
     */
    private int maxSize;

    /**
     * 数组
     */
    private int[] stack;

    /**
     * 栈顶
     */
    private int top = -1;

    public ArrayStackTwo(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    /**
     * 查看栈顶元素
     *
     * @return
     */
    public int theTopValue() {
        return stack[top];
    }

    /**
     * 是否栈满
     *
     * @return
     */
    public boolean isFull() {
        return top == maxSize - 1;
    }

    /**
     * 是否栈空
     *
     * @return
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 新增元素
     *
     * @param value
     */
    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满，新增失败！");
            return;
        }
        top++;
        stack[top] = value;
    }

    /**
     * 获取一个元素
     *
     * @return
     */
    public int pop() {
        if (isEmpty()) {
            System.out.println("栈为空！");
            return -999;
        }
        int temp = stack[top];
        top--;
        return temp;
    }

    /**
     * 从栈顶开始遍历栈
     */
    public void list() {
        if (isEmpty()) {
            System.out.println("栈为空！");
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }

    /**
     * 返回操作符的优先级
     *
     * @param oper 运算符
     * @return
     */
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    /**
     * 判断是否是一个运算符
     *
     * @param oper
     * @return
     */
    public boolean isOper(int oper) {
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
    public int cal(int num1, int num2, int oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                //注意，因为Num2是先入的栈，所以它在前面
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }
}
