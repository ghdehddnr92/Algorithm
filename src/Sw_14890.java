import java.util.Scanner;

public class Sw_14890 {
	static int N,L;
	//static int arr[][];
	//static int arr2[][];
	static int cnt =0;
	static boolean visited[][];
	static int res =0;
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);

		N = in.nextInt();
		L = in.nextInt();
		int arr[][] = new int[N][N];
		int arr2[][] = new int[N][N];
		visited = new boolean[N][N];// 경사로처리 

		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				arr[i][j] = in.nextInt();
			}
		}

		arrChange(arr,arr2);

		solve(arr);

		resetVisited();
		System.out.println("change -------------------");
		solve(arr2);

		System.out.println(res);
	}
	public static void solve(int map[][]){

		for(int i=0;i<N;i++){
			int start = map[i][0];
			boolean sameCheck = true; // 모두 같은지 체크하는 변수 true일 경우 res ++;
			boolean possible = true;
			for(int j=1;j<N;j++){
				if(map[i][j]- map[i][j-1]>=2 || map[i][j]- map[i][j-1] <=-2){ // 현재꺼보다 전께 2가 작거나 클경우
					possible = false;
					break; // 바로 확인할 것 없이 break;걸어서 다음 줄로 넘어감 
				}
			}	
			// 경사로를 놔서 갈 수 잇는지 못가는지 check 
			for(int j=1;j<N;j++){
				if(map[i][j-1]- map[i][j]== 1 || map[i][j-1]- map[i][j] == -1){ //경사로의 차이가 1일경우 
					if(map[i][j-1]- map[i][j] == 1){ //왼의 경사로가 높을 경우 
						int length = L;
						if(j+L-1<N){
							while(length>0){ // 오른으로L만큼 같은 높이가 있는지 확인 
						//		System.out.println("오른으로 체크 res++ "+i+" "+j);
								int k= j;
								if(visited[i][k]==true){
									System.out.println("visited 겹침:"+i+" "+k);
									possible = false;
									break;
								}
								if(map[i][k]!=map[i][j]){
									possible = false;
									break;
								}
								length--;
								k++;
							}
							if(possible ==true){ // res++,visited처리 
							
								System.out.println("오른 으로 체크 res++ "+i+" "+j);
								for(int l=j;l<j+L;l++){
									System.out.print("l visited:"+l);
									visited[i][l]= true;
								}
								System.out.println("");
							}
						}
						else{
							possible = false;
							break;
						}	
					}
					else{ //경사로가 높아질 경우 
						int length = L;
						if(j-1-L>=0){
							while(length>0){ // 왼쪽으로L만큼 같은 높이가 있는지 확인 
								
								int k= j-2;
								if(visited[i][k]==true){
									System.out.println("visited 겹침"+i+" "+k);
									possible = false;
									break;
								}
								if(map[i][k]!=map[i][j-1]){
									possible = false;
									break;
								}
								length--;
								k--;
							}

							if(possible == true){
								System.out.println("왼쪽으로 체크 res++ "+i+" "+j);
							
								for(int l=j-1;l>j-1-L;l--){
									System.out.print("l :+"+l);
									visited[i][l]= true;
								}
								System.out.println("");
							}
						}
						else{ // 범위check
							possible = false;
							break;
						}
					}
				}
			}
			if(possible == true){
				System.out.println("res ++"+i+" 번째 쭐 ");
				res++;
			}
		//	showVisited();
		}
	}

	public static void arrChange(int arr[][], int arr2[][]){
		for(int i=0;i<N;i++){
			for(int j= 0;j<N;j++){
				arr2[i][j] = arr[j][i];
			}
		}
	}
	public static void showVisited(){
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				System.out.print(visited[i][j]+" ");
			}
			System.out.println("");
		}
	}
	public static void resetVisited(){
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				visited[i][j] = false;
			}
		}
	}
}
