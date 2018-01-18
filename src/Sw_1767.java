import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Sw_1767 {

	static int T;
	static int N;
	static int arr[][];
	static boolean dirCheck[];
	static boolean visited[][];
	static int maxCore=0;
	static int minLength=Integer.MAX_VALUE;
	static ArrayList<Core> list = new ArrayList<Core>();

	public static void main(String[]args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for(int t=1;t<=T;t++){
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());

			arr = new int[N][N];
			visited= new boolean[N][N];

			for(int i=0;i<N;i++){
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++){
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for(int i=1;i<N-1;i++){
				for(int j=1;j<N-1;j++){
					if(arr[i][j]==1){
						list.add(new Core(i,j));
					}
				}
			}
	
			dfs(0,1,0);
			System.out.println(maxCore);
			System.out.println(minLength);
		}
	}
	public static void dfs(int index, int core, int length){
		if(index == list.size()){
			System.out.println("종료 length : "+length);
			if(maxCore <core){
				maxCore = core;
				minLength= length;
			}
			else if(maxCore == core){
				if(length < minLength){
					minLength = length;
				}
			}
			return;
		}

		Core tmp = list.get(index);
		checkAround(tmp.y,tmp.x);
		
		System.out.println(" dfs 시작 y: "+tmp.y+"x: "+tmp.x);
	
		if(dirCheck[0]==false){
			int len=0;
			for(int i=tmp.x+1;i<N;i++){
				visited[tmp.y][i]=true;
				len++;
			}
			System.out.println("y :"+tmp.y+"x: "+tmp.x+" 동 len"+len);
			
			dfs(index+1,core+1,length+len);
			for(int i=tmp.x+1;i<N;i++){
				visited[tmp.y][i]=false;
			}
		}
		if(dirCheck[1]==false){
			int len=0;
			for(int i=0;i<tmp.x;i++){
				visited[tmp.y][i]=true;
				len++;
			}
			System.out.println("y :"+tmp.y+"x: "+tmp.x+" 서 len"+len);
			dfs(index+1,core+1,length+len);
			for(int i=0;i<tmp.x;i++){
				visited[tmp.y][i]=false;
			}
		}
		if(dirCheck[2]==false){
			int len=0;
			for(int i=tmp.y+1;i<N;i++){
				visited[i][tmp.x]=true;
				len++;
			}
			System.out.println("y :"+tmp.y+"x: "+tmp.x+" 남 len"+len);
			dfs(index+1,core+1,length+len);
			for(int i=tmp.y+1;i<N;i++){
				visited[i][tmp.x]=false;
			}
		}
		if(dirCheck[3]==false){
			int len=0;
			if(index == list.size()){
				return;
			}
			for(int i=0;i<tmp.y;i++){
				visited[i][tmp.x]=true;
				len++;
			}
			System.out.println("y :"+tmp.y+"x: "+tmp.x+" 북 len"+len);
			dfs(index+1,core+1,length+len);
			for(int i=0;i<tmp.y;i++){
				visited[i][tmp.x]=false;
			}
		}
	}
	public static void checkAround(int y, int x){
		dirCheck = new boolean[4];
		//교차하는지랑 코어가 있는지 검사하는 함수.
		for(int i=x+1;i<N;i++){
			if(arr[y][i]==1  || visited[y][i]==true){
				System.out.println("y :"+y+"x: "+x+" 0 true ");
				dirCheck[0]=true;
				break;
			}
		}
		for(int i=0;i<x;i++){
			if(arr[y][i]==1 || visited[y][i]==true){
				System.out.println("y :"+y+"x: "+x+" 1 true ");
				dirCheck[1]=true;
				break;
			}
		}
		for(int i=y+1;i<N;i++){
			if(arr[i][x]==1 || visited[i][x]==true){
				System.out.println("y :"+y+"x: "+x+" 2 true ");
				dirCheck[2]=true;
				break;
			}
		}
		for(int i=0;i<y;i++){
			if(arr[i][x]==1 || visited[i][x]==true){
				System.out.println("y :"+y+"x: "+x+" 3 true ");
				dirCheck[3]=true;
				break;
			}
		}
	
	}
}
class Core{
	int y;
	int x;

	public Core(int y, int x){
		this.y = y;
		this.x = x;
	}
}
