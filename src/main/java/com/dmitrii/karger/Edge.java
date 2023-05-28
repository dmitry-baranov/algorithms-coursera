package com.dmitrii.karger;

class Edge {
    private int first;
    private int second;

    public Edge(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    public void merge(int removed, int remaining) {
        if (first == remaining) {
            first = removed;
        }
        if (second == remaining) {
            second = removed;
        }
    }

    public boolean isLoop() {
        return first == second;
    }

    public Edge clone() {
        return new Edge(first, second);
    }
}