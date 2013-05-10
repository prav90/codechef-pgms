package programmingChallenges.P110101;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		String ip;
		while((ip = br.readLine()) != null) {
			StringTokenizer sz = new StringTokenizer(ip," ");
			int i = Integer.parseInt(sz.nextToken());
			int j = Integer.parseInt(sz.nextToken());
			int ti,tj;
			if(i < j) {
				ti = i;
				tj = j;
			}
			else {
				ti = j;
				tj = i;
			}
			int max = 0;
			for(;ti <= tj; ti++) {
				int temp = ti;
				int length = 0;
				while(temp != 1) {
					length += 1;
					if(temp % 2 == 0)
						temp /= 2;
					else
						temp = temp * 3 + 1;
				}
				length += 1;
				if(length > max) max = length;
			}
			result.append(i+" "+j+" "+max);
			
			ip = br.readLine();
		}
		System.out.print(result);
	}

}
