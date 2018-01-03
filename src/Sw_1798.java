import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Sw_1798 {
	static int T, N, M;
	static int time[][];
	static String location[][];
	static boolean visited[];
	static int result;
	static int dayTime;
	static int startIndex;
	static int max = 0;
	public static void main(String[]args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String line;

		T = Integer.parseInt(br.readLine());

		for(int t = 0; t<T; t++){
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			time = new int[N+1][N+1];
			visited = new boolean[N+1];

			for(int i=1;i<N;i++){
				st = new StringTokenizer(br.readLine());
				for(int j=i+1;j<N+1;j++){
					time[i][j] = Integer.parseInt(st.nextToken());
					time[j][i] = time[i][j];
				}
			}
			System.out.println("");

			location = new String[N+1][3];

			for(int i=1; i< N+1;i++){
				line = br.readLine();

				st = new StringTokenizer(line);
				String tmp = st.nextToken();

				if(tmp.equals("A") || tmp.equals("H")){
					if(tmp.equals("A")){
						startIndex = i;
					}
					location[i][0] = tmp;
					location[i][1] = "";
					location[i][2] = "";
				}
				else{
					location[i][0] = tmp;
					location[i][1] = st.nextToken();
					location[i][2] = st.nextToken();
				}
			}


			//			for(int i=1;i<N+1;i++){
			//				for(int j=1;j<N+1;j++){
			//					System.out.print(time[i][j] +" ");
			//				}
			//				System.out.println();
			//			}
			//
			//			for(int i=1;i<N+1;i++){
			//				for(int j=0;j<3;j++){
			//					System.out.print(location[i][j]+" ");
			//				}
			//				System.out.println("");
			//			}

			for(int i=1;i<N+1;i++){
				if(location[i][0].equals("P")){
					dfs(startIndex,i);
					resetVisited();
				}
			}
		}
	}
	public static void dfs(int y, int x){
		System.out.println("y:"+y+" x: "+x);
		dayTime += time[y][x]; // 가는 시간 
		visited[x] = true;

		dayTime += Integer.parseInt(location[y][1]); //놀이 시간 
		result += Integer.parseInt(location[y][2]); // 만족도 
		
	}
	public static void resetVisited(){
		for(int i=1;i<N+1;i++){
			visited[i] = false;
		}
	}
}
