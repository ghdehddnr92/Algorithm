import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Algo_1697_2 {
	static int N,K;

	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
		
		N = in.nextInt();
		K = in.nextInt();
		
		bfs();
	}
	public static void bfs(){
		Queue<Integer> q = new LinkedList<>();
		
		q.add(N);
		
		while(!q.isEmpty()){
			
			int tmp = q.poll();
			
			
		}
	}
}
