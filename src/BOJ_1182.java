import java.util.Scanner;

// [Bit Mask] 부분집합의 합
public class BOJ_1182 { 

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int result = sc.nextInt();
		int[] arr = new int[n];
		int bitMax = (int) (Math.pow(2, n) - 1);
		int cnt = 0;

		for (int i = 0; i < n; i++) { // Initialization
			arr[i] = sc.nextInt();
		}

		for (int bit = 1; bit <= bitMax; bit++) { // 모든 비트 순회
			int sum = 0;

			for (int i = 0; i < n; i++) { // 1인 비트 체크
				if ((bit & (1 << i)) != 0)
					sum += arr[i];
			}

			if (sum == result)
				cnt++;
		}

		System.out.println(cnt);

	}

}
