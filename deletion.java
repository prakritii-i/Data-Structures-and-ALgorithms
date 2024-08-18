class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    // Insert a node at the beginning
    void addToHead(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Insert a node at the end
    void addToTail(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Delete a node by value
    void deleteByValue(int value) {
        if (head == null) {
            System.out.println("Empty list");
            return;
        }

        // Check if the node to be deleted is the head
        if (head.data == value) {
            head = head.next;
            return;
        }

        Node current = head;
        Node prev = null;

        // Search for the node with the specified value
        while (current != null && current.data != value) {
            prev = current;
            current = current.next;
        }

        // If the node with the specified value is found, delete it
        if (current != null) {
            prev.next = current.next;
        } else {
            System.out.println("Value " + value + " not found in the list.");
        }
    }

    // Display the linked list
    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class deletion {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        // Insert nodes at the beginning
        linkedList.addToHead(3);
        linkedList.addToHead(21);
        

        // Display the linked list
        System.out.println("Single Linked List after operations:");
System.out.println("Add from head");
        linkedList.display();

        // Insert nodes at the end
        linkedList.addToTail(4);
       
        // Display the linked list
        System.out.println("Add from Tail");
        linkedList.display();

        // Delete a node by value
        linkedList.deleteByValue(3);

        // Display the linked list
        System.out.println("Deletion by value");
        linkedList.display();
    }
}
