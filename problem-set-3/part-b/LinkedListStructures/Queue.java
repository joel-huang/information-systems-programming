package LinkedListStructures;

import java.util.Scanner;

// Create exception class for handling an empty queue.
class EmptyQueueException extends Exception {
    public EmptyQueueException(String s) {
        super(s);
    }
}

public class Queue {

    private Node firstNode;
    private Node lastNode;

    // Constructor
    Queue() {
        firstNode = null;
        lastNode = null;
    }

    public boolean isEmpty() {
        // If there is no first node, there is no queue.
        return (firstNode == null);
    }

    public void enqueue(int value) {

        // Generate the new node that is going to be added.

        Node n = new Node(value, null);

        // If queue is empty, this is the first node.
        if (isEmpty()) firstNode = n;

        // If it is not, then the last node points to n.
        else {
            lastNode.setLink(n);
        }

        // Either way, the last node is now n.
        lastNode = n;
    }

    public Node dequeue() throws EmptyQueueException {

        if (isEmpty()) throw new EmptyQueueException("You tried to remove something from an empty queue.");

        // Unlink the first node from the second node. Prep to return it.
        Node n = firstNode;

        // The second node is now the first.
        firstNode = firstNode.getLink();

        // Return n, which is the copy of the node removed.
        n.setLink(null);
        return n;
    }

    public void displayQueue() throws EmptyQueueException {

        Node currentNode = firstNode;

        if (isEmpty()) throw new EmptyQueueException("Tried displaying... but the queue is empty!");

        while (currentNode != null) {
            System.out.println(currentNode.getData());
            currentNode = currentNode.getLink();
        }
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Queue queue = new Queue();
        char ch;
        System.out.println("Queue Test");

        do {
            System.out.println("\nQueue Operations\n");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. isEmpty");
            System.out.println("4. displayQueue");

            System.out.print("Enter the operation code: ");
            String choice = reader.next();

            switch(choice) {
                case "1":
                    System.out.print("Enter integer element to queue: ");
                    int data = reader.nextInt();
                    queue.enqueue(data);
                    try {
                        System.out.print("Queue = ");
                        queue.displayQueue();
                    } catch (EmptyQueueException ex) {
                        System.out.println(ex);
                    }
                    break;

                case "2":
                    System.out.println("Dequeuing...");
                    try {
                        System.out.println("Item dequeued: " + queue.dequeue().getData());
                        System.out.print("Queue = ");
                        queue.displayQueue();
                    } catch (EmptyQueueException ex) {
                        System.out.println(ex);
                    }
                    break;

                case "3":
                    System.out.println("Checking if queue is empty...");
                    System.out.println(queue.isEmpty());
                    break;

                case "4":
                    System.out.println("Displaying queue...");
                    try {
                        queue.displayQueue();
                    } catch (EmptyQueueException ex) {
                        System.out.println(ex);
                    }
                    break;

                default:
                    System.out.println("That is not a valid operation.");
                    break;
            }

            System.out.print("\nDo you wish to continue (Type y or n): ");
            ch = reader.next().charAt(0);
        } while(ch == 'y' || ch == 'Y');
    }
}