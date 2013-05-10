package MagicBoard;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.StringTokenizer;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String ip = br.readLine();
		StringTokenizer sz = new StringTokenizer(ip," ");
		StringBuilder result = new StringBuilder();
		int n = Integer.parseInt(sz.nextToken());
		BitSet [] magicboard = new BitSet[n];
		//int [] rowCount = new int[n];
		int [] colCount = new int[n];
		for(int i = 0; i < n; i++) {
			magicboard[i] = new BitSet();
			//rowCount[i] = n;
			colCount[i] = n;
		}
		int q = Integer.parseInt(sz.nextToken());
		while(q > 0) {
			sz= new StringTokenizer(br.readLine()," ");
			String query = sz.nextToken();
			if(query.equals("RowQuery")) {
				int queryNum = Integer.parseInt(sz.nextToken());
				result.append((n-magicboard[queryNum-1].cardinality())+"\n");
				//result.append(rowCount[queryNum-1]+"\n");
			}
			else if(query.equals("ColQuery")) {
				int queryNum = Integer.parseInt(sz.nextToken());
				result.append(colCount[queryNum-1]+"\n");
			}
			else if(query.equals("RowSet")) {
				int queryNum = Integer.parseInt(sz.nextToken());
				int val = Integer.parseInt(sz.nextToken());
				int row = queryNum - 1;
				if(val == 0) {
					//rowCount[row] = n;
					// increment all columns count by 1 if the bit at n is true
					for(int i = 0; i < n; i++) {
						if(magicboard[row].get(i) == true) {
							colCount[i]+= 1;
							// 	set the bit in the column to false
							magicboard[row].set(i,false);
						}
					}
					
				}
				else {
					//rowCount[row] = 0;
					// decrement all columns by count 1 if the bit at n is false
					for(int i = 0; i < n; i++) {
						if(magicboard[row].get(i) == false) {
							colCount[i]-= 1;
							// set the bit in the column to true
							magicboard[row].set(i,true);
						}
					}
				}
			}
			else { // colset
				int queryNum = Integer.parseInt(sz.nextToken());
				int val = Integer.parseInt(sz.nextToken());
				int col = queryNum - 1;
				if(val == 0) {
					colCount[col] = n;
					// increment all rows count by 1 if bit at n is true
					for(int i = 0; i < n; i++) {
						if(magicboard[i].get(col) == true) {
							//rowCount[i]+= 1;
							// set that bit to false
							magicboard[i].flip(col);
						}
					}
				}
				else {
					colCount[col] = 0;
					// decrement all rows by count 1 if bit at n is false
					for(int i = 0; i < n; i++) {
						if(magicboard[i].get(col) == false) {
							//rowCount[i]-=1;
							// set that bit to true
							magicboard[i].flip(col);
						}
					}
				}
			}
			q--;
		}
		System.out.print(result);
	}

}
