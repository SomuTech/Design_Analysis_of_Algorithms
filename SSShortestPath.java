public class SSShortestPath
{
	static void dijkstra(int graph[][],int source)
	{
		int count=graph.length;
		boolean visited[]=new boolean[count];
		int dis[]=new int[count];
		
		for(int i=0;i<count; i++)
		{
			visited[i]=false;
			dis[i]=Integer.MAX_VALUE;
		}
		
		dis[0]=0;
		for(int i=0; i<count; i++)
		{
			int u=findMinDistance(visited,dis);
			visited[u]=true;
			for(int v=0; v<count; v++)
			{
				if(!visited[v] && graph[u][v]!=0 && (dis[u]+graph[u][v]<dis[v]))
				{
					dis[v]=dis[u]+graph[u][v];
				}
			}
		}
		//print
		for(int i=0; i<dis.length; i++)
			System.out.println("distance from source to "+ i + " is "+ dis[i]);
	}
	static int findMinDistance(boolean visited[],int dis[])
	{
		int mindistance=Integer.MAX_VALUE;
		int mindistanceVertex=-1;
		for(int i=0; i<dis.length; i++)
		{
			if(!visited[i] && dis[i]<mindistance)
			{
				mindistance=dis[i];
				mindistanceVertex=i;
			}
		}
		return mindistanceVertex;
	}
	
	public static void main(String args[])
	{
		int graph[][]={ { 0,4,2,0,8},
                                      { 0,0,0,4,5 },
                                      { 0, 0,0,1,0 },
                                      { 0, 0,0,0,3 },
                                      { 0, 0, 0, 0,0}};
        SSShortestPath.dijkstra(graph,0);
	}
}

/*OUTPUT
distance from source to 0 is 0
distance from source to 1 is 4
distance from source to 2 is 2
distance from source to 3 is 3
distance from source to 4 is 6
*/