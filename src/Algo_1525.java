import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Algo_1525 {
	static int arr[][]={{1,2,3},{4,5,6},{7,8,0}};
	static int map[][];
	static boolean visited[][];
	static int min = Integer.MAX_VALUE;
	static int dy[]={1,0,-1,0};
	static int dx[]={0,1,0,-1};
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
		map = new int[3][3];
		visited = new boolean[3][3];
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				map[i][j] = in.nextInt();
			}
		}

		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if(map[i][j]==0){
					visited[i][j] = true;
					dfs(i,j,0,map);
				//	bfs(i,j,map);
				}
			}
		}
		if(min == Integer.MAX_VALUE){
			System.out.println(-1);
		}
		else{
			System.out.println(min);
		}
	}
	public static void showMap(int map[][]){
		System.out.println("-------------");
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				System.out.print(map[i][j]+" ");
			}
			System.out.println("");
		}
	}
	public static void bfs(int y,int x,int checkMap[][]){
		Queue<Puzzle>q = new LinkedList<Puzzle>();
		q.add(new Puzzle(y,x,0,checkMap));
		visited[y][x] = true;
		
		while(!q.isEmpty()){
		
			Puzzle tmp = q.poll();
			System.out.println("-----"+tmp.y+" "+tmp.x+" "+tmp.cnt+" ----------------------");
		//	if(sameCheck(tmp.checkMap)){
			if(tmp.cnt==2){
				if(min > tmp.cnt){
					min = tmp.cnt;
				}
				return;
			}
			for(int i=0;i<4;i++){
				int ny = tmp.y+dy[i];
				int nx = tmp.x+dx[i];
				int nCnt = tmp.cnt+1;
				
				if(ny<0 || nx<0 || ny>=3 || nx>=3){
					continue;
				}
				if(visited[ny][nx]){
					continue;
				}
				
				int tmpMap = checkMap[ny][nx];
				checkMap[y][x]=checkMap[ny][nx];
				checkMap[ny][nx]=0;
				System.out.println(checkMap[ny][nx]+" "+checkMap[y][x]+" 랑 변경 ");
				visited[ny][nx] =true;
				showMap(checkMap);
				q.add(new Puzzle(ny,nx,nCnt,checkMap));
				checkMap[y][x]=0;
				checkMap[ny][nx] =tmpMap;
				visited[ny][nx] = false;
			}
		}
	}
	public static void dfs(int y, int x,int cnt,int checkMap[][]){
		//System.out.println(cnt+"-----------------------------");
		if(cnt > 4*3*3){
			return;
		}
		if(sameCheck(checkMap)){
			if(min > cnt){
				min = cnt;
			}
			return;
		}

		for(int i=0;i<4;i++){
			int ny = y+dy[i];
			int nx = x+dx[i];

			if(ny<0 || nx<0 || ny>=3 || nx>=3){
				continue;
			}
			if(visited[ny][nx]){
				continue;
			}
			int tmp = checkMap[ny][nx];
			checkMap[y][x]=checkMap[ny][nx];
			checkMap[ny][nx]=0;
			visited[ny][nx] =true;
		//	showMap(checkMap);
			dfs(ny,nx,cnt+1,checkMap);
			checkMap[y][x]=0;
			checkMap[ny][nx] =tmp;
			visited[ny][nx] = false;

		//	showMap(checkMap);
		}
	}
	public static boolean sameCheck(int checkMap[][]){
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if(arr[i][j]!=checkMap[i][j]){
					return false;
				}
			}
		}
		return true;
	}
}
class Puzzle{
	int y;
	int x;
	int cnt;
	int checkMap[][];
	Puzzle(int y, int x, int cnt,int checkMap[][]){
		this.y = y;
		this.x = x;
		this.cnt = cnt;
		this.checkMap= checkMap;
	}
}