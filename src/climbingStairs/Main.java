package climbingStairs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int getOnes(int n) {
		int count = 0;
		while(n > 0) {
			n &= (n-1);
			count++;
		}
		return count;
	}

	public static void main(String[] args) throws Exception{
		
		int [] vals = new int[1000001];
		vals[1] = 1;
		vals[2] = 2;
		for(int i = 3; i < 1000001; i++) {
			vals[i] = (vals[i-1]+vals[i-2]) % 1000000007;
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		while(T > 0) {
			StringTokenizer sz = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(sz.nextToken());
			int G = Integer.parseInt(sz.nextToken());
			int ans = getOnes(vals[N]);
			if(ans == G) {
				result.append("CORRECT\n");
			}
			else {
				result.append("INCORRECT\n");
			}
			T--;
		}
		
		System.out.print(result);
		
	}

}
