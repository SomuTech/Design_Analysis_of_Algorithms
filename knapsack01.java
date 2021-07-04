
class Knapsack01
{
    static int knapsack(int cap,int[] wt,int[] val,int n)
    {
        int k[][]=new int[n+1][cap+1];
        for(int i=0; i<n+1; i++){
            for(int j=0;j<cap+1; j++){
                k[i][j]=0;
            }
        }
        //
        for(int r=0; r<n+1; r++){
            for(int c=0; c<cap+1; c++)
            {
                if(r==0 || c==0)
                    k[r][c]=0;
                else if(wt[r-1]<=c)
                    k[r][c]=Math.max(val[r-1] + k[r-1][c-wt[r-1]],k[r-1][c]);
                else
                    k[r][c]=k[r-1][c];
            }
        }
    return k[n][cap];
    }

    public static void main(String args[])
    {
        int val[] ={5,6,7,9,12,12,14};
        int weight[]= {2,3,3,4,5,6,7};
        int cap =15;
        System.out.println(Knapsack01.knapsack(cap,weight,val,val.length));
    }
}
