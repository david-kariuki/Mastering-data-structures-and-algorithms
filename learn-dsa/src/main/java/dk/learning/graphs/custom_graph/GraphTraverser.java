package dk.learning.graphs.custom_graph;

import java.util.ArrayList;

public class GraphTraverser {

    public static void depthFirstSearch(Vertex startVertex, ArrayList<Vertex> visitedVertices) {
        System.out.println("Start vertex data : " + startVertex.getData());

        // Iterate through edges of start vertex and for each edge get neighbour vertex, check if it has not been
        // visited before, if not add it to visited vertices list and recursively call depth first traversal with
        // neighbour vertex as start vertex
        for (Edge edge : startVertex.getEdges()) {
            Vertex neighbour = edge.getEnd(); // Get neighbour vertex from edge

            // Check if neighbour vertex has not been visited before, if not add it to visited vertices list and
            // recursively
            if (!visitedVertices.contains(neighbour)) {
                visitedVertices.add(neighbour); // Add neighbour vertex to visited vertices list
                GraphTraverser.depthFirstSearch(neighbour, visitedVertices); // Recursively call depth first traversal with neighbour vertex as start vertex
            }
        }
    }

    public static void breadthFirstSearch(Vertex startVertex, ArrayList<Vertex> visitedVertices) {

        Queue visitQueue = new Queue();
        visitQueue.enqueue(startVertex);

        // Iterate through visit queue until it is empty, for each vertex in visit queue print its data and add its
        // unvisited neighbour vertices to visited vertices list and visit queue
        while (!visitQueue.isEmpty()) {
            Vertex current = visitQueue.dequeue(); // Get vertex to visit from queue
            System.out.println(current.getData());

            // Iterate through edges of current vertex and add unvisited neighbour vertices to visited vertices list
            // and visit queue
            for (Edge edge : current.getEdges()) {
                Vertex neighbour = edge.getEnd(); // Get neighbour vertex from edge

                // Check if neighbour vertex has not been visited before, if not add it to visited vertices list and
                // visit queue
                if (!visitedVertices.contains(neighbour)) {
                    visitedVertices.add(neighbour); // Add neighbour vertex to visited vertices list
                    visitQueue.enqueue(neighbour);  // Add neighbour vertex to visit queue
                }
            }
        }
    }
}
