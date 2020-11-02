
public class BigOhExploration {

	public static void main(String[] args) {
		int n = 100;
		example1(n);
	}
	
	
	public static void example1(int n) {
		//Which one is faster
		
		//Example A
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.println("Working on " + i + "  " + j);
			}
		}

		//Example B
		for(int i = 0; i < n; i++) {
			System.out.println("Working on " + i );
		}
		for(int j = 0; j < n; j++) {
			System.out.println("Working on " + j);
		}
	}

	public static int[] createPositiveArray(int size) {
		int [] a = new int[size];
		int currentNum = 0;
		for(int i = 0; i < a.length; i++) {
			a[i] = currentNum++;
		}
		
		
		return a;
	}
	
}
