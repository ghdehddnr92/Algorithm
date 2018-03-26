import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sw_4014 {
	static int T;
	static int N,X;
	static int arr[][];
	static int res =0;
	static int arr2[][];
	static boolean visited[][];
	public static void  main(String[]args) throws NumberFormatException, IOException{
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T=Integer.parseInt(br.readLine());

		for(int t=1;t<=T;t++){
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			arr =new int[N][N];
			arr2  = new int[N][N];
			visited = new boolean[N][N];
			for(int i=0;i<N;i++){
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++){
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			//세로 체크 
			solve();

			mapChange();
			resetVisited();
			//	showArr();
			//가로 체크 
			//	System.out.println("--------가로 체크---------");
			solve();

			System.out.println("#"+t+" "+res);
			res =0;

		}
	}
	public static void resetVisited(){
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				visited[i][j]=false;
			}
		}
	}
	public static void solve(){
		for(int i=0;i<N;i++){
	//		System.out.println("줄 : "+i+" 번째줄");
			boolean flag = true; 
			for(int j=0;j<N-1;j++){
				if(arr[i][j]!=arr[i][j+1]){
			//		System.out.println("j일경우 :"+j);
					if(Math.abs(arr[i][j+1]-arr[i][j])>=2){ // 차이가 2이상 날 경우 경사로를 못만듬.
						flag = false;
						break;
					}
					else{ // 차이가 1 날 경우 
				//		System.out.println(j+" 랑 "+(j+1)+" 이랑 다름");
						if(arr[i][j]<arr[i][j+1]){
				//			System.out.println("커질 경우 ");
							int check = arr[i][j];
							int length = 1;
							for(int k=j;k>=0;k--){
								if(check == arr[i][k]){
									length++;
								}
								else{
									break;
								}
							}
							if(length>=X){
								for(int k=j;k>j-X;k--){
									if(k<0){
										flag = false;
										break;
									}
									else{
										if(!visited[i][k]){
											visited[i][k] = true;
					//						System.out.print(k+" 에 활주로 건설");
										}
										else{
											flag = false;
											break;
										}
									}
								}
					//			System.out.println("");
							}
							else{
					//			System.out.println("length가 X보다 작아서 false");
								flag = false;
								break;
							}
						}
						else{ //작아질 경우 
					//		System.out.println("작아질 경우 ");
							int check = arr[i][j+1];
							int length = 1;
							for(int k=j+2;k<N;k++){
								if(check == arr[i][k]){
									length++;
								}
								else{
									break;
								}
							}
							if(length>=X){
							
								for(int k=j+1;k<j+1+X;k++){
									if(!visited[i][k]){
										visited[i][k] = true;
						//				System.out.print(k+" 에 활주로 건설");
									}
									else{
										flag = false;
										break;
									}
								}
								j = j+X-1;
						//		System.out.println("");
							}
							else{
							//	System.out.println("length가 X보다 작아서 false");
								flag = false;
								break;
							}
						}
					}
				}
			}
			if(flag == true){
			//	System.out.println(i+" 번째 줄 활주로 건설 가능");
				res ++;
			}
		}
	}
	public static void mapChange(){
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				arr2[i][j] = arr[j][i];
			}
		}
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				arr[i][j] = arr2[i][j];
			}
		}
	}
	public static void showArr(){
		System.out.println("-----------------------");
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println("");
		}
	}
}
