package queue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Siddharth on 12/8/2017.
 */
public class Queue {
    int head = 0;
    int tail = 0;

    List<Integer> queue = new ArrayList<>();

    public void enqueue(int value)
    {
        queue.add(value);
        tail ++;
    }

    public void dequeue()
    {
        if(queue.size() > 0)
        {
            queue.remove(head);
            tail --;
        }
        else
        {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void printQueue()
    {
        for (int value : queue)
        {
            System.out.print("|" + value + "|");
        }
    }
}
