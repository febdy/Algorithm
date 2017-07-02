import java.util.Scanner;
import java.io.FileInputStream;
 
class BOJ_14500_2 {
    static int n;
    static int m;
    static int max = 0;
    static int sum = 0;
    static int map[][];
    static int visited[][];
    static int dx[] = { 1, -1, 0, 0 };
    static int dy[] = { 0, 0, 1, -1 };
 
    public static void main(String args[]) throws Exception {
        // Scanner sc = new Scanner(new FileInputStream("sample_input.txt"));
 
        Scanner sc = new Scanner(System.in);
 
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        visited = new int[n][m];
 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }
 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                DFS(i, j, 0);
                sum = 0;
                cross(i, j);
                sum = 0;
            }
        }
 
        System.out.println(max);
 
    } // main
 
    static void DFS(int curr_x, int curr_y, int depth) {
        if (depth == 4) {
            if(sum > max)
                max = sum;
            
            return;
        }
 
        visited[curr_x][curr_y] = 1;
        sum += map[curr_x][curr_y];
 
        for (int i = 0; i < 4; i++) {
            int next_x = curr_x + dx[i];
            int next_y = curr_y + dy[i];
 
            if (next_x >= 0 && next_y >= 0 && next_x < n && next_y < m && visited[next_x][next_y] == 0) {
                DFS(next_x, next_y, depth + 1);
            }
        }
 
        visited[curr_x][curr_y] = 0;
        sum -= map[curr_x][curr_y];
 
    } // DFS
 
    static void cross(int curr_x, int curr_y) {
        sum = map[curr_x][curr_y];
        int min = 99999;
        int cnt = 0;
 
        for (int i = 0; i < 4; i++) {
            int next_x = curr_x + dx[i];
            int next_y = curr_y + dy[i];
 
            if (next_x >= 0 && next_y >= 0 && next_x < n && next_y < m) {
                sum += map[next_x][next_y];
                cnt++;
 
                if (min > map[next_x][next_y])
                    min = map[next_x][next_y];
            }
        }
 
        if (cnt == 4)
            sum -= min;
 
        if (sum > max)
            max = sum;
 
    }
}

