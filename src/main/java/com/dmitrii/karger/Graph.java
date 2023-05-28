package com.dmitrii.karger;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Graph {

    private final Set<Integer> vertices;

    private final List<Edge> edges;

    public Graph(int countVertices) {
        this.vertices = new HashSet<>(countVertices);
        this.edges = new ArrayList<>(countVertices * countVertices);
    }

    public Graph(Set<Integer> vertices, List<Edge> edges) {
        this.vertices = vertices;
        this.edges = edges;
    }

    public void addVertex(Integer vertex) {
        vertices.add(vertex);
    }

    public void addEdge(Edge input) {
        boolean isExist = false;
        for (Edge edge : edges) {
            if (edge.getFirst() == input.getFirst() && edge.getSecond() == input.getSecond()
                    || edge.getFirst() == input.getSecond() && edge.getSecond() == input.getFirst()) {
                isExist = true;
                break;
            }
        }
        if (!isExist) {
            edges.add(input);
        }
    }

    public Set<Integer> getVertices() {
        return vertices;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public Graph copyGraph() {
        Set<Integer> verticesClone = new HashSet<>(this.vertices);
        List<Edge> edgesClone = this.edges.stream().map(Edge::clone).collect(Collectors.toList());
        return new Graph(verticesClone, edgesClone);
    }
}