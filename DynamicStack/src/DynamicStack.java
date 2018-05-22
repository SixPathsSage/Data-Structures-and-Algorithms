/**
 * Created by Siddharth on 5/22/2018.
 */
public class DynamicStack {
    private int top = -1;
    private int[] stack = new int[0];
    public void push(int value)
    {
        int size = stack.length;
        if (size == (top + 1))
        {
            int tempArraySize;
            if (size == 0)
            {
                tempArraySize = 1;
            }
            else
            {
                tempArraySize = size * 2;
            }

            int[] tempArray = new int[tempArraySize];
            for(int i = 0; i < size; i ++)
            {
                tempArray[i] = stack[i];
            }
            stack = tempArray;
        }
        stack[top+1] = value;
        top ++;
    }

    public void pop()
    {
        if (stack.length > 0)
        {
            top --;
        }
        else
        {
            System.out.println("Stack is Empty");
        }
    }

    public void display()
    {
        for(int i = 0; i <= top; i ++)
        {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DynamicStack s = new DynamicStack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.display();
        s.pop();
        s.display();
    }
}