import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Sw_1251 {
	static int T;
	static int N;
	static Double E;
	static long result = 0;
	static int arr[][];

	static LinkedList<Land> first= new LinkedList<Land>();
	static LinkedList<Land> list = new LinkedList<Land>();
	
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);

		T = in.nextInt();

		for(int t=1;t<=T;t++){
			N  = in.nextInt();

			arr =new int[2][N];

			for(int i=0;i<2;i++){
				for(int j=0;j<N;j++){
					arr[i][j] = in.nextInt();
				}
			}
			for(int j=0;j<N;j++){
				first.add(new Land(arr[0][j],arr[1][j]));
			}
			
			E = in.nextDouble();
			//System.out.println("firstsize"+first.size());
			solve();
			System.out.println("#"+t+" "+(long)((result*E)+0.5));
			result =0;
			list.clear();
		}
	}
	public static void solve(){
		
		long value;
		Land tmp = first.getFirst();
		first.removeFirst();
		list.add(tmp);
		
		while(!first.isEmpty()){
			
			tmp = first.getFirst();
			first.removeFirst();
			long min = Long.MAX_VALUE;
			for(int i=0;i<list.size();i++){
				long minusX = list.get(i).x-tmp.x;
				long minusY = list.get(i).y-tmp.y;
				value = (minusX*minusX)+(minusY*minusY);
				if(value < min){
					min = value;
				//	System.out.println("min :"+min);
				}
			}
			result += min;
			list.add(tmp);
		}
	}
}
class Land{
	int y; 
	int x;

	Land(int y, int x){
		this.y = y;
		this.x = x;
	}
}
