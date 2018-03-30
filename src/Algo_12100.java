import java.util.Scanner;

public class Algo_12100 {
	static int N;
	static int arr[][];
	static int max = 0;
	static boolean visited[][];
	static int dy[]={1,0,-1,0};
	static int dx[]={0,1,0,-1};
	static int tmp[][];
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);

		N = in.nextInt();
		arr = new int[N][N];
		int map[][] = new int[N][N];
		visited = new boolean[N][N];
		tmp = new int[N][N];

		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				arr[i][j] = in.nextInt();
			}
		}
		setMap(map);
		solve(0,map);

		System.out.println(max);
	}
	public static void setTmp(int map[][]){
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				tmp[i][j] = map[i][j];
			}
		}
	}
	public static void setMap(int map[][]){
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				map[i][j] = arr[i][j];
			}
		}
	}
	public static void solve(int depth,int map[][]){
		if(depth==5){
			searchMax();
			return;
		}

		for(int i=0;i<4;i++){
//			System.out.println("----"+ depth+" "+i+" 방향 -----");
			setTmp(map);
//			System.out.println("맵 ~~~~~~~~");
//			for(int a=0;a<N;a++){
//				for(int b=0;b<N;b++){
//					System.out.print(tmp[a][b]+" ");
//				}
//				System.out.println("");
//			}

			move(i,tmp);
//			showMap(tmp);
			resetVisited();
			int tmp2[][] = new int[N][N];
			for(int a=0;a<N;a++){
				for(int b=0;b<N;b++){
					tmp2[a][b] = tmp[a][b];
				}
			}
			solve(depth+1, tmp2);
		}
	}

	public static void resetVisited(){
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				visited[i][j] = false;
			}
		}
	}
	public static void showMap(int map[][]){
		System.out.println("-------------------");
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				System.out.print(map[i][j]+" ");
			}
			System.out.println("");
		}
	}
	public static void move(int dir,int map[][]){
		if(dir ==0){ //위 
			for(int j=0;j<N;j++){
				for(int i=1;i<N;i++){
					if(map[i][j]!=0){
						int k = i;
						while(true){
							if(k<=0){
								break;
							}
							if(map[k-1][j]==0){
								if(k-1>=0){
									k--;
									map[k][j]=map[k+1][j];
									map[k+1][j] =0;
								}
								else{
									break;
								}
							}
							else{
								if(map[k][j]==map[k-1][j] && !visited[k-1][j]){
									map[k-1][j]+= map[k][j];
									visited[k-1][j] = true;
									map[k][j] = 0;
								}
								break;
							}
						}			
					}
				}
			}
		}
		else if(dir ==1){ // 아래 
			for(int j=0;j<N;j++){
				for(int i=N-1;i>=0;i--){
					if(map[i][j]!=0){
						int k = i;
						while(true){
							if(k>=N-1){
								break;
							}
							if(map[k+1][j]==0){
								if(k+1<N){
									k++;
									map[k][j]=map[k-1][j];
									map[k-1][j] =0;
								}
								else{
									break;
								}
							}
							else{
								if(map[k][j]==map[k+1][j] && !visited[k+1][j]){
									map[k+1][j]+= map[k][j];
									visited[k+1][j] = true;
									map[k][j] = 0;
								}
								break;
							}
						}			
					}
				}
			}
		}
		else if(dir==2){ // 좌 
			for(int	i=0;i<N;i++){
				for(int j=1;j<N;j++){
					if(map[i][j]!=0){
						int k = j;
						while(true){
							if(k<=0){
								break;
							}
							if(map[i][k-1]==0){
								if(k-1>=0){
									k--;
									map[i][k]=map[i][k+1];
									map[i][k+1] =0;
								}
								else{
									break;
								}
							}
							else{
								if(map[i][k]==map[i][k-1] && !visited[i][k-1]){
									map[i][k-1]+= map[i][k];
									visited[i][k-1] = true;
									map[i][k] = 0;
								}
								break;
							}
						}			
					}
				}
			}
		}
		else{ //우 
			for(int i=0;i<N;i++){
				for(int j=N-2;j>=0;j--){
					if(map[i][j]!=0){
						int k = j;
						while(true){
							if(k>=N-1){
								break;
							}
							if(map[i][k+1]==0){
								if(k+1<N){
									k++;
									map[i][k]=map[i][k-1];
									map[i][k-1] =0;
								}
								else{
									break;
								}
							}
							else{
								if(map[i][k]==map[i][k+1] && !visited[i][k+1]){
									map[i][k+1]+= map[i][k];
									visited[i][k+1] = true;
									map[i][k] = 0;
								}
								break;
							}
						}			
					}
				}
			}
		}
	}
	public static void searchMax(){
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(tmp[i][j]>max){
					max = tmp[i][j];
				}
			}
		}
	}
}
