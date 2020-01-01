package Concurrency;

public class MethodOrdering {

    int state = 0;

    public MethodOrdering() {
    }

    public synchronized void first() {
        while(state != 0){
            try{
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        // printFirst.run() outputs "first". Do not change or remove this line.
        //printFirst.run();
        System.out.println("first");
        state = 1;

        notifyAll();

    }

    public synchronized void second() {
        while(state != 1){
            try{
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        //printSecond.run();
        System.out.println("second");
        state = 2;
        notifyAll();

    }

    public synchronized void third() {
        while(state != 2){
            try{
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        // printThird.run() outputs "third". Do not change or remove this line.
        //printThird.run();
        System.out.println("third");

    }

    public static void main(String[] args) {
        MethodOrdering object = new MethodOrdering();
        Runnable one = object::first;
        Runnable two = object::second;
        Runnable three = object::third;

        Thread threadOne = new Thread(one);
        threadOne.start();

        Thread threadTwo = new Thread(two);
        threadTwo.start();

        Thread threadThree = new Thread(three);
        threadThree.start();



    }
}
