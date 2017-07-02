import java.util.Scanner;
import java.io.FileInputStream;
 
class BOJ_13458 {
    public static void main(String args[]) throws Exception {
        // Scanner sc = new Scanner(new FileInputStream("sample_input.txt"));
 
        Scanner sc = new Scanner(System.in);
 
        int n = sc.nextInt();
        int[] candidate = new int[n];
 
        for (int i = 0; i < n; i++) {
            candidate[i] = sc.nextInt();
        }
 
        int b = sc.nextInt();
        int c = sc.nextInt();
        long cnt = 0;
 
        for (int i = 0; i < n; i++) {
            cnt++;
            int remainder = (candidate[i] - b) % c;
            int exam_supervisor = (candidate[i] - b) / c;
 
            if (candidate[i] > b) {
                if (remainder == 0)
                    cnt += exam_supervisor;
                else {
                    if (exam_supervisor == 0)
                        cnt += 1;
                    else
                        cnt += exam_supervisor + 1;
                }
            }
 
        } // for
 
        System.out.println(cnt);
 
    } // main
}
