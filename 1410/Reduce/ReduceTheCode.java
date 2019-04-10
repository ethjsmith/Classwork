public class ReduceTheCode { 	// @Edited by Ethan Smith
	private int foo,bar;		// @Edited on 4/8/2019
	private int [][] tao;		// @Project : Reduce the code
	public ReduceTheCode(){		// @File : ReduceTheCode
		setVariables(5);
	}
	public int getFoo(){
		return foo;
	}
	public void setVariables(int a){
		foo = a;
		bar = foo * 5;
		tao = new int[foo][];
		for (int i = 0; i < foo; i++){
			tao[i] = new int[bar];
			for (int j = 0; j < bar; j++)
				tao[i][j] = foo+bar;
		}
	}
	public static int a(int i){
		if (i >= 0 && i <= 20) 
			return i+12;
		return -1;
	}
	public static int b(int i){
		int[] z = {3493,3011,6881,5413,2144,1728,8383,2970,8226,2396,4106,9201,9582,7412,4091,7291,1747,9922,4647,6070,9946};
		if (i >= 0 && i <= 20)
			return z[i];
		return -1;
	}
	public static void c(int i){// This method didn't do anything 
	}
}