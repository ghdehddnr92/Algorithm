import java.util.Scanner;

public class test {
	static int N,M;
	static int arr[][];
	static int com[];
	public static void main(String []args){
		Scanner in = new Scanner(System.in);
		N= in.nextInt();
		M= in.nextInt();
		
		arr = new int[N][M];
		com = new int[N*M];
	
		combination(0,N*M,3,1);
	}
	public static void combination(int index, int n, int r, int target){
		if(r ==0){
			for(int i=0;i<index;i++){
				System.out.print(com[i]+" ");
			}
			System.out.println("");
		}
		else if (target == n){
			return;
		}
		else{
			com[index]= target;
			combination(index+1, n,r-1 ,target+1);
			combination(index, n, r, target+1);
		}
	}	
}
