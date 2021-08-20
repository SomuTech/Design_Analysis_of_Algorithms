import java.util.*;
class KruskalAlgorithm
{
	static int V = 5;
	static int[] parent = new int[V];
	static int INF = Integer.MAX_VALUE;
	
	int find(int i)
	{
		while (parent[i] != i)
			i = parent[i];
		return i;
	}

	void union(int i, int j)
	{
		int a = find(i);
		int b = find(j);
		parent[a] = b;
	}

	void kruskalMST(int graph[][])
	{
		int sum = 0;
		for (int i = 0; i < V; i++)
			parent[i] = i;
		int k = 0;
		while (k < V - 1)
		{
			int min = INF, a = -1, b = -1;
			for (int i = 0; i < V; i++)
			{
				for (int j = 0; j < V; j++)
				{
					if (find(i) != find(j) && graph[i][j] < min)
					{
						min = graph[i][j];
						a = i;
						b = j;
					}
				}
			}
			union(a, b);
			System.out.printf("Edge %d:(%d, %d) cost:%d \n",k++, a, b, min);
			sum += min;
		}
		System.out.printf("\n Minimum cost= %d \n", sum);
	}
public static void main(String[] args)
{
	int graph[][] = {
		{ INF, 2, INF, 6, INF },
		{ 2, INF, 3, 8, 5 },
		{ INF, 3, INF, INF, 7 },
		{ 6, 8, INF, INF, 9 },
		{ INF, 5, 7, 9, INF },
	};
	KruskalAlgorithm obj=new KruskalAlgorithm();
	obj.kruskalMST(graph);
	}
}

/*Edge 0:(0, 1) cost:2
Edge 1:(1, 2) cost:3
Edge 2:(1, 4) cost:5
Edge 3:(0, 3) cost:6

 Minimum cost= 16
*/