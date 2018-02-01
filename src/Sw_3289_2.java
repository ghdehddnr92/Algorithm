import java.util.Scanner;

public class Sw_3289_2 {
	static int T;
	static int N,M;
	static int arr[];
	static int select;
	static int a,b;
	static String result="";
	
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);

		T = in.nextInt();

		for(int t=1;t<=T;t++){
			N = in.nextInt();
			M = in.nextInt();
			arr = new int[N+1];

			for(int i=1;i<=N;i++){
				arr[i] = i;
			}
			for(int i=0;i<M;i++){
				select = in.nextInt();
				a = in.nextInt();
				b = in.nextInt();

				if(select ==0){
					union(a,b);
				}
				else{
					check(a,b);
				}
			//	show();
			}

			System.out.println("#"+t+" "+result);
			result="";
		}
	}
	public static int find(int x){
		if(x == arr[x]){
			return x;
		}
		arr[x] = find(arr[x]);
		return arr[x];
	}
	public static void union(int a,int b){
		if(find(a) != find(b)){
			arr[find(a)] = find(b);
		}
		else{
			return;
		}
	}
	public static void check(int a, int b){
		if(find(a)==find(b)){
			result+="1";
		}
		else{
			result+="0";
		}
	}
	public static void show(){
		for(int i=1;i<=N;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}
