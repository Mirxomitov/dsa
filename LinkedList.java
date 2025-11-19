// Tohir Mirxomitov 
// 19.11.2025

public class LinkedList {
    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    Node head;
    Node tail;

    public void add(int value) {
        if (head == null) {
            head = new Node(value);
            tail = head;
            return;
        }

        if (tail != null) {
            Node newNode = new Node(value);
            tail.next = newNode;
            tail = newNode;
        }
    }

    public int pop() {
        int result = tail.value;

        if (head == tail) {
            head = null;
            tail = null;
            return result;
        }

        Node dNode = head;

        while (dNode.next != tail) {
            dNode = dNode.next;
        }

        tail = dNode;
        tail.next = null;

        return result;
    }

    public int peek() {
        return tail.value;
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

class LinkedListTest {
    public static void main(String[] args) {
        LinkedList ls = new LinkedList();
        ls.add(0);
        ls.add(1);
        ls.add(2);
        ls.add(3);
        ls.add(4);

        System.out.println(ls.pop());
    }
}