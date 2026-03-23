package dk.learning.linked_list.singly;

/**
 * Singly Linked List is a linear data structure where each element (called a node) contains a value and a reference
 * (or pointer) to the next node in the sequence. The last node in the list points to null, indicating the end of
 * the list.
 * Singly linked lists allow for efficient insertion and deletion of elements, as they do not require contiguous
 * memory allocation like arrays. However, they do not support backward traversal, as each node only has a reference
 * to the next node.
 *
 * @author David Kariuki
 */
@SuppressWarnings("ALL")
public class SinglyLinkedList {

    public Node head;
    public Node tail;
    public int size = 0;

    /**
     * Creates a new singly linked list with a single node containing the specified value. The head and tail of the
     * list are both set to this new node, and the size of the list is initialized to 1.
     *
     * @param nodeValue Value
     * @return Node
     * Time Complexity: O(1) - The method performs a constant number of operations, regardless of the size of the list.
     * Space Complexity: O(1) - The method uses a constant amount of additional space to create a new node and update
     * the list's head, tail, and size.
     */
    public Node create(int nodeValue) {
        Node node = new Node();     // ---------- O(1)
        node.value = nodeValue;     // ---------- O(1)
        node.next = null;           // ---------- O(1)

        head = node;                // ---------- O(1)
        tail = node;                // ---------- O(1)

        size = 1;                   // ---------- O(1)
        return head;                // ---------- O(1)
    }

    /**
     * Inserts a new node with the specified value at the given location in the linked list.
     * <p>
     * The method checks if the linked list is empty before attempting to insert, and if so, it creates a new singly
     * linked list with the provided value
     * <p>
     * The method handles three
     * cases:
     * 1. Inserting at the beginning of the list (location 0): The new node becomes the new head, and its next
     * reference points to the old head.
     * 2. Inserting at the end of the list (location greater than the current size): The new node becomes the new tail,
     * and the old tail's next reference points to the new node.
     * 3. Inserting at a specific location in the middle of the list: The method traverses the list to find the node at
     * the specified location, updates the next references to insert the new node in the correct position.
     * <p>
     * For middle insertion:
     * Find node before insertion point,
     * Save the next node,
     * Connect previous node to new node,
     * Connect new node to saved next node.
     * <p>
     * Time Complexity: O(n) in the worst case, where n is the location at which the new node is being inserted.
     * Inserting at the beginning or end of the list has a time complexity of O(1).
     * <p>
     * Space Complexity: O(1) - The method uses a constant amount of additional space to create a new node and update
     * the list's head, tail, and size.
     *
     * @param nodeValue
     * @param location
     */
    public void insert(int nodeValue, int location) {

        Node node = new Node();                     // --------- O(1)
        node.value = nodeValue;                     // --------- O(1)

        if (head == null) {
            create(nodeValue);                      // --------- O(1)
            return;                                 // --------- O(1)
        } else if (location == 0) {
            // Inserting at beginning of LinkedList
            node.next = head;                       // --------- O(1)
            head = node;                            // --------- O(1)
        } else if (location >= size) {
            // Inserting at the end of the LinkedList
            node.next = null;                       // --------- O(1)
            tail.next = node;                       // --------- O(1)
            tail = node;                            // --------- O(1)
        } else {
            // Inserting at a specific location in the LinkedList
            Node tempNode = head;                   // --------- O(1)
            int index = 0;                          // --------- O(1)

            while (index < location - 1) {          // --------- O(n) in worst case, where n is the location
                tempNode = tempNode.next;           // --------- O(1)
                index++;                            // --------- O(1)
            }

            Node nextNode = tempNode.next; // Save the next node            --------- O(1)
            node.next = nextNode; // Link new node to the old next node     --------- O(1)
            tempNode.next = node; // Link current node to new node          --------- O(1)
        }

        size++; // Increase LinkedList size
    }

    /**
     * Traverses the linked list and prints the value of each node in a formatted manner. The method starts from the head
     * node and iterates through the list until it reaches the end (null). It prints the values of the nodes in a format
     * like [value1 -> value2 -> value3], where each node's value is separated by an arrow (->). If the linked list is
     * empty (i.e., head is null), it prints a message indicating that the linked list is empty.
     * <p>
     * Time Complexity: O(n), where n is the size of the linked list, because it needs to traverse through all the
     * nodes to print their values.
     * Space Complexity: O(1), as the method uses a constant amount of additional space for temporary variables,
     * regardless
     */
    public void traverse() {

        // Check for head otherwise terminate
        if (head == null) {
            System.out.println("Head not found. LinkedList is empty!");
            return;
        } else {

            Node tempNode = head; // Start from head node  ---------- O(1)
            System.out.print("[");                  // ----------- O(1)
            for (int i = 0; i < size; i++) {        // ----------- O(n) where n is the size of the linked list

                System.out.print(tempNode.value);   // ----------- O(1)

                // Don't print arrow after last node
                if (i < size - 1) {
                    System.out.print(" -> ");       // ----------- O(1)
                }

                // Move to next node
                tempNode = tempNode.next;           // ---------- O(1)
            }
        }
        System.out.print("]\n");                    // ----------- O(1)
    }

    /**
     * Searches for a node with the specified value in the linked list.
     * <p>
     * The method starts from the head node and iterates through the list, comparing each node's value with the
     * target value (nodeValue). If a node with the specified value is found, it prints a message indicating the value
     * and its index in the list,  and returns true.
     * <p>
     * If the method reaches the end of the list without finding the value, it prints a message indicating that the
     * head was not found and returns false. If the linked list is empty (i.e., head is null), it also prints a
     * message indicating that the linked list is empty and returns false.
     *
     * @param nodeValue
     * @return boolean
     * <p>
     * Time Complexity: O(n), where n is the size of the linked list, because in the worst case, it may need to
     * traverse through all the nodes to find the target value or determine that it is not present in the list.
     * Space Complexity: O(1), as the method uses a constant amount of additional space for temporary variables,
     * regardless of the size of the linked list.
     */
    public boolean search(int nodeValue) {

        if (head == null) { // Check for head otherwise terminate
            System.out.println("Head not found. LinkedList is empty!");     // ----------- O(1)
            return false;                                                   // ----------- O(1)
        } else {

            Node tempNode = head;                                           // ----------- O(1)
            for (int i = 0; i < size; i++) {                                // ----------- O(N)

                if (tempNode.value == nodeValue) {                          // ----------- O(1)
                    System.out.print("Value  found at index " + i);         // ----------- O(1)
                    return true;                                            // ----------- O(1)
                }
                tempNode = tempNode.next;                                   // ----------- O(1)
            }
        }

        System.out.println("Head not found!");                              // ----------- O(1)
        return false;                                                       // ----------- O(1)
    }

    /**
     * Deletes a node at the specified location in the linked list.
     * <p>
     * The method handles three cases:
     * 1. Deleting the head node (location 0): The head is updated to point to the next node. If the list becomes
     * empty after deletion, the tail is also set to null.
     * 2. Deleting the last node (location greater than or equal to the current size): The method traverses the list
     * to find the second-to-last node, updates its next reference to null, and updates the tail to point to this node.
     * If the list becomes empty after deletion, both head and tail are set to null.
     * 3. Deleting a node at a specific location in the middle of the list: The method traverses the list to find the
     * node just before the specified location, updates its next reference to skip the node being deleted, effectively
     * removing it from the list.
     * <p>
     * The method also checks if the linked list is empty before attempting to delete, and if so, it prints a message
     * indicating that the linked list is empty and returns without performing any deletion.
     * <p>
     * Time Complexity: O(n) in the worst case, where n is the location of the node being deleted. Deleting the head
     * node has a time complexity of O(1), while deleting the last node or a node in the middle requires traversing
     * the list, resulting in O(n).
     * Space Complexity: O(1), as the method uses a constant amount of additional space for temporary variables,
     * regardless of the size of the linked list.
     *
     * @param location
     */
    public void deleteAtLocation(int location) {

        System.out.println("Deleting node at index " + location);

        if (head == null) {                                                  // ----------- O(1)
            System.out.println("Head not found. LinkedList is empty!");      // ----------- O(1)
            return;                                                          // ----------- O(1)
        } else if (location == 0) {                                          // ----------- O(1)
            head = head.next;                                                // ----------- O(1)

            // In case we have only one node in the LinkedList, we need to update tail as well
            if (size == 1) {                                                 // ----------- O(1)
                tail = null;                                                 // ----------- O(1)
            }
        } else if (location >= size) { // Deleting last node                 // ----------- O(1)
            Node tempNode = head;                                            // ----------- O(1)
            for (int i = 0; i < size - 2; i++) {                             // ----------- O(N)
                tempNode = tempNode.next;                                    // ----------- O(1)
            }

            // In case we have only one node in the LinkedList, we need to update head as well
            if (tempNode == head) {                                          // ----------- O(1)
                tail = head = null; // Update head and tail to null if we are deleting the only node in the LinkedList
                size--;                                                      // ----------- O(1)
                return;                                                      // ----------- O(1)
            }
            tempNode.next = null;                                            // ----------- O(1)
            tail = tempNode;                                                 // ----------- O(1)
            size--;                                                          // ----------- O(1)
        } else { // Deleting node at specific location in the middle of the LinkedList
            Node tempNode = head;                                            // ----------- O(1)
            for (int i = 0; i < location - 1; i++) {                         // ----------- O(N)
                tempNode = tempNode.next;                                    // ----------- O(1)
            }
            tempNode.next = tempNode.next.next;                              // ----------- O(1)
            size--;                                                          // ----------- O(1)
        }
    }

    /**
     * Deletes the entire linked list by setting the head and tail references to null. This effectively removes all
     * nodes from the list, allowing for garbage collection to reclaim the memory used by the nodes.
     * <p>
     * The method also checks if the linked list is empty before attempting to delete, and if so, it simply returns
     * without performing any deletion.
     * Time complexity: O(1) - The method performs a constant number of operations, regardless of the size of the
     * linked list.
     * Space complexity: O(1) - The method uses a constant amount of additional space to update the head and tail
     * references.
     */
    public void delete() {
        // Check for head otherwise terminate
        if (head == null) {     // --------- O(1)
            return;             // --------- O(1)
        }
        head = tail = null;     // --------- O(1)
        size = 0;               // --------- O(1)
        System.out.println("Deleted Linked List. Size : " + size);
    }
}
