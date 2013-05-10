package mixtures;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		String ip = br.readLine();
		while(ip != null) {
			int T = Integer.parseInt(ip);
			int [][] newMixture = new int [T][T];
			int [][] smoke = new int [T][T];
			StringTokenizer sz = new StringTokenizer(br.readLine()," ");
			for(int i = 0; i < T; i++) {
				newMixture[i][i] =  Integer.parseInt(sz.nextToken());
				smoke[i][i] = 0;
			}
			for(int k = 1; k < T; k++) {
				for(int i = 0; i < T-k; i++) {
					int a = i+k;
					int minSmoke = Integer.MAX_VALUE; int minCurrent = -1;
					for(int j = i; j < a; j++) {
						int smokeF = newMixture[i][j] * newMixture[j+1][a] + smoke[i][j] + smoke[j+1][a];
						if(smokeF < minSmoke) {
							minSmoke = smokeF;
							minCurrent = j;
						}
					}
					smoke[i][a] = minSmoke;
					newMixture [i][a] = (newMixture[i][minCurrent] + newMixture[minCurrent+1][a]) % 100;
				}
			}
//			for(int i = 0; i < T; i++) {
//				for(int j = 0; j < T; j++) {
//					System.out.print(newMixture[i][j]+" ");
//				}
//				System.out.println();
//			}
//			
//			for(int i = 0; i < T; i++) {
//				for(int j = 0; j < T; j++) {
//					System.out.print(smoke[i][j]+" ");
//				}
//				System.out.println();
//			}
			//System.out.println(smoke[0][T-1]);
			result.append(smoke[0][T-1]+"\n");
			ip = br.readLine();
		}
		System.out.print(result);

	}

}
