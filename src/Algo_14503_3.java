import java.util.Scanner;

public class Algo_14503_3 {

	static int r,c;
	static int arr[][];
	static int dy[]={-1,0,1,0}; // 북 동 남 서 
	static int dx[]={0,1,0,-1};
	static int curY,curX,curDir;
	static int backDir;
	static int res =0;

	public static void main(String[]args){
		Scanner in = new Scanner(System.in);

		r = in.nextInt();
		c = in.nextInt();

		arr =new int[r][c];
		curY = in.nextInt();
		curX = in.nextInt();
		curDir = in.nextInt();

		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
				arr[i][j] = in.nextInt(); //0 인경우 빈칸, 1인경우 벽, 2인경우 청소한 경우
			}
		}

		solve();

		System.out.println(res);
	}
	public static void solve(){
		boolean clearFlag = true;
		while(true){
			if(clearFlag){
				clear(); // 현재 방향 청소.
			}
			if(!checkFourDir()){
				if(!checkBackDir()){ // 후진도 불가능
					return;
				}
				else{
					moveBack();
				}
			}
			else{
				changeDir();//왼쪽으로 방향 변경.
				if(checkLeft()){ // 왼쪽 청소 가능 
					move();
					clearFlag = true;
				}
				else{ // 왼쪽 청소 불가능 
					clearFlag = false;
				}
			}
		}
	}
	public static void moveBack(){
		curY+=dy[backDir];
		curX+=dx[backDir];
	}
	public static void move(){
		curY+=dy[curDir];
		curX+=dx[curDir];
	}
	public static void changeDir(){
		if(curDir == 0){
			curDir = 3;
		}
		else{
			curDir--;
		}
	}
	public static boolean checkLeft(){
		if(arr[curY+dy[curDir]][curX+dx[curDir]]==0){ // 청소 가능할 경우 
			return true;
		}
		else{ //이미 청소했거나 벽인경우.
			return false;
		}
	}
	public static void clear(){
		if(arr[curY][curX] == 0){
			arr[curY][curX] = 2;
			res++;
		}
	}
	public static boolean checkFourDir(){
		if(arr[curY+1][curX] != 0 && arr[curY-1][curX] != 0 && arr[curY][curX+1] != 0 && arr[curY][curX-1] !=0){
			return false;
		}
		else{ // 후진 가능 
			return true;
		}
	}
	public static boolean checkBackDir(){
		getBackDir();
		int ny = curY+dy[backDir];
		int nx = curX+dx[backDir];

		if(arr[ny][nx]==1){ // 뒤쪽이 벽일경우 
			return false;
		}
		else{
			return true;
		}
	}
	public static void getBackDir(){
		if(curDir ==1){
			backDir = 3;
		}
		else if(curDir ==2){
			backDir = 0;
		}
		else if (curDir ==3){
			backDir = 1;
		}
		else{
			backDir = 2;
		}
	}
	public static void showArr(){
		System.out.println("----------------");
		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println("");
		}
	}
}
