import java.util.*;
import java.io.*;
public class CCCPiday3 {
	
	//Pretty much same as Piday1 but made it shorter and more condensed
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static final int MOD = 1000000007;
	static int[][][] dp;

	public static int search(int n, int k, int min) {
		if (n==k || k==1 || k*min==n) return 1;
		if (dp[n][k][min]!=-1) return dp[n][k][min];
		int paths = 0;
		for (int i=min; i<=n/k; i++) {
			paths+=search(n-i, k-1, i);
		}
		return dp[n][k][min] = paths;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int n = readInt(), k = readInt();
		dp = new int[255][255][255];
		for (int i[][]: dp) {
			for (int j[]: i) {
				Arrays.fill(j, -1);
			}
		}
		System.out.println(search(n,k,1));

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