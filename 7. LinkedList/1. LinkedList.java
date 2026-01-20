// Total LinkedList Operations

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
    }
}