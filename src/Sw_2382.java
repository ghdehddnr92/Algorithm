import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Sw_2382 {
	static int T;
	static int N,M,K; // N 셀 크기 , M 은 시간 , K는 미생물 수 
	static int arr[][];
	static int map[][] ;
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
		Queue<Mi2>q = new LinkedList<>();
		
		T = in.nextInt();
		for(int t=0;t<T;t++){
			
			N = in.nextInt();
			M = in.nextInt();
			K = in.nextInt();
			arr = new int[K][4];
			map = new int[N][N];
			
			for(int i=0;i<N;i++){
				for(int j=0;j<N;j++){
					if(i==0 || i==N-1){
						map[i][j]=-1;
					}
					if(j==0 || j==N-1){
						map[i][j]=-1;
					}
				}
			}
			for(int i=0;i<K;i++){
				for(int j=0;j<4;j++){
					arr[i][j]= in.nextInt();
				}
				Mi2 mi = new Mi2(arr[i][0],arr[i][1],arr[i][2],arr[i][3]);
				map[arr[i][0]][arr[i][1]]=arr[i][2];
				q.add(mi);
			}
			//showMap();
			//showArr();
			//System.out.println(q.size());
			for(int m=0;m<M;m++){
				Mi2 tmp = null;
				int cnt=0;
				while(cnt<=q.size()){
					tmp = q.poll();
					System.out.println("전 : tmp x : "+tmp.y+"tmp y: "+tmp.x+"dir "+tmp.dir+"num: "+ tmp.num);
					if(tmp.dir==1){
						tmp.y=tmp.y-1;
					}
					else if(tmp.dir==2){
						tmp.y=tmp.y+1;
					}
					else if(tmp.dir==3){
						tmp.x=tmp.x-1;
					}
					else{
						tmp.x=tmp.x+1;
					}
					
					if(map[tmp.y][tmp.x]==-1){
						if(tmp.dir==1){
							tmp.dir=2;
						}
						else if(tmp.dir==2){
							tmp.dir=1;
						}
						else if(tmp.dir==3){
							tmp.dir=4;
						}
						else{
							tmp.dir=3;
						}
						
						if(tmp.num%2==0){
							tmp.num= tmp.num/2;
						}
						else{
							double d = (double)tmp.num/2;
							tmp.num= (int)d;
						}
						System.out.println("후 : tmp x : "+tmp.y+"tmp y: "+tmp.x+"dir "+tmp.dir+"num: "+ tmp.num);
					}
					else{
						
						if(map[tmp.y][tmp.x]==0){ // 약품지역이 아닐경우 같은것이 없을 경우 
							map[tmp.y][tmp.x]=tmp.num;
						}
						else{ // 같은것이 있을 경우
							
						}
					}
					System.out.println("cnt : "+ cnt);
					showMap();
					q.add(tmp);
					cnt++;
				}
				cnt=0;
			}
		
			while(!q.isEmpty()){
				System.out.println(q.size());
				Mi2 tmp = q.poll();
				System.out.println("미생물 : "+ tmp.x+" "+tmp.y+" "+tmp.num+" "+tmp.dir);
			}
		}
	}
	public static void showMap(){
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				System.out.print(map[i][j]+" ");
			}
			System.out.println("");
		}
	}
	public static void showArr(){
		for(int i=0;i<N;i++){
			for(int j=0;j<4;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println("");
		}
	}
}
class Mi2{
	int y;
	int x;
	int num;
	int dir;
	
	Mi2(int y, int x, int num, int dir){
		this.y = y;
		this.x = x;
		this.num = num;
		this.dir = dir;
	}
}