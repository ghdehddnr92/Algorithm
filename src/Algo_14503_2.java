import java.util.Scanner;
import java.io.FileInputStream;
 
class Algo_14503_2 {
    static int n;
    static int m;
    static int map[][];
    static int cnt = 0;
 
    static int dx[] = { -1, 0, 1, 0 };
    static int dy[] = { 0, 1, 0, -1 };
 
    public static void main(String args[]) throws Exception {
        // Scanner sc = new Scanner(new FileInputStream("sample_input.txt"));
 
        Scanner sc = new Scanner(System.in);
 
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
 
        int curr_x = sc.nextInt();
        int curr_y = sc.nextInt();
        int curr_d = sc.nextInt();
 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }
 
        solve(curr_x, curr_y, curr_d);
 
        System.out.println(cnt);
 
    } // main
 
    static void solve(int curr_x, int curr_y, int curr_d) {
        if (map[curr_x][curr_y] == 1)
            return;
 
        if (map[curr_x][curr_y] == 0) {
        	System.out.println(curr_x+" "+curr_y+" "+curr_d);
            map[curr_x][curr_y] = 2;
            cnt++;
        }
 
        for (int i = 0; i < 4; i++) {
            int next_d = (curr_d + 3) % 4;
            int next_x = curr_x + dx[next_d];
            int next_y = curr_y + dy[next_d];
 
            if (map[next_x][next_y] == 0) {
                solve(next_x, next_y, next_d);
                return;
            } else {
                curr_d = next_d;
            }
        }
 
        if (curr_d == 0) {
            curr_x++;
        } else if (curr_d == 1) {
            curr_y--;
        } else if (curr_d == 2) {
            curr_x--;
        } else if (curr_d == 3) {
            curr_y++;
        }
        solve(curr_x, curr_y, curr_d);
    } 
}