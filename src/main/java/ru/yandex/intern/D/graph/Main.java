package ru.yandex.intern.D.graph;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int graphCounter = 0;

        while (graphCounter < 1) {
            Graph graph = new Graph();
            for (int i = 1; i <= n; i++) {
                graph.addVertex(Character.forDigit(i, 10));
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        graph.addEdge(i, j);
                    }
                }
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        if (i != j && i != k && j != k)
                            graph.addEdge(j, k);
                    }
                }
            }
            graph.bfc();
            graphCounter++;
        }
//        int result = 0;
//        for (int i = 1; i <= n; i++) {
//            int ribs = 0;
//            int anotherRibs = 0;
//            for (int j = 1; j <= n; j++) {
//                if (i != j && ribs < n) {
//                    ribs++;
//                }
//                else if (ribs == n)
//                    result++;
//            }
//            for (int j = 1; j <= n; j++) {
//                for (int k = 1; k <= n ; k++) {
//                    if (i != j && i != k && j != k && anotherRibs < n - 1)
//                        anotherRibs++;
//                }
//            }
//            result += anotherRibs;
//        }
//        System.out.println(result);
    }
}

class Graph {
    private final int MAX_VERTS = 10;
    private Vertex vertexList[]; //массив вершин
    private int adjMat[][]; // матрица смежности
    private int nVerts; // текущее количество вершин
    private Queue<Integer> queue;

    public Graph() {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for (int j = 0; j < MAX_VERTS; j++) {
            for (int k = 0; k < MAX_VERTS; k++) {  // заполнение матрицы смежности нулями
                adjMat[j][k] = 0;
            }
        }
        queue = new PriorityQueue<>();
    }

    public void addVertex(char lab) {
        vertexList[nVerts++] = new Vertex(lab);
    }

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayVertex(int v) {
        System.out.println(vertexList[v].getLabel());
    }

    public void bfc() { // обход в глубину
        vertexList[0].setWasVisited(true);
        displayVertex(0);
        queue.add(0);
        int v2;

        while (!queue.isEmpty()) {
            int v = queue.remove();

            while((v2 = getAdjUnvisitedVertex(v))!=-1) {// цикл будет работать, пока все смежные вершины не будут найденны, и не будут добавлены в очередь
                vertexList[v2].wasVisited =true;
                displayVertex(v2);
                queue.add(v2);
            }
        }

        for (int j = 0; j < nVerts; j++) {  // сброс флагов
            vertexList[j].wasVisited = false;
        }

    }

    private int getAdjUnvisitedVertex(int v) {
        for (int j = 0; j < nVerts; j++) {
            if (adjMat[v][j] == 1 && vertexList[j].wasVisited == false) {
                return j; //возвращает первую найденную вершину
            }
        }
        return -1;
    }
}

class Vertex {
    private char label;  // метка А например
    public boolean wasVisited;

    public Vertex(final char label) {
        this.label = label;
        wasVisited = false;
    }

    public char getLabel() {
        return this.label;
    }

    public boolean isWasVisited() {
        return this.wasVisited;
    }

    public void setWasVisited(final boolean wasVisited) {
        this.wasVisited = wasVisited;
    }
}
