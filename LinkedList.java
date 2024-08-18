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
        Node temp = head; // you cannot change head thats why you put in head in temp
        while (temp != null) {// 
            System.out.print(temp.data + "->");
            temp = temp.next;
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
    //For Adding Elemt at the middle of Linked List
    public void add(int idx,int data) {
        //1: create node
        Node newNode = new Node(data);
        if(idx==0){
            addFirst(data);
            return;
        }
        Node temp=head;
        int i =0;
        while (i < idx-1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next =newNode;
    } 
    //Search In linked list thtogh iterative way
    public int itersearch(int key){
        Node temp = head;
        int i=0;
        
        //iterative loop
        while(temp!=null){
            if(temp.data==key){
                return i;
            }
            temp=temp.next;
            i++;
        }
        return -i;
    }
     //Search In linked list throgh Recusive approach
     public int recursiveSearchHelper(Node node, int key, int index) {
        if (node == null){
        return -1; }// Base case: key not found
        if (node.data == key){
            return index;} // Key found
        return recursiveSearchHelper(node.next, key, index + 1); // Recur for next node
    }
    // Reverse A link List 
    public void Reverse(){
        Node prev = null;
        Node curr = tail =head;
        Node next;
        while (curr != null) {
            next =curr.next;
            curr.next = prev;
            prev = curr;
            curr=next;
        }
        head =prev;
    }
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addlast(3);
        ll.addlast(4);
        
        // ll.add(2, 9);
        // System.out.println(ll.itersearch(4));
        // System.out.println(ll.itersearch(9));/
    //   System.out.println(ll.recursiveSearchHelper(ll.head, 4, 0));
    ll.printList();
    ll.Reverse();
        ll.printList(); // Corrected print statement////
    }
}
