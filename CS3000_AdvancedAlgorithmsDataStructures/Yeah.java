import java.util.HashMap;

public class Yeah {
	public static long ffib(int n) {
		HashMap<Integer, Long> c = new HashMap<Integer, Long>(); 
		return fib3(n,c);
	}
	public HashMap<Integer, Long> c = new HashMap<Integer, Long>(); 
	public static void main (String [] args) {
		int n = 0;
		while (true) {
			n += 1;
			System.out.println(ffib(n) + "N:" + n);
		}
	}
	public static long fib(int n) {
		if (n <= 1) {
			return 1;
		}else {
			return (fib(n-1) + fib(n-2));
		}
	}
	public static long fib2(int n) {
		long n1 = 1;
		long n2 = 1;
		long ans=0;
		for (int i=2;i<=n;i++) {
			ans = n1 + n2;
			n2 = n1;
			n1 = ans;
		}
		return ans;
	}
	// fib 1 is bad because it redos lots of work over and over, we need a data structure to hold our previous calculations
	//HashMap<Integer, Long> c = new HashMap<Integer, Long>(); 
	public static long fib3(int n, HashMap<Integer,Long> c) {
		if (n <= 1) {
			return 1;
			
		}
		else {
			if (c.containsKey(n)) {
				return c.get(n);
			}
			else {
				long ans = fib3(n-1,c) + fib3(n-2,c);
				c.put(n,ans);
				return (n);
			}
		}
	}
	
	// rod cutting
	// return the max money you can get :) 
	// o  I c 
	
	public static int cutMyRod(int n) {
		return 1;
		
	}
	
	
	
}
