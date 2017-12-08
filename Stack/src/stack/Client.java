package stack;

/**
 * Created by Siddharth on 12/8/2017.
 */
public class Client {
    public static void main(String[] args) {
        Stack stack = new Stack();
        for(int index = 0; index < 10; index ++)
        {
            stack.push(index);
        }
        System.out.println("After Push");
        stack.printStack();
        stack.pop();
        System.out.println("After Pop");
        stack.printStack();
    }
}
