package linkedlist;

import customexceptions.EmptyListException;
import customexceptions.ValueNotFoundException;

/**
 * Created by Siddharth on 12/7/2017.
 */
public class LinkedList {
    Node head = null;
    Node tail = null;
    int count = 0;
    public void add(int value)
    {
        if(head != null)
        {
            Node node = new Node(value);
            if(head == tail)
            {
                head.next = node;
                tail = node;
            }
            else
            {
                tail.next = node;
                tail = node;
            }
        }
        else
        {
            Node node = new Node(value);
            node.next = null;
            head = tail = node;
        }
        count ++;
    }

    public void add(int index, int value) throws IndexOutOfBoundsException
    {
        if(index <= count)
        {
            Node currentNode = head;
            for(int i = 0; i <= count; i ++)
            {
                if(i == index - 1)
                {
                    Node newNode = new Node(value);
                    newNode.next = currentNode.next;
                    currentNode.next = newNode;
                    count ++;
                    return;
                }
                currentNode = currentNode.next;
            }
        }
        else
        {
            throw new IndexOutOfBoundsException("Linked list index out of bound");
        }
    }

    public void deleteValue(int value) throws ValueNotFoundException, EmptyListException
    {
        if(head != null)
        {
            Node currentNode = head;
            Node previousNode = head;
            do {
                if(currentNode.value == value)
                {
                    if (currentNode == head)
                    {
                        head = currentNode.next;
                        count --;
                        return;
                    }
                    else
                    {
                        previousNode.next = currentNode.next;
                        count --;
                        return;
                    }
                }
                else
                {
                   previousNode = currentNode;
                   currentNode = currentNode.next;
                }
            }while (currentNode != null);
        }
        else
        {
            throw new EmptyListException("Linked list is empty");
        }
    }

    public int getCount()
    {
        return count;
    }

    public void getAll()
    {
        if(head != null)
        {
            Node currentNode = head;
            do
            {
                System.out.print(currentNode.value + "->");
                currentNode = currentNode.next;
            } while (currentNode != null);
        }
        System.out.print("/ \n");
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        for(int index = 1; index <= 10; index ++)
        {
            linkedList.add(index);
        }
        linkedList.add(5, 3);
        linkedList.getAll();
        try {
            linkedList.deleteValue(3);
        } catch (ValueNotFoundException e) {
            e.printStackTrace();
        } catch (EmptyListException e) {
            e.printStackTrace();
        }
        linkedList.getAll();
    }
}
