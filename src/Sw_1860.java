import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Sw_1860 {
	static int T;
	static int N,M,K;
	static int cnt = 0;
	static int time = 0;
	
	static PriorityQueue<Integer> pr;
	static String result="Possible";
	public static void main(String[]args) throws NumberFormatException, IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++){
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			pr = new PriorityQueue<Integer>();
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++){
				pr.add(Integer.parseInt(st.nextToken()));
			}

			solve();

			System.out.println("#"+t+" "+result);
			result= "Possible";
			time =0;
			cnt = 0;
		}
	}
	public static void solve(){
		while(!pr.isEmpty()){
			int cus = pr.poll();
			
			if(time == cus){
				if(cnt>0){
					cnt +=-1;
				}
				else{
					result="Impossible";
					return;
				}
			}
			
			while(time!=cus){
				
				time++;

				if(time%M==0){
					cnt+=K;
				}

				if(time==cus){
					if(cnt>0){
						cnt+=-1;
					}
					else{
						result="Impossible";
						return;
					}
				}
			}
		}
	}
}
