package byteLandianCoins;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

	/**
	 * @param args
	 */
	public static long getMaxDollars(int n,HashMap<Integer,Long> map) {
		if(n < 4) {
			return n;
		}
		if(map.get(n) != null) return map.get(n);
		long maxDollar = Math.max(n,getMaxDollars(n/2,map)+getMaxDollars(n/3,map)+getMaxDollars(n/4,map));
		if(!map.containsKey(n)) map.put(n, maxDollar);
		return maxDollar;
	}
	
	public static void main(String[] args) throws Exception{ 
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String ip = br.readLine();
		while(ip != null) {
			int n = Integer.parseInt(ip);
			HashMap<Integer,Long> map =new HashMap<Integer,Long>();
			System.out.println(getMaxDollars(n,map));
			ip = br.readLine();
		}
	}

}
