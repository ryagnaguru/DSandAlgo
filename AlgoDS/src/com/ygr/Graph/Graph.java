package com.ygr.Graph;

import java.util.*;
import java.util.stream.Collectors;

public class Graph {

    Map<String, List<String>> graph = new HashMap<>();

    public static void main(String[] args) {

        Graph graph = new Graph();
        graph.addVertices("a");
        graph.addVertices("b");
        graph.addVertices("c");
        graph.addVertices("d");
        graph.addVertices("e");
        graph.addVertices("f");
        System.out.println(graph.graph);
        graph.createEdges("a", "b");
        graph.createEdges("a", "c");
        graph.createEdges("b", "e");
        graph.createEdges("c", "f");
        graph.createEdges("c", "d");
        graph.createEdges("d", "f");
        graph.createEdges("d", "e");
        graph.createEdges("f", "e");
        System.out.println(graph.graph);

        graph.bfs("a");
        graph.dfs("a");
//        graph.removeEdge("chennai", "salem");
//        System.out.println(graph.graph);
//        graph.removeVertex("madurai");
//        System.out.println(graph.graph);

    }

    void bfs(String vertex) {
        Map<String, Boolean> visited = new HashMap<>();
        Queue<String> values = new LinkedList<>();
        List<String> data = new ArrayList<>();

        values.offer(vertex);
        visited.put(vertex, true);

        while (!values.isEmpty()) {
            String currentVertex = values.poll();
            data.add(currentVertex);
            this.graph.get(currentVertex).forEach(ver -> {
                if (!visited.containsKey(ver)) {
                    values.add(ver);
                    visited.put(ver, true);
                }
            });
        }
        System.out.println("bfs" + data);
    }

    void dfs(String vertex) {
        Map<String, Boolean> visited = new HashMap<>();
        Stack<String> values = new Stack<>();
        List<String> data = new ArrayList<>();

        values.push(vertex);
        visited.put(vertex, true);

        while (!values.isEmpty()) {
            String currentVertex = values.pop();
            data.add(currentVertex);
            this.graph.get(currentVertex).forEach(ver -> {
                if (!visited.containsKey(ver)) {
                    values.push(ver);
                    visited.put(ver, true);
                }
            });
        }
        System.out.println(" dfs " + data);
    }

    void addVertices(String vertex) {
        if (!graph.containsKey(vertex)) {
            graph.put(vertex, new ArrayList<>());
        }
    }

    void createEdges(String from, String to) {
        if (graph.containsKey(from) && graph.containsKey(to)) {
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
    }

    void removeEdge(String from, String to) {
        List<String> fromList = this.graph.get(from);
        List<String> toList = this.graph.get(to);
        fromList = fromList.stream().filter(fr -> !fr.equalsIgnoreCase(to)).collect(Collectors.toList());
        toList = toList.stream().filter(t -> !t.equalsIgnoreCase(from)).collect(Collectors.toList());
        this.graph.put(from, fromList);
        this.graph.put(to, toList);
    }

    void removeVertex(String vertex) {
        if (this.graph.containsKey(vertex)) {
            this.graph.get(vertex).forEach(ver -> removeEdge(ver, vertex));
            this.graph.remove(vertex);
        }
    }

}
