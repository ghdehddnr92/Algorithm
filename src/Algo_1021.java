import java.util.LinkedList;
import java.util.Scanner;

public class Algo_1021 {
	static int N;
	static int M;
	static int arr[];
	
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
		
		N = in.nextInt();
		M = in.nextInt();
		arr = new int[M];
		
		for(int i=0;i<M;i++){
			arr[i] = in.nextInt();
		}
		Deque dq = new Deque(M,arr);

		dq.getCnt();
	}
}
class Deque {
	public int cnt =0;
	public int arr[];
	public LinkedList<Integer> q = new LinkedList<Integer>();
	Deque(int qSize, int arr[]){

		for(int i=1;i<=qSize;i++){
			q.add(i);
		}
		this.arr = arr;

		for(int i=0;i<arr.length;i++){
			solve(arr[i]);
		}
	}

	public void solve(int n){
		while(true){
			int target = q.indexOf(n);
			int leftDir = target;

			int qsize  = q.size();
			int rightDir = qsize-target -1;
			
			if(leftDir == 0){ //1번 연산 
				q.remove(target);
				break;
			}
			
			if(leftDir<= rightDir){ // 2번 연산 
				q.addLast(q.removeFirst());
				System.out.println("2");
				cnt++;
			}
			else{//3번 연산
				q.addFirst(q.removeLast());
				System.out.println("3");
				cnt++;
			}
		}
	}
	public void getCnt(){
		System.out.println(cnt);
	}
}
