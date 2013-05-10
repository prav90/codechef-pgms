package buy1get1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {


	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		while(T > 0) {
			String ip = br.readLine();
			int [] caps = new int[26];
			int [] small = new int[26];
			int cost = 0;
			for(int i = 0; i < ip.length(); i++) {
				int charval = Integer.valueOf(ip.charAt(i));
				if(charval > 96) {
					int index = charval - 97;
					if(small[index] > 0) {
						cost += 1;
						small[index] -= 1;
					}
					else
						small[index] += 1;
				}
				else {
					int index = charval - 65;
					if(caps[index] > 0) {
						cost += 1;
						caps[index] = 0;
					}
					else
						caps[index] += 1;
				}
			}
			
			for(int i = 0; i < 26; i++) {
				if(small[i] != 0)
					cost += 1;
				if(caps[i] != 0)
					cost += 1;
			}
			result.append(cost+"\n");
			T--;
		}
		System.out.print(result);

	}

}
