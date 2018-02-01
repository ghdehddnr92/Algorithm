import java.util.PriorityQueue;
import java.util.Scanner;

public class Sw_1860 {
	static int T;
	static int N,M,K;
	static int cnt=0;
	static int time =0;
	static PriorityQueue<Integer> pr;
	static String result="Possible";
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
		T = in.nextInt();
		for(int t=1;t<=T;t++){
			N = in.nextInt();
			M = in.nextInt();
			K = in.nextInt();
			pr = new PriorityQueue<Integer>();
			for(int i=0;i<N;i++){
				pr.add(in.nextInt());
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
			//System.out.println("cus:"+cus);
			while(time!=cus){
			
				time++;
			//	System.out.println("time:"+time);
				if(time%M==0){
					cnt+=K;
				}

				if(time==cus){
			//		System.out.println("cnt:"+cnt);
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
