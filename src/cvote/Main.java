package cvote;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringBuilder result = new StringBuilder();
		StringTokenizer sz = new StringTokenizer(br.readLine()," ");
		int chefcount = Integer.parseInt(sz.nextToken());
		int M = Integer.parseInt(sz.nextToken());
		HashMap<String,Integer> chefVoteCount = new HashMap<String,Integer>();
		HashMap<String,String> chefcountry = new HashMap<String,String>();
		HashMap<String,Integer> countryVoteCount = new HashMap<String,Integer>();
		while(chefcount-- > 0) {
			sz = new StringTokenizer(br.readLine()," ");
			String chef = sz.nextToken();
			String country = sz.nextToken();
			chefVoteCount.put(chef,0);
			countryVoteCount.put(country,0);
			chefcountry.put(chef,country);
		}
		String maxChef = "";
		String maxCountry = "";
		while(M-- > 0) {
			String key = br.readLine();
			chefVoteCount.put(key, chefVoteCount.get(key)+1);
			String country = chefcountry.get(key);
			countryVoteCount.put(country, countryVoteCount.get(country)+1);
			if(maxChef == "" && maxCountry == "") {
				maxChef = key;
				maxCountry = country;
			}
			else {
				if(!(maxChef.compareTo(key) == 0)){ // not the samechefs
					int max = chefVoteCount.get(maxChef);
					int current = chefVoteCount.get(key);
					if(current > max)
						maxChef = key;
					else if(current == max) {
						maxChef = (maxChef.compareTo(key) > 0? key : maxChef);
					}
				}
				if(!(maxCountry.compareTo(country) == 0)){ // not the samechefs
					int max = countryVoteCount.get(maxCountry);
					int current = countryVoteCount.get(country);
					if(current > max)
						maxCountry = country;
					else if(current == max) {
						maxCountry = (maxCountry.compareTo(country) > 0? country : maxCountry);
					}
				}
			}
		}
		
		System.out.println(maxCountry);
		System.out.println(maxChef);
		
	}

}
