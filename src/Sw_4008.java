import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sw_4008 {
	static int T;
	static int N;
	static int arr[];
	static int plusCnt, minusCnt, mulCnt, divCnt;
	static int yunsan[];
	static int tmp[];
	static boolean visited[];
	static int max = -100000000;
	static int min = 100000000;
	public static void main(String[]args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());

		for(int t=1;t<=T;t++){
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			yunsan = new int[N-1];
			tmp = new int[N-1];
			visited = new boolean[N-1];

			st = new StringTokenizer(br.readLine());
			plusCnt = Integer.parseInt(st.nextToken());
			minusCnt = Integer.parseInt(st.nextToken());
			mulCnt = Integer.parseInt(st.nextToken());
			divCnt = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());

			for(int i=0;i<N;i++){
				arr[i] = Integer.parseInt(st.nextToken());
			}

			dfs(0,0,0,0,0,arr[0]);

			System.out.println("#"+t+" "+(max-min));
			max = -100000000;
			min = 100000000;
		}
	}

	public static void dfs(int index, int plus, int minus, int mul, int div, int res){
		if(plus == plusCnt && minus == minusCnt && mul == mulCnt && div == divCnt){
			max = Math.max(res, max);
			min = Math.min(res, min);
			return;
		}
		if(plus<plusCnt){
			dfs(index+1, plus+1, minus, mul, div, res + arr[index+1]);
		}
		if(minus<minusCnt){
			dfs(index+1, plus, minus+1, mul, div, res - arr[index+1]);
		}
		if(mul<mulCnt){
			dfs(index+1, plus, minus, mul+1, div, res * arr[index+1]);
		}
		if(div<divCnt){
			dfs(index+1, plus, minus, mul, div+1, res / arr[index+1]);
		}
	}
}
