import java.util.Scanner;

public class Algo_5585 {
	static int N;
	static int cnt=0;
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
		
		N =in.nextInt();
		
		solve();
		
	}
	public static void solve(){
		N= 1000-N;
		while(N!=0){
			if(N>=500){
				N=N-500;
				cnt++;
			}
			else if(N<500 && N>=100){
				N=N-100;
				cnt++;
			}
			else if(N<100 &&N >=50){
				N=N-50;
				cnt++;
			}
			else if(N<50 &&N>=10){
				N=N-10;
				cnt++;
			}
			else if(N<10 && N>=5){
				N=N-5;
				cnt++;
			}
			else{
				N=N-1;
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
