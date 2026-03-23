package dk.learning.graphs.custom_graph;

import java.util.ArrayList;

public class Main {

    private static boolean isWeighted = true;
    private static boolean isDirected = false;

    public static void main(String[] args) {

        // Create Graph / Bus Network
        Graph nairobiBusNetwork = new Graph(isWeighted, isDirected);

        // Add vertex / Bus Station
        Vertex westLandsStation = nairobiBusNetwork.addVertex("Westlands");
        Vertex cbdStation = nairobiBusNetwork.addVertex("CBD Kenkom");

        // Add Edges / Bus Routes
        int weight = 5; // 5 KM
        nairobiBusNetwork.addEdge(westLandsStation, cbdStation, weight);

        nairobiBusNetwork.print();

        // Graph Traversal
        TestGraph test = new TestGraph();
        Vertex startingVertex = test.getStartingVertex();
        ArrayList<Vertex> visitedVertices1 = new ArrayList<Vertex>();
        ArrayList<Vertex> visitedVertices2 = new ArrayList<Vertex>();
        visitedVertices1.add(startingVertex);
        visitedVertices2.add(startingVertex);

        System.out.println("\nDFS:");
        GraphTraverser.depthFirstSearch(startingVertex, visitedVertices1);

        System.out.println("\nBFS:");
        GraphTraverser.breadthFirstSearch(startingVertex, visitedVertices2);
    }
}
