import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Algo_4179 {
	static int r,c;
	static String arr[][];
	static boolean visited[][];
	static boolean visited2[][];
	static int startY, startX;
	static int dy[]={1,0,-1,0};
	static int dx[]={0,1,0,-1};
	static int res =0;
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);

		r = in.nextInt();
		c = in.nextInt();

		arr = new String[r][c];
		visited =new boolean[r][c];
		visited2 =new boolean[r][c];
		for(int i=0;i<r;i++){
			String line = in.next();
			for(int j=0;j<c;j++){
				arr[i][j] = line.charAt(j)+"";
				if(arr[i][j].equals("J")){
					startY = i;
					startX = j;
				}
			}
		}
		//showArr();

		bfs();
		if(res!=0){
			System.out.println(res+1);
		}
		else{
			System.out.println("IMPOSSIBLE");
		}
	}

	public static void mapChange(){
		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
				if(arr[i][j].equals("F") && !visited2[i][j]){
					bfs2(i,j);
				}
			}
		}
		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
				visited2[i][j] = false;
			}
		}
	}
	public static void bfs2(int y, int x){
		Queue<Fire> q= new LinkedList<Fire>();
		q.add(new Fire(y,x,0));
		visited2[y][x]= true;
		
		while(!q.isEmpty()){
			Fire tmp = q.poll();
			
			for(int i=0;i<4;i++){
				int ny = tmp.y+dy[i];
				int nx = tmp.x+dx[i];
				int nCnt = tmp.cnt+1;
				
				if(nCnt == 2){
					return;
				}
				if(ny<0|| nx<0|| ny>=r || nx>=c){
					continue;
				}
				if(visited2[ny][nx]){
					continue;
				}
				if(arr[ny][nx].equals("#")){
					continue;
				}
			//	System.out.println(ny+" "+nx);
				arr[ny][nx] = "F";
				visited2[ny][nx] = true;
			}
		}
	}
	public static void bfs(){
		Queue<Fire> q = new LinkedList<Fire>();
		q.add(new Fire(startY,startX,0));
		visited[startY][startX] = true;
		while(!q.isEmpty()){
			Fire tmp = q.poll();

			for(int i=0;i<4;i++){
				int ny = tmp.y+dy[i];
				int nx = tmp.x+dx[i];
				int nCnt = tmp.cnt+1;

				if(ny<0|| nx<0|| ny>=r || nx>=c){
					continue;
				}
				if(visited[ny][nx]){
					continue;
				}
				if(arr[ny][nx].equals("F") || arr[ny][nx].equals("#")){
					continue;
				}

				q.add(new Fire(ny,nx,nCnt));
			//	System.out.println(ny+" "+nx);
				visited[ny][nx]= true;
//				for(int a =0 ;a<r;a++){
//					for(int b =0;b<c;b++){
//						System.out.print(visited[a][b]+" ");
//					}
//					System.out.println("");
//				}
				if((ny==0 || nx==0 || ny==r-1 || nx==c-1) && arr[ny][nx].equals(".")){
					res = nCnt;
					return;
				}
			}
			mapChange();
	//		showArr();
		}
	}

	public static void showArr(){
		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println("");
		}
	}
}
class Fire{
	int y;
	int x;
	int cnt;

	Fire(int y, int x, int cnt){
		this.y = y;
		this.x =x;
		this.cnt = cnt;
	}
}
