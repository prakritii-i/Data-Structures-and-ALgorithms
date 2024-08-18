class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedListStack {
    Node top;

    // Push operation to add an element to the top of the stack
    void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        System.out.println("Pushed element: " + data);
    }

    // Pop operation to remove the element from the top of the stack
    void pop() {
        if (top != null) {
            int poppedElement = top.data;
            top = top.next;
            System.out.println("Popped element: " + poppedElement);
        } else {
            System.out.println("Stack is empty. Cannot pop.");
        }
    }

    // Search operation to check if an element is present in the stack
    boolean search(int data) {
        Node temp = top;
        while (temp != null) {
            if (temp.data == data) {
                return true; // Element found
            }
            temp = temp.next;
        }
        return false; // Element not found
    }

    // Traverse operation to display the elements in the stack
    void traverseStack() {
        Node temp = top;
        if (temp != null) {
            System.out.print("Stack elements: ");
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        } else {
            System.out.println("Stack is empty.");
        }
    }
}

public class LinkedListStackExample {
    public static void main(String[] args) {
        LinkedListStack linkedListStack = new LinkedListStack();

        // Push elements onto the stack
        linkedListStack.push(10);
        linkedListStack.push(15);
        linkedListStack.push(20);

        // Display the stack
        linkedListStack.traverseStack();

        // Search for an element in the stack
        int searchElement = 20;
        boolean isElementPresent = linkedListStack.search(searchElement);
        if (isElementPresent) {
            System.out.println("Element " + searchElement + " found in the stack.");
        } else {
            System.out.println("Element " + searchElement + " not found in the stack.");
        }

        // Pop an element from the stack
        linkedListStack.pop();

        // Display the stack after popping
        linkedListStack.traverseStack();
    }
}
