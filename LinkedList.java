import java.util.*;

public class LinkedList {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;

    // To add to the LinkedList
    public void addFirst(int data) {
        // 1st step = create new node
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode; // newNode itself is the new node, further steps not required
            return;
        }
        // New node next = head
        newNode.next = head;

        // step3 - head = newNode
        head = newNode;
    }

    // Method to print the LinkedList
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    public void addlast(int data ){
        //step 1 - create node
        Node newNode=new Node(data);
        if (head ==  null){
            head= tail=newNode;
        }
        //stepp 2 
        tail.next= newNode;
        // step 3 
        tail = newNode;
        return;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addlast(3);
        ll.addlast(4);
        
        ll.printList(); // Corrected print statement
    }
}
