import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sw_4013_2 {
	static int T;
	static int K;
	static int arr[][];
	static int command[][];
	static boolean visited[];
	public static void main(String[]args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t=1;t<=T;t++){
			K = Integer.parseInt(br.readLine());
			arr  = new int[4][8];
			visited = new boolean[3];
			for(int i=0;i<4;i++){
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<8;j++){
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			command= new int[K][2];

			for(int i=0;i<K;i++){
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<2;j++){
					command[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			solve();
			
			System.out.println("#"+t+" "+sum());
		}
	}
	public static void solve(){
		for(int i=0;i<K;i++){
			check();
			move(command[i][0],command[i][1]);

			//System.out.println("");
			if(command[i][0]==1){
				if(visited[0]){
					move(2,-command[i][1]);
					if(visited[1]){
						move(3,command[i][1]);
						if(visited[2]){
							move(4,-command[i][1]);
						}
					}
				}
			}
			else if(command[i][0]==2){
				if(visited[0]){
					move(1,-command[i][1]);
				}
				if(visited[1]){
					move(3,-command[i][1]);
					if(visited[2]){
						move(4,command[i][1]);
					}
				}
			}
			else if(command[i][0]==3){
				if(visited[2]){
					move(4,-command[i][1]);
				}
				if(visited[1]){
					move(2,-command[i][1]);
					if(visited[0]){
						move(1,command[i][1]);
					}
				}
			}
			else{
				if(visited[2]){
					move(3,-command[i][1]);
					if(visited[1]){
						move(2,command[i][1]);
						if(visited[0]){
							move(1,-command[i][1]);
						}
					}
				}
			}
		//	showArr();
		}
	}
	public static int sum(){
		int sum =0;
		if(arr[0][0]==1){
			sum+=1;
		}
		if(arr[1][0]==1){
			sum+=2;
		}
		if(arr[2][0]==1){
			sum+=4;
		}
		if(arr[3][0]==1){
			sum+=8;
		}
		return sum;
	}
	public static void check(){
		Arrays.fill(visited, false);
		if(arr[0][2]!=arr[1][6]){
			visited[0] = true;
		}
		if(arr[1][2]!=arr[2][6]){
			visited[1] = true;
		}
		if(arr[2][2]!=arr[3][6]){
			visited[2] = true;
		}
	}
	public static void move(int index, int dir){
		if(dir == 1){ // 시계방향 
			int tmp = arr[index-1][7];
			for(int i=6;i>=0;i--){
				arr[index-1][i+1] = arr[index-1][i];
			}
			arr[index-1][0] = tmp;
		}
		else{ // 반시계 방향 
			int tmp = arr[index-1][0];
			for(int i=1;i<=7;i++){
				arr[index-1][i-1]= arr[index-1][i];
			}
			arr[index-1][7] = tmp;
		}
	}
	public static void showArr(){
		System.out.println("--------------------");
		for(int i=0;i<4;i++){
			for(int j=0;j<8;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println("");
		}
	}
}
