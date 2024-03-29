package project;
import java.util.*;

import java.io.*;
public class test {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static class Edge {
		int to;
		public Edge(int to) {
			this.to = to;
		}
	}
	
	static boolean[] visited, visited2;
	static ArrayList<Edge>[] list;
	
	public static int dfs(int i) {

		visited[i] = true;
		System.out.println(i);
		for (Edge e: list[i]) {
			if (!visited[e.to]) {
				dfs(e.to);
			}
		}
		return 0;
	}
	
	public static void bfs(int i) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(i);
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			System.out.println(temp);
			for (Edge edge: list[temp]) {
				if (!visited2[edge.to]) {
					queue.add(edge.to);
				}
			}
			
		}
	}
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int n = 5;
		list = new ArrayList[n];
		for (int i=0; i<list.length; i++) {
			list[i] = new ArrayList<Edge>();
		}
		visited = new boolean[n];
		visited2 = new boolean[n];
		list[0].add(new Edge(1));
		list[0].add(new Edge(2));
		list[0].add(new Edge(3));
		
		dfs(0);
		bfs(0);
		
		

	}

	static String next() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}

	static long readLong() throws IOException {
		return Long.parseLong(next());
	}

	static int readInt() throws IOException {
		return Integer.parseInt(next());
	}

	static double readDouble() throws IOException {
		return Double.parseDouble(next());
	}

	static char readCharacter() throws IOException {
		return next().charAt(0);
	}

	static String readLine() throws IOException {
		return br.readLine().trim();
	}
}
