import java.util.*;
public class Knapsack01
{
	static int algorithm(int wt[],int p[],int n,int W)
	{
		//intilization
		int k[][]=new int[n+1][W+1];
        for(int i=0; i<n+1; i++){
            for(int j=0;j<W+1; j++){
                k[i][j]=0;
            }
        }
        //calculation
		for(int r=0; r<n+1; r++)
		{
			for(int c=0; c<W+1; c++)
			{
				if(r==0 || c==0)
					k[r][c]=0;
				else if(wt[r-1]<=W)
					k[r][c]=Math.max(k[r-1][c],k[r-1][W-wt[r-1]]+p[r-1]);
				else
					k[r][c]=k[r-1][c];
			}
		}
		return k[n][W];
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("enter no.of items:");
		int n=sc.nextInt();
		int wt[]=new int[n],p[]=new int[n];
		System.out.println("enter profit and weight of each item:");
		for(int i=0; i<n; i++)
		{
			System.out.print("enter profit and weight of item "+i+":");
			p[i]=sc.nextInt();
			wt[i]=sc.nextInt();
		}
		System.out.print("enter capacity of knapsack:"); 
		int W=sc.nextInt();
		System.out.println("maximum profit:"+Knapsack01.algorithm(wt,p,n,W));
	}
}
/*
OUTPUT:
enter no.of items:5
enter profit and weight of each item:
enter profit and weight of item 0:45 8
enter profit and weight of item 1:78 15
enter profit and weight of item 2:40 25
enter profit and weight of item 3:90 27
enter profit and weight of item 4:60 18
enter capacity of knapsack:50
maximum profit:313
*/
