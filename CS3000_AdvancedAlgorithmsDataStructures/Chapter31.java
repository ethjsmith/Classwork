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
		BigInteger ret[] = new BigInteger[2];
		ret[0] = a;
		ret[1] = BigInteger.ONE;
		ret[2] = BigInteger.ZERO;
		return ret;
	}else {
		BigInteger z[] = extendedEuclid(b,a.mod(b));
		BigInteger zz[] = new BigInteger[2];
		zz[0] = z[0];
		zz[1] = z[2];
		zz[2] = z[1].subtract(a.divide(b).multiply(z[2]));
		return zz;
	}
}
public static BigInteger modularExponentiation(BigInteger a, BigInteger b, BigInteger n) {
	BigInteger d = BigInteger.ONE;
	String s = a.toString(2);
	for (int i =0;i<s.length();i++) {
		d = (d.multiply(d)).mod(n);
		if (s.charAt(i) == '1') {
			d = (d.multiply(a)).mod(n);
		}
	}
	return d;
}
public static void main (String args[]) {
	BigInteger a = new BigInteger("899");
	BigInteger b = new BigInteger("493");
	BigInteger c = new BigInteger("4");
	//BigInteger out = modularExponentiation(a,b,c);
	BigInteger out[] = extendedEuclid(a,b);
	System.out.println(out[0].toString() + "" + out[1].toString() + "" + out[2].toString());
}
}