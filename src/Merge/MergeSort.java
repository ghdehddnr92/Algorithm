package Merge;

import java.util.Arrays;

public class MergeSort {
	static int sorted[] = new int[8];

	public static void mergeSort(int arr[],int start,int end){
		int mid;
		if(start<end){
			mid = (start+end)/2;
			//분할 과정
			mergeSort(arr,start,mid);
			mergeSort(arr,mid+1,end);
			//병합
			merge(arr,start,mid,end);
		}
	}
	public static void merge(int arr[],int start, int mid, int end){
		int i;
		int leftIndex = start; //왼쪽의 배열 인덱스 
		int rightIndex= mid+1; // 오른쪽의 배열 인덱스 
		int destIndex=0;
		
		while(leftIndex<=mid && rightIndex<=end){
			if(arr[leftIndex] < arr[rightIndex]){
				sorted[destIndex]=arr[leftIndex];
				leftIndex++;
			}
			else{
				sorted[destIndex]=arr[rightIndex];
				rightIndex++;
			}
			destIndex++;
		}
		while(leftIndex<= mid){
			sorted[destIndex++] = arr[leftIndex++];
		}
		while(rightIndex<=end){
			sorted[destIndex++] = arr[rightIndex++];
		}
		
		destIndex = 0;
		for(int a=start;a<=end;a++){
			arr[a] = sorted[destIndex++];
		}
		showArr(arr);
	}
	public static void showArr(int arr[]){
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println("");
	}
}
