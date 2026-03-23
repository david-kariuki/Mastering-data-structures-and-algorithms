package dk.learning.graphs.custom_graph;

import java.util.ArrayList;

public class Graph {

    private ArrayList<Vertex> vertices;
    private boolean isWeighted = true;
    private boolean isDirected = true;

    public Graph(boolean isWeighted, boolean isDirected) {
        this.vertices = new ArrayList<>();
        this.isWeighted = isWeighted;
        this.isDirected = isDirected;
    }

    public void addEdge(Vertex startVertex, Vertex endVertex, Integer weight) {
        if (!this.isWeighted) {
            weight = null;
        }

        startVertex.addEdge(endVertex, weight);

        if (!isDirected) {
            endVertex.addEdge(startVertex, weight);
        }
    }

    public void removeEdge(Vertex startVertex, Vertex endVertex) {
        startVertex.removeEdge(endVertex);
        if (!isDirected) {
            endVertex.removeEdge(startVertex);
        }
    }

    public Vertex addVertex(String data) {
        Vertex vertex = new Vertex(data);
        this.vertices.add(vertex);
        return vertex;
    }

    public void removeVertex(Vertex vertex) {
        this.vertices.remove(vertex);
    }

    public ArrayList<Vertex> getVertices() {
        return vertices;
    }

    public boolean isWeighted() {
        return isWeighted;
    }

    public boolean isDirected() {
        return isDirected;
    }

    public Vertex getVertexByValue(String value) {
        for (Vertex vertex : this.vertices) {
            if (vertex.getData().equals(value)) {
                return vertex;
            }
        }
        return null;
    }

    public void print() {
        for (Vertex vertex : this.vertices) {
            vertex.print(isWeighted);
        }
    }
}
