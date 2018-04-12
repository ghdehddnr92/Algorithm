import java.util.Scanner;

public class Algo_1331 {
	static boolean visited[][];
	static String res = "Valid";
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);

		visited =new boolean[7][7];

		String line = in.next();
		int startY,startX;
		int y= Integer.parseInt(line.charAt(1)+"");
		int x= line.charAt(0)-'A'+1;
		visited[y][x] = true;
		startY = y;
		startX = x;
		for(int i=1;i<36;i++){
			line = in.next();

			int ny = Integer.parseInt(line.charAt(1)+"");
			int nx = line.charAt(0)-'A'+1;

			//	System.out.println(ny+" "+nx+" "+y +" "+x);
			if(ny< 1 || nx<1 || ny>=7 || nx>=7){
				//		System.out.println("범위 X" );

				System.out.println("Invalid");
				return;
			}
			if(!((ny-2==y && nx-1==x)||(ny-2==y && nx+1==x)|| (ny+2==y && nx-1 ==x) || (ny+2==y && nx+1==x) 
					||(nx-2==x && ny-1==y)||(nx+2==x && ny-1==y)||(nx-2==x && ny+1==y)||(nx+2==x && ny+1==y))){
				System.out.println("Invalid");
				return;
			}
			if(visited[ny][nx]){
				System.out.println("Invalid");
				return;
			}
			visited[ny][nx]= true;
			if(i == 35){
				if(!((ny-2==startY && nx-1==startX)||(ny-2==startY && nx+1==startX)|| (ny+2==startY && nx-1 ==startX) || (ny+2==startY && nx+1==startX) 
						||(nx-2==startX && ny-1==startY)||(nx+2==startX && ny-1==startY)||(nx-2==startX && ny+1==startY)||(nx+2==startX && ny+1==startY))){
					System.out.println("Invalid");
					return;
				}
			}

			y = Integer.parseInt(line.charAt(1)+"");
			x = line.charAt(0)-'A'+1;

		}
		if(!check()){
			//	System.out.println("완성 X");
			System.out.println("Invalid");
			return;
		}
		System.out.println("Valid");
	}

	public static boolean check(){
		for(int i=1;i<7;i++){
			for(int j=1;j<7;j++){
				if(!visited[i][j]){
					return false;
				}
			}
		}
		return true;
	}
}
