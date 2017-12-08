package stack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Siddharth on 12/8/2017.
 */
public class Stack {
    int top = -1;
    List<Integer> stack = new ArrayList<>();

    public void push(int value)
    {
        stack.add(value);
        top ++;
    }

    public void pop()
    {
        if(top > -1)
        {
            stack.remove(top);
            top --;
        }
        else
        {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public int stackSize()
    {
        return stack.size();
    }

    public void printStack()
    {
        for (int index = stack.size()-1; index >= 0; index --) {
            System.out.println("|"+stack.get(index)+"|");
        }
    }
}
