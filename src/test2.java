import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test2 {

	private static int R,C, max;
	private static boolean visited[][];
	private static char[][] arr;
	private static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
	private static boolean[] abc;
	static int cnt =0;

	private static void back(int r, int c) {

		if(cnt > max){
			max = cnt;
		}

		for(int i=0;i<4;i++){
			int nextR = r+dir[i][0];
			int nextC = c+dir[i][1];

			if(nextR>=R || nextR<0 || nextC>=C || nextC<0) {
				continue;
			}

			if(cnt>=R*C) {
				continue;
			}

			if(visited[nextR][nextC]) {
				continue;
			}

			if(abc[arr[nextR][nextC]]) {
				continue;
			}
			//System.out.println(nextR+" "+nextC);
			visited[nextR][nextC] = true;
			abc[arr[nextR][nextC]] = true;
			cnt++;
			back(nextR,nextC);
			visited[nextR][nextC]=false;
			abc[arr[nextR][nextC]] = false;
			cnt--;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[R][C];
		visited = new boolean[R][C];
		abc = new boolean[100];
		for(int i=0; i<R; i++) {
			String temp = br.readLine();
			for(int j=0; j<C; j++)
				arr[i][j] = temp.charAt(j);
		}
		max = Integer.MIN_VALUE;
		visited[0][0] = true;
		abc[arr[0][0]] = true;
		cnt++;

		back(0,0);

		System.out.println(max);
	}
}