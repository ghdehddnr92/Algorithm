import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo_13701 {
	static int arr[];
	static boolean visited[];
	public static void main(String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		line = br.readLine();
		arr = new int[5000000];
		visited  = new boolean[33554432];
		StringTokenizer st = new StringTokenizer(line);
		int cnt=0;
		while(st.hasMoreTokens()){
			int tmp = Integer.parseInt(st.nextToken());		
			if(visited[tmp]==false){
				arr[cnt]=tmp;
				visited[tmp]=true;
				cnt++;
			}
		}
		for(int i=0;i<cnt;i++){
			System.out.print(arr[i]+" ");
		}
	}
}
