import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class line3 {
	
	static int N;
	static int parent[];
	
	public static void main(String[]args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		parent = new int[100001];
		
		Arrays.fill(parent, -1);
		
		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			union(x,y);
		}
		
		System.out.println(countRoot());
	}
	public static int countRoot(){
		int res = 0;
		for (int i = 0; i < 100001; i++) {
			if (parent[i] < -1) {
				res++;
			}
		}
		return res;
	}
	public static int find(int n) {
		if (parent[n] < 0){
			return n;
		}

		parent[n] = find(parent[n]);

		return parent[n];
	}
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if (a == b){
			return;
		}
		parent[a] += parent[b];
		parent[b] = a;
	}
}
