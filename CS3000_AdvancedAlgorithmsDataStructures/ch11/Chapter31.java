// Ethan Smith
// CS 3100 Advanced Algorithms
// Chapter 31 programming

import java.math.BigInteger;
public class Chapter31 {
// euclids algorithm 
	public static BigInteger euclid(BigInteger a,BigInteger b) {
		if (b.compareTo(BigInteger.ZERO) == 0) {
			return a;
		}else return euclid(b,a.mod(b));
	}


public static BigInteger[] extendedEuclid(BigInteger a, BigInteger b) {
	if (b.compareTo(BigInteger.ZERO) == 0) {
		BigInteger ret[] = new BigInteger[3];
		ret[0] = a;
		ret[1] = BigInteger.ONE;
		ret[2] = BigInteger.ZERO;
		return ret;
	}else {
		BigInteger z[] = extendedEuclid(b,a.mod(b));
		BigInteger zz[] = new BigInteger[3];
		zz[0] = z[0];
		zz[1] = z[2];
		zz[2] = z[1].subtract(a.divide(b).multiply(z[2]));
		return zz;
	}

}
public static BigInteger modularExponentiation(BigInteger a, BigInteger b, BigInteger n) {
	BigInteger d = BigInteger.ONE;
	String s = b.toString(2);
	for (int i=0;i<s.length();i++) {
		d = (d.multiply(d)).mod(n);	
		if (s.charAt(i) == '1') {
			d = (d.multiply(a)).mod(n);
		}
	}
	return d;
}
public static Boolean sudoPrime(final BigInteger a) {
	if (modularExponentiation(new BigInteger("2"),a.subtract(BigInteger.ONE),a) != (BigInteger.ONE).mod(a)) {
		return false; // composite 
	}
	return true; // Prime
}
public static void main (String args[]) {
	BigInteger a = new BigInteger("21");
	BigInteger b = new BigInteger("9");
	System.out.println("Testing euclid with 21 and 9 (expected 3)");
	System.out.println(euclid(a,b).toString());
	
	a = new BigInteger("99");
	b = new BigInteger("78");
	System.out.println("Testing extended euclid with 99 and 78 (expected is 3, -11, 14)");
	BigInteger[] out = extendedEuclid(a,b);
	System.out.println(out[0].toString() + "," + out[1].toString() + "," + out[2].toString());
	
	
	a = new BigInteger("7");
	b = new BigInteger("560");
	BigInteger c = new BigInteger("561");
	System.out.println("Testing Modular Exponentiation with 7, 560, 561 (expected 1)");
	System.out.println(modularExponentiation(a,b,c).toString());

	
	a = new BigInteger("40");
	System.out.println("Testing pseudoPrime with 40 : false");
	System.out.println(sudoPrime(a));
	a = new BigInteger("13");
	System.out.println("Testing pseudoPrime with 13 : true");
	System.out.println(sudoPrime(a));
	
//	BigInteger out = modularExponentiation(a,b,c);
//	System.out.println(out.toString());
//	BigInteger z = new BigInteger("7");
//	boolean quas = sudoPrime(z);
//	boolean wex = sudoPrime(z);
//	System.out.println(quas);
//	System.out.println(wex);
	
	//BigInteger out[] = extendedEuclid(a,b);
	
}
}