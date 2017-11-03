import java.util.Scanner;

public class Practice_sort {
	static int arr[];
	
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
		arr = new int[7];
		
		for(int i=0;i<arr.length;i++){
			arr[i] = in.nextInt();
		}
		
	//	bubbleSort();
	//	insertionSort();
		qsort(arr,0,6);
		for(int i=0;i<7;i++){
			System.out.print(arr[i]+" ");
		}
	}
	public static void bubbleSort(){
		int tmp=0;
		for(int i=0;i<6;i++){
			for(int j=0;j<5;j++){
				if(arr[j]>arr[j+1]){
					tmp = arr[j+1];
					arr[j+1]= arr[j];
					arr[j]= tmp;
				}
			}
		}
	}
	public static void insertionSort(){
		int tmp=0;
		for(int i=0;i<6;i++){
			for(int j=0;j<5;j++){
				if(arr[j]>arr[j+1]){
					
				}
			}
		}
	}
	public static void qsort(int arr[],int left, int right){

		int i,j,pivot, tmp;

		if(left<right){
			i = left;
			j = right;
			pivot = arr[left];

			while(i<j){
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
