import java.util.Scanner;
import java.io.FileInputStream;

// SWEXPERT 4008. 숫자 만들기 (2017년 하반기 전자 문제)

class Solution02 {

	static int min;
	static int max;

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			int[] ops = new int[4];
			int[] nums = new int[n];
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;

			for (int i = 0; i < 4; i++) {
				ops[i] = sc.nextInt();
			}

			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextInt();
			}

			DFS(nums[0], ops, nums, 1);

			System.out.println("#" + test_case + " " + (max - min));

		} // for
	} // main

	public static void DFS(int result, int[] ops, int[] nums, int cnt) {
		if (cnt == nums.length) {
			if (result > max)
				max = result;
			if (result < min)
				min = result;

			return;
		}

		if (ops[0] != 0) {
			ops[0] -= 1;
			DFS(result + nums[cnt], ops, nums, cnt + 1);
			ops[0] += 1;
		}

		if (ops[1] != 0) {
			ops[1] -= 1;
			DFS(result - nums[cnt], ops, nums, cnt + 1);
			ops[1] += 1;
		}

		if (ops[2] != 0) {
			ops[2] -= 1;
			DFS(result * nums[cnt], ops, nums, cnt + 1);
			ops[2] += 1;
		}

		if (ops[3] != 0) {
			ops[3] -= 1;
			DFS(result / nums[cnt], ops, nums, cnt + 1);
			ops[3] += 1;
		}

	}
}
