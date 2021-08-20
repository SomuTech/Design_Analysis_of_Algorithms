import java.util.*;
class QuickSort
{
	void quick(int arr[],int low,int high)
	{
		if(low <high)
		{
			int pi=partition(arr,low,high);
			quick(arr,low,pi-1);
			quick(arr,pi+1,high);
		}
	}
	int partition(int arr[],int low,int high)
	{
		int p=arr[high],i=low-1;
		for(int j=low;j<=high-1;j++)
		{
			if(arr[j]<p)
			{
				i++;
				int temp=arr[j]; arr[j]=arr[i]; arr[i]=temp;
			}
		}
		int temp=arr[i+1]; arr[i+1]=arr[high]; arr[high]=temp;
		return (i+1);
	}
}

class MergeSort
{
	void merge(int arr[],int l,int m,int r)
	{
		int n1=m-l+1,n2=r-m;
		int la[]=new int[n1],ra[]=new int[n2];
		for(int i=0;i<n1;++i)
			la[i]=arr[l+i];
		for(int j=0;j<n2;++j)
			ra[j]=arr[m+1+j];
		int i=0,j=0,k=l;
		while(i<n1&&j<n2){
			if(la[i]<=ra[j]){
				arr[k]=la[i];
				i++;}
			else{
				arr[k]=ra[j];
				j++;
			}
			k++;
		}
		while(i<n1){
			arr[k]=la[i];
			i++;
			k++;
		}
		while(j<n2){
			arr[k]=ra[j];
			j++;
			k++;
		}
	}
	void divide(int arr[],int l,int r)
	{
		if(l<r){
			int m=(l+r)/2;
			divide(arr,l,m);
			divide(arr,m+1,r);
			merge(arr,l,m,r);
		}
	}
}

public class Sorting_Alg
{
	public static void main(String args[])
	{
		MergeSort obj=new MergeSort();
		QuickSort obj1=new QuickSort();
		Random objr=new Random();
		long bestq[]=new long[5],worstq[]=new long[5],avgq[]=new long[5];
		long bestm[]=new long[5],worstm[]=new long[5],avgm[]=new long[5];
		for(int l=0;l<5;l++)
		{
			int arr[]=new int[1000];
			//average case
			for(int b=0;b<1000;b++)
				arr[b]=objr.nextInt(2001-1000)+1000;
			long mstart=System.nanoTime();
			obj.divide(arr,0,arr.length-1);
			long mend=System.nanoTime();
			long qstart=System.nanoTime();
			obj1.quick(arr,0,arr.length-1);
			long qend=System.nanoTime();
			avgq[l]=(qend-qstart); avgm[l]=(mend-mstart);
			int arr1[]=new int[1000];
			int temp=arr.length-1;
			//worst case
			for(int i=0;i<arr.length;i++)
				arr1[i]=arr[temp--];
			mstart=System.nanoTime();
			obj.divide(arr1,0,arr1.length-1);
			 mend=System.nanoTime();
			 qstart=System.nanoTime();
			obj1.quick(arr1,0,arr1.length-1);
			 qend=System.nanoTime();
			worstq[l]=(qend-qstart); worstm[l]=(mend-mstart);
			//best case
			mstart=System.nanoTime();
			obj.divide(arr1,0,arr1.length-1);
			 mend=System.nanoTime();
			 qstart=System.nanoTime();
			obj1.quick(arr1,0,arr1.length-1);
			 qend=System.nanoTime();
			bestq[l]=(qend-qstart); bestm[l]=(mend-mstart);
		}
		System.out.println("best case of quick");
		for(long i:bestq)
			System.out.print(i+",");
		System.out.println("\nbest case of merge");
		for(long i:bestm)
			System.out.print(i+",");
		System.out.println("\navg case of quick");
		for(long i:avgq)
			System.out.print(i+",");
		System.out.println("\navg case of merge");
		for(long i:avgm)
			System.out.print(i+",");
		System.out.println("\nworst case of quick");
		for(long i:worstq)
			System.out.print(i+",");
		System.out.println("\nworst case of merge");
		for(long i:worstm)
			System.out.print(i+",");
	}
}

/*OUTPUT
best case of quick
4345600,3995400,3987500,1100600,1056100,
best case of merge
294200,264100,249000,190900,205300,
avg case of quick
10379100,4663900,3626900,1087800,1095100,
avg case of merge
1675700,459000,311200,343500,284800,
worst case of quick
4398500,4435200,4080900,1088200,1051700,
worst case of merge
370000,296100,235400,198800,203500,
*/
