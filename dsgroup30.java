package isaac;

import java.util.Scanner; // import scanner to get user input
import java.util.PriorityQueue; // import priority queue to implement Dijkstra algorithm

public class DsGroup30 
{
    static int V = 5; // Number of vertices in graph (A, B, C, D, S)
    static int[] dist = new int[V]; // array to store shortest distance from source to each vertex
    static boolean[] visited = new boolean[V]; // array to keep track of visited vertices
    static int[][] graph = new int[V][V]; // 2D array to store the distances between each vertex

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        // Getting input from user for distances between each vertex (in kilometres)
        System.out.println("Enter the distances between each vertex (in kilometres):");
        System.out.println("A to B:");
        graph[0][1] = sc.nextInt();
        System.out.println("A to C:");
        graph[0][2] = sc.nextInt();
        System.out.println("B to C:");
        graph[1][2] = sc.nextInt();
        System.out.println("C to D:");
        graph[2][3] = sc.nextInt();
        System.out.println("B to D:");
        graph[1][3] = sc.nextInt();
        System.out.println("D to S:");
        graph[3][4] = sc.nextInt();


        // Initializing arrays
        for (int i = 0; i < V; i++) 
        {
            dist[i] = Integer.MAX_VALUE; // initialize distance to infinity
            visited[i] = false; // initialize all vertices as unvisited
        }

        // Setting source vertex (A) distance as 0
        dist[0] = 0;

        // Implementing Dijkstra algorithm
        for (int i = 0; i < V - 1; i++) 
        {
            // Finding the vertex with the smallest distance
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int j = 0; j < V; j++) 
            {
                if (visited[j] == false && dist[j] <= min) 
                {
                    min = dist[j];
                    minIndex = j;
                }
            }

            // Marking the vertex as visited
            visited[minIndex] = true;

            // Updating distance of adjacent vertices
            for (int j = 0; j < V; j++) 
            {
                if (!visited[j] && graph[minIndex][j] != 0 && dist[minIndex] != Integer.MAX_VALUE 
                		&& dist[minIndex] + graph[minIndex][j] < dist[j]) 
                {
                    dist[j] = dist[minIndex] + graph[minIndex][j];
                }
            }
        }

        // Printing the shortest distance from A to S
        System.out.println("Shortest distance from A to S: " + dist[4] + " km (A to C to D to S)");

    }
}
