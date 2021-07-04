import java.util.Arrays;
import java.util.Random;
import java.io.*;
class Quick{
	void swap(int[] arr, int i, int j){
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	int partition(int[] arr, int low, int high){
		int pivot=high;
		int p=low,q=high-1;
		int temp=0;
		while(p!= pivot && q!=pivot){
			if(temp==0){
				if(arr[p]>arr[pivot]){
					swap(arr,p,pivot);
					pivot=p;
					temp=1;
				}
				p++;
			}else {
				if(arr[q]<arr[pivot]){
					swap(arr,q,pivot);
					pivot=q;
					temp=0;
				}
				q--;
			}
		}
		return pivot;
	}
	void quickSort(int[] arr, int low, int high){
		if(low >= high) return;
		int part=partition(arr,low,high);
		quickSort(arr,low,part-1);
		quickSort(arr,part+1,high);
	}
}
class Merge{
	void divide(int[] arr, int start, int end){
		if(start == end || start> end) return;
		int mid=(start+end)/2;
		divide(arr,start,mid);
		divide(arr,mid+1,end);
		merge(arr,start,mid,end);
	}
	void merge(int[] arr, int start, int mid, int end){
		int size1=(mid-start)+1,size2=(end-mid);
		int[] a1 =new int[size1],a2 =new int[size2];
		if (size1 > 0) System.arraycopy(arr, start , a1, 0, size1);
		if(size2 > 0) System.arraycopy(arr,mid+1,a2,0,size2);
		int i=0,j=0,k=start;
		while(i<size1 && j<size2){
			if(a1[i]<a2[j]){
				arr[k]=a1[i];
				i++;
			}else{
				arr[k]=a2[j];
				j++;
			}
			k++;
		}
		while(i<size1){
			arr[k]=a1[i];
			k++;
			i++;
		}
		while(j<size2){
			arr[k]=a2[j];
			k++;
			j++;
		}
	}
}

public class Week1{
	Quick q=new Quick();
	Merge m=new Merge();
	float[] t1 =new float[10];
	float[] t2 =new float[10];
	int[] arr1;
	int[] arr2;
	long start1=0,start2=0,end1=0,end2=0;
	void calculate(int i){
		start1=System.nanoTime();
		q.quickSort(arr1,0,arr1.length-1);
		end1=System.nanoTime();
		start2=System.nanoTime();
		m.divide(arr2,0,arr2.length-1);
		end2=System.nanoTime();
		t1[i/100-11]=((float)(end1-start1))/1000000;
		t2[i/100-11]=((float)(end2-start2))/1000000;
	}
	void initializer(int i){
		arr1=new int[i];
		arr2=new int[i];
	}
	void average(){
		Random r=new Random();
		for(int i=1100;i<=2000;i+=100){
			initializer(i);
			for(int j=0;j<i;j++){
				arr1[j]=r.nextInt(i);
				arr2[j]=arr1[j];
			}
			calculate(i);
		}
		printDetails("Average");
	}
	void best(){
		for(int i=1100;i<=2000;i+=100){
			initializer(i);
			for(int j=0;j<i;j++) {
				arr1[j] = j + 1;
				arr2[j] = j + 1;
			}
			calculate(i);
		}
		printDetails("Best");
	}
	void worst(){
		for(int i=1100;i<=2000;i+=100){
			initializer(i);
			for(int j=0;j<i;j++) {
				arr1[j] = i-j-1;
				arr2[j] = i-j-1;
			}
			calculate(i);
		}
		printDetails("Worst");
	}
	void printDetails(String str){
		System.out.println("In "+str+" case:\n");
		for(int i=1100,k=0;k<t1.length;i+=100,k++)
			System.out.printf("Array of size %d took %.2f ms in quickSort, %.2f ms in merge sort%n",i,t1[k],t2[k]);
		System.out.println("-----------------------------------------------");
		writing();
	}
	void writing(){
		try{
			FileWriter data = new FileWriter("value.txt",true);
			for(int i=0;i<t1.length;i++) data.write(t1[i]+" ");
			data.write("\n");
			for(int i=0;i<t2.length;i++) data.write(t2[i]+" ");
			data.write("\n");
			data.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
		Week1 w=new Week1();
		w.best();
		w.average();
		w.worst();
	}
}