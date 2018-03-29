//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
//
//public class Algo_1194 {
//	static int N,M;
//	static boolean visited[][];
//	static String arr[][];
//	static int dy[] = {1,0,-1,0};
//	static int dx[] = {0,1,0,-1};
//	public static void main(String[]args){
//		Scanner in = new Scanner(System.in);
//		N = in.nextInt();
//		M = in.nextInt();
//		
//		arr = new String[N][M];
//		visited = new boolean[N][M];
//		for(int i=0;i<N;i++){
//			String line = in.next();
//			for(int j=0;j<M;j++){
//				arr[i][j] = line.charAt(j)+"";
//			}
//		}
//		for(int i=0;i<N;i++){
//			for(int j=0;j<M;j++){
//				if(arr[i][j].equals("0")){
//					bfs(i,j,0);
//				}
//			}
//		}
//	}
//	public static void bfs(int y, int x, int cnt){
//		Queue<Moon> q = new LinkedList<>();
//		q.add(new Moon(y,x,cnt,alphabet));
//		
//		while(!q.isEmpty()){
//			Moon tmp = q.poll();
//			
//			for(int i=0;i<4;i++){
//				int ny = tmp.y+dy[i];
//				int nx = tmp.x+dx[i];
//				int nCnt = tmp.cnt +1;
//				
//				if(ny<0 || nx<0 || ny>=N || nx>=M){
//					continue;
//				}
//				if(arr[ny][nx].equals("#")){
//					continue;
//				}
//				
//				if(arr[ny][nx].equals("1")){
//					System.out.println(nCnt);
//					return;
//				}
//				if(arr[ny][nx].equals("A")||arr[ny][nx].equals("B")||arr[ny][nx].equals("C")||arr[ny][nx].equals("D")||arr[ny][nx].equals("E")||arr[ny][nx].equals("F")){
//					System.out.println("문방문 :"+arr[ny][nx]);
//					System.out.println("키 상태");
//					for(int j=0;j<6;j++){
//						System.out.print(nAlphabet[j]);
//					}
//					System.out.println("");
//					if(arr[ny][nx].equals("A")){
//						if(!nAlphabet[0]){
//							continue;
//						}
//					}
//					else if(arr[ny][nx].equals("B")){
//						if(!nAlphabet[1]){
//							continue;
//						}
//					}
//					else if(arr[ny][nx].equals("C")){
//						if(!nAlphabet[2]){
//							continue;
//						}
//					}
//					else if(arr[ny][nx].equals("D")){
//						if(!nAlphabet[3]){
//							continue;
//						}
//					}
//					else if(arr[ny][nx].equals("E")){
//						if(!nAlphabet[4]){
//							continue;
//						}
//					}
//					else{
//						if(!nAlphabet[5]){
//							continue;
//						}
//					}
//					
//					System.out.println("열쇠를 가지고 있어서 입장");
//				}
//				if(arr[ny][nx].equals("a")||arr[ny][nx].equals("b")||arr[ny][nx].equals("c")||arr[ny][nx].equals("d")||arr[ny][nx].equals("e")||arr[ny][nx].equals("f")){
//					System.out.println("키 획득 :"+arr[ny][nx]);
//					if(arr[ny][nx].equals("a")){
//						nAlphabet[0] =true;
//					}
//					else if(arr[ny][nx].equals("b")){
//						nAlphabet[1]=true;
//					}
//					else if(arr[ny][nx].equals("c")){
//						nAlphabet[2]=true;
//					}
//					else if(arr[ny][nx].equals("d")){
//						nAlphabet[3]=true;
//					}
//					else if(arr[ny][nx].equals("e")){
//						nAlphabet[4]=true;
//					}
//					else{
//						nAlphabet[5]=true;
//					}
//				}
//				System.out.println("----------------다음칸 이동 :"+ny+" "+nx+" "+nCnt);
//			
//				q.add(new Moon(ny,nx,nCnt,nAlphabet));
//			}
//		}
//	}
//	public static void showArr(){
//		for(int i=0;i<N;i++){
//			for(int j=0;j<M;j++){
//				System.out.print(arr[i][j]+" ");
//			}
//			System.out.println("");
//		}
//	}
//}
//class Moon{
//	int y;
//	int x;
//	int cnt;
//	Moon(int y, int x,int cnt,boolean alphabet[]){
//		this.y  =y;
//		this.x = x;
//		this.cnt = cnt;
//	}
//}