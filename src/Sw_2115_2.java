import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Sw_2115_2 {
	static int T;
	static int N;
	static int M,C;

	static int arr[][];
	static int tmp[];
	static boolean visited[][];
	static int res = 0;
	static int max =0;
	static int maxValue[];
	static int valueMax =0;
	static int mulMax =0;
	static PriorityQueue <Integer> q;
	public static void main(String[]ars) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		StringTokenizer st;

		for(int t=1;t<=T;t++){
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			q = new PriorityQueue<Integer>();
			arr = new int[N][N];
			tmp = new int[M];
			maxValue = new int[2];
			visited = new boolean[N][N];
			for(int i=0;i<N;i++){
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++){
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0;i<N;i++){
				for(int j=0;j<=N-M;j++){
					dfs(i,j,0);
				}
			}
			
			valueMax =0;
			mulMax =0;
			for(int i=0;i<N;i++){
				for(int j=0;j<=N-M;j++){
					boolean flag = true;
					for(int k=j;k<j+M;k++){
						if(visited[i][k]){
							flag = false;
						}
					}
					if(flag){
						dfs2(i,j,0);
					}
				}
			}
			System.out.println("#"+t+" "+(maxValue[0]+maxValue[1]));
			mulMax =0;
			valueMax =0;
		}
	}
	public static void dfs(int y, int x,int length){
		if(length==M){
			for(int i=0;i<(1<<M);i++){
				int value =0;
				int mul =0;
				for(int j=0;j<M;j++){
					if((i &(1<<j)) >0){
						value+=tmp[j];
						mul += (tmp[j]*tmp[j]);
					}
				}
				if(value<=C  && mul >= mulMax){
					valueMax = value;
					mulMax = mul;
					maxValue[0] = mul;
					
					for(int a=0;a<N;a++){
						for(int b=0;b<N;b++){
							visited[a][b]= false;
						}
					}
					for(int k=x-1;k>=x-M;k--){
						visited[y][k] = true;
					}
				}
			}
			res =0;
			return;
		}

		tmp[length] = arr[y][x];
		res += tmp[length];
		dfs(y,x+1,length+1);
	}
	public static void dfs2(int y, int x,int length){
		if(length==M){
			for(int i=0;i<(1<<M);i++){
				int value =0;
				int mul =0;
				for(int j=0;j<M;j++){
					if((i &(1<<j)) >0){
						value+=tmp[j];
						mul += (tmp[j]*tmp[j]);
					}
				}
				if(value<=C &&  mul >= mulMax){
					valueMax = value;
					mulMax = mul;
					maxValue[1] = mul;
				}
			}
			return;
		}

		tmp[length] = arr[y][x];
		dfs2(y,x+1,length+1);
	}
}
