import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
 * 
 * SW Expert Academy (SWEA) 
 * 5948. 새샘이의 7-3-5 게임
 * by BitMasking.
 * 
 * */
public class SWEA5948 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int numbers[] = new int[7];

		for (int tc = 0; tc < T; tc++) {
			for (int i = 0; i < 7; i++) {
				numbers[i] = sc.nextInt();
			}
			
			int fifth = solve(numbers);
			
			System.out.println("#" + (tc + 1) + " " + fifth);
		}

	}
	
	public static int solve(int[] numbers) {
		int bitMax = 1 << 7;
		List<Integer> sumList = new ArrayList<Integer>();
		
		for (int bit = 0; bit < bitMax; bit++) {
			if (Integer.bitCount(bit) == 3) {
				int sum = 0;
				
				for (int i = 0; i < 7; i++) {
					if ((bit & (1 << i)) != 0) {
						sum += numbers[i];
					}
				}
				
				if (!sumList.contains(sum)) {
					sumList.add(sum);
				}
				
			} // if (Integer.bitCount)
			
		} // for (int bit = 0;)
		
		Collections.sort(sumList);
		
		int result = sumList.get(sumList.size() - 5); // The fifth number from back.
		
		return result;
	}
}
