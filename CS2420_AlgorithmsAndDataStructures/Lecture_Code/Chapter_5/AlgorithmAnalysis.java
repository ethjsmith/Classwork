
public class AlgorithmAnalysis {

	public static void main(String[] args) {

		System.out.println("Starting main");
		
		//TODO create a loop that uses the createArrayAndFillWithRandom code to test the speed
		
		//For timing, I had some luck with the following:
//		long startTime = System.nanoTime();
//		.....your program....
//		long endTime   = System.nanoTime();
//		long totalTime = endTime - startTime;
//		System.out.println(totalTime);
	
		
		//This code for later
		//closestNumbers();

		System.out.println("Finished with main");

	}

	public static int[] createArrayAndFillWithRandom(int size) {
		int [] a = new int[size];
		for(int i = 0; i < a.length; i++) {
			a[i] = (int)(Math.random()*Integer.MAX_VALUE/2);
		}
		return a;
	}

	public static void closestNumbers() {
		int size = 10;
		int [] a = createArrayAndFillWithRandom(size);
		//create some code that will check with two numbers of a are the closest
	}
	

}
