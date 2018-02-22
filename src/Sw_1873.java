import java.util.Scanner;

public class Sw_1873 {
	static int T;
	static int H,W;
	static int N;
	static String command;
	static String map[][];
	static int tankX, tankY, tankDir;
	static int dx, dy;
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);

		T = in.nextInt();

		for(int t=1;t<=T;t++){
			H = in.nextInt();
			W = in.nextInt();
			map = new String[H][W];
			for(int i=0;i<H;i++){
				String line = in.next();
				for(int j=0;j<W;j++){
					map[i][j] = line.charAt(j)+"";
					if(map[i][j].equals("^")){
						tankY = i;
						tankX = j;
						dy = -1;
						dx = 0;
						tankDir = 1;
					}
					else if(map[i][j].equals("v")){
						tankY = i;
						tankX = j;
						dy = 1;
						dx = 0;
						tankDir = 2;
					}
					else if(map[i][j].equals("<")){
						tankY = i;
						tankX = j;
						dy = 0;
						dx = -1;
						tankDir = 3;
					}
					else if(map[i][j].equals(">")){
						tankY = i;
						tankX = j;
						dy = 0;
						dx = 1;
						tankDir = 4;
					}
				}
			}
			N = in.nextInt();
			command = in.next();

			for(int i=0;i<command.length();i++){
				play(command.charAt(i)+"");
			//	System.out.println(command.charAt(i)+"");
			//	showMap();
			//	System.out.println("--------------");
			}
			System.out.print("#"+t+" ");
			showMap();
			tankX =0;
			tankY =0;
			dy =0;
			dx =0;
			tankDir =0;
		}
	}
	public static void tankCheck(){
		if(tankY+dy >=0 && tankY+dy<H && tankX+dx>=0 && tankX+dx<W){
			if(map[tankY+dy][tankX+dx].equals(".")){
				map[tankY][tankX]=".";
				map[tankY+dy][tankX+dx]=stringDir();
				tankX = tankX+dx;
				tankY = tankY+dy;
			}
			else{
				map[tankY][tankX]=stringDir();
			}
		}
		else{
			map[tankY][tankX]=stringDir();
		}
	}
	public static String stringDir(){
		if(tankDir ==1){
			return "^";
		}
		else if(tankDir==2){
			return "v";
		}
		else if(tankDir==3){
			return "<";
		}
		else{
			return ">";
		}
	}
	public static void shotCheck(){

		int curX=tankX;
		int curY=tankY;
		while(true){
			curX+=dx;
			curY+=dy;
			if(curX>=W || curY>=H || curX<0 || curY<0){
				break;
			}

			//System.out.println(curY+" "+curX);
			if(map[curY][curX].equals("*")){
				map[curY][curX]=".";
				break;
			}
			else if(map[curY][curX].equals("#")){
				break;
			}
		}
	}
	public static void play(String com){
		if(com.equals("U")){
			dy = -1;
			dx = 0;
			tankDir =1;
			tankCheck();
		}
		else if(com.equals("D")){
			dy = 1;
			dx = 0;
			tankDir = 2;
			tankCheck();
		}
		else if(com.equals("L")){
			dy = 0;
			dx = -1;
			tankDir = 3;
			tankCheck();
		}
		else if(com.equals("R")){
			dy = 0;
			dx = 1;
			tankDir = 4;
			tankCheck();
		}
		else{ //포탄 발사 
			shotCheck();
		}
	}
	public static void showMap(){
		for(int i=0;i<H;i++){
			for(int j=0;j<W;j++){
				System.out.print(map[i][j]);
			}
			System.out.println("");
		}
	}
}