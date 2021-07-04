class All_pairs_shortest_path
{
    final static int inf=9999,v=4;

    void floydwarshal(int [][] graph)
    {
        int i,j,k;
        for(k=0; k<v; k++)
            for(i=0; i<v; i++)
                for(j=0; j<v; j++)
                {
                   //shortest path
                    graph[i][j]=Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
        display(graph);
    }
    // display
    void display(int graph[][])
    {
        System.out.println("shortest distances between every pair of vertices:");
        for (int i=0; i<v; i++)
        {
            for (int j=0; j<v; j++)
            {
                if (graph[i][j]==inf)
                    System.out.print("INF ");
                else
                    System.out.print(graph[i][j]+"   ");
            }
            System.out.println();
        }
    }
    public static void main(String args[])
    {
        int graph[][] = { {0,   3,  inf, 7},
                          {8, 0,   2, inf},
                          {5, inf, 0,   1},
                          {2, inf, inf, 0}
                        };
        All_pairs_shortest_path obj=new All_pairs_shortest_path();
        obj.floydwarshal(graph);
    }      
}

/* OUTPUT:
shortest distances between every pair of vertices:
0   5   8   9
INF 0   3   4
INF INF 0   1
INF INF INF 0 */