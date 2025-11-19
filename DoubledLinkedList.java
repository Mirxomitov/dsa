// Tohir Mirxomitov
// 19.11.2025

// Before DoubledLinkedList lets implement LinkedList
// LinkedList.java

public class DoubledLinkedList {
    private class Node {
        Node prev;
        Node next;
        int value;

        Node(int value, Node prev, Node next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    Node head;
    Node tail;

    public void appendFront(int value) {
        if (head == null) {
            head = new Node(value, null, null);
            tail = head;
            return;
        }

        head.prev = new Node(value, null, head);
        head = head.prev;
    }

    public void appendRear(int value) {
        if (head == null) {
            head = new Node(value, null, null);
            tail = head;
            return;
        }
        
        tail.next = new Node(value, tail, null);
        tail = tail.next;
    }

    public int popFront() {
        int result = head.value;
       
        if (head == tail) {
            head = null;
            tail = null;
            return result;
        }

        head = head.next;
        head.prev = null;
        return result;
    }

    public int popRear() {
        int result = tail.value;

        if (head == tail) {
            head = null;
            tail = null;
            return result;
        }

        tail = tail.prev;
        tail.next = null;
        return result;
    }

    public int peekFront() {
        int result = head.value;
        return result;
    }

    public int peekRear() {
        int result = tail.value;
        return result;
    }

     @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node dNode = head;

        while (dNode != null) {
            sb.append(dNode.value).append(" ");
            dNode = dNode.next;
        }

        return sb.toString();
    }
}

class DoubledLinkedListTest {
    public static void main(String[] args) {
        DoubledLinkedList dll = new DoubledLinkedList();

        // Test appendFront / appendRear
        dll.appendFront(10);
        dll.appendRear(20);
        dll.appendFront(5);
        System.out.println(dll); // 5 10 20

        // Test peek
        System.out.println(dll.peekFront()); // 5
        System.out.println(dll.peekRear());  // 20

        // Test pop
        System.out.println(dll.popFront()); // 5
        System.out.println(dll.popRear());  // 20
        System.out.println(dll);            // 10

        // Pop last element
        System.out.println(dll.popFront()); // 10
        System.out.println(dll);            // (empty)

        //Exception
        dll.popFront();
    }
}
