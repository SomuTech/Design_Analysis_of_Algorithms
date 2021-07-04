public class Knapsack
{
    static int snap(int v[],int w[],int ca,int n)
    {
        double p_w[]=new double[n];
		int item[]=new int[n];
        for(int i=0; i<v.length; i++){
            p_w[i]=v[i]/w[i];
			item[i]=i+1;
		}
		System.out.println("item\tweight\tvalue\tv/w");
		for(int i=0;i<n;i++)
			System.out.println(item[i]+"\t"+w[i]+"\t"+v[i]+"\t"+p_w[i]);
        //sorting
        for(int i=0;i<n-1;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if(p_w[i]<p_w[j])
				{
					double temp=p_w[j]; p_w[j]=p_w[i]; p_w[i]=temp;
					int temp1=v[j]; v[j]=v[i]; v[i]=temp1;
					temp1=w[j]; w[j]=w[i]; w[i]=temp1;
					temp1=item[j];item[j]=item[i];item[i]=temp1;
				}
			}
		}
        int sum=0,k=0;
		//cost calculation
        while(ca>0)
		{
			if(w[k]<ca)
			{
				sum+=1*v[k];
				ca=ca-w[k];
			}
			else
			{
                sum+=v[k]*(float)ca/w[k];
				ca=0;
			}
			k++;
		}
		System.out.println("rearranging");
		System.out.println("item\tweight\tvalue\tv/w");
		for(int i=0;i<n;i++)
			System.out.println(item[i]+"\t"+w[i]+"\t"+v[i]+"\t"+p_w[i]);
        return sum;
    }
    public static void main(String args[])
    {
        int w[]={18,15,10},v[]={25,24,15};
        int ca=20;
        System.out.println("minimum cost:"+Knapsack.snap(v,w,ca,3));
    }
}

/*output

C:\Users\Somashekar\Desktop\sem4\DAA_LAB>java Knapsack
item    weight  value   v/w
0       5       30      6.0
1       10      20      2.0
2       20      300     15.0
3       40      100     2.0
4       30      150     5.0
rearranging
item    weight  value   v/w
2       20      300     15.0
0       5       30      6.0
4       30      150     5.0
3       40      100     2.0
1       10      20      2.0
minimum cost:492
  */
