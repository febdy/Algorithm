import java.util.Scanner;
import java.io.FileInputStream;
 
class CG_46 { // 할인권
    public static void main(String args[]) throws Exception {
        // Scanner sc = new Scanner(new FileInputStream("sample_input.txt"));
 
        Scanner sc = new Scanner(System.in);
 
        int T;
        int test_case;
 
        T = sc.nextInt();
        for (test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            int unknown = 9999;
            int sale_ticket = 0;
 
            int arr[][] = new int[n][n];
 
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j)
                        arr[i][j] = 0;
                    else
                        arr[i][j] = unknown;
                }
            } // 배열 초기화
 
            for (int i = 0; i < m; i++) {
                int a = sc.nextInt() - 1;
                int b = sc.nextInt() - 1;
                arr[a][b] = sc.nextInt();
                arr[b][a] = arr[a][b];
            } // 배열에 값 넣기
 
            for (int pass = 0; pass < n; pass++) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (arr[i][j] > arr[i][pass] + arr[pass][j]) {
                            arr[i][j] = arr[i][pass] + arr[pass][j];
                        }
                    }
                }
            }
 
            int p = sc.nextInt();
 
            for (int i = 0; i < p; i++) {
                int s = sc.nextInt() - 1;
                int e = sc.nextInt() - 1;
 
                if (arr[s][e] > k)
                    sale_ticket++;
            }
 
            System.out.println("Case #" + test_case);
            System.out.println(sale_ticket);
 
        }
    }
}
