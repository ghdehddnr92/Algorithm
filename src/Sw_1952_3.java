import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sw_1952_3 {

	static int T;
	static int money[];
	static int month[];
	static int min = Integer.MAX_VALUE;

	public static void main(String[]args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		StringTokenizer st;

		for(int t=1;t<=T;t++){
			st = new StringTokenizer(br.readLine());
			money = new int[4];
			month = new int[13];
			for(int i=0;i<4;i++){
				money[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=1;i<=12;i++){
				month[i] = Integer.parseInt(st.nextToken());
			}

			solve(1,0);
			System.out.println("#"+t+" "+min);
			min = Integer.MAX_VALUE;
		}
	}
	public static void solve(int index,int res){
		//System.out.println(index+" "+res);
		if(res >min){
			return;
		}
		if(index >= 13){
			if(min > res){
				min = res;
			}
			return;
		}

		solve(index+1,res+(money[0]*month[index]));
		solve(index+1,res+money[1]);
		solve(index+3,res+money[2]);
		solve(index+12,res+money[3]);
	}
}
