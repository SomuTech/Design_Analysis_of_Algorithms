import java.util.*;
class PrimsAlgorithm {
	
	int minKey(int key[], Boolean mstSet[],int V)
	{
		int min = Integer.MAX_VALUE, min_index = -1;
		for (int i = 0; i < V; i++)
			if (mstSet[i] == false && key[i] < min) {
				min = key[i];
				min_index = i;
			}
		return min_index;
	}
	
	void primMST(int graph[][],int V)
	{
		int parent[] = new int[V];
		int key[] = new int[V];
		Boolean mstSet[] = new Boolean[V];
		for (int i = 0; i < V; i++) {
			key[i] = Integer.MAX_VALUE;
			mstSet[i] = false;
		}
		key[0] = 0;
		parent[0] = -1;
		for (int count = 0; count < V - 1; count++) {
			int u = minKey(key, mstSet,V);
			mstSet[u] = true;
			for (int v = 0; v < V; v++)
				if (graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]) {
					parent[v] = u;
					key[v] = graph[u][v];
				}
		}
		
		//printing
		System.out.println("Edge \tWeight");
			for (int i = 1; i < V; i++)
				System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
	}
	
	public static void main(String[] args)
	{
		int graph[][] = new int[][] { { 0, 2, 0, 6, 0 },
									{ 2, 0, 3, 8, 5 },
									{ 0, 3, 0, 0, 7 },
									{ 6, 8, 0, 0, 9 },
									{ 0, 5, 7, 9, 0 } };
		PrimsAlgorithm obj = new PrimsAlgorithm();
		obj.primMST(graph,5);
	}
}