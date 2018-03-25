import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sw_14499 {
	static int N,M,y,x,K;
	static int arr[][];
	static int command[];
	static int dice[];
	public static void main(String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());	
		M = Integer.parseInt(st.nextToken());	
		y = Integer.parseInt(st.nextToken());	
		x = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		command = new int[K];
		dice = new int[6];

		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		for(int i=0;i<K;i++){
			command[i] = Integer.parseInt(st.nextToken());
		}

		solve();

	}
	public static void solve(){
		
		for(int i=0;i<K;i++){	
			boolean flag = false;
			if(command[i]==1){
				if(x+1>=M){
					flag = true;
				}
				else{
					x=x+1;
				}
			}
			else if(command[i]==2){
				if(x-1<0){
					flag = true;
				}
				else{
					x=x-1;
				}
			}
			else if(command[i]==3){
				if(y-1<0){
					flag = true;
				}
				else{
					y=y-1;
				}
			}
			else{
				if(y+1>=N){
					flag = true;
				}
				else{
					y = y+1;
				}
			}

			if(flag == false){
				change(command[i]);
				if(arr[y][x]==0){
					arr[y][x] = dice[5];
				}
				else{
					dice[5] = arr[y][x];
					arr[y][x]=0;
				}

				System.out.println(dice[0]);
			}
			flag = false;
		}
	}
	public static void change(int num){
		if(num==1){
			int tmp = dice[5];
			dice[5] = dice[2];
			dice[2] = dice[0];
			dice[0] = dice[3];
			dice[3] = tmp;
		}
		else if(num==2){
			int tmp = dice[3];
			dice[3] = dice[0];
			dice[0] = dice[2];
			dice[2] = dice[5];
			dice[5] = tmp;
		}
		else if(num==3){
			int tmp = dice[1];
			dice[1] = dice[0];
			dice[0] = dice[4];
			dice[4] = dice[5];
			dice[5] = tmp;
		}
		else{
			int tmp = dice[5];
			dice[5] = dice[4];
			dice[4] = dice[0];
			dice[0] = dice[1];
			dice[1] = tmp;
		}
	}
	public static void showArr(){
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println("");
		}
	}
}
