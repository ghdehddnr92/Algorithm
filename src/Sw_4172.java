import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sw_4172 {
	static int T;
	static int N,M;
	static int price[];
	static int s[];
	static int max =0;
	public static void main(String[]args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t=1;t<=T;t++){
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			price = new int[M];
			s = new int[M];

			for(int i=0;i<M;i++){
				st = new StringTokenizer(br.readLine());
				price[i] = Integer.parseInt(st.nextToken());
				s[i] = Integer.parseInt(st.nextToken());	
			}
			dfs(0,0,0);

			System.out.println("#"+t+" "+max);
			max =0;
		}
	}
	public static void dfs(int index, int sumPrice, int sumS){
		if(index == M){
			if(sumPrice<=N){
				if(max <sumS){
					max = sumS;
				}
			}
			return;
		}

		if(sumPrice+price[index]<=N){
			dfs(index+1 , sumPrice+price[index],sumS+s[index]);
		}
		dfs(index+1, sumPrice,sumS);
		}
	}
