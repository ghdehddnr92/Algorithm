import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Sw_3282 {
	static int T;
	static int N,K;
	static int D[][];
	static Bag bag[];

	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
		
		T = in.nextInt();
		
		for(int t=1;t<=T;t++){
			N = in.nextInt();
			K = in.nextInt();
			bag = new Bag[N+1]; 
			D = new int[N+1][K+1];
			
			for(int i=1;i<=N;i++){
				bag[i] = new Bag(in.nextInt(), in.nextInt());
			}

			for(int i=1;i<=N;i++){
				for(int j=1;j<=K;j++){
					if(bag[i].weight >j){
						D[i][j]=D[i-1][j];
					}
					else{
						D[i][j]= Math.max(bag[i].value+D[i-1][j-bag[i].weight],D[i-1][j] );
					}
				}	
			}
			System.out.println("#"+t+" "+D[N][K]);
		}
	}
}
class Bag{
	int weight;
	int value;

	public Bag(int weight, int value){
		this.weight = weight;
		this.value = value;
		
	}
}