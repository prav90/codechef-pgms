package stanford.RandomContractionAlgorithm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

public class Graph {
	int vertex;
	int size;
	ArrayList<Integer> [] adj;
	
	public Graph(int size) {
		vertex = size;
		this.size = size;
		adj = (ArrayList<Integer>[]) new ArrayList[size+1];
		for(int i = 1; i <= size; i++) {
			adj[i] = new ArrayList<Integer>();
		}
	}
	
	public Graph(Graph original) {
		vertex = original.vertex;
		size = original.size;
		adj = (ArrayList<Integer>[]) new ArrayList[size+1];
		for(int i = 1; i <= size;i++) {
			adj[i] = new ArrayList<Integer>();
			adj[i].addAll(original.adj[i]);
		}
	}
	
	public void addEdge(int u,int v) {
		adj[u].add(v);
		//adj[v].add(u);
	}
	
	public boolean isValid(int vertex) {
		return adj[vertex] != null;
	}
	
	public boolean hasEdge(int pivot, int v) {
		for(int x : adj[pivot]) {
			if(x == v)
				return true;
		}
		return false;
	}
	
	public void merge(int pivot, int v) {
		// remove v from adj[pivot]
		ArrayList<Integer> newAdjPivot = new ArrayList<Integer>();
		for(int x : adj[pivot]) {
			if(x != v)
				newAdjPivot.add(x);
		}
		adj[pivot] = newAdjPivot;
		for(int x : adj[v]) {
			// remove v from all its adjacent nodes and replace it with the pivot
			if(x != pivot) { // remove self loops
				ArrayList<Integer> temp = new ArrayList<Integer>();

				for(int y : adj[x]) {
					if(y == v) {
						temp.add(pivot);
						adj[pivot].add(x);
					}
					else {
						temp.add(y);
					}
				}
				adj[x] = temp;
			}
		}
		adj[v] = null;
		vertex--;
	}
	
	public int getCutSize() {
		for(int i = 1; i <= size; i++ ) {
			if(adj[i] != null) 
				return adj[i].size();
		}
		return -1;
	}
	
	public void print() {
		StringBuilder result = new StringBuilder();
		for(int i = 1; i <= size; i++ ) {
			if(adj[i] != null) {
				result.append("Vertex "+i+": "+ adj[i].size());
//				for(int x : adj[i]) {
//					result.append(x+" ");
//				}
				result.append("\n");
			}
		}
		System.out.print(result);
	}
	
	public static void main(String [] args) throws Exception{
		int size = 200;
		int min = Integer.MAX_VALUE;
		Graph original = new Graph(size);
//		g.addEdge(1,2);
//		g.addEdge(1,2);
//		g.addEdge(1,2);
//		g.addEdge(1,3);
//		g.addEdge(1,4);
//		g.addEdge(1,6);
//		g.addEdge(2,6);
//		g.addEdge(4,5);
//		g.addEdge(5,6);
////		g.addEdge(1,6);
////		g.addEdge(2,6);
////		g.addEdge(4,5);
////		g.addEdge(5,6);
		//g.print();
		BufferedReader br = new BufferedReader(new FileReader("C:\\AndroidWorkspace\\kargerMinCut.txt"));
		String ip = br.readLine();
		while(ip != null) {
			StringTokenizer sz = new StringTokenizer(ip,"\t");
			int u = Integer.parseInt(sz.nextToken());
			while(sz.hasMoreTokens()) {
				int v = Integer.parseInt(sz.nextToken());
				original.addEdge(u, v);
			}
			ip = br.readLine();
		}
		for(int i = 0; i < 10000; i++) {
		Graph g = new Graph(original);
		Random rand = new Random();
		while(g.vertex > 2) {
			int pivot = rand.nextInt(size)+1;
			while(!g.isValid(pivot))
				pivot = rand.nextInt(size)+1;
			int v = rand.nextInt(size)+1;
			while(!g.isValid(v) || v == pivot || !g.hasEdge(pivot,v))
				v = rand.nextInt(size)+1;
			//System.out.println("Merging "+pivot+' '+" and "+v);
			g.merge(pivot, v);
			
		}
		int currmin = g.getCutSize();
		if(currmin < min) min = currmin;
		}
		System.out.print("MinCut Size :"+min);
	}
}
