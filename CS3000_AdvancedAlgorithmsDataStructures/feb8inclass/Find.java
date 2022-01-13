package reco;

public class Find { // Brute force 
	public static int [] findMaxSubarray(int [] a) {
		int maxStartIndex = 0;
		int maxEndIndex = 0;
		for (int i=0;i<a.length;i++) {
			int max = 0,currentSum=0;
			maxEndIndex=i;
			for (int j=i;j<a.length;j++) {
				currentSum += a[j];
				if (currentSum > max) {
					max = currentSum;
					maxEndIndex = j;
					maxStartIndex = i;
				}
			}
		}
		return new int [] {maxStartIndex,maxEndIndex};
	}
	public static void main(String[] args) {
		int [] a = findMaxSubarray(new int[] {13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,4,7});
		System.out.println("indicies" + a[0] + a[1]);
	}
	public static int [] recursiveArray(int [] a) {
		// yeah 
	}
	
}
