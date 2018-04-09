import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test2 {
	static int tmp[];
	static boolean visited[];
	public static void main(String[]args){
		//bubun();
		tmp = new int[3];
		visited = new boolean[5];
		//combination(0,5,3,0);
		//dfs(0,0);
		factorial(0);
	}
	public static void bubun(){
		for(int i=0;i<(1<<5);i++){
			for(int j=0;j<5;j++){
				if((i & (1<<j))>0){
					System.out.print(j+" ");
				}
			}
			System.out.println("");
		}
	}
	public static void combination(int index, int n, int r, int target){
		if(r==0){
			for(int i=0;i<3;i++){
				System.out.print(tmp[i]+" ");
			}
			System.out.println("");
			return;
		}
		else if(n==target){
			return;
		}
		else{
			tmp[index] = target;
			combination(index+1,n,r-1,target+1);
			combination(index,n,r,target+1);
		}
	}
	public static void dfs(int depth, int index){
		if(depth==3){
			for(int i=0;i<3;i++){
				System.out.print(tmp[i]+" ");
			}
			System.out.println("");
			return;
		}

		for(int i=index;i<5;i++){
			tmp[depth] = i;
			dfs(depth+1,i+1);
		}
	}
	public static void factorial(int index){
		if(index == 3){
			for(int i=0;i<3;i++){
				System.out.print(tmp[i]+" ");
			}
			System.out.println("");
			return;
		}
		for(int i=0;i<5;i++){
			if(!visited[i]){
				tmp[index] = i;
				visited[i] = true;
				factorial(index+1);
				visited[i] = false;
			}
		}
	}
}