import java.util.*;
import java.io.*;
public class DMOJLongestIncreasingSubsequence {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static final int MOD = 1000000007;
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int n = readInt();
		int[] numbers = new int[n];
		for (int i=0; i<n; i++) {
			numbers[i] = readInt();
		}
		int[] dp = new int[n];
		Arrays.fill(dp, 1);
		int length = 0;

		for (int i=0; i<n; i++) {	
			for (int j=0; j<i; j++) {
				if (numbers[j]<numbers[i]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
				System.out.println(Arrays.toString(dp)+"   "+i+"  "+j);
			}
			length = Math.max(length, dp[i]);
		}
		System.out.println(length);
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
