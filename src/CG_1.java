import java.util.Scanner;
import java.io.FileInputStream;
 
class CG_1 { // 숫자 골라내기
    public static void main(String args[]) throws Exception {
        // Scanner sc = new Scanner(new FileInputStream("sample_input.txt"));
 
        Scanner sc = new Scanner(System.in);
 
        int T;
        int test_case;
 
        T = sc.nextInt();
        for (test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int num = 0;
            int result = 0;
 
            for (int i = 0; i < n; i++) {
                num = sc.nextInt();
 
                result ^= num;
            }
 
            System.out.println("Case #" + test_case);
            System.out.println(result);
 
        }
    }
}
