package Concurrency;

public class FooBarNTimes {


    private int n;
    private boolean fooTurn = true;

    public FooBarNTimes(int n) {
        this.n = n;
    }

    public static void main(String[] args) {

        FooBarNTimes obj = new FooBarNTimes(10);
        Runnable foo = () -> {
            try {
                obj.foo();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable bar = () -> {
            try {
                obj.bar();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread one = new Thread(foo);
        Thread two = new Thread(bar);

        two.start();
        one.start();
    }

    public synchronized void foo() throws InterruptedException {

        for (int i = 0; i < n; i++) {

            while (!fooTurn){
                wait();
            }
            // printFoo.run() outputs "foo". Do not change or remove this line.
            System.out.print("foo");
            fooTurn = false;
            notify();
        }
    }

    public synchronized void bar() throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (fooTurn){
                wait();
            }
            // printBar.run() outputs "bar". Do not change or remove this line.
            System.out.print("bar");
            fooTurn = true;
            notify();
        }
    }

}
