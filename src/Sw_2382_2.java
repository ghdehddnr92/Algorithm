//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Sw_2382_2 {
//	static int T;
//	static int N,M,K;
//	static Misang arr[][];
//	static int res = 0;
//	public static void main(String[]args) throws NumberFormatException, IOException{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//		T = Integer.parseInt(br.readLine());
//		StringTokenizer st;
//		for(int t=1;t<=T;t++){
//			st = new StringTokenizer(br.readLine());
//
//			N = Integer.parseInt(st.nextToken());
//			M = Integer.parseInt(st.nextToken());
//			K = Integer.parseInt(st.nextToken());
//
//			arr = new Misang[N][N];
//
//			for(int i=0;i<K;i++){
//				st = new StringTokenizer(br.readLine());
//				int y = Integer.parseInt(st.nextToken());
//				int x = Integer.parseInt(st.nextToken());
//				int miNum = Integer.parseInt(st.nextToken());
//				int dir = Integer.parseInt(st.nextToken());
//				Misang tmp = new Misang(miNum,dir,0);
//
//				arr[y][x] = tmp;
//			}
//
//			int time = 0;
//
//			while(time<M){
//
//				for(int i=0;i<N;i++){
//					for(int j=0;j<N;j++){
//						if(arr[i][j]!=null && arr[i][j].time == time){
//							play(i,j,time);
//						}
//					}
//				}
//				print();
//				
//				time++;
//			}
//
//			sum();
//			System.out.println("#"+t+" "+res);
//			res =0;
//		}
//	}
//	public static void print(){
//		System.out.println("----------------------");
//		for(int i=0;i<N;i++){
//			for(int j=0;j<N;j++){
//				if(arr[i][j]!=null){
//					System.out.println(i+" "+j+" "+arr[i][j].miNum+" "+arr[i][j].dir+" "+arr[i][j].time);
//				}
//			}
//		}
//	}
//	public static void sum(){
//		for(int i=0;i<N;i++){
//			for(int j=0;j<N;j++){
//				if(arr[i][j]!=null){
//					res +=arr[i][j].miNum;
//				}
//			}
//		}
//	}
//	public static void play(int i, int j, int time){
//		//System.out.println(" 좌표 :"+i+" "+j+" "+time);
//		if(arr[i][j]!=null && arr[i][j].time == time){
//			if(arr[i][j].dir==1){
//				if(arr[i-1][j]!=null){ //다음 이동 칸이 빈칸이 아닌경우
//					if(arr[i-1][j].time == time+1){ // 이미 이동한 미생물일 경우 합침.
//						arr[i-1][j].miNum += arr[i][j].miNum;
//						if(arr[i-1][j].miNum > arr[i][j].miNum){
//							arr[i-1][j].dir = arr[i][j].dir;
//						}
//						else{
//							arr[i-1][j].dir = arr[i-1][j].dir;
//						}
//						arr[i][j] = null;
//					}
//					else{ //아닐경우 이동해야하는 미생물일 경우 
//						
//					}
//				}
//				else{ // 다음 이동 칸이 빈칸일 경우 
//					arr[i-1][j] = arr[i][j];
//					arr[i][j] = null;
//					if(yakAreaCheck(i-1,j)){
//						arr[i-1][j].miNum /= 2;
//						arr[i-1][j].dir = 2;
//					}
//					arr[i-1][j].time++;
//				}
//			}
//			else if(arr[i][j].dir ==2){
//				if(arr[i+1][j]!=null){ //다음 이동 칸이 빈칸이 아닌경우
//					if(arr[i+1][j].time == time+1){ // 이미 이동한 미생물일 경우 합침.
//						arr[i+1][j].miNum += arr[i][j].miNum;
//						if(arr[i+1][j].miNum > arr[i][j].miNum){
//							arr[i+1][j].dir = arr[i][j].dir;
//						}
//						else{
//							arr[i+1][j].dir = arr[i+1][j].dir;
//						}
//						arr[i][j] = null;
//					}
//					else{ //아닐경우 이동해야하는 미생물일 경우 
//						if(arr[i+1][j].dir==1){
//							Misang tmp = arr[i+1][j];
//							arr[i+1][j]=null;
//							play(i,j,time);
//							arr[i][j] = tmp;
//							if(yakAreaCheck(i,j)){
//								arr[i][j].dir = 1;
//								arr[i][j].miNum /= 2;
//							}
//							arr[i][j].time++;
//						}
//						else{
//							for(int k=0;k<N;k++){
//								play(i+1,k,time);
//							}
//							play(i,j,time);
//						}
//					}
//				}
//				else{ // 다음 이동 칸이 빈칸일 경우 
//					arr[i+1][j] = arr[i][j];
//					arr[i][j] = null;
//					if(yakAreaCheck(i+1,j)){
//						arr[i+1][j].miNum /= 2;
//						arr[i+1][j].dir = 1;
//					}
//					arr[i+1][j].time++;
//				}
//			}
//			else if(arr[i][j].dir ==3){
//				if(arr[i][j-1]!=null){ //다음 이동 칸이 빈칸이 아닌경우
//					if(arr[i][j-1].time == time+1){ // 이미 이동한 미생물일 경우 합침.
//						arr[i][j-1].miNum += arr[i][j].miNum;
//						if(arr[i][j-1].miNum > arr[i][j].miNum){
//							arr[i][j-1].dir = arr[i][j].dir;
//						}
//						else{
//							arr[i][j-1].dir = arr[i][j-1].dir;
//						}
//						arr[i][j] = null;
//					}
//					else{ //아닐경우 이동해야하는 미생물일 경우 
//						
//					}
//				}
//				else{ // 다음 이동 칸이 빈칸일 경우 
//					arr[i][j-1] = arr[i][j];
//					arr[i][j] = null;
//					if(yakAreaCheck(i,j-1)){
//						arr[i][j-1].miNum /= 2;
//						arr[i][j-1].dir = 4;
//					}
//					arr[i][j-1].time++;
//				}
//			}
//			else{
//				if(arr[i][j+1]!=null){ //다음 이동 칸이 빈칸이 아닌경우
//					if(arr[i][j+1].time == time+1){ // 이미 이동한 미생물일 경우 합침.
//						arr[i][j+1].miNum += arr[i][j].miNum;
//						if(arr[i][j+1].miNum > arr[i][j].miNum){
//							arr[i][j+1].dir = arr[i][j].dir;
//						}
//						else{
//							arr[i][j+1].dir = arr[i][j+1].dir;
//						}
//						arr[i][j] = null;
//					}
//					else{ //아닐경우 이동해야하는 미생물일 경우 
//					
//					}
//				}
//				else{ // 다음 이동 칸이 빈칸일 경우 
//					arr[i][j+1] = arr[i][j];
//					arr[i][j] = null;
//					if(yakAreaCheck(i,j+1)){
//						arr[i][j+1].miNum /= 2;
//						arr[i][j+1].dir = 3;
//					}
//					arr[i][j+1].time++;
//				}
//			}
//		}
//	}
//	
//	public static boolean yakAreaCheck(int y, int x){
//		boolean flag = false;
//
//		if(y ==0 || x ==0 ||y == N-1 || x == N-1){
//			flag = true;
//		}
//		else{
//			flag = false;
//		}
//		return flag;
//	}
//}
//class Misang{
//
//	int miNum;
//	int dir;
//	int time;
//	Misang(int miNum, int dir, int time){
//
//		this.miNum = miNum;
//		this.dir = dir;
//		this.time = time;
//	}
//}
//
