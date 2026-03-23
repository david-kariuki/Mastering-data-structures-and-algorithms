package dk.learning.graphs.custom_graph;

/**
 * Directed Graph
 */
public class Edge {

    private Vertex start;
    private Vertex end;
    private Integer weight; // Cost - How much it takes to move from one place to another

    public Edge(Vertex start, Vertex end, Integer weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    public Vertex getStart() {
        return this.start;
    }

    public Vertex getEnd() {
        return this.end;
    }

    public Integer getWeight() {
        return this.weight;
    }
}
