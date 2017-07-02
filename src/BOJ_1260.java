import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;
 
class BOJ_1260 {
    static int N;
    static int[][] adj;
    static int[] visited;
    static ArrayList<Integer> queue;
 
    public static void main(String args[]) throws Exception {
        // Scanner sc = new Scanner(new FileInputStream("sample_input.txt"));
 
        Scanner sc = new Scanner(System.in);
 
        N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt() - 1;
 
        adj = new int[N][N];
        visited = new int[N];
        queue = new ArrayList<Integer>();
 
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            adj[u][v] = 1;
            adj[v][u] = 1;
        }
 
        DFS(V);
        visited = new int[N];
        System.out.println();
        BFS(V);
 
    } // main
 
    static void DFS(int curr) {
        visited[curr] = 1;
        System.out.print(curr + 1);
        System.out.print(" ");
 
        for (int i = 0; i < N; i++) {
            if (adj[curr][i] == 1 && visited[i] == 0) {
                DFS(i);
            }
        }
 
    } // DFS
 
    static void BFS(int curr) {
        visited[curr] = 1;
        queue.add(curr);
 
        while (queue.isEmpty() != true) {
            curr = queue.get(0);
            queue.remove(0);
            System.out.print(curr + 1);
            System.out.print(" ");
 
            for (int i = 0; i < N; i++) {
                if (adj[curr][i] == 1 && visited[i] == 0) {
                    visited[i] = 1;
                    queue.add(i);
                }
            }
        }
 
    } // BFS
 
}
