
public class SortPractice {
	static int arr[] = {9,1,6,8,4,3,2,0};
	static int tmp[];
	public static void main(String[]args){
		tmp = new int[arr.length];
		
		mergeSort(0,arr.length-1);
	}
	public static void mergeSort(int start, int end){
		
		if(end - start<1){
			return;
		}
		
		int mid = (start+end)/2;
		
		mergeSort(start,mid);
		mergeSort(mid+1,end);
		
		merge(start, mid , end);
		
	}
	public static void merge(int start, int mid, int end){
		int left = start;
		int right = mid+1;
		int resultIndex = 0;
		
		while(left <= mid && right <= end){
			
		}
	}
}
