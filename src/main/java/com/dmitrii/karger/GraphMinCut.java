package com.dmitrii.karger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GraphMinCut {

    public int findMinCut(Graph input) {
        Graph graph = input.copyGraph();
        Random random = new Random();

        for (int countVertices = graph.getVertices().size(); countVertices > 2; countVertices--) {
            Edge removed = graph.getEdges().remove(random.nextInt(graph.getEdges().size()));
            List<Edge> forRemove = new ArrayList<>(countVertices);
            for (Edge edge : graph.getEdges()) {
                edge.merge(removed.getFirst(), removed.getSecond());
                if (edge.isLoop()) {
                    forRemove.add(edge);
                }
            }
            graph.getEdges().removeAll(forRemove);
        }
        return graph.getEdges().size();
    }
}



