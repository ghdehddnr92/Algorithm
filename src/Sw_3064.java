import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//구간합, 펜윅트리 
public class Sw_3064 {
	static int T;
	static int N,M;
	static long arr[];
	static long tree[];
	static int C;
	static Queue<Long> q;
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
	
		T = in.nextInt();
		
		for(int t=1;t<=T;t++){
			N = in.nextInt();
			M = in.nextInt();
			arr = new long[N+1];
			tree = new long[N+1];
			for(int i=1;i<=N;i++){
				arr[i] = in.nextInt();
				update(i,arr[i]);
			}
			
			int X, Y;
			int L, R;
			q = new LinkedList<Long>();
			for(int i=0;i<M;i++){
				C = in.nextInt();
				
				if(C == 1){
					X = in.nextInt();
					Y = in.nextInt();
					update(X,Y);
				}
				else{
					L = in.nextInt();
					R = in.nextInt();
					q.add((sum(R)-sum(L-1)));
				}
			}
			System.out.print("#"+t+" ");
			while(q.size()>1){
				System.out.print(q.poll()+" ");
			}
			System.out.println(q.poll());
		}
	}
	public static void update(int X, long Y){
		while(X < tree.length){
			tree[X] += Y;
			X += (X & -X);
		}
	}
	public static long sum(int i){
		long res =0;
		while(i > 0){
			res += tree[i];
			i -= (i & -i);
		}
		return res;
	}
}
