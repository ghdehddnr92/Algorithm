import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Algo_1941 {
	static int arr[][];
	static boolean visited[][];
	static int dy[] = {1,0,-1,0};
	static int dx[] = {0,1,-0,-1};
	static int res = 0;
	static int tmp[];
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
		arr = new int[5][5];
		visited = new boolean[5][5];
		tmp = new int[7];
		for(int i=0;i<5;i++){
			String line = in.next();
			for(int j=0;j<5;j++){
				if(line.charAt(j)=='Y'){//임도연 파 
					arr[i][j] = 1;
				}
				else{
					arr[i][j] = 0; // 이다솜 파 
				}
			}
		}

		combination(0,25,7,0,0);

		System.out.println(res);
	}

	public static void combination(int index, int n, int r, int target,int cnt){
		if(r == 0){
			if(cnt>=4){
				for(int i=0;i<7;i++){
					System.out.print(tmp[i]+" ");
				}
				System.out.println("");
				check();
			}
			return;
		}
		else if(target==n){
			return;
		}
		else{
			tmp[index] = target;
			if(arr[target/5][target%5]==0){
				combination(index+1,n,r-1,target+1,cnt+1);
			}
			else{
				combination(index+1,n,r-1,target+1,cnt);
			}
			combination(index,n,r,target+1,cnt);
		}
	}
	//연결되어있는지 확인 
	public static void check(){
		
	}
	public static void showArr(){
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println("");
		}
	}
	public static void showVisited(){
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				System.out.print(visited[i][j]+" ");
			}
			System.out.println("");
		}
	}
}
class Gongju{
	int y; 
	int x;
	int cnt;
	int depth;
	Gongju(int y, int x,int cnt,int depth){
		this.y = y;
		this.x = x;
		this.cnt = cnt;
		this.depth= depth;
	}
}