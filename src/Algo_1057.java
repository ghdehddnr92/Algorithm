import java.util.Scanner;

public class Algo_1057 {
	static int N,a,b;
	static int cnt=0;
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		a = in.nextInt();
		b = in.nextInt();
		
		solve(N);
	}
	public static void solve(int end){
		if(end==1){
			System.out.println("-1");
			return;
		}
		if(a>b){
			if(a-b==1 && a/2==0){
				System.out.println(cnt);
				return;
			}
		}
		else{
			if(b-a==1 && b/2==0){
				System.out.println(cnt);
				return;
			}
		}
		cnt++;
		for(int i=1;i<=end;i++){
			if(i==a){
				if(i/2==0 && i!=1){
					a=i/2;
					System.out.println("1");
				}
				else{
					a=(i+1)/2;
					System.out.println("2");
				}
			}
			if(i==b){
				if(i/2==0){
					b=i/2;
					System.out.println("3");
				}
				else{
					b=(i+1)/2;
					System.out.println("4");
				}
			}
		}
		System.out.println("a : "+a+" b : "+b+" cnt: "+cnt);
		solve(end/2);
	}
}
