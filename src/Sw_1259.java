import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Sw_1259 {
	
	static int T,N;
	static int arr[][];
	static boolean visited[];
	static LinkedList<Integer> list;
	
	public static void main(String[]args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());

		for(int t=1;t<=T;t++){
			N = Integer.parseInt(br.readLine());
			arr = new int[N][2];
			list = new LinkedList<Integer>();
			visited = new boolean[N];
			st =new StringTokenizer(br.readLine());

			for(int i=0;i<N;i++){
				for(int j=0;j<2;j++){
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			solve();

			System.out.print("#"+t+" ");

			for(int i=0;i<list.size();i++){
				System.out.print(list.get(i)+" ");
			}
			System.out.println("");
		}
	}
	public static void solve(){
		
		list.add(arr[0][0]);
		list.add(arr[0][1]);
		
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(!visited[j]){
					if(list.getLast() == arr[j][0]){
						list.add(arr[j][0]);
						list.add(arr[j][1]);
						visited[j] = true;
					}
					else if(list.getFirst()==arr[j][1]){
						list.addFirst(arr[j][1]);
						list.addFirst(arr[j][0]);
						visited[j] = true;
					}
				}
			}
		}
	}
}
