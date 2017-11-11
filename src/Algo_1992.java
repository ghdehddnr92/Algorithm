import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo_1992 {
	static int N;
	static int arr[][];
	static int zeroCnt;
	static int oneCnt;
	public static void main(String args[]) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N =Integer.parseInt(br.readLine());
		
		arr= new int[N][N];
		for(int i=0;i<N;i++){
			String line =br.readLine();
			for(int j=0;j<N;j++){
				arr[i][j] = Integer.parseInt(line.charAt(j)+"");
			}
		}	
		check(0,N-1,0,N-1);
	}
	public static void check(int startX, int endX, int startY, int endY){
	
		
		int allCnt = (endY+1-startY)*(endX+1-startX);
		zeroCnt=0;
		oneCnt=0;
		for(int i=startX;i<endX+1;i++){
			for(int j=startY;j<endY+1;j++){
				if(arr[i][j]==0){
					zeroCnt++;
				}
				else{
					oneCnt++;
				}
			}
		}

		if(zeroCnt==allCnt){
			System.out.print("0");
			return;
		}
		else if(oneCnt==allCnt){
			System.out.print("1");
			return;
		}
		else{
			System.out.print("(");
	
			check(startX,endX/2,startY,endY/2);
			check(endX/2+1,endX,startY,endY/2);
			check(startX,endX/2,endY/2,endY);
			check(endX/2+1,endX,endY/2,endY);
			System.out.print(")");
		}
	}
}
