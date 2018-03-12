import java.util.Scanner;

public class test{
	static boolean visited[];
	static int arr[] = {2,4,6,8};
	static int tmp[];
	public static void main(String[]args){
		
		visited = new boolean[4];
		tmp = new int[3];
		
		//combination(0,4,2,0);
		//bubun1();
		//bubun2(0);
		factorial(0);
	}
	public static void combination(int index, int n, int r, int target){
		if(r==0){
			for(int i=0;i<2;i++){
				System.out.print(tmp[i]+" ");
			}
			System.out.println("");
		}
		else if(target == n){
			return;
		}
		else{
			tmp[index] = arr[target];
			combination(index+1,n,r-1,target+1);
			combination(index,n,r,target+1);
		}
	}
	public static void bubun1(){
		for(int i=0;i<(1<<3);i++){
			for(int j=0;j<3;j++){
				if((i&(1<<j))>0){
					System.out.print(arr[j]+" ");
				}
			}
			System.out.println("");
		}
	}
	public static void bubun2(int index){
		if(index == 3){
			for(int i=0;i<3;i++){
				if(visited[i]){
					System.out.print(arr[i]+" ");
				}
			}
			System.out.println("");
			return;
		}
		
		visited[index] = true;
		bubun2(index+1);
		visited[index] = false;
		bubun2(index+1);
	}
	public static void factorial(int index ){
		if(index ==3 ){
			if(index == 3){
				for(int i=0;i<3;i++){
					if(visited[i]){
						System.out.print(tmp[i]+" ");
					}
				}
				System.out.println("");
				return;
			}
		}
		for(int i=0;i<3;i++){
			if(!visited[i]){
				tmp[i] = arr[index];
				visited[i] = true;
				factorial(index+1);
				visited[i] =false;
			}
		}
	}
}