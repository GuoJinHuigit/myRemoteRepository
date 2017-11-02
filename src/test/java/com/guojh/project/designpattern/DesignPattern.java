package com.guojh.project.designpattern;

import org.junit.Test;

import javax.swing.plaf.PanelUI;
import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by Administrator on 2017/10/31.
 *
 * java中的23中设计模式
 */

/*测试类*/
public class DesignPattern {

    /*单例模式懒汉式测试方法*/
    @Test
    public void testSington(){
        Singleton singleton =Singleton.getInstance();
        Singleton singleton1 =Singleton.getInstance();
        System.out.print(singleton);
        System.out.print(singleton1);
    }

    /*单例模式饿汉式测试方法*/
    @Test
    public void testMySingleton(){
        MySington mySington =MySington.getInstance();
        MySington mySington1 =MySington.getInstance();
        System.out.print(mySington ==mySington1);
    }
}

/*单例模式
* 懒汉式*/

class Singleton{

    private static Singleton singleton = new Singleton();
    /*构造私有，防止被实例化*/
    private Singleton(){

    }

    public static Singleton getInstance(){
        return singleton;
    }
}

/*单例模式
* 饿汉式*/
class MySington{

    private static MySington mySington = null;

    private MySington(){

    }

   /* private static synchronized void syncInst(){
        if (mySington == null){
            mySington = new MySington();
        }
    }*/

    public static synchronized MySington getInstance(){
        if (mySington == null){
            mySington = new MySington();
        }
        return mySington;
    }
}

/*简单工厂模式
* 缺点：当客户不再满足现有的车型号时，只要这种产品符合抽象产品制定的合同，
* 那么只要同志工厂类就可以被客户使用了，所以对产品部分来说他是符合开闭原则的，
* 但是在工厂部分每增加一种车型都要在工厂类中增加相应的逻辑方法，这显然是违背
* 开闭原则的
*
* */
/*产品类*/
abstract class BMW{
    public BMW(){

    }
}

class BMW1 extends BMW{

    public BMW1(){
        System.out.println("bmw1 is created");
    }
}

class BMW2 extends BMW{

    public BMW2(){
        System.out.println("bmw2 is created");
    }
}

/*工厂类*/
class Factory{

    public BMW createBMW(int type){
        if(type == 1){
            return new BMW1();
        }else if(type==2){
            return new BMW2();
        }else {
            return null;
        }
    }
}

/*客户类*/
class Customer{

    /*简单工厂测试*/
    public static void main(String[] args){
        Factory factory = new Factory();
        factory.createBMW(1);
        factory.createBMW(2);
    }

}

/*工厂方法模式*/

/*产品类*/
abstract class Car{
    public Car(){

    }
}

class SmallCar extends Car{
    public SmallCar(){
        System.out.println("this is smallCar");
    }
}
class MidCar extends Car{

    public MidCar(){
        System.out.println("this is Mid Car");
    }
}

/*创建工厂类*/
interface FactoryCar{

    Car createCar();
}
class FactorySmallCar implements FactoryCar{

    @Override
    public SmallCar createCar() {
        return new SmallCar();
    }
}
class FactoryMidCar implements FactoryCar{

    @Override
    public MidCar createCar() {
        return new MidCar();
    }
}
/*客户类*/
class Customer1{

    public static void main(String[] args){
        FactoryMidCar factoryMidCar = new FactoryMidCar();
        MidCar midCar =factoryMidCar.createCar();
        FactorySmallCar factorySmallCar = new FactorySmallCar();
        SmallCar smallCar =factorySmallCar.createCar();

    }
}

/*观察者模式*/

/*observer接口*/
interface Observer{

    public void update();
}

class Observer1 implements Observer{

    @Override
    public void update() {
        System.out.println("observer1 has received");
    }
}
class Observer2 implements Observer{

    @Override
    public void update() {
        System.out.println("observer2 has received");
    }
}

/*Subject接口及其实现类*/
interface Subject{

    /*增加观察者*/
    public void add(Observer observer);
    /*删除观察者*/
    public void del(Observer observer);
    /*通知所有观察者*/
    public void notifyObservers();

    /*自身的操作*/
    public void operation();
}

abstract class AbstractSubject implements Subject{

    private Vector<Observer> vector = new Vector<Observer>();

    public void add(Observer observer){
        vector.add(observer);
    }

    public void del(Observer observer){
        vector.remove(observer);
    }

    public void notifyObservers(){
        Enumeration<Observer> emumer =vector.elements();
        while (emumer.hasMoreElements()){
            emumer.nextElement().update();
        }
    }
}

class MySubject extends AbstractSubject{

    @Override
    public void operation() {
        System.out.println("update self");
        notifyObservers();
    }
}
 class ObserverTest {

    public static void main(String[] args) {
        Subject sub = new MySubject();
        sub.add(new Observer1());
        sub.add(new Observer2());
        sub.operation();
    }
}





