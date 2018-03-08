import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Sw_3752{
	static int N,T;
	static int arr[];
	static boolean check[];
	static int maxSum =0;
	static int res =1;
	static Queue<Integer> q;
	public static void main(String[]args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());

		for(int t=1;t<=T;t++){
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			st = new StringTokenizer(br.readLine());
			q  = new LinkedList<Integer>();
			for(int i=0;i<N;i++){
				arr[i] = Integer.parseInt(st.nextToken());
				maxSum+=arr[i];
			}
			check = new boolean[maxSum+1];

			solve();
			System.out.println("#"+t+" "+res);
			res = 1;
			maxSum =0;
		}
	}
	public static void solve(){
		check[0] = true;
		for(int i=0;i<N;i++){
			for(int j=0;j<check.length;j++){
				if(check[j]){
					if(!check[j+arr[i]]){
						q.add(j+arr[i]);
					}
				}
			}
			while(!q.isEmpty()){
				int tmp = q.poll();
				if(!check[tmp]){
					check[tmp] = true;
					res++;
				}
			}
		}
//
//		for(int i=0;i<check.length;i++){
//			System.out.print(check[i]+" ");
//		}
//		System.out.println("");
	}
}

