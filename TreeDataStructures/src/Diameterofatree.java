// Java program to find diameter of a
// binary tree using DFS.
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Diameterofatree {

	// Used to track farthest node.
	static int x;
	static int maxCount;
	static List<Integer> adj[];
	
	// Sets maxCount as maximum distance
	// from node
	static void dfsUtil(int node, int count,
						boolean visited[],
					List<Integer> adj[])
	{
		visited[node] = true;
		count++;
		
		List<Integer> l = adj[node];
		for(Integer i: l)
		{
			if(!visited[i]){
				if (count >= maxCount) {
					maxCount = count;
					x = i;
				}
				dfsUtil(i, count, visited, adj);
			}
		}
	}
	
	// The function to do DFS traversal. It uses
	// recursive dfsUtil()
	static void dfs(int node, int n, List<Integer>
									adj[])
	{
		boolean[] visited = new boolean[n + 1];
		int count = 0;
	
		// Mark all the vertices as not visited
		Arrays.fill(visited, false);
	
		// Increment count by 1 for visited node
		dfsUtil(node, count + 1, visited, adj);
		
	}
	
	// Returns diameter of binary tree represented
	// as adjacency list.
	static int diameter(List<Integer> adj[], int n)
	{
		maxCount = Integer.MIN_VALUE;
	
		/* DFS from a random node and then see
		farthest node X from it*/
		dfs(1, n, adj);
	
		/* DFS from X and check the farthest node
		from it */
		dfs(x, n, adj);
	
		return maxCount;
	}
	
	/* Driver program to test above functions*/
	public static void main(String args[])
	{
		int n = 5;
	
		/* Constructed tree is
			1
			/ \
			2 3
		/ \
		4 5 */
		adj = new List[n + 1];
		for(int i = 0; i < n+1 ; i++)
			adj[i] = new ArrayList<Integer>();
	
		/*create undirected edges */
		adj[1].add(2);
		adj[2].add(1);
		adj[1].add(3);
		adj[3].add(1);
		adj[2].add(4);
		adj[4].add(2);
		adj[2].add(5);
		adj[5].add(2);
		
		/* maxCount will have diameter of tree */
		System.out.println("Diameter of the given " +
					"tree is " + diameter(adj, n));
	}
}
// This code is contributed by Sumit Ghosh
