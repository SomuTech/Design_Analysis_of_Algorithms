import java.util.*;
import java.lang.Math;
public class Week_9
{
    void subset(int num,int n, int x[])
    {
        for(int i=1;i<=n;i++)
            x[i]=0;        //x=[0 0 0 0 0]
        for(int i=n;num!=0;i--)  //
        {
            x[i]=num%2;     //0 0
            num=num/2;      //0
        }
    }
    public static void main(String[] args) 
    {
        int n,d,sum,present=0;
        int j;
        System.out.print("Enter the number of elements of set: "); 
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();                         //n=5
        int a[]=new int[n+1], x[]=new int[n+1]; //a=6,x=6
        System.out.print("Enter the elements of set: ");
        for(int i=1;i<=n;i++)   
            a[i]=sc.nextInt();  //1 2 3 4 5
        System.out.print("Enter the positive integer sum: ");
        d=sc.nextInt();       //5
        if(d>0)
        {
            for(int i=1;i<=Math.pow(2,n)-1;i++)  //2^5=32
            {
                Week_9 obj=new Week_9();
                obj.subset(i,n,x);
                sum=0;
                for(j=1;j<=n;j++)
                if(x[j]==1)
                    sum=sum+a[j];
                if(d==sum)
                {
                    System.out.print("Subset elements: ");
                    present=1;
                    for(j=1;j<=n;j++)
                        if(x[j]==1)
                            System.out.print(a[j]+" ");
                    System.out.println();
                }
            }
        }
        if(present==0)
        System.out.println("Solution does not exists!");
    }
}
