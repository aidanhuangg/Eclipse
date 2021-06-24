import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int N = readInt();
		int[] stones = new int[N];
		for (int i=0; i<N; i++) {
			stones[i] = readInt();
		}
		long[] dp = new long[N];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		
		for (int i=0; i<N; i++) { //the stone that we are on currently
			for (int j=i+1; j<=i+2; j++) { //the stone that we are looking at
				if (j<N) {
					dp[j] = Math.min(dp[j], dp[i]+Math.abs(stones[j]-stones[i]));
				}
			}
		}
		System.out.println(dp[N-1]);
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
