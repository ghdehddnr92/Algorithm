import java.util.*;
import java.io.*;
/**
 * 퀵 정렬 소스 코드 
 */
public class QuickSort {

	public static void main(String []args){

		int arr[] = {5,3,7,6,2,1,4};

		quickSort(arr,0,arr.length-1);
	
		showArr(arr);
	}

	/**
	 * quickSort 정렬구현 메소드
	 * 
	 * @param arr 정렬할 배열 
	 * @param left 배열의 왼쪽 인덱스 
	 * @param right 배열의 오른쪽 인덱스
	 */
	public static void quickSort(int arr[], int left, int right){
		int i,j,pivot,tmp;

		if(left < right){
			i = left;
			j = right;
			pivot = arr[left];
 
			while(i < j){
				while(arr[j] > pivot){
					j--;
				}
				
				while(i<j && arr[i] <= pivot){
					i++;
				}
				
				tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
			}
			
			arr[left] = arr[i];
			arr[i] = pivot;
			
			quickSort(arr,left,i-1);
			quickSort(arr,i+1,right);
		}
	}
	
	public static void showArr(int arr[]){
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}
}