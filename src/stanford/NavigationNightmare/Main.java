package stanford.NavigationNightmare;

import java.util.Scanner;

public class Main {
	
	static class Farm {
		int FarmX,FarmY;
		boolean coord = false;
	}
	
	static class Road {
		int from,to;
		int length;
		char dir;
		int time;
		Road(int from,int to,int length,char dir, int time) {
			this.from = from;
			this.to = to;
			this.length = length;
			this.dir = dir;
			this.time = time;
		}
	}
	
	static class Query {
		int fromq,toq;
		int time;
		Query(int fromq, int toq, int time) {
			this.fromq = fromq;
			this.toq = toq;
			this.time = time;
		}
	}
	
	static void union(int [] farms, int f1, int f2) {
		farms[find(farms,f1)] = find(farms,f2); 
	}
	
	static int find(int [] farms,int f1) {
		while(f1 !=  farms[f1]) f1 = farms[f1];
		return f1;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int M = scan.nextInt();
		
		int [] farms = new int[N+1];
		Farm [] farmPosition = new Farm[N+1];
		for(int i = 0; i < farmPosition.length; i++) {
			farmPosition[i] = new Farm();
		}
		farms[0] = -1;
		for(int i = 1; i <= N; i++) {
			farms[i] = i;
		}
		
		Road [] roads = new Road[M];
		
		int i = 0;
		
		boolean first = true;
		
		while(M-- > 0) {
			
			int F1 = scan.nextInt();
			int F2 = scan.nextInt();
			int D  = scan.nextInt();
			char dir = scan.next().charAt(0);
			
			roads[i++] = new Road(F1,F2,D,dir,i);
		
			if(first) {
				farmPosition[F1].FarmX = 0;
				farmPosition[F1].FarmY = 0;
				farmPosition[F1].coord = true;
				first = false;
			}
			
			Farm currNode,coordinateNode;
			if(farmPosition[F2].coord == true) { // reverse length
				currNode = farmPosition[F1];
				coordinateNode = farmPosition[F2];
				D = -D;
			}
			else {
				currNode = farmPosition[F2];
				coordinateNode = farmPosition[F1];
			}
			if(dir == 'N') {
				currNode.FarmX = coordinateNode.FarmX;
				currNode.FarmY = coordinateNode.FarmY + D;
			}
			else if(dir == 'S') {
				currNode.FarmX = coordinateNode.FarmX;
				currNode.FarmY = coordinateNode.FarmY + (-D);
			}
			else if(dir == 'E') {
				currNode.FarmX = coordinateNode.FarmX + (D);
				currNode.FarmY = coordinateNode.FarmY ;
			}
			else {
				currNode.FarmX = coordinateNode.FarmX+ (-D);
				currNode.FarmY = coordinateNode.FarmY ;
			}
			currNode.coord = true;
		}
		
		//for(i = 1; i < farmPosition.length; i++)
			//System.out.println("Farm :"+i+" xcord :"+farmPosition[i].FarmX+" ycord :"+farmPosition[i].FarmY);
		
		int T = scan.nextInt();
		
		Query [] query = new Query[T];
		i = 0;
		while(T-- > 0) {
			int from = scan.nextInt();
			int to = scan.nextInt();
			int time = scan.nextInt();
			query[i++] = new Query(from, to, time);
		}
		StringBuilder result = new StringBuilder();
		
		for(i = 0; i < query.length; i++) {
			int fromsite = query[i].fromq;
			int tosite = query[i].toq;
			for(int j = 0; j < query[i].time; j++) {
				union(farms,roads[j].from,roads[j].to);
			}
			if(find(farms,fromsite) == find(farms,tosite)) {
				int dist = Math.abs(farmPosition[fromsite].FarmX - farmPosition[tosite].FarmX);
				dist += Math.abs(farmPosition[fromsite].FarmY - farmPosition[tosite].FarmY);
				result.append(dist+"\n");
			}
			else {
				result.append("-1\n");
			}
		}
		System.out.print(result);
	}

}
