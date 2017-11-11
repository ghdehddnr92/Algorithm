import java.util.Scanner;

public class Practice_sort {
	static int arr[];
	
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
		arr = new int[6];
		
		for(int i=0;i<arr.length;i++){
			arr[i] = in.nextInt();
		}
		
	//	bubbleSort();
		//insertionSort();
	//	selectionSort();
	//	mergeSort();
		//qsort(arr,0,6);
		for(int i=0;i<6;i++){
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
		for(int i=1;i<6;i++){
			int tmp = arr[i];
			int aux = i-1;
			while((aux)>=0 && (arr[aux]>tmp)){
				arr[aux+1]= arr[aux];
				aux--;
			}
			arr[aux+1]=tmp;
		}
	}
	public static void selectionSort(){
	
		for(int i=0;i<6;i++){
			int indexMin = i;
			int tmp;
			for(int j=i+1;j<6;j++){
				if(arr[j]<arr[indexMin]){
					indexMin=j;
				}
			}
			tmp = arr[indexMin];
			arr[indexMin]= arr[i];
			arr[i] =tmp;
		}
	}
	public static void mergeSort(int left, int right){
		
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
