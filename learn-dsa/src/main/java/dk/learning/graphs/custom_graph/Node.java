package dk.learning.graphs.custom_graph;

public class Node {

    public Vertex data;
    private Node next;

    public Node(Vertex data) {
        this.data = data;
        this.next = null;
    }

    public Node getNextNode() {
        return this.next;
    }

    public void setNextNode(Node node) {
        this.next = node;
    }
}