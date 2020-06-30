package com.ygr.Graph;

import java.util.*;

public class Dijkstra {

    Map<String, Set<Node>> graph = new HashMap<>();

    public static void main(String[] args) {
        Dijkstra dijkstra = new Dijkstra();
        dijkstra.addVertices("a");
        dijkstra.addVertices("b");
        dijkstra.addVertices("c");
        dijkstra.addVertices("d");
        dijkstra.addVertices("e");
        dijkstra.addVertices("f");

        dijkstra.addEdges("a", "b", 4);
        dijkstra.addEdges("a", "c", 2);
        dijkstra.addEdges("b", "e", 3);
        dijkstra.addEdges("c", "d", 2);
        dijkstra.addEdges("c", "f", 4);
        dijkstra.addEdges("d", "e", 3);
        dijkstra.addEdges("d", "f", 1);
        dijkstra.addEdges("f", "e", 1);
        System.out.println(dijkstra.graph);
        dijkstra.dijikstras("c", "e");

    }

    void dijikstras(String start, String end) {
        Queue<Node> nodes = new PriorityQueue<>((o1, o2) -> o1.weightage.compareTo(o2.weightage));
        Map<String, Integer> distance = new HashMap<>();
        this.graph.keySet().forEach(src -> {
            distance.put(src, src.equalsIgnoreCase(start) ? 0 : Integer.MAX_VALUE);
            if (src.equalsIgnoreCase(start)) {
                nodes.offer(new Node(src, 0));
            } else {
                nodes.offer(new Node(src, Integer.MAX_VALUE));
            }
        });
        System.out.println(distance);
        Map<String, String> previous = new HashMap<>();
        int i = 0;
        while (!nodes.isEmpty()) {
            i++;
            Node src = nodes.poll();
            if (src.value.equalsIgnoreCase(end)) {
                break;
            }
            Set<Node> neighbours = this.graph.get(src.value);
            neighbours.forEach(neigh -> {
                Integer sum = distance.get(src.value) + neigh.weightage;
                if (distance.get(neigh.value) > sum) {
                    distance.put(neigh.value, sum);
                    previous.put(neigh.value, src.value);
                    nodes.offer(neigh);
                }
            });
        }

        System.out.println(distance);
        System.out.println(previous);
        System.out.println(i);

    }

    void addVertices(String values) {
        if (!this.graph.containsKey(values)) {
            this.graph.put(values, new HashSet<>());
        }
    }

    void addEdges(String from, String to, int weightage) {
        this.graph.get(from).add(new Node(to, weightage));
    }

    class Node {
        String value;
        Integer weightage;

        @Override
        public String toString() {
            return "Node{" +
                    "value='" + value + '\'' +
                    ", weightage=" + weightage +
                    '}';
        }

        Node(String value, int weightage) {
            this.value = value;
            this.weightage = weightage;
        }
    }
}