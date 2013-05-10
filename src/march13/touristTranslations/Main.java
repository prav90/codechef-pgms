package march13.touristTranslations;

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
		StringTokenizer ip = new StringTokenizer(br.readLine()," ");
		StringBuilder finalResult = new StringBuilder();
		int T = Integer.parseInt(ip.nextToken());
		String perm = ip.nextToken();
		char [] charSubs = perm.toCharArray();
		perm = perm.toUpperCase();
		char [] charSubsUpper = perm.toCharArray();
		while(T-- > 0) {
			String code = br.readLine();
			String result = "";
			for(int i = 0; i < code.length(); i++) {
				char c = code.charAt(i);
				if( c >= 'a' && c <= 'z') {
					result += charSubs[c - 'a'];
				}
				else if(c >= 'A' && c <= 'Z') {
					result += charSubsUpper[c - 'A'];
				}
				else if(c == '_') {
					result += " ";
				}
				else {
					result += c;
				}
			}
			finalResult.append(result+"\n");
		}
		System.out.print(finalResult);
	}

}
