import java.util.Scanner;

public class Algo_14503 {
	static int N,M,r,c,d;
	static int arr[][];
	static boolean visited[][];
	static int cnt=0;
	static int finished=0;
	static int dr[]={-1,0,1,0};
	static int dc[]={0,1,0,-1};
	public static void main(String[]args){
	
		Scanner in = new Scanner(System.in);
		N= in.nextInt();
		M=in.nextInt();
		r = in.nextInt();
		c = in.nextInt();
		d = in.nextInt();
		
		arr= new int[N][M];
		visited = new boolean[N][M];
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				arr[i][j] =in.nextInt();
			}
		}
		
		while(true){
			if(arr[r][c]==0){ //1.번 현재를 청소
				arr[r][c]=2;
				cnt++;
			}
			boolean ret = false;
			for(int i=0;i<4;i++){
				int nd = (d+3)%4;
				int nr = r+dr[nd];
				int nc = c+dc[nd];
				System.out.println("nr"+nr+"nc"+nc);
				if(arr[nr][nc]==0){//왼쪽이 청소하지 않았을 경우 
					
					d = nd;
					r = nr;
					c = nc;
					ret =true;
					break;
				}
				else{
					d = nd;
				}
			}
			if(!ret){
				if(arr[r+1][c]==1 && arr[r-1][c]==1 && arr[r][c+1]==1 && arr[r][c-1]==1){
					System.out.println(cnt);
					break;
				}
				else{
					r = r-dr[d];
					c = c-dc[d];
				}
			}
		}
	}
}