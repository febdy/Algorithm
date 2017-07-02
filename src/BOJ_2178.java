import java.util.ArrayList;
import java.util.Scanner;
import java.awt.Point;
import java.io.FileInputStream;
 
class BOJ_2178 {
    static int n;
    static int m;
    static int[][] map;
    static int[][] visited;
    static ArrayList<Point> queue;
 
    public static void main(String args[]) throws Exception {
        // Scanner sc = new Scanner(new FileInputStream("sample_input.txt"));
 
        Scanner sc = new Scanner(System.in);
 
        n = sc.nextInt();
        m = sc.nextInt();
 
        map = new int[n][m];
 
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }
 
        visited = new int[n][m];
        queue = new ArrayList<Point>();
 
        BFS(0, 0);
 
    } // main
 
    static void BFS(int x, int y) {
        int[] move_x = { 1, -1, 0, 0 };
        int[] move_y = { 0, 0, 1, -1 };
 
        int level = 1;
        visited[x][y] = 1;
        queue.add(new Point(x, y));
 
        while (queue.isEmpty() != true) {
            int queue_size = queue.size();
 
            for (int i = 0; i < queue_size; i++) {
                int curr_x = queue.get(0).x;
                int curr_y = queue.get(0).y;
                queue.remove(0);
 
                for (int j = 0; j < 4; j++) {
                    int next_x = move_x[j] + curr_x;
                    int next_y = move_y[j] + curr_y;
 
                    if (next_x < n && next_y < m && next_x >= 0 && next_y >= 0) {
                        if (map[next_x][next_y] == 1 && visited[next_x][next_y] == 0) {
                            visited[next_x][next_y] = 1;
                            queue.add(new Point(next_x, next_y));
 
                            if (next_x == n - 1 && next_y == m - 1) {
                                System.out.println(level + 1);
                                break;
                            }
                        }
                    }
 
                }
 
            } // queue_size for
 
            level++;
        } // while
 
    } // BFS
 
}
