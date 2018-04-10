import java.util.Scanner;

public class Algo_13460 {
	static int N,M;
	static String arr[][];
	static int res =0;
	static int dy[]={-1,1,0,0};
	static int dx[]={0,0,-1,1};
	public static void main(String[]args){
		Scanner in  = new Scanner(System.in);
		N = in.nextInt();
		M = in.nextInt();
		
		arr = new String[N][M];
		
		for(int i=0;i<N;i++){
			String line = in.next();
			for(int j=0;j<N;j++){
				arr[i][j]= line.charAt(j)+"";
			}
		}
		//showArr();
		
		solve();
		
		if(res >10){
			System.out.println(-1);
		}
		else{
			System.out.println(res);
		}
	}
	public static void solve(){
		
	}
	public static void move(int dir){
		if(dir ==0){ // 위로 기울일 경우. 

		}
		else if(dir ==1){ //하로 기울일 경우. 
			
		}
		else if(dir ==2){//좌로 기울일 경우 .
			
		}
		else{ //우로 기울일 경우. 
			
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
