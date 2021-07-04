import java.util.*;
public class HamiltonianCycles
{
     int V, pathCount;
     int path[], graph[][];

    public void findHamiltonianCycle(int[][] g)
    {
        V = g.length;
        path = new int[V];
        Arrays.fill(path, -1);
        graph = g;        
        try
        {            
            path[0] = 0;
            pathCount = 1;            
            solve(0);
            System.out.println("No solution found");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.print("\nPath : ");
            for (int i = 0; i <= V; i++)
                System.out.print(path[i % V] +" ");
        }
    }

    public void solve(int vertex) throws Exception
    {
        if (graph[vertex][0] == 1 && pathCount == V)
            throw new Exception("Solution found");
        if (pathCount == V)
            return;
        for (int i = 0; i < V; i++)
        {
            if (graph[vertex][i] == 1 )
            {
                path[pathCount++] = i;
				graph[vertex][i] = 0;
				graph[i][vertex] = 0;
                if (!isPresent(i))
                    solve(i);
				graph[vertex][i] = 1;
                graph[i][vertex] = 1;
				path[--pathCount] = -1;                    
            }
        }
    }    
    
    public boolean isPresent(int v)
    {
        for (int i = 0; i < pathCount - 1; i++)
            if (path[i] == v)
                return true;
        return false;                
    }

    public static void main (String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        HamiltonianCycles hc = new HamiltonianCycles();
        System.out.print("Enter number of vertices: ");
        int V = scan.nextInt();
        System.out.println("Enter matrix:");
        int[][] graph = new int[V][V];
        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++)
                graph[i][j] = scan.nextInt();
        hc.findHamiltonianCycle(graph);        
    }    
}