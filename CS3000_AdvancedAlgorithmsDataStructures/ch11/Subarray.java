/*
 * 	Ethan Smith
 *  CS3000
 *  Max subarray (Chapter 4 programming)
 *  2/16/20
 */

	//4.1-3 Implement  both  the  brute-force  and  recursive  algorithms  for  the  maximum-subarray problem on your own computer.
	//What problem size gives the crossover point  at  which  the  recursive  algorithm  beats  the  brute-force  algorithm?  
	//Then, change the base case of the recursive algorithm  to use the brute-force  algorithm whenever the problem size is less than. 
	//Does that change the crossover point?

import java.util.Random;
public class Subarray {
	public static void main(String[] args) {
		long st,et,tt;
		int [] input = {0};
		
		for (int i=3;i<500;i++) {
			input = new int [i];
			for (int z= 0;z<i;z++) {
				input[z] = new Random().nextInt(10 + 10) - 10;
			}
		//int[] inp = new int [] {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
		//int az[] = {3, -1, -1, 10, -3, -2, 4};
//		int avg = 0;
//		for (int z = 0;z<1000;z++) {
//			st = System.nanoTime();
//			int [] a = findMaximumSubarray(input);
//			//System.out.println(a[0] + "  " + a[1] + " " + a[2]);
//			et = System.nanoTime();
//			tt = et - st;
//			avg += tt;
//			//System.out.println(tt);
//		}
//		System.out.println(avg/1000);
		
		int avg = 0;
		for (int z = 0;z<1000;z++) {
			st = System.nanoTime();
			int [] ans = maxSub(input,0,input.length-1);
			//System.out.println(ans[0] + ", " + ans[1] + ", " + ans[2]);
			et = System.nanoTime();
			tt = et - st;
			avg += tt;
		}
		System.out.println(avg/1000);
		
	}
	}	

	public static int max(int a,int b, int c) { // gets the max of multiple vars
		if (a >= b && a >= c) {
			return a;
		}else if (b >= a && b >= c){
			return b;
		}
		return c;
	}
	
	public static int[] maxSub(int [] a, int left, int right) {
		if (left == right) {
			return new int [] {left,right,a[left]};
		}
		
		int mid = (left+right) / 2;
		int[] maxLeft = maxSub(a,left,mid);
		int[] maxRight = maxSub(a,mid + 1, right);
		int[] maxBoth = maxCross(a,left,mid,right);
		if (maxLeft[2] >= maxRight[2] && maxLeft[2] >= maxBoth[2]) {
			return maxLeft;
		}else if (maxRight[2] >= maxLeft[2] && maxRight[2] >= maxBoth[2]) {
			return maxRight;
		}
		return maxBoth;
	}
	public static int[] maxCross(int[] a,int left,int mid, int right) {
		int leftSum = Integer.MIN_VALUE;
		int sum = 0,maxLeft= 0,maxRight=0;
		for (int i=mid; i>= left;i--) {
			sum = sum + a[i];
			if (sum > leftSum) {
				leftSum = sum;
				maxLeft= i;
			}
		}
		int rightSum = Integer.MIN_VALUE;
		sum = 0;
		for (int i = mid+1; i<=right;i++) {
			sum = sum + a[i];
			if (sum > rightSum) {
				rightSum = sum;
				maxRight = i;
			}
		}
		return new int[] {maxLeft,maxRight,(leftSum + rightSum)};
		}
	
	
	
	
	public static int [] findMaximumSubarray(int [] a) {
		int maxStartIndex = 0;
		int maxEndIndex = 0;
		int max = 0;
		for(int i = 0; i < a.length; i++) {
			int currentSum = 0;
			for(int j = i; j < a.length; j++) {
				currentSum += a[j];
				if(currentSum > max) {
				max = currentSum;
				maxEndIndex = j;
				maxStartIndex = i;
				}
			}
		}
		return new int[] {maxStartIndex, maxEndIndex,max};
	}	

	
}
