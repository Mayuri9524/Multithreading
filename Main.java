package Semaphore;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args)
    {
        Queue<Shirt> store = new ConcurrentLinkedDeque<>();

        Semaphore SemaProducer = new Semaphore(5);
        // IN the beginning showroom is empty hence adding 5 products is allowed
        Semaphore SemaCustomer = new Semaphore(0);
        //Customer is not allowed to by as the store is empty
        // at any point of time store will have either 0 or max 5 shirts
        Producer p1 = new Producer(store,"p1",SemaProducer,SemaCustomer);
        Producer p2 = new Producer(store,"p2",SemaProducer,SemaCustomer);
        Producer p3 = new Producer(store,"p3",SemaProducer,SemaCustomer);
        Producer p4 = new Producer(store,"p4",SemaProducer,SemaCustomer);
        Producer p5 = new Producer(store,"p5",SemaProducer,SemaCustomer);



        Thread tp1= new Thread(p1);
        Thread tp2= new Thread(p2);
        Thread tp3= new Thread(p3);
        Thread tp4= new Thread(p4);
        Thread tp5= new Thread(p5);

        Customer c1 = new Customer(store,"c1",SemaCustomer,SemaProducer);
        Customer c2 = new Customer(store,"c2",SemaCustomer,SemaProducer);
        Customer c3 = new Customer(store,"c3",SemaCustomer,SemaProducer);
        Customer c4 = new Customer(store,"c4",SemaCustomer,SemaProducer);
        Customer c5 = new Customer(store,"c5",SemaCustomer,SemaProducer);

        Thread tc1= new Thread(c1);
        Thread tc2= new Thread(c2);
        Thread tc3= new Thread(c3);
        Thread tc4= new Thread(c4);
        Thread tc5= new Thread(c5);

        tp1.start();
        tp2.start();
        tp3.start();
        tp4.start();
        tp5.start();

        tc1.start();
        tc2.start();
        tc3.start();
        tc4.start();
        tc5.start();

        // ConcurrentListDeque makes a multi thread enable queue
        //multiple thread can read write update etc. on the queue at the at  same time
        //normal linked list does not allow multiple read write at the same time
        //it only allows multiple reads
        // Either of them are not thread safe  [Synchronization issue]
    }
}
