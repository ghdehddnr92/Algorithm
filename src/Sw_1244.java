//처음에는 그리디 방식으로 풀려다가 , 예외처리 실패, 결국 완탐.
//완탐으로 다돌렸을때 시간초과나서 vistied로 중복 처리 해줌.


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sw_1244 {

	static int T;
	static int changeCnt;
	static boolean visited[][];
	static String money;
	static String result[];
	static int max =0;

	public static void main(String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int t=1;t<=T;t++){
	
			st = new StringTokenizer(br.readLine());
			money = st.nextToken();
			changeCnt = Integer.parseInt(st.nextToken());
			result = new String[money.length()];
			visited = new boolean[changeCnt+1][1000000];
			for(int i=0;i<money.length();i++){
				result[i] = money.charAt(i)+"";
			}
			solve(0);

			System.out.println("#"+t+" "+max);
			max = 0;
		}
	}
	public static void solve(int cnt){
		visited[cnt][Integer.parseInt(money)] = true;
		if(cnt == changeCnt){
			max = Math.max(max , Integer.parseInt(money));
			return;
		}

		for(int i=0;i<money.length()-1;i++){
			for(int j=i+1;j<money.length();j++){
				if(result[i].equals(result[j])){
					continue;
				}
				swap(i,j);
				if(visited[cnt+1][Integer.parseInt(money)]!=true){
					solve(cnt+1);
				}
				swap(j,i);
			}
		}
	}
	public static void swap(int i, int j){
		String tmp = result[i];
		result[i] = result[j];
		result[j] = tmp;
		
		money = "";
		for(int k=0;k<result.length;k++){
			money +=result[k];
		}
	}
}
