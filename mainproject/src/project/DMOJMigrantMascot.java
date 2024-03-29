package project;
import java.util.*;
import java.io.*;

public class DMOJMigrantMascot  {  //maybe look into something similar to dijkstra's? 
	static class Edge implements Comparable<Edge>{
		int to;
		int weight;
		public Edge (int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return 0;
		}
	}
	static class path implements Comparator<Edge> {
		@Override
		public int compare(Edge o1, Edge o2) {
			// TODO Auto-generated method stub
			if (o1.weight < o2.weight) {
				return 1;	
			} else if (o1.weight > o2.weight) {
				return -1;
			}
			return 0;
		}
	}

	public static void search(ArrayList<Edge>[] list, int N, int M) {
		boolean[] visited = new boolean[N];

		int[] lowestpaths = new int[N];
		Arrays.fill(lowestpaths, Integer.MAX_VALUE);
		lowestpaths[0] = 0;

		PriorityQueue<Edge> queue = new PriorityQueue<Edge>(new path());
		visited[0] = true;
		for (Edge j: list[0]) {
			lowestpaths[j.to] = Math.min(lowestpaths[j.to], j.weight);

			if (!visited[j.to]) {
				queue.add(new Edge(j.to, j.weight));
			} 
		}
		while (!queue.isEmpty()) {
			Edge edge = queue.poll();
			visited[edge.to] = true;

			lowestpaths[edge.to] = Math.min(lowestpaths[edge.to], edge.weight);

			for (Edge k: list[edge.to]) {
				if (!visited[k.to]) {
					queue.add(new Edge(k.to, k.weight));
				}
			}
		}
		for (int i: lowestpaths) {
			System.out.println(i);
		}

	}


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static ArrayList<Edge>[] list;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int N = readInt(), M = readInt();
		list = new ArrayList[N];
		for (int i=0; i<list.length; i++) {
			list[i] = new ArrayList<Edge>();
		}
		for (int i=0; i<N; i++) {
			int a = readInt()-1, b = readInt()-1, p = readInt();
			list[a].add(new Edge(b, p));
		}
		search(list, N, M);

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
