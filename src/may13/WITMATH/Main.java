package may13.WITMATH;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.BitSet;

public class Main {

	/**
	 * @param args
	 */
	static int fi(int n) 
    { 
      int result = n; 
      for(int i=2;i*i <= n;i++) 
      { 
        if (n % i == 0) result -= result / i; 
        while (n % i == 0) n /= i; 
      } 
      if (n > 1) result -= result / n; 
      return result; 
    } 
	
	static BitSet primes = new BitSet(1000000001);
	
	static void setprimes() {
		for(int i = 2; i <= 1000000000; i++) {
			primes.set(i);
		}
		for(int i = 2; i <= 31623; i++) {
			if(primes.get(i)) {
				for(int j = 2 * i; j <= 1000000000; j++) {
					primes.set(j, false);
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		setprimes();
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			long N = Long.parseLong(br.readLine());
			if(N <= 1000000000) {
				for(long i = N; i >= 2; i--) {
					if(primes.get((int)i)) {
						result.append(i+"\n");
						break;
					}
				}
			}
			else {
				long m = 1000000001;
				
				long j = N;
				for(; j > 1000000000; j--) {
					int k = 2;
					boolean resultfound = true;
					int limit = (int)Math.sqrt(j);
					for(; k <= limit; k++) {
						if(primes.get(k)) {
							if(N % k == 0) {
								resultfound = false;
								break;
							}
						}
					}
					if(resultfound) {
						result.append(j+"\n");
						break;
					}
				}
				if(j == 1000000000) {
					for(long i = N; i >= 2; i--) {
						if(primes.get((int)i)) {
							result.append(i+"\n");
							break;
						}
					}
				}
				
			}
			
		}
		System.out.println(result);
  }
}


