package dk.learning.linked_list.singly;

public class Main {

    public static void main(String[] args) {

        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.create(5);

        System.out.print("Head value : " + singlyLinkedList.head.value);

        singlyLinkedList.insert(6, 1);
        System.out.print("\n\nInserted Head value : " + singlyLinkedList.head.value);


        singlyLinkedList.insert(7, 3);
        System.out.print("\n\nInserted value : " + singlyLinkedList.head.next.next.value);

        singlyLinkedList.insert(8, 4);
        singlyLinkedList.insert(9, 0);

        System.out.print("\nTraversing LinkedList");
        singlyLinkedList.traverse();

        System.out.print("\n\nSearching LinkedList");
        singlyLinkedList.search(8);

        int locationToDelete = 4;
        System.out.println("\n\nDeleting value at location " + locationToDelete);
        System.out.print("Before delete -> ");
        singlyLinkedList.traverse();
        singlyLinkedList.deleteAtLocation(locationToDelete);
        singlyLinkedList.traverse();

        System.out.println("\n\nBefore deleting LinkedList");
        singlyLinkedList.traverse();
        System.out.println("After deleting LinkedList");
        singlyLinkedList.delete();

    }
}
