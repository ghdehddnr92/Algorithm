import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Algo_13701 {
	static int arr[];
	static int num=0;
	static boolean visited[];
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
		String line;
		line = in.nextLine();
		arr = new int[5000000];
		visited  = new boolean[33554432];
		StringTokenizer st = new StringTokenizer(line);
		int cnt=0;
		while(st.hasMoreTokens()){
			int tmp = Integer.parseInt(st.nextToken());		
			if(visited[tmp]==false){
				arr[cnt]=tmp;
				num++;
				visited[tmp]=true;
				cnt++;
			}
		}
		for(int i=0;i<cnt;i++){
			System.out.print(arr[i]+" ");
		}
	}
}
