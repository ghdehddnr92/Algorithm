import java.util.Arrays;
import java.util.Scanner;

public class Algo_1920_2 {
	static int N,M;
	static int arr[];
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		arr = new int[N];
		for(int i=0;i<N;i++){
			arr[i] = in.nextInt();
		}

		Arrays.sort(arr);
		M =in.nextInt();

		for(int i=0;i<M;i++){			
			binarySearch(0,arr.length-1,in.nextInt());
		}
	}
	public static void binarySearch(int start, int end, int a){
		int mid = (start+end)/2;
		//System.out.println(start+" "+end);
		if(start > end){
			System.out.println("0");
			return;
		}

		if(arr[mid]>a){
			binarySearch(start,mid-1,a);
		}
		else if(arr[mid]<a){
			binarySearch(mid+1,end,a);
		}
		else{
			System.out.println("1");
			return;
		}
	}
	public static int interSearch(int[] arr,int first,int last,int target){ 
		double mid2; 
		if(arr[first]>target || arr[last]<target)
			//탐색대상이 존재하지 않을 경우 탈출 조건 
			return -1;//-1 반환은 탐색 실패 
		mid2=((double)(target-arr[first])/(arr[last]-arr[first])*(last-first))+first;//도출해낸 공식
		int mid=(int)mid2; 
		if(arr[mid]==target) 
			return mid;//탐색 target의 index값 반환 
		else if(target<arr[mid]) 
			return interSearch(arr,first,mid-1,target); 
		else 
			return interSearch(arr,mid+1,last,target); 
	} 
} 

