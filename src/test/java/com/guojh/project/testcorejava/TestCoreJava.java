package com.guojh.project.testcorejava;

import org.junit.Test;

import java.util.Random;
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

    /*将一个String字符串从小到大排序后在输出
    * 如String=="1,2,0,6,4,10,3"
    * 从小到大排序后再生成字符串输出*/
    @Test
    public void testString(){

        String str="1,3,9,12,80,8,15,1";
        System.out.println("str式"+str.toString());
        String[] arr =str.split(",");
        for (int i=0;i<arr.length;i++){
            System.out.println("数组时"+arr[i]);
        }

        int[] in = new int[arr.length];
        for (int i=0;i<arr.length;i++){
            in[i]=Integer.parseInt(arr[i]);//将string转换为int
        }
        //使用冒泡排序进行排序
        for (int i=0;i<in.length-1;i++){
            for(int j=0;j<in.length-i-1;j++){
                if(in[j]>in[j+1]){
                    int temp;
                    temp=in[j];
                    in[j]=in[j+1];
                    in[j+1]=temp;
                }
            }
        }

        //将字符串数组中的字符串拼接起来
        StringBuilder builder =new StringBuilder();
        String oldStr = ",";
        for(int i=0;i<in.length;i++){
            builder.append(String.valueOf(in[i])).append(oldStr);
        }
        //去掉最后一个逗号的方法
        //1.截取字串的方式去掉最后一个
        //String strs =builder.substring(0,builder.length()-1);
        //2.使用replace和lastindexof
       /* int index =builder.lastIndexOf(",");
        String str1 =builder.deleteCharAt(index).toString();*/
        //3.使用replace
        String str1 =builder.replace(builder.length()-1,builder.length(),"").toString();
        System.out.println("最后的数字式"+str1.toString());


    }

    //int数组----String数组
    public String[] getArrayString(int[] intArr){

        String[] strArr = new String[intArr.length];
        for(int i=0;i<intArr.length;i++){
           strArr[i]= String.valueOf(intArr[i]);
        }
        return strArr;
    }
    //string数组-----int数组
    public int[] getArrayInt(String[] strArr){
        int[] intArr = new int[strArr.length];
        for(int i=0;i<strArr.length;i++){
            intArr[i] =Integer.parseInt(strArr[i]);
        }
        return intArr;
    }


    /*random随机数操作*/
    @Test
    public void testRandom(){
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789";
        Random random = new Random();

        char[] array = str.toCharArray();
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<4;i++){
            builder.append(array[random.nextInt(array.length)]);//从array的字符数组中随即取出一个下标的字符拼接
        }
        System.out.println(builder.toString());
    }

}
