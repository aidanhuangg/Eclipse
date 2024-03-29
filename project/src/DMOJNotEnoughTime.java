import java.util.*;
import java.io.*;
public class DMOJNotEnoughTime {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static final int MOD = 1000000007;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int n = readInt(), t = readInt();
		int[] dp = new int[10001];
		for (int l=1; l<=n; l++) { //loop for multiple customers
			
			int[] revenue = new int[2001], preptime = new int[2001];
			for (int i=1; i<=3; i++) { //we store our item profits and cost of production
				preptime[i] = readInt();
				revenue[i] = readInt();
			}
			
			for (int i = t; i >= 0; i--) { //we start from the greatest amount of time for production and decrement
				for (int k = 1; k <=3; k++) { //loop through our different items and their costs
					if (i >= preptime[k]) {
						dp[i] = Math.max(dp[i], dp[i - preptime[k]] + revenue[k]); //we take the best option, the first for loop at the very beginning will account for the other customers
					}
				}
			}
		}
		System.out.println(dp[t]);
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
