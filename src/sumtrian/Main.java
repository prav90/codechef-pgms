package sumtrian;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	/**
	 * @param args
	 */
	public static int getMaxResult(int [][] ip,int [][] cache,int i,int j,int n) {
		if(i > n || j > n) return 0;
		if(cache[i][j] != -1) return cache[i][j];
		int result = ip[i][j] + max(getMaxResult(ip,cache,i+1,j,n),getMaxResult(ip,cache,i+1,j+1,n));
		cache[i][j] = result;
		return result;
	}
	
	public static int max(int a,int b) {
		if( a > b) {
			return a;
		}
		else {
			return b;
		}
	}
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		StringBuilder result = new StringBuilder();
		while(t > 0) {
			int n = Integer.parseInt(br.readLine().trim());
			int [][] input = new int[n][n];
			int [][] cache = new int[n][n];
			for(int i = 1; i <= n; i++) {
				StringTokenizer sz = new StringTokenizer(br.readLine().trim()," ");
				for(int j = 0; j < i; j++) {
					input[i-1][j] = Integer.parseInt(sz.nextToken());
					cache[i-1][j] = -1;
				}
			}
			result.append(""+getMaxResult(input,cache,0,0,n-1)+"\n");
			t--;
		}
		System.out.print(result);
	}

}
