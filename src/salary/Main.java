package salary;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int [] w = new int[N];
			StringTokenizer sz = new StringTokenizer(br.readLine()," ");
			for(int i = 0; i < N; i++) {
				w[i] = Integer.parseInt(sz.nextToken());
			}
			
			int count = 0;
			
			while(true) {
				int val = w[0]; boolean allSame = true;
				for(int i = 1; i < N; i++) {
					if(w[i] != val)
						allSame = false;
				}
				if(allSame)
					break;
				
				int max = w[0];
				for(int i = 1; i < N; i++) {
					if(w[i] > max)
						max = w[i];
				}
				
				for(int i = 0; i < N; i++) {
					if(w[i] == max) {
						count++;
						w[i] -= 1;
					}
				}
				
			}
			result.append(count+"\n");
		}
		System.out.print(result);
	}

}
