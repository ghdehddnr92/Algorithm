import java.util.Scanner;

public class Algo_2023 {
	static int N;
	static int arr[];
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
		
		N =in.nextInt();
		arr =new int[N+1];
		if(N==1){
			System.out.println("2");
			System.out.println("3");
			System.out.println("5");
			System.out.println("7");
		}
		else{
			dfs(2,"2");
			dfs(2,"3");
			dfs(2,"5");
			dfs(2,"7");
		}
	}
	public static void dfs(int index,String num){
		if(index == N+1){
			System.out.println(num);
			return;
		}
		
		for(int i=0;i<10;i++){
			if(check(Integer.parseInt(num+String.valueOf(i)))){
				String tmp = num+String.valueOf(i);
				dfs(index+1,tmp);
			}
		}
	}
	//소수인지 체크하는함수 
	public static boolean check(int num){
		int cnt =0;
		boolean flag = true;
		for(int i=2;i<num;i++){
			if(num%i==0){
				cnt++;
				flag = false;
				return flag;
			}
		}
		return flag;
	}
}
