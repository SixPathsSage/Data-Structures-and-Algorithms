package queue;

/**
 * Created by Siddharth on 12/8/2017.
 */
public class Client {
    public static void main(String[] args) {
        Queue queue = new Queue();
        for (int index = 0; index < 10; index ++)
        {
            queue.enqueue(index);
        }
        System.out.println("\nAfter enqueue");
        queue.printQueue();

        System.out.println("\nAfter dequeue");
        queue.dequeue();
        queue.printQueue();
    }
}
