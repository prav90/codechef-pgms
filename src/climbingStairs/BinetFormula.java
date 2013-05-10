package climbingStairs;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BinetFormula {

	/**
	 * @param args
	 */
	
	private static final BigInteger[][] MATRIX =
	    {{BigInteger.ONE, BigInteger.ONE},
	     {BigInteger.ONE, BigInteger.ZERO}};
	     
	public static BigInteger f(int n) {
	    if (n == 0) return BigInteger.ZERO;
	    if (n == 1) return BigInteger.ONE;
	    return power(MATRIX, n - 1)[0][0];
	}
	     
	private static BigInteger[][] power(BigInteger[][] m,
	                                        int power) {
	    if (power == 1) return m;
	    BigInteger[][] sub = power(m, power / 2);
	    if (power % 2 == 0) {
	        return multiply(sub, sub);
	    } else {
	        return multiply(multiply(sub, sub), m);
	    }
	}
	 
	private static BigInteger[][] multiply(BigInteger[][] m1,
	                                        BigInteger[][] m2) {
	    return new BigInteger[][]{
	        {m1[0][0].multiply(m2[0][0]).add(m1[0][1].multiply(m2[1][0])),
	         m1[0][0].multiply(m2[0][1]).add(m1[0][1].multiply(m2[1][1]))},
	        {m1[1][0].multiply(m2[0][0]).add(m1[1][1].multiply(m2[1][0])),
	         m1[1][0].multiply(m2[0][1]).add(m1[1][1].multiply(m2[1][1]))}
	    };
	}
	
	public static final double PHI = (1d + Math.sqrt(5)) / 2d;
	
	public static BigInteger fibonacci(int n) {
		if(n == 0)
		      return BigInteger.ZERO;
		    if(n == 1 || n == 2)
		      return BigInteger.ONE;
		    //----- fib(n) = (phi^n - (-phi^-n)) / sqrt(5)
		    BigDecimal phin = new BigDecimal(PHI).pow(n);
		    BigDecimal nphin = new BigDecimal(-PHI).pow(-n);
		    BigDecimal fib = phin.subtract(nphin).divide(new BigDecimal(Math.sqrt(5d)), BigDecimal.ROUND_HALF_EVEN);
		    return fib.toBigInteger();
//		double sqrt5 = Math.sqrt(5.0);
//		double phi = (sqrt5 + 1) /2.0;
//		BigDecimal pi = new BigDecimal(phi);
//		BigDecimal div = new BigDecimal(sqrt5);
//		BigDecimal num = pi.pow(n);
//		BigDecimal denom = num.divide(div);
//		return denom.toBigInteger();
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(f(8).mod(new BigInteger("1000000007")));
	}

}
