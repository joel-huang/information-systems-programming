package LinkedListStructures;
import java.util.Scanner;

// Create exception class for handling an empty stack.
class EmptyStackException extends Exception {
    public EmptyStackException(String s) {
        super(s);
    }
}

public class Stack {

    private Node topNode;

    // Constructor
    Stack() {
        topNode = null;
    }

    public boolean isEmpty() {
        // Returns true if topNode == null,
        // false if otherwise.
        return topNode == null;
    }

    public void push(int value) {

        // By definition, you can only push an element on the top of the stack.

        // Create a new node, has data: value, and link to next node: null.
        Node n = new Node(value, null);

        // If there is a top node existing, link the new node to it.
        if (topNode != null) {
            n.setLink(topNode);
        }

        // Replace the top node (property) of the stack with n.
        topNode = n;
    }

    public int top() throws EmptyStackException {

        if (isEmpty()) throw new EmptyStackException("Tried getting top element... but the stack is empty!");

        return topNode.getData();
    }

    public Node pop() throws EmptyStackException {

        if (isEmpty()) throw new EmptyStackException("... but the stack is empty!");

        // Create copy of the node to be popped, in order to return it.
        Node toBeRemoved = topNode;

        // Replace the top node with the second-most top node
        topNode = topNode.getLink();

        return toBeRemoved;
    }

    public void displayStack() throws EmptyStackException {

        Node currentNode = topNode;

        if (isEmpty()) throw new EmptyStackException("Tried displaying... but the stack is empty!");

        while (currentNode != null) {
            System.out.println(currentNode.getData());
            currentNode = currentNode.getLink();
        }
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Stack stack = new Stack();
        char ch;
        do {
            System.out.println("\nStack Operations");
            System.out.println("1. Push");
            System.out.println("2. Top");
            System.out.println("3. Pop");
            System.out.println("4. isEmpty");
            System.out.println("5. displayStack");
            System.out.print("Enter the operation code: ");
            String choice = reader.next();

            switch(choice) {
                case "1":
                    System.out.print("Enter integer element to push: ");
                    int data = reader.nextInt();
                    stack.push(data);
                    try {
                        System.out.println("Stack = ");
                        stack.displayStack();
                    } catch (EmptyStackException ex) {
                        System.out.println(ex);
                    }
                    break;

                case "2":
                    System.out.println("Displaying top element...");
                    try {
                        System.out.println("Element: " + stack.top());
                    } catch (EmptyStackException ex) {
                        System.out.println(ex);
                    }
                    break;

                case "3":
                    System.out.println("Pooping top element...");
                    try {
                        System.out.println("Element popped: " + stack.pop().getData());
                        System.out.print("Stack = ");
                        stack.displayStack();
                    } catch (EmptyStackException ex) {
                        System.out.println(ex);
                    }
                    break;

                case "4":
                    System.out.print("Checking if stack is empty: ");
                    System.out.println(stack.isEmpty());
                    break;

                case "5":
                    System.out.println("Displaying stack...");
                    try {
                        stack.displayStack();
                    } catch (EmptyStackException ex) {
                        System.out.println(ex);
                    }
                    break;

                default:
                    System.out.println("Invalid input.");
                    break;
            }

            System.out.print("\nContinue? Y/N ");
            ch = reader.next().charAt(0);
        } while(ch == 'y' || ch == 'Y');
    }
}
