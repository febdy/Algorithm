import java.util.Scanner;
import java.io.FileInputStream;
 
class BOJ_1012 {
    static int[][] field;
    static int[][] visited;
    static int m;
    static int n;
 
    public static void main(String args[]) throws Exception {
        // Scanner sc = new Scanner(new FileInputStream("sample_input.txt"));
 
        Scanner sc = new Scanner(System.in);
 
        int T = sc.nextInt();
 
        for (int test_case = 0; test_case < T; test_case++) {
            m = sc.nextInt(); // 가로
            n = sc.nextInt(); // 세로
            int k = sc.nextInt();
            int cnt = 0;
 
            field = new int[n][m];
            visited = new int[n][m];
 
            for (int i = 0; i < k; i++) {
                int x = sc.nextInt(); // 가로
                int y = sc.nextInt(); // 세로
                field[y][x] = 1;
            }
 
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (field[i][j] == 1 && visited[i][j] == 0) {
                        DFS(i, j);
                        cnt++;
                    }
                }
            }
 
            System.out.println(cnt);
 
        } // test_case for
 
    } // main
 
    static void DFS(int cur_y, int cur_x) {
        int move_x[] = { 0, 0, 1, -1 };
        int move_y[] = { 1, -1, 0, 0 };
 
        visited[cur_y][cur_x] = 1;
 
        for (int i = 0; i < 4; i++) {
            int next_x = cur_x + move_x[i];
            int next_y = cur_y + move_y[i];
 
            if (next_x >= 0 && next_x < m && next_y >= 0 && next_y < n) {
                if (field[next_y][next_x] == 1 && visited[next_y][next_x] == 0)
                    DFS(next_y, next_x);
            }
        }
 
    } // DFS
 
}
