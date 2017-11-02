package com.guojh.project.testcorejava;

import org.junit.Test;

/**
 * Created by Administrator on 2017/10/31.
 */
public class MyLamp {

    @Test
    public void testLamp(){
        Lamp lamp =new Lamp();
        Bulb bulb = new RedBulb();
        lamp.setBulb(bulb);
        lamp.lightOn();

    }
}

class Lamp{
    private Bulb bulb;

    public void setBulb(Bulb bulb){
        this.bulb=bulb;
    }

    public void lightOn(){
        bulb.shine();
    }
}

interface Bulb{
    void shine();
}

class GreenBulb implements Bulb{

    @Override
    public void shine() {
        System.out.print("this is greenBulb");
    }
}

class YellowBulb implements Bulb{

    @Override
    public void shine() {
        System.out.print("this is yellowBulb");
    }
}

class RedBulb implements Bulb{

    @Override
    public void shine() {
        System.out.print("this is redBulb");
    }
}


