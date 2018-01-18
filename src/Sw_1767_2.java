import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Sw_1767_2 {
	static int map[][];
	static int numProcessor = 0;
	static int numLine = Integer.MAX_VALUE;
	static int T, N;
	static ArrayList<Point> list;

	static class Point {
		int x;
		int y;

		public Point() {
		}

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}


	// i,j가 d 방향으로 전선을 놓는 경우
	public static void dfs(int idx, int line, int connect, boolean check[][]) {
		if (idx == list.size()) {
			if (numProcessor < connect) {
				numProcessor = connect;
				numLine = line;
				return;
			} else if (numProcessor == connect) {
				if (numLine > line) {
					numLine = line;
					return;
				}
			}
			return;
		}
		Point cur = list.get(idx);
		int x = cur.x; // row
		int y = cur.y; // col

		int up = 0, down = 0, left = 0, right = 0;
		boolean collision = false; // 충돌 체크

		// 1. up
		for (int i = x - 1; i >= 0; i--) {
			if (check[i][y]||map[i][y]==1) {
				collision = true;
			}
		}
		if (!collision) {// 충돌 경우가 없다면 재귀를 타본다
			for (int i = x - 1; i >= 0; i--) { // 전선 놓고
				check[i][y] = true;
				up++;
			}
			dfs(idx + 1, line+up, connect + 1, check); // 재귀
			for (int i = x - 1; i >= 0; i--) { // 원상복귀
				if (map[i][y] != 1){
					check[i][y] = false;
				}
			}
		}
		collision = false; // 충돌 체크 원복

		// 2. down
		for (int i = x + 1; i < N; i++) {
			if (check[i][y]||map[i][y]==1) {
				collision = true;
			}
		}
		if (!collision) {
			for (int i = x + 1; i < N; i++) {
				check[i][y] = true;
				down++;
			}
			dfs(idx + 1, line + down, connect + 1, check);// 재귀
			for (int i = x + 1; i < N; i++) { // 원상복귀. 
				if (map[i][y] != 1){
					check[i][y] = false;
				}
			}
		}
		collision = false;

		
		
		// 재귀 3 left
		for (int i = y - 1; i >= 0; i--) {
			if (check[x][i]||map[x][i]==1) {
				collision = true;
			}
		}
		if (!collision) {// 충돌 경우가 없다면 재귀를 타본다
			for (int i = y - 1; i >= 0; i--) { // 전선 놓고
				check[x][i] = true;
				left++;
			}
			dfs(idx + 1, line + left, connect + 1, check); // 재귀
			for (int i = y - 1; i >= 0; i--) { // 원상복귀
				if (map[x][i] != 1 ){
					check[x][i] = false;
				}
			}
		}
		collision = false;

		// 재귀 4 right
		for (int i = y + 1; i < N; i++) {
			if (check[x][i]||map[x][i]==1) {
				collision = true;
			}
		}
		if (!collision) {
			for (int i = y + 1; i < N; i++) {
				check[x][i] = true;
				right++;
			}
//			System.out.println(idx + " right rec: " + right);
			dfs(idx + 1, line + right, connect + 1, check);// 재귀
			for (int i = y + 1; i < N; i++) { // 원상복귀
				if (map[x][i] != 1){
					check[x][i] = false;
				}
			}
		}

		collision = false;
		// 아무것도 안움직이고 다음 점 살피는 경우
		dfs(idx + 1, line, connect, check);
		return;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			boolean check[][] = new boolean[N][N];
			list = new ArrayList<>();
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {	//프로세서 있는 부분은 체크 true
						check[i][j] = true;
					}
					if (map[i][j] == 1 && i != 0 && j != 0) {	//프로세서 있는 가장자리 부분은 체크 true
						check[i][j] = true;
						list.add(new Point(i, j));
					}
				}
			}
			dfs(0, 0, 0, check);
			if(numLine !=Integer.MAX_VALUE)
				System.out.println("#" + t + " " + numLine);
			else 
				System.out.println("#" + t + " " + 0);
		} // end of test
	}
}