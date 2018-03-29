import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Sw_1949_4 {
    public static int[] dx = { 0, 1, 0, -1 };
    public static int[] dy = { -1, 0, 1, 0 };
    public static int N, K, maxCount;
    public static boolean[][] isVisited;
    public static int[][] grid;
 
    public static void dfs(int curHeight, int x, int y, int count, boolean isShaved) {
        if(count+curHeight<=maxCount) return;
 
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= N || ny < 0 || ny >= N)
                continue;
 
            if (isVisited[nx][ny])
                continue;
 
            if (curHeight > grid[nx][ny]) {
 
                isVisited[nx][ny] = true;
                maxCount = Math.max(maxCount, count+1);
                dfs(grid[nx][ny], nx, ny, count + 1, isShaved);
                isVisited[nx][ny] = false;
            } else {
                if (isShaved)
                    continue;
 
                if (grid[nx][ny] - K > grid[x][y] - 1)
                    continue;
 
                isVisited[nx][ny] = true;
                maxCount = Math.max(maxCount, count+1);
                dfs(grid[x][y] - 1, nx, ny, count + 1, true);
                isVisited[nx][ny] = false;
            }
        }
    }
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
 
        for (int z = 1; z <= T; z++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            isVisited = new boolean[N][N];
            grid = new int[N][N];
            int max = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    grid[i][j] = Integer.parseInt(st.nextToken());
                    if (max < grid[i][j]) {
                        max = grid[i][j];
                    }
                }
            }
            maxCount = Integer.MIN_VALUE;
            int ans = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (grid[i][j] == max) {
                        isVisited[i][j] = true;
                        dfs(grid[i][j], i, j, 1, false);
                        isVisited[i][j] = false;
                    }
                }
 
            }
            sb.append("#" + z + " " + maxCount + "\n");
        }
        System.out.print(sb); 
    }
}