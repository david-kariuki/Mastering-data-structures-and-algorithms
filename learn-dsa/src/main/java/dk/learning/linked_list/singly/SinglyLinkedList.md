# Singly Linked List

## What is a Singly Linked List

A singly linked list is a linear data structure where each element (node) contains:

- a value (data)
- a reference (pointer) to the next node

The last node points to `null`, indicating the end of the list.

---

## Node Structure

```java
class Node {
    int value;
    Node next;
}
```

---

## Key Components

- Head → first node in the list
- Tail → last node in the list
- Size → number of nodes in the list

---

## Key Properties

- Dynamic size
- Efficient insertion and deletion
- No random access (must traverse)

---

## Memory Insight

Nodes are not stored sequentially.

```
Head → 1 → 2 → 4 → 5 → null
```

Each node points to the next node using references.

---

# Creation of Singly Linked List

## Idea

- Create a node
- Set head and tail to that node
- Set size to 1

---

## Code

```java
Node node = new Node();
node.value =value;
node.next =null;

head =node;
tail =node;
size =1;
```

---

## Time Complexity

O(1)

---

## Space Complexity

O(1)

---

# Insertion in Singly Linked List

## High-Level Flow

```
Create Node → Check if empty → Insert at head / tail / middle
```

---

## 1. Insert at Beginning

```java
node.next =head;
head =node;
```

Time Complexity: O(1)

---

## 2. Insert at End

```java
node.next =null;
tail.next =node;
tail =node;
```

Time Complexity:

- O(1) with tail pointer
- O(n) without tail

---

## 3. Insert in Middle

```java
Node tempNode = head;

for(
int i = 0;
i<location -1;i++){
tempNode =tempNode.next;
}

Node nextNode = tempNode.next;
node.next =nextNode;
tempNode.next =node;
```

---

## Key Insight (Insertion)

- No shifting like arrays
- Only pointer updates
- Order matters:
    - Set node.next first
    - Then update tempNode.next

---

# Traversal

## Code

```java
Node tempNode = head;

while(tempNode !=null){
        System.out.

println(tempNode.value);

tempNode =tempNode.next;
}
```

Time Complexity: O(n)

---

# Search

## Code

```java
Node tempNode = head;

while(tempNode !=null){
        if(tempNode.value ==value){
        return true;
        }
tempNode =tempNode.next;
}

        return false;
```

Time Complexity: O(n)

---

# Deletion in Singly Linked List

## 1. Delete at Beginning

```java
head =head.next;

if(size ==1){
tail =null;
        }
```

Time Complexity: O(1)

---

## 2. Delete at End

```java
Node tempNode = head;

for(
int i = 0;
i<size -2;i++){
tempNode =tempNode.next;
}

tempNode.next =null;
tail =tempNode;
```

Time Complexity: O(n)

---

## 3. Delete in Middle

```java
Node tempNode = head;

for(
int i = 0;
i<location -1;i++){
tempNode =tempNode.next;
}

tempNode.next =tempNode.next.next;
```

---

## Key Insight (Deletion)

```
prev → target → next
becomes
prev → next
```

---

## 4. Delete Entire Linked List

```java
head =null;
tail =null;
size =0;
```

Time Complexity: O(1)

---

# Time Complexity Summary

| Operation       | Time Complexity |
|-----------------|-----------------|
| Create          | O(1)            |
| Insert (head)   | O(1)            |
| Insert (tail)   | O(1)            |
| Insert (middle) | O(n)            |
| Traverse        | O(n)            |
| Search          | O(n)            |
| Delete (head)   | O(1)            |
| Delete (tail)   | O(n)            |
| Delete (middle) | O(n)            |

---

# Space Complexity

O(1) (excluding storage for nodes)

---

# Interview Thinking

When solving linked list problems, think:

- Is this pointer manipulation?
- Do I need the previous node?
- Am I breaking the chain?
- What happens at head and tail?

---

# Core Patterns

- Insert = reconnect links
- Delete = skip node
- Traverse = move step by step

---

# Important Edge Cases

- Empty list
- Single node list
- Insert at head
- Insert at tail
- Delete head
- Delete tail

---

# Final Takeaway

- Linked lists trade fast insertion/deletion for slow access
- Most problems revolve around pointer handling
- Pointer order is critical
- Think in links, not values