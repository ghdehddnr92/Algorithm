import java.util.ArrayList;
import java.util.Scanner;

public class Algo_1987_2 {
	static int y,x;
	static String arr[][];
	static ArrayList<String> list;
	static int max =0;
	static boolean visited[][];
	static int dy[]= {1,0,-1,0};
	static int dx[]= {0,1,0,-1};
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
		
		y = in.nextInt();
		x = in.nextInt();
		
		arr = new String[y][x];
		list = new ArrayList<String>();
		visited = new boolean[y][x];
		for(int i=0;i<y;i++){
			String line = in.next();
			for(int j=0;j<x;j++){
				arr[i][j] = line.charAt(j)+"";
			}
		}
		showArr();
		visited[0][0] = true;
		list.add(arr[0][0]);
		dfs(0,0);
		
		System.out.println(max);
		
	}
	public static void dfs(int r, int c){
		if(max < list.size()){
			max = list.size();
		}
		for(int i=0;i<4;i++){
			int ny = r+dy[i];
			int nx = c+dx[i];
			if(ny<0 || nx<0 || ny>=y || nx>=x){
				continue;
			}
			if(visited[ny][nx]){
				continue;
			}
			if(list.contains(arr[ny][nx])){
				continue;
			}
			
			visited[ny][nx] = true;
			list.add(arr[ny][nx]);
		//	System.out.println(list);
		//	showVisited();
			dfs(ny,nx);
			visited[ny][nx] = false;
			list.remove(list.size()-1);
		//	System.out.println(list);
		}
	}
	public static void showVisited(){
		for(int i=0;i<y;i++){
			for(int j=0;j<x;j++){
				System.out.print(visited[i][j]+" ");
			}
			System.out.println("");
		}
	}
	public static void showArr(){
		for(int i=0;i<y;i++){
			for(int j=0;j<x;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println("");
		}
	}
}