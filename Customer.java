package Semaphore;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Customer implements Runnable{
    private Queue<Shirt> store;
    private String name;
    Semaphore SemaCustomer;
    Semaphore semaproducer;


    public Customer(Queue<Shirt> store, String name, Semaphore semaCustomer, Semaphore semaproducer) {
        this.store = store;
        this.name = name;
        SemaCustomer = semaCustomer;
        this.semaproducer = semaproducer;
    }

    public void run()
    {
        while (true) {
            try {
                SemaCustomer.acquire();


                System.out.println("Current Size: " + store.size() + " removing shirt by customer: " + name);
                store.remove();
                System.out.println("Size is not proper hence cannot remove");
                semaproducer.release();
                // producer can enter post a shirt is bought so producer that can enter after here is n+1


            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
