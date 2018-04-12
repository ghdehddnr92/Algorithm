import java.util.Scanner;

public class Algo_9207 {
	static int N;
	static String arr[][];
	static String map[][];
	static boolean visited[][];
	static int dy[] ={1,0,-1,0};
	static int dx[] ={0,1,0,-1};
	public static void main(String[]args){
		Scanner in =new Scanner(System.in);

		N= in.nextInt();


		for(int t=0;t<N;t++){
			arr = new String[5][9];
			map = new String[5][9];
			visited = new boolean[5][9];
			
			for(int i=0;i<5;i++){
				String line = in.next();
				for(int j=0;j<9;j++){
					arr[i][j]= line.charAt(j)+"";
				}
			}	
			for(int i=0;i<5;i++){
				for(int j=0;j<9;j++){
					map[i][j] = arr[i][j];
				}
			}
			
			solve();
		}
	}
	public static void solve(){
		for(int i=0;i<5;i++){
			for(int j=0;j<9;j++){
				if(map[i][j].equals("o")){
					visited[i][j] = true;
					jump(i,j);
					visited[i][j] = false;
				}
			}
		}
	}
	public static void jump(int y, int x){
		for(int i=0;i<4;i++){
			int ny = y+dy[i];
			int nx = x+dx[i];
			
			if(ny<0|| nx<0 || ny>=5 ||nx>=9){
				continue;
			}
			if(visited[ny][nx]){
				continue;
			}
			
			if(arr[ny][nx].equals(".")|| arr[ny][nx].equals("#")){
				continue;
			}
			
		}
	}
	public static void showArr(){
		for(int i=0;i<5;i++){
			for(int j=0;j<9;j++){
				System.out.print(map[i][j]+" ");
			}
			System.out.println("");
		}
	}
}
