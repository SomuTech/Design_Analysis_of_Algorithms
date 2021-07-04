import java.util.*;
public class Kruskal
{
	int parent[]=new int[10];
	int find(int m)
	{
		int p=m;
		while(parent[p]!=0)
			p=parent[p];
		return p;
	}
	void union(int i,int j)
	{
		if(i<j)
			parent[i]=j;
		else
			parent[j]=i;
	}
	void krkl(int[][]arr, int n)
	{
		int u=0,k=0,v=0,sum=0;
		while(k<n-1)
		{
			int i,j,min=99;
			for(i=1;i<=n;i++)
				for(j=1;j<=n;j++)
					if(arr[i][j]<min&&i!=j)
						{
							min=arr[i][j];
							u=i;v=j;
						}
						i=find(u);
						j=find(v);
					if(i!=j)
					{
						union(i,j);
						System.out.println("("+u+","+v+")"+"="+arr[u][v]);
						sum=sum+arr[u][v];
						k++;
			}
		arr[u][v]=arr[v][u]=99;
		}
		System.out.println("The cost of minimum spanning tree = "+sum);
	}
	public static void main(String[] args)
	{
		int arr[][]=new int[10][10];
		System.out.println("Enter the number of vertices of the graph");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		System.out.println("Enter the wieghted matrix");
		for(int i=1;i<=n;i++)
		for(int j=1;j<=n;j++)
		arr[i][j]=sc.nextInt();
		Kruskal obj=new Kruskal();
		obj.krkl(arr,n);
	}
}

/*
Output:
Enter the number of vertices of the graph
6
Enter the wieghted matrix
0 3 99 99 6 5
3 0 1 99 99 4
99 1 0 6 99 4
99 99 6 0 8 5
6 99 99 8 0 2
5 4 4 5 2 0
(2,3)=1
(5,6)=2
(1,2)=3
(2,6)=4
(4,6)=5
The cost of minimum spanning tree = 15*/