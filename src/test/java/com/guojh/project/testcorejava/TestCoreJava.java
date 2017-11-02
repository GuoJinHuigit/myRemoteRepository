package com.guojh.project.testcorejava;

import com.sun.xml.internal.stream.Entity;
import org.junit.Test;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/10/30.
 */

public class TestCoreJava {



    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个整数:");
        int n = sc.nextInt();
        int a = factorial(n);
        System.out.println("n的阶乘为"+a);
    }


    /*函数的递归调用
    * a++先运算，再自加*/
    public static int factorial(int n){

        if(n == 1) return 1;
        int result = factorial(n-1);
        return n*result;
    }


    /*冒泡排序*/
    @Test
    public void testSort(){

        int[] a={2,8,4,0,7};

        for(int i=0;i<a.length-1;i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp;
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }

        for (int i=0;i<a.length;i++){
            System.out.print(a[i]);
        }
    }

    //数组的扩容
    @Test
    public void testAddArray(){

        /*1.首先定义一个指定长度的数组
        * 2.在定义一个新数组，为原数组长度的2倍
        * 3，将元数组的内容拷贝到新书组中，*/
        int[] a = new int[]{1,4,5,10,2};//原数组
        int[] b = new int[a.length*2];//新数组
        for (int i=0;i<a.length;i++){
            b[i]=a[i];//原数组赋给新数组
        }
        for (int i=0;i<b.length;i++){
            System.out.print(b[i]+"\t");
        }
    }

    /*选择排序*/
    @Test
    public void testPrintArray(){
        int[] a = new int[]{1,6,10,2,4,1};
        for(int i=0;i<a.length-1;i++){
            for (int j=i+1;j<a.length;j++){
                if(a[i]>a[j]){
                    int temp;
                    temp = a[i];
                    a[i] =a[j];
                    a[j] = temp;
                }
            }
        }

        for (int i=0;i<a.length;i++){
            System.out.print(a[i]+"\t");
        }
    }

    /*java自动类型提升测试*/
    @Test
    public void testAuto(){

        System.out.println(3*0.1==0.3);
        System.out.println(1*0.3==0.3);
    }

}
