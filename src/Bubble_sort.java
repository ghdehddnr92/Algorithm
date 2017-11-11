import java.util.Scanner;

public class Bubble_sort {
	static int arr[]= {55,7,78,12,42};
	public static void main(String[]args){
		BubbleSort();
		
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println("");
	}
	public static void BubbleSort(){
		int tmp;
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr.length-1;j++){
				if(arr[j]>arr[j+1]){
					tmp =arr[j];
					arr[j]= arr[j+1];
					arr[j+1] = tmp;
				}
				for(int l=0;l<arr.length;l++){
					System.out.print(arr[l]+" ");
				}
				System.out.println("");
			}
		}
	}
}
