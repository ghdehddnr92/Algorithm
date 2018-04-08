import java.util.Scanner;

public class Algo_14503 {
	static int N, M;
	static int arr[][];
	static int y,x,d;
	static int dirArr[]={};
	static int res =0;
	public static void main(String[]args){

		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		M = in.nextInt();
		y = in.nextInt();
		x = in.nextInt();
		d = in.nextInt();
		arr = new int[N][M];
		
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				arr[i][j] = in.nextInt();
			}
		}
		solve();
		System.out.println(res);
	}
	public static boolean check(){

		//그 다음 방향 체크 
		if(d ==0){
			d = 3;
		}
		else{
			d -= 1;
		}
		
		if(d == 0){
			if(y-1 >=0 && arr[y-1][x]==0){
				return true;
			}
		}
		else if (d == 1){
			if(x+1 <M && arr[y][x+1]==0){
				return true;
			}
		}
		else if (d == 2){
			if(y+1 <N && arr[y+1][x]==0){
				return true;
			}
		}
		else{
			if(x-1>=0 && arr[y][x-1]==0){
				return true;
			}
		}
		return false;
	}

	public static void solve(){
		
		boolean flag = true;
		boolean oneFlag = true;
		while(flag){
			//System.out.println(y+" "+x+" "+d);
			if(oneFlag){
				if(arr[y][x]==0){ // 현재 위치 청소 
					res++;
					arr[y][x]=2;
				}
			}
			boolean dirFlag = false;
			for(int i=0;i<4;i++){
				if(check()){
					dirFlag = true;
					break;
				}
			}
			boolean backFlag = false;
			if(dirFlag){ // 4방향중 있을 경우 
				if(d==0){
					y-=1;
				}
				else if(d==1){
					x+=1;
				}
				else if(d==2){
					y+=1;
				}
				else{
					x-=1;
				}
				oneFlag = true;
			}
			else{
				oneFlag = false;
				if(d==0){
					if(arr[y+1][x]==1){
						backFlag = true;
					}
					else{
						y+=1;
					}
				}
				else if (d==1){
					if(arr[y][x-1]==1){
						backFlag =true;
					}
					else{
						x-=1;
					}
				}
				else if(d==2){
					if(arr[y-1][x]==1){
						backFlag = true;
					}
					else{
						y-=1;
					}
				}
				else if(d==3){
					if(arr[y][x+1]==1){
						backFlag = true;
					}
					else{
						x+=1;
					}
				}
			}
			if(backFlag == true){
				flag = false;
			}
		}
	}
}