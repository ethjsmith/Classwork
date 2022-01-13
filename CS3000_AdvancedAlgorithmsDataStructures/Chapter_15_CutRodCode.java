package yeah;

import java.util.HashMap;

public class Chapter_15_CutRodCode {
	
	private static HashMap<Integer, Integer> ans = new HashMap<Integer,Integer>();
	
	public static int cutRod(int [] p, int n) {
		if(n == 0) {
			return 0;
		}
		if (ans.containsKey(n)) {
			return ans.get(n);
		}
		int q = -1;
		for(int i = 1; i <= n; i++) {
			q = Math.max(q, p[i] + cutRod(p,n-i));
		}
		ans.put(n,q);
		return q;
	}

	public static void main(String[] args) {

		int [] prices = {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30, 33, 36, 39, 42, 45, 48, 51, 54, 57, 60, 63, 66, 69, 72, 75, 78, 81, 84, 87, 90, 93, 96, 99, 102, 105, 108, 111, 114, 117, 120, 123, 126, 129, 132, 135, 138, 141, 144, 147, 150, 153, 156, 159, 162, 165, 168, 171, 174, 177, 180, 183, 186, 189, 192, 195, 198, 201, 204, 207, 210, 213, 216, 219, 222, 225, 228, 231, 234, 237, 240, 243, 246, 249, 252, 255, 258, 261, 264, 267, 270, 273, 276, 279, 282, 285, 288, 291, 294, 297};
		
		//see what happens when the prices get larger
		for(int i = 4; i < 100; i++) {
			int maxPrice = cutRod(prices,i);
			System.out.println("Max price for size " + i + " is " + maxPrice);			
		}

	}

}
