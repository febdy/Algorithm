import java.util.Scanner;

// SWEXPERT 4012. 요리사 (2017년 하반기 SDS 문제)

class Solution02 {

	static int n;
	static int[][] s;
	static int min;

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			n = sc.nextInt();
			s = new int[n][n];
			int[] check = new int[n];
			min = Integer.MAX_VALUE;

			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					s[i][j] = sc.nextInt();

			cook(check, 0, 0);

			System.out.println("#" + test_case + " " + min);

		} // for
	} // main

	public static void cook(int[] check, int a_cnt, int cnt) {
		if (a_cnt == n / 2 || cnt == n) {
			int a_sum = 0;
			int b_sum = 0;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (i == j)
						continue;

					if (check[i] == 0 && check[j] == 0)
						b_sum += s[i][j];
					else if (check[i] == 1 && check[j] == 1)
						a_sum += s[i][j];
				}

			}

			if (min > Math.abs(a_sum - b_sum))
				min = Math.abs(a_sum - b_sum);

			return;
		}

		check[cnt] = 1;
		cook(check, a_cnt + 1, cnt + 1);
		check[cnt] = 0;
		cook(check, a_cnt, cnt + 1);

	}
}