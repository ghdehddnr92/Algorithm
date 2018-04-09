import java.util.Scanner;

public class Sw_1952_4 {
	static int T;
	static int min = Integer.MAX_VALUE;
	static int price[];
	static int month[];
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
		T = in.nextInt();

		for(int t=1;t<=T;t++){
			price = new int[4];
			month = new int[12];

			for(int i=0;i<4;i++){
				price[i] = in.nextInt();
			}
			for(int i=0;i<12;i++){
				month[i] = in.nextInt();
			}
			dfs(0,0);

			System.out.println("#"+t+" "+min);
			min = Integer.MAX_VALUE;
		}
	}
	public static void dfs(int index, int sum){
		if(index >=12){
			if(sum < min){
				min = sum;
			}
			return;
		}

		if(sum>min){
			return;
		}
		dfs(index+1,sum+(price[0]*month[index]));
		dfs(index+1,sum+price[1]);
		dfs(index+3,sum+price[2]);
		dfs(index+12,sum+price[3]);
	}
}
