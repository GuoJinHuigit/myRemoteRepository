package com.guojh.project.testtryfinally;

import org.junit.Test;

/**
 * Created by Administrator on 2017/11/6.
 */
public class TryClass {

    @Test
    public void testTryin(){
        int s =testTry();
        System.out.println(s);
    }

    /*测试try中的return语句之前执行finally还是之后执行*/
    public int testTry(){
        int b=50;
        try {
            b=50;
            System.out.println("create the try");
            return b+=100;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("this is catch");
        }finally {
            b=200;
            b+=100;
            System.out.println("this is finally");
        }
        return b;
    }

    @Test
    public void testTryFina(){
        int i = testTryFinally();
        System.out.print(i);
    }


    /*测试try和finally中都有return语句怎么执行
    * finally中有return语句则会覆盖try中的return的值*/
    public int testTryFinally(){
        int i=0;
        try {
            i = 10;
            i+=10;
            System.out.println("this is try");
            return i++;
        } catch (Exception e) {
            System.out.println("this is catche");
            e.printStackTrace();
        } finally {
            i+=100;
            System.out.println("this is finally");
            return i+=16;
        }
    }

    @Test
    public void testTryCacheFi(){

        int i = testTryCatch();
        System.out.print(i);
    }

    /*测试当有异常产生时，
    return语句会如何执行
    当程序中出现了异常会进入cathc块，然后给变量赋值，最后返回cache快中的return,
    但是finally中也有return时，会覆盖cache快种的return*/

    public int testTryCatch(){

        int i=0;
        try {
            i=100;
            System.out.println("this is try");
            i+=80;
            i/=0;
            i+=30;
            return i++;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("this is cache");
            i+=60;
            i*=3;
            return i++;
        } finally {
            i+=50;
            System.out.println("this is finally");
            //return i*3+2;
        }
    }
}
