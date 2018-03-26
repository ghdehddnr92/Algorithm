
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Sw_2383_4 {

	private static int N, M, K;
	private static Miarr[][] arr;
	private static int[][] dirarr = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	private static Queue<Mi3> bfs(Queue<Mi3> list) {

		Queue<Mi3> list2 = new LinkedList<>();
		Queue<Mi3> list3 = new LinkedList<>();

		int time = 1;
		while (M >= time) {
			while (!list.isEmpty()) {
				Mi3 now = list.poll();
				int nextrow = now.row + dirarr[now.dir - 1][0];
				int nextcol = now.col + dirarr[now.dir - 1][1];
				int nextdir = 0, nextmicnt;

				if (change(nextrow, nextcol)) { // 가장자리-->방향변경 and 절반줄이기
					switch (now.dir) {
					case 1:
						nextdir = 2;
						break;
					case 2:
						nextdir = 1;
						break;
					case 3:
						nextdir = 4;
						break;
					case 4:
						nextdir = 3;
						break;

					}
					nextmicnt = now.micnt / 2;
					if (nextmicnt != 0) {
						list2.offer(new Mi3(nextrow, nextcol, nextmicnt, nextdir));
						arr[nextrow][nextcol] = new Miarr(nextmicnt, nextdir);
					}
				} else {
					List<Mi3> summi = new LinkedList<>();
					int sum = now.micnt;
					while (!list.isEmpty()) {
						Mi3 chk = list.poll();
						if (chk.col+dirarr[chk.dir-1][1] == nextcol && chk.row+dirarr[chk.dir-1][0] == nextrow) {
							sum += chk.micnt;
							summi.add(chk);
						} else {
							list3.offer(chk);
						}
					}

					Mi3 max = new Mi3(nextrow, nextcol, now.micnt, now.dir);

					for (int i = 0; i < summi.size(); i++) {
						arr[summi.get(i).row][summi.get(i).col] = null;
						if (max.micnt < summi.get(i).micnt)
							max = summi.get(i);
					}


					while (!list3.isEmpty())
						list.offer(list3.poll());

					list2.offer(new Mi3(nextrow, nextcol, sum, max.dir));
					arr[nextrow][nextcol] = new Miarr(sum, max.dir);

				}
				arr[now.row][now.col] = null;

			}
			System.out.println("-----------------------------------------");
			for(int i=0;i<N;i++){
				for(int j=0;j<N;j++){
					if(arr[i][j]!=null){
						System.out.println(i+" "+j+" "+arr[i][j].dir+" "+arr[i][j].micnt);
					}
				}
			}
			time++;
			while (!list2.isEmpty())
				list.offer(list2.poll());
		}
		return list;
	}

	private static boolean change(int row, int col) {
		if (row == 0 || col == 0 || row == N - 1 || col == N - 1)
			return true;
		return false;
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int TestCase = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TestCase; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			arr = new Miarr[N][N];
			Queue<Mi3> list = new LinkedList<>();
			int row, col, num, dir;

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				row = Integer.parseInt(st.nextToken());
				col = Integer.parseInt(st.nextToken());
				num = Integer.parseInt(st.nextToken());
				dir = Integer.parseInt(st.nextToken());
				list.offer(new Mi3(row, col, num, dir));
				arr[row][col] = new Miarr(num, dir);
			}

			Queue<Mi3> ans = bfs(list);
			int cnt = 0;
			while(!ans.isEmpty()) {
				Mi3 mi = ans.poll();
				//System.out.println(mi.row+"::"+mi.col+"::"+mi.micnt);
				cnt+=mi.micnt;
			}
			/*for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
               if (arr[i][j] != null) {
                  cnt += arr[i][j].micnt;
                  System.out.println(i + "," + j + ":::" + arr[i][j].micnt);
               }
            }
         }*/

			System.out.println("#" + tc + " " + cnt);
		}
	}
}

class Mi3 {
	int row;
	int col;
	int micnt;
	int dir;

	public Mi3(int row, int col, int micnt, int dir) {
		this.row = row;
		this.col = col;
		this.micnt = micnt;
		this.dir = dir;
	}
}

class Miarr {
	int micnt;
	int dir;

	public Miarr(int micnt, int dir) {
		this.micnt = micnt;
		this.dir = dir;
	}
}