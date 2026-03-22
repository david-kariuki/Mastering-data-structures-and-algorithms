package dk.learning;

/**
 * Middle of a Linked List
 *
 * <p>Find the middle node of a singly linked list.</p>
 * <p>If the number of nodes is odd, return the exact middle node.</p>
 * <p>If the number of nodes is even, return the second middle node.</p>
 *
 * <p><b>Examples:</b></p>
 *
 * <pre>
 * Input:  0 → 1 → 2 → 3 → 4
 * Output: 2
 *
 * Input:  0 → 1 → 2 → 3 → 4 → 5
 * Output: 3
 * </pre>
 *
 * @author David Kariuki
 */
public class MiddleOfLinkedList {

    public static void main(String[] args) {
        Node head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(4);
        //head.next.next.next.next.next = new Node(5);

        System.out.println(middleOfLinkedList(head)); // 2
    }

    public static int middleOfLinkedList(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow.value;
    }

    private static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }
}
