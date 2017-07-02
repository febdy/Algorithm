import java.util.Scanner;
import java.io.FileInputStream;
 
class BOJ_14499 {
    public static void main(String args[]) throws Exception {
        // Scanner sc = new Scanner(new FileInputStream("sample_input.txt"));
 
        Scanner sc = new Scanner(System.in);
 
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int k = sc.nextInt();
 
        int map[][] = new int[n][m];
        int dice[] = { 0, 0, 0, 0, 0, 0 };
 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }
 
        for (int i = 0; i < k; i++) {
            int move = sc.nextInt();
 
            switch (move) {
            case 1:
                if (y + 1 < m) {
                    y = y + 1;
 
                    int temp = dice[1];
                    dice[1] = dice[5];
                    dice[5] = dice[3];
                    dice[3] = dice[2];
                    dice[2] = temp;
 
                    check_map(map, x, y, dice);
                }
                break;
            case 2:
                if (0 <= y - 1) {
                    y = y - 1;
 
                    int temp = dice[1];
                    dice[1] = dice[2];
                    dice[2] = dice[3];
                    dice[3] = dice[5];
                    dice[5] = temp;
 
                    check_map(map, x, y, dice);
                }
                break;
            case 3:
                if (0 <= x - 1) {
                    x = x - 1;
 
                    int temp = dice[0];
                    dice[0] = dice[5];
                    dice[5] = dice[4];
                    dice[4] = dice[2];
                    dice[2] = temp;
 
                    check_map(map, x, y, dice);
                }
                break;
            case 4:
                if (x + 1 < n) {
                    x = x + 1;
 
                    int temp = dice[0];
                    dice[0] = dice[2];
                    dice[2] = dice[4];
                    dice[4] = dice[5];
                    dice[5] = temp;
 
                    check_map(map, x, y, dice);
                }
                break;
            default:
                break;
            } // switch
 
        } // for
 
    } // main
 
    static void check_map(int[][] map, int x, int y, int[] dice) {
        if (map[x][y] == 0)
            map[x][y] = dice[5];
        else {
            dice[5] = map[x][y];
            map[x][y] = 0;
        }
 
        System.out.println(dice[2]);
    }
}
