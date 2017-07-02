import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;
 
class BOJ_2644 {
    static int n;
    static int[][] adj;
    static int[] visited;
    static ArrayList<Integer> queue;
 
    public static void main(String args[]) throws Exception {
        // Scanner sc = new Scanner(new FileInputStream("sample_input.txt"));
 
        Scanner sc = new Scanner(System.in);
 
        n = sc.nextInt();
        int input1 = sc.nextInt() - 1;
        int input2 = sc.nextInt() - 1;
        int m = sc.nextInt();
 
        adj = new int[n][n];
        visited = new int[n];
        queue = new ArrayList<Integer>();
 
        for (int i = 0; i < m; i++) {
            int parent = sc.nextInt() - 1;
            int child = sc.nextInt() - 1;
 
            adj[parent][child] = 1;
            adj[child][parent] = 1;
        }
 
        BFS(input1, input2);
 
        if (visited[input2] == 0)
            System.out.println("-1");
 
    } // main
 
    static void BFS(int input1, int input2) {
        int level = 0;
        visited[input1] = 1;
        queue.add(input1);
 
        while (queue.isEmpty() != true) {
            int queue_size = queue.size();
 
            for (int i = 0; i < queue_size; i++) {
                int curr = queue.get(0);
                queue.remove(0);
 
                for (int j = 0; j < n; j++) {
                    if (adj[curr][j] == 1 && visited[j] == 0) {
                        visited[j] = 1;
                        queue.add(j);
 
                        if (j == input2) {
                            System.out.println(level + 1);
                        }
                    }
                }
 
            } // queue_size for
 
            level++;
        } // while
 
    } // BFS
 
}
