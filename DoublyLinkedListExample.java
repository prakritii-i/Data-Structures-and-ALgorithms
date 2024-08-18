class Node {
    int data;
    Node prev;
    Node next;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    Node head;

    // Insert a node at the beginning
    void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Insert a node at the end
    void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
    }

    // Insert a node at a specific position
    void insertAtPosition(int data, int position) {
        if (position <= 0) {
            System.out.println("Invalid position");
            return;
        }
        Node newNode = new Node(data);
        if (position == 1) {
            if (head != null) {
                newNode.next = head;
                head.prev = newNode;
            }
            head = newNode;
            return;
        }
        Node temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of bounds");
            return;
        }
        newNode.next = temp.next;
        newNode.prev = temp;
        if (temp.next != null) {
            temp.next.prev = newNode;
        }
        temp.next = newNode;
    }

 
    // Delete a node from the head
    void deleteFromHead() {
        if (head == null) {
            System.out.println("Empty list");
            return;
        }
        head = head.next;
        if (head != null) {
            head.prev = null;
        }
    }

    // Delete a node from the end
    void deleteFromEnd() {
        if (head == null) {
            System.out.println("Empty list");
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        if (temp.prev != null) {
            temp.prev.next = null;
        } else {
            head = null;
        }
    }
// Delete a node at a specific position
    void deleteAtPosition(int position) {
        if (position <= 0 || head == null) {
            System.out.println("Invalid position or empty list");
            return;
        }
        Node temp = head;
        if (position == 1) {
            head = temp.next;
            if (head != null) {
                head.prev = null;
            }
            return;
        }
        for (int i = 1; i < position && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of bounds");
            return;
        }
        if (temp.prev != null) {
            temp.prev.next = temp.next;
        }
        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }
    }

    // Search for a value in the doubly linked list
    boolean search(int value) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == value) {
                return true; // Value found
            }
            temp = temp.next;
        }
        return false; // Value not found
    }

    // Display the doubly linked list
    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class DoublyLinkedListExample {
    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

        // Insert nodes at the beginning
        doublyLinkedList.insertAtBeginning(3);
        doublyLinkedList.insertAtBeginning(12);
        doublyLinkedList.insertAtBeginning(19);

        // Display the doubly linked list
        System.out.println("Doubly Linked List after insertion at the beginning:");
        doublyLinkedList.display();

        // Insert nodes at the end
        doublyLinkedList.insertAtEnd(6);
        doublyLinkedList.insertAtEnd(15);

        // Display the doubly linked list
        System.out.println("Doubly Linked List after insertion at the end:");
        doublyLinkedList.display();

        // Insert nodes at a specific position
        doublyLinkedList.insertAtPosition(10, 3);

        // Display the doubly linked list
        System.out.println("Doubly Linked List after insertion at a specific position:");
        doublyLinkedList.display();

        // Search for a value in the doubly linked list
        int searchValue = 4;
        boolean isValuePresent = doublyLinkedList.search(searchValue);

        if (isValuePresent) {
            System.out.println("Value " + searchValue + " found in the doubly linked list.");
        } else {
            System.out.println("Value " + searchValue + " not found in the doubly linked list.");
        }

        // Delete a node at a specific position
        doublyLinkedList.deleteAtPosition(3);

        // Display the doubly linked list
        System.out.println("Doubly Linked List after deletion at a specific position:");
        doublyLinkedList.display();

        // Delete a node from the head
        doublyLinkedList.deleteFromHead();

        // Display the doubly linked list
        System.out.println("Doubly Linked List after deletion from the head:");
        doublyLinkedList.display();

        // Delete a node from the end
        doublyLinkedList.deleteFromEnd();

        // Display the doubly linked list
        System.out.println("Doubly Linked List after deletion from the end:");
        doublyLinkedList.display();
    }
}
