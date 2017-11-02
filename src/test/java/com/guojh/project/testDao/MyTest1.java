package com.guojh.project.testDao;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 2017/10/23.
 */
public class MyTest1 {

    @Test
    public void testRandom(){
        int max = 35;
        int min = 4;
        int n =10;
        Random random = new Random();
        List<Integer> list= new ArrayList<Integer>();
        int rs ;
        while (list.size()<=n){
            rs= random.nextInt(max) % (max - min + 1) + min;
            list.add(rs);
        }

        for (Integer arr : list){
            System.out.println("随机数"+arr);
        }

    }
}
