package com.dmitrii.karger;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class GraphMinCutTest {

    @Test
    void findMinCut() {
        Graph graph = graphFromFile("kargerMinCut.txt", 200);

        GraphMinCut service = new GraphMinCut();

        long startTime = System.currentTimeMillis();
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < 100; i++) {
            result = Math.min(result, service.findMinCut(graph));
        }
        long finishTime = System.currentTimeMillis();
        System.out.println("Time: " + (finishTime - startTime));
        System.out.println("Result: " + result);
        Assertions.assertEquals(result, 17);
    }

    static Graph graphFromFile(String fileName, int size) {
        Graph graph = new Graph(size);
        try (Scanner rowReader = new Scanner(new File("./src/test/resources/" + fileName))) {
            while (rowReader.hasNextLine()) {
                Scanner colReader = new Scanner(rowReader.nextLine());
                int current = 0;
                int first = -1;
                while (colReader.hasNextInt()) {
                    if (current == 0) {
                        first = colReader.nextInt();
                        graph.addVertex(first);
                    } else {
                        graph.addEdge(new Edge(first, colReader.nextInt()));
                    }
                    current++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return graph;
    }
}