import java.util.Scanner;

public class Practice {
	static int tmp[];
	static boolean visited[];
	public static void main(String[]args){
		

		tmp = new int[3];
		visited = new boolean[3];
	//	combination(0,5,3,0);
	//	bubun(3,0);
	}
	public static void combination(int index, int n, int r, int target){
		if(r == 0){
			for(int i=0;i<tmp.length;i++){
				System.out.print(tmp[i]+" ");
			}
			System.out.println();
			return;
		}
		else if(target == n){
			return;
		}
		else {
			tmp[index] = target;
			combination(index+1,n,r-1,target+1);
			combination(index,n,r,target+1);
		}
	}
	public static void bubun(int n, int depth){
		if(n ==depth){
			for(int i=0;i<3;i++){
				if(visited[i]==true){
					System.out.print(i+" ");
				}
			}
			System.out.println("");
			return;
		}
		visited[depth] = true;
		bubun(n,depth+1);
		visited[depth] = false;
		bubun(n,depth+1);
	}
}
