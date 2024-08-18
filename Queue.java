class QueueExample {
    private static final int MAX_SIZE = 100; // Maximum size of the queue
    private int[] queue;
    private int front, rear;

    public QueueExample() {
        queue = new int[MAX_SIZE];
        front = rear = -1;
    }

    // Enqueue operation to add an element to the end of the queue
    void enqueue(int data) {
        if (rear == MAX_SIZE - 1) {
            System.out.println("Queue is full. Cannot enqueue.");
            return;
        }
        if (front == -1) {
            front = 0;
        }
        queue[++rear] = data;
        System.out.println("Enqueued element: " + data);
    }

    // Dequeue operation to remove an element from the front of the queue
    void dequeue() {
        if (front == -1) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return;
        }
        int dequeuedElement = queue[front++];
        if (front > rear) {
            front = rear = -1;
        }
        System.out.println("Dequeued element: " + dequeuedElement);
    }

    // Check if the queue is empty
    boolean isEmpty() {
        return front == -1;
    }

    // Get the size of the queue
    int size() {
        if (front == -1) {
            return 0;
        }
        return rear - front + 1;
    }

    // Peek operation to view the front element of the queue without removing it
    void peek() {
        if (front == -1) {
            System.out.println("Queue is empty. Cannot peek.");
            return;
        }
        System.out.println("Front element of the queue: " + queue[front]);
    }

    // Display all elements in the queue
    void displayQueue() {
        if (front == -1) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue elements: ");
        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }
}

public class Queue{
    public static void main(String[] args) {
        QueueExample queueExample = new QueueExample();

        // Enqueue elements to the queue
        queueExample.enqueue(10);
        queueExample.enqueue(15);
        queueExample.enqueue(20);

        // Display the queue
        queueExample.displayQueue();

        // Dequeue an element from the queue
        queueExample.dequeue();

        // Display the queue after dequeue operation
        queueExample.displayQueue();

        // Peek at the front element of the queue
        queueExample.peek();

        // Check if the queue is empty
        boolean isEmpty = queueExample.isEmpty();
        System.out.println("Is the queue empty? " + isEmpty);

        // Get the size of the queue
        int queueSize = queueExample.size();
        System.out.println("Size of the queue: " + queueSize);
    }
}
