import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;
 
class CG_3 { // 시험 공부
    public static void main(String args[]) throws Exception {
        // Scanner sc = new Scanner(new FileInputStream("sample_input.txt"));
 
        Scanner sc = new Scanner(System.in);
 
        int T;
        int test_case;
 
        T = sc.nextInt();
        for (test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int score[] = new int[n];
            int final_score = 0;
 
            for (int i = 0; i < n; i++)
                score[i] = sc.nextInt();
 
            Arrays.sort(score);
 
            for (int i = 1; i <= k; i++) {
                final_score += score[n - i];
            }
 
            System.out.println("Case #" + test_case);
            System.out.println(final_score);
 
        }
    }
}
