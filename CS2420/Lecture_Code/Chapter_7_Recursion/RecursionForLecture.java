
public class RecursionForLecture {
	
	
	/**
	 * Explain without using recursive language what this method does?
	 */
	public static int mystery1( int a, int b ){
		if (b == 1){						
			return a;
		}
		else{
			return a + mystery1(a, b-1);
		}
	}

	/**
	 * Explain without using recursive language what this method does?
	 */
	public static int mystery2 (int array[], int size){
		if (size == 1){
			return array[0];
		}
		else{
			return array[size-1] + mystery2(array, size-1);
		}
	}

	/**
	 * Explain without using recursive language what this method does?
	 */
	public static String mystery3 (int array[], int x){
		if (x < array.length){
			return mystery3(array, x+1) + "" + array[x] + " ";
		}
		else{
			return "";
		}
	}


	/**
	 *
	 *To solve this, you might want to look at
	 *the s.substring and s.length methods
	 */
	public static boolean testPalindrome(String s){ 
		return true;
	}

	

	public static void main(String[] args) {

		int x = mystery1(1,1);
		System.out.println("mystery1 says " + x);

		int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int b[] = {11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
		x = mystery2(a,1);
		System.out.println("mystery2 says '" + x + "' with array a");

		x = mystery2(b,1);
		System.out.println("mystery2 says '" + x + "' with array b");

		String s = mystery3(a,9);
		System.out.println("mystery3 says '" + s + "' with array a");

		s = mystery3(b,9);
		System.out.println("mystery3 says '" + s + "' with array b");


		boolean answer;
		String p;

		p = "radar";
		answer = testPalindrome(p);
		if (answer == true){
			System.out.println("Your function stays that '" + p + "' is a palindrome");
		}
		else{
			System.err.println("Your function stays that '" + p + "' is NOT a palindrome");
		}

		p = "able was i ere i saw elba";
		answer = testPalindrome(p);
		if (answer == true){
			System.out.println("Your function stays that '" + p + "' is a palindrome");
		}
		else{
			System.err.println("Your function stays that '" + p + "' is NOT a palindrome");
		}

		p = "a man, a plan, a canal - panama.";
		answer = testPalindrome(p);
		if (answer == true){
			System.out.println("Your function stays that '" + p + "' is a palindrome");
		}
		else{
			System.err.println("Your function stays that '" + p + "' is NOT a palindrome");
		}

		p = "This is not a palindrome";
		answer = testPalindrome(p);
		if (answer == true){
			System.err.println("Your function stays that '" + p + "' is a palindrome");
		}
		else{
			System.out.println("Your function stays that '" + p + "' is not a palindrome");
		}

		p = "a man not here nam a";
		answer = testPalindrome(p);
		if (answer == true){
			System.err.println("Your function stays that '" + p + "' is a palindrome");
		}
		else{
			System.out.println("Your function stays that '" + p + "' is not a palindrome");
		}

	}

}
