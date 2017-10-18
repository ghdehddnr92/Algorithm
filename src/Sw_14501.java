import java.util.Scanner;

public class Sw_14501 {
	static int N;
	static int arr[][];
	static long max=0;
	static int day=0;
	static long sum=0;
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
		
		N= in.nextInt();
		arr = new int[N+1][2];
		for(int i=1;i<=N;i++){
			for(int j=0;j<2;j++){
				arr[i][j]= in.nextInt();
			}
		}
		dfs(1,0);
		System.out.println(max);
	}
	public static void dfs(int day, int sum){
		if(day==N+1){
		//	System.out.println(sum);
			if(sum>max){
				max = sum;
			}
			return;
		}
		//System.out.println("day :" +day+" 1 : "+arr[day][0]+" N" + N+ " sum : "+sum);
		if(day+arr[day][0]<=N+1){ // 선택할 경우 
			dfs(day+arr[day][0],sum+arr[day][1]);
		}
		if(day+1<=N+1){ // 선택하지 않을 경우 
			dfs(day+1,sum);
		}
	}
}
