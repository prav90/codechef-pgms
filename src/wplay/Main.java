package wplay;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

class TrieST<Value> {
	private static  int R = 26;
	
	private Node root = new Node();
	
	private static class Node {
		private Object val;
		private Node[] next = new Node[R];
	}
	
	public Value get(String key) {
		Node x = get(root,key,0);
		if(x == null) return null;
		return (Value) x.val;
	}
	
	private Node get(Node x, String key, int d) {
		if( x == null) return null;
		if( d == key.length()) return x;
		char c =  (char) (key.charAt(d) - 65);
		return get(x.next[c],key,d+1);
	}
	
	public void put(String key) {
		root = put(root,key,0);
	}
	private Node put(Node x, String key, int d) {
		if(x == null) {
			x = new Node();
		}
		if(d == key.length()) {
			x.val = d;
			return x;
		}
		char c = (char) (key.charAt(d) - 65);
		x.next[c] =  put(x.next[c],key,d+1);
		return x;
	}
	
	public Iterable<String> keys() {
		return keysWithPrefix("");
	}
	
	public boolean hasPrefix(String prefix) {
		return hasPrefix(root,prefix,0);
	}
	
	private boolean hasPrefix(Node x,String prefix,int d) {
		
		if(d == prefix.length()) return true;
		if(x == null) return false;
		char c = (char) (prefix.charAt(d) - 65);
		return (x.next[c] != null && hasPrefix(x.next[c],prefix,d+1));
	}
	
	private Iterable<String> keysWithPrefix(String prefix) {
		Queue<String> queue = new LinkedList<String>();
		Node x = get(root,prefix, 0);
		collect(x,prefix,queue);
		return queue;
	}
	
	private void collect(Node x, String key,Queue<String> q) {
		if(x == null) return;
		if(x.val != null) q.add(key);
		for(int c = 0; c < R; c++) {
			collect(x.next[c], key + ((char)(c+65)), q);
		}
		
	}
}

public class Main {

	/**
	 * @param args
	 */
	private static int maxLengthFound;
	private static String maxLengthWord;
	private static Set<String> set = new HashSet<String>();
	public static String findOptimalWord(String board, int [] usedCount, TrieST<Integer> dict,Set<String> set) {
		maxLengthFound = 0;
		maxLengthWord = null;
		getMaxLengthWord(board,dict, "",set);
		if(maxLengthFound == 0) {
			return null;
		}
		else {
			return maxLengthWord;
		}
	}
	
	private static void getMaxLengthWord(String board,TrieST<Integer> dict,String prefix,Set<String> set) {
		if(prefix != "" && !dict.hasPrefix(prefix)) {set.add(prefix);return;}
		
		else {
			//System.out.println("*****here too "+dict.hasPrefix(prefix));
			Integer wlen = dict.get(prefix);
			if(wlen != null && wlen > maxLengthFound) {
				maxLengthFound = wlen;
				maxLengthWord = prefix;
			}
			
			int N = board.length();
			for(int i = 0; i < N; i++) {
//				System.out.println(" inside loop "+ set.contains(prefix+board.charAt(i)));
				if(!set.contains(prefix+board.charAt(i)))
					getMaxLengthWord(board.substring(0, i)+board.substring(i+1,N), dict, prefix+board.charAt(i),set);
			}
		}
	}
	
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		TrieST<Integer> dict = new TrieST<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int D = Integer.parseInt(br.readLine());
		while(D > 0) {
			String ip = br.readLine();
			dict.put(ip);
			D--;
		}
		StringTokenizer sz = new StringTokenizer(br.readLine()," ");
		int r = Integer.parseInt(sz.nextToken());
		int c = Integer.parseInt(sz.nextToken());
		int T = Integer.parseInt(br.readLine());
		while(T > 0) {
			int rows = r;
			String board = "";
			int [] usedCount = new int[26];
			
			while(rows > 0) {
				String row = br.readLine();
				for(int i = 0; i < row.length(); i++) {
					usedCount[row.charAt(i) - 65] += 1;
				}
				board += row;
				rows--;
			}
			//System.out.println(board);
			int start = 0;
			while(true) {
				String formedWord = findOptimalWord(board,usedCount,dict,set);
				if(formedWord == null) {
					break; // current player lost
				}
				else { // mark used characters,switch player
					start = start == 0? 1 : 0;
					for(int i = 0; i < formedWord.length(); i++) {
						usedCount[formedWord.charAt(i) - 65] -= 1;
					}
					board = ""; // reset the board with unused characters
					for(int i = 0; i < usedCount.length; i++) {
						int tmp = usedCount[i];
						while(tmp > 0) {
							board += ((char) (i+65));
							tmp --;
						}
					}
				}
			}
			if(start == 0) {
				result.append("Bob\n");
			}
			else {
				result.append("Alice\n");
			}
			T--;
		}
		System.out.print(result);
//		
//		for(String x : dict.keys()) {
//			System.out.println(x);
//			System.out.println(dict.get(x));
//		}
		
	}

}
