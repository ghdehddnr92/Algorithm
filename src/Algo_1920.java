import java.util.Arrays;
import java.util.Scanner;

public class Algo_1920 {
	static int A[];
	static int N;
	static int M;
	static int B[];
	public static void main(String[]args){
		Scanner in =new Scanner(System.in);
		
		N = in.nextInt();
		A = new int[N];
		for(int i= 0;i<N;i++){
			A[i] = in.nextInt();
		}
		M = in.nextInt();
		B = new int[M];
		for(int i=0;i<M;i++){
			B[i] = in.nextInt();
		}
		qsort(A,0,N-1);
		
		for(int i=0;i<M;i++){
			binarySearch(B[i],0,N-1);
		}
	}
	public static void binarySearch(int num,int start, int end){
		int mid = (start+end)/2;
	//	System.out.println(start+" "+end);
		if(start>end){
			System.out.println("0");
			return;
		}
		if(A[mid]==num){
			System.out.println("1");
			return;
		}
		else if(A[mid]<num){
			binarySearch(num,mid+1,end);
		}
		else{ // A[mid] > num
			binarySearch(num,start,mid-1);
		}
	}
	public static void qsort(int arr[], int left, int right){
		int i, j, tmp, pivot;
		
		if(left < right){
			i = left;
			j = right;
			pivot = arr[left];
			while(i < j){
				while(arr[j]>pivot){
					j--;
				}
				while(i<j && arr[i]<=pivot){
					i++;
				}
				tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
		
			}
			arr[left] = arr[i];
		    arr[i] = pivot;
			qsort(arr,left,i-1);
			qsort(arr,i+1,right);
		}
	}
}
