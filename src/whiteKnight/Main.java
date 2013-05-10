package whiteKnight;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	/**
	 * @param args
	 */
//	static boolean [][] marked;
//	static int [][] countPawn;
	
	public static int getMaxPawn(char [][] board,boolean [][] marked, int [][] countPawn,int startX,int startY,int limitX,int limitY) {
		if(startX < 0 || startX > limitX) return 0;
		if(startY < 0 || startY > limitY) return 0;
		if(marked[startX][startY])
			return countPawn[startX][startY];
		int a,b,c,d;
		if(board[startX][startY] == 1) {
			a = 1 + getMaxPawn(board,marked,countPawn,startX-1,startY+2,limitX,limitY);
			b = 1 + getMaxPawn(board,marked,countPawn,startX+1,startY+2,limitX,limitY);
			c = 1 + getMaxPawn(board,marked,countPawn,startX-2,startY+1,limitX,limitY);
			d = 1 + getMaxPawn(board,marked,countPawn,startX+2,startY+1,limitX,limitY);
		}
		else {
			a = getMaxPawn(board,marked,countPawn,startX-1,startY+2,limitX,limitY);
			b = getMaxPawn(board,marked,countPawn,startX+1,startY+2,limitX,limitY);
			c = getMaxPawn(board,marked,countPawn,startX-2,startY+1,limitX,limitY);
			d = getMaxPawn(board,marked,countPawn,startX+2,startY+1,limitX,limitY);
		}
		a = Math.max(a, b);
		c = Math.max(c, d);
		a = Math.max(a, c);
		marked[startX][startY] = true;
		countPawn[startX][startY] = a;
		return a;
	}
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while(T > 0) {
			int n = Integer.parseInt(br.readLine());
			char [][] board = new char [n][n];
			boolean [][] marked = new boolean[n][n];
			int [][] countPawn =  new int [n][n];
			int temp = 0, knightX = 0, knightY = 0;
			while(temp  < n) {
				String ip = br.readLine();
				for(int j = 0; j < ip.length(); j++) {
					if(ip.charAt(j) == '.') {
						board[temp][j] = 0;
					}
					else if(ip.charAt(j) == 'P') {
						board[temp][j] = 1;
					}
					else {
						board[temp][j] = 'K';
						knightX = temp;
						knightY = j;
					}
				}
				
				temp++;
			}
			
//			// mark all direct pawns
//			if(knightX - 1 >= 0 && knightY+2 < n) countPawn[knightX - 1][knightY+2] = 1;
//			if(knightX + 1 < n && knightY+2 < n) countPawn[knightX + 1][knightY+2] = 1;
//			if(knightX - 2 >= 0 && knightY+1 < n) countPawn[knightX - 2][knightY+1] = 1;
//			if(knightX + 2 < n && knightY+1 < n) countPawn[knightX + 2][knightY+1] = 1;
//			
//			
//			
//			for(int col = knightY + 1; col < n; col++) {
//				for(int row = 0; row < n; row++) {
//						if(countPawn[row][col] != 1) {
//							int a = 0, b = 0, c = 0, d = 0;
//							if(col - 1 >= 0 && row -2 >= 0) a = countPawn[row-2][col-1];
//							if(col - 1 >= 0 && row +2 < n) b = countPawn[row+2][col-1];
//							if(col - 2 >= 0 && row -1 >= 0) c = countPawn[row-1][col-2];
//							if(col - 2 >= 0 && row +1 < n) d = countPawn[row+1][col-2];
//							a =  Math.max(a, b);
//							c = Math.max(c, d);
//							a = Math.max(a, c);
//							if(board[row][col] == 1) {
//								countPawn[row][col] = a + 1;
//							} else {
//								countPawn[row][col] = a;
//							}
//					}
//				}
//			}
			
//			for(int i = 0; i < n; i++) {
//				for(int j = 0; j < n; j++) {
//					System.out.print(countPawn[i][j]+" ");
//				}
//				System.out.println();
//			}
//			
//			int maxPawn = -1,col = n-1;
//			for(int row = 0; row < n; row++) {
//				if(maxPawn < countPawn[row][col]) {
//					
//					maxPawn = countPawn[row][col];
//				}
//			}
			
			//result.append(maxPawn+"\n");
			
			int max  = getMaxPawn(board,marked,countPawn,knightX,knightY,n-1,n-1);
			
			result.append(max+"\n");
			
			T--;
		}
		System.out.print(result);
	}

}
