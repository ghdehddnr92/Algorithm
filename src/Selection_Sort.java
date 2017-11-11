
public class Selection_Sort {
	static int arr[]={9,1,6,8,4,3,2,0};
	static int cur=0;
	public static void main(String[]args){
		
		SelectionSort();
	}
	public static void SelectionSort(){
		
		for(int i=0;i<arr.length;i++){
			int min=Integer.MAX_VALUE;
			int tmp;
			for(int j=i;j<arr.length;j++){
				if(arr[j]<min){
					min= arr[j];
					cur = j;
				}
			}
			tmp = arr[i];
			arr[i] = arr[cur];
			arr[cur] = tmp;
			
			for(int k=0;k<arr.length;k++){
				System.out.print(arr[k]+" ");
			}
			System.out.println("");
		}
	}
}
