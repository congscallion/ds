/**
 * BrandBigData.com Inc. Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion.stack;

/**
 * 使用数组实现栈
 *
 * 栈实现一般提功主要如下方法：
 *
 * push: 将元素压入栈顶
 * pop: 弹出栈顶元素
 * peek or top： 返回栈顶元素
 * isEmpty: 空栈返回true， 其它返回 false.
 *
 * @author wangcong
 * @version $Id: StackByArray.java, v0.1 7/8/19 9:02 AM wangcong Exp $$
 */
public class StackByArray {

    private static final int MAX = 1000; // 栈最大深度
    int top;  // 栈顶下标
    private int[] table = new int[MAX];

    public StackByArray(){
        top = -1;
    }


    public boolean isEmpty(){
        return top <=0;
    }

    public int push(int data){

        if(top >= (MAX-1)){
            throw  new StackOverflowError();
        }

        table[++top] = data;

        return  data;
    }


    public int pop(){

        if(top < 0){
            throw new StackOverflowError();
        }

        return table[top--];
    }


    public int peek(){
        return table[top];
    }

}