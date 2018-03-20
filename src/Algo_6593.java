import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Algo_6593 {
	static int L,R,C;
	static String arr[][][];
	static boolean flag = false;
	static boolean visited[][][];
	static int min = Integer.MAX_VALUE;
	//남 동 북 서 하 상 
	static int dl[] ={0,0,0,0,1,-1};
	static int dy[] ={1,0,-1,0,0,0};
	static int dx[] ={0,1,0,-1,0,0};
	public static void main(String[]args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine());
		Scanner in = new Scanner(System.in);
		while(true){
			L = in.nextInt();
			R = in.nextInt();
			C = in.nextInt();

			if(L==0 && R==0 && C==0){
				return;
			}

			arr = new String[L][R][C];
			visited = new boolean[L][R][C];
			
			for(int i=0;i<L;i++){
				for(int j=0;j<R;j++){
					String line = in.next();
					for(int k=0;k<C;k++){
						arr[i][j][k] = line.charAt(k)+"";
					}
				}
			}

			for(int i=0;i<L;i++){
				for(int j=0;j<R;j++){
					for(int k=0;k<C;k++){
						if(arr[i][j][k].equals("S")){
							bfs(i,j,k,0);
							break;
						}
					}
				}
			}
			//showArr();
			if(min!=Integer.MAX_VALUE){
				System.out.println("Escaped in "+min+" minute(s).");
			}
			else{
				System.out.println("Trapped!");
			}
			min = Integer.MAX_VALUE;
		}
	}
	public static void bfs(int l,int y,int x,int cnt){
		Queue<Sangbum> q = new LinkedList<Sangbum>();
		q.add(new Sangbum(l,y,x,cnt));

		while(!q.isEmpty()){
			Sangbum tmp = q.poll();

			for(int i=0;i<6;i++){
				int nl = tmp.l+dl[i];
				int ny = tmp.y+dy[i];
				int nx = tmp.x+dx[i];
				int nCnt = tmp.cnt+1;

				if(nl<0|| ny<0 ||nx<0|| nl>=L || ny>=R || nx>=C){
					continue;
				}
				if(arr[nl][ny][nx].equals("#")){
					continue;
				}
				if(visited[nl][ny][nx]){
					continue;
				}
				//	System.out.println(nl+" "+ny+" "+nx);

				if(arr[nl][ny][nx].equals("E")){
					if(nCnt< min){
						min = nCnt;
						flag =true;
						return;
					}
				}
				q.add(new Sangbum(nl,ny,nx,nCnt));
				visited[nl][ny][nx] = true;
			}
		}
	}
	public static void showArr(){
		for(int i=0;i<L;i++){
			System.out.println("----------------");
			for(int j=0;j<R;j++){
				for(int k=0;k<C;k++){
					System.out.print(arr[i][j][k]+" ");
				}
				System.out.println("");
			}

		}
	}
}
class Sangbum{
	int l;
	int y;
	int x;
	int cnt;
	public Sangbum(int l,int y, int x,int cnt){
		this.l = l;
		this.y = y;
		this.x = x;
		this.cnt =cnt;
	}
}
