import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Algo_2580 {

	static int arr[][];
	static ArrayList<Integer> list;
	static int currentY, currentX;
	public static void main(String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		arr  = new int[10][10];
		StringTokenizer st;
		list = new ArrayList<Integer>();

		for(int i=1;i<=9;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=9;j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		solve();
		
		showArr();
	}
	public static boolean solve(){
		int y = 0;
		int x = 0;
		
		if(findEmpty()){ //모든 칸을 채웠을 경우 
			return true;
		}
		y = currentY;
		x = currentX;
		
		for(int i=1;i<=9;i++){
			if(isSafe(i,y,x)){ //넣을수 있는 수가 있을 경우 
				arr[y][x]=i;
				if(solve()){
					return true;
				}
				arr[y][x] = 0;
			}
		}
		return false;
	}
	public static boolean isSafe(int num, int y, int x){
		if(checkX(x,num) && checkY(y,num) &&  checkBox(y,x,num)){
			return true;
		}
		return false;
	}
	//로  체크 
	public static boolean checkX(int y, int num){
		for(int i=1;i<=9;i++){
			if(arr[y][i] == num){
				return false;
			}
		}
		return true;
	}
	//
	public static boolean checkY(int x, int num){
		for(int i=1;i<=9;i++){
			if(arr[i][x] == num){
				return false;
			}
		}
		return true;
	}
	public static boolean checkBox(int r, int c, int n) {
	    int row = ((int) Math.ceil(r / 3.0) - 1) * 3 + 1;
	    int col = ((int) Math.ceil(c / 3.0) - 1) * 3 + 1;
	    for (int i = 0; i < 3; i++) {
	        for (int j = 0; j < 3; j++) {
	            if (arr[row + i][col + j] == n) {
	                return false;
	            }
	        }
	    }
	    return true;
	}
	public static boolean findEmpty(){
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				if (arr[i][j] == 0) {
					currentY = i;
					currentX = j;
					return false;
				}
			}
		}
		return true; //모두칸을 채웠을 경우 
	}
	//세로체크 
	public static boolean colCheck(int y, int x){
		int zeroCnt =0;
		for(int i=0;i<9;i++){
			if(arr[i][x]==0){
				zeroCnt++;
			}
		}

		if(zeroCnt == 1){
			return true;
		}
		else{
			return false;
		}
	}
	
	public static void showArr(){
		System.out.println("------------------------");
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println("");

		}
	}
}
