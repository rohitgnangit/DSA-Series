// Total LinkedList Operations

// OUTPUT :
// A->B->C->D->E (Print LinkedList)
// 5            (Length of Linked List)
// 3            (Search Key in LL)
// A->B->C->DD->E   (Update value in LL)
// A->B->C->DD->E->f    (Add new node at End)
// a->A->B->C->DD->E->f     (Add new node at Begining)
// a->A->B->c->C->DD->E->f      (Add new node at Middle)
// A->B->c->C->DD->E->f     (Delete node at Begining)
// A->B->c->C->DD->E    (Delete node at End)
// A->B->C->DD->E   (Delete node at Middle)

class Node {
    String data;
    Node next;
    Node (String data) {
        this.data = data;
        this.next = null;
    }
}
class Main {
    static Node head;
    // Print LinkedList
    public static void printLL() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) {
                System.out.print("->");
            }
            temp = temp.next; 
        }
        System.out.println();   // for going to next line
    }
    // Length of Linked List
    public static int lengthLL() {
        Node temp = head;
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }
    // Search Key in LL
    public static int search(String key) {
        Node temp = head;
        int i = 0;
        while(temp != null) {
            if(temp.data.equals(key)) {
                return i;
            }
            i++;
            temp = temp.next;
        }
        return -1;
    }
    // Update value in LL
    public static void update(int index, String newVal) {
        Node temp = head;
        int i = 0;
        while(temp != null) {
            if(i == index) {
                temp.data = newVal;
            }
            i++;
            temp = temp.next;
        }
    }
    // Add new node at End
    public static void addAtEnd(String newData) {
        Node newNode = new Node(newData);
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }
    // Add new node at Begining
    public static void addAtBegining(String newData) {
        Node newNode = new Node(newData);
        newNode.next = head;
        head = newNode;
    }
    // Add new node at Middle
    public static void addAtMiddle(String newData, int index) {
        Node newNode = new Node(newData);
        Node temp = head;
        for(int i = 0; i < index-1; i++) {
            temp = temp.next;
        }
        Node after = temp.next;
        temp.next = newNode;
        newNode.next = after;
    }
    
    // Delete node at Begining
    public static void deleteAtBegining() {
        // EdgeCase-1: If no elements in LL
        if(head == null) return;
        // More than one element
        head = head.next;
    }
    // Delete node at End
    public static void deleteAtEnd() {
        Node temp = head;
        // EdgeCase-1: If no elements in LL
        if(temp == null) return;
        // EdgeCase-2: If only one element in LL
        if(temp.next == null) head = null;
        // More than one element in LL 
        while(temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
    }
    // Delete node at Middle
    public static void deleteAtMiddle(int index) {
        // EdgeCase-1: If index is 0
        if(index == 0) {
            deleteAtBegining();
            return;
        }
        // EdgeCase-2: If head is null
        if(index < 0 && head == null) return;
        // More than one element in LL
        Node temp = head;
        for(int i = 0; i < index-1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }
    public static void main(String[] args) {
        // Data for nodes
        Node node1 = new Node("A");
        Node node2 = new Node("B");
        Node node3 = new Node("C");
        Node node4 = new Node("D");
        Node node5 = new Node("E");
        // Connecting nodes
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        // Initializing Head as node1
        head = node1;
        
        // Print LL
        printLL();
        // Length of LL
        System.out.println(lengthLL());
        // Search Key in LL
        System.out.println(search("D"));
        // Update new value in LL
        update(3, "DD");
        printLL();
        // Add node at End
        addAtEnd("f");
        printLL();
        // Add node at Begining
        addAtBegining("a");
        printLL();
        // Add node at Middle
        addAtMiddle("c", 3);
        printLL();
        // Delete node at Begining
        deleteAtBegining();
        printLL();
        // Delete node at End
        deleteAtEnd();
        printLL();
        // Delete node at Middle
        deleteAtMiddle(2);
        printLL();
        
    }
}
