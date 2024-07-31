package Semaphore;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Producer implements Runnable{
    private Queue<Shirt> store;
    private String name;
    Semaphore semaproducer;
    Semaphore SemaCustomer;

    public Producer(Queue<Shirt> store, String name, Semaphore semaproducer, Semaphore SemaCustomer) {
        this.store = store;
        this.name = name;
        this.semaproducer = semaproducer;
        this.SemaCustomer = SemaCustomer;
    }

    public void run()
    {
        while (true) {

            try{semaproducer.acquire();
                //producer enter and acquire a key, producer that can enter further--

            System.out.println("Current Size: " + store.size() + " adding a shirt by producer: " + name);
            store.add(new Shirt());
            SemaCustomer.release();
            // consumer can enter post a shirt is added so consumer that can enter after here is n+1
        }

        catch(InterruptedException e) {
            throw new RuntimeException(e);}
    }}
}
