import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sw_2112 {

	static int T;
	static int D,W,K;
	static int arr[][];
	static int tmp[][];
	static int min = Integer.MAX_VALUE;

	public static void main(String[]args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t=1;t<=T;t++){
			st = new StringTokenizer(br.readLine());

			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arr = new int[D][W];
			tmp = new int[D][W];

			for(int i=0;i<D;i++){
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<W;j++){
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int map[][] = new int[D][W];
			for(int i=0;i<D;i++){
				for(int j=0;j<W;j++){
					map[i][j] = arr[i][j];
				}
			}

			if(check(arr)){
				System.out.println("#"+t+" "+0);
			}
			else{
				for(int i=0;i<D;i++){
					if(dfs(0,map,0,i)){
						break;
					}
				}
				System.out.println("#"+t+" "+min);
				min = Integer.MAX_VALUE;
			}
		}	
	}

	public static boolean dfs(int depth,int map[][],int cnt,int num){

		if(depth==D || cnt == num){
			if(check(map)){
				if(min >cnt){
					min = cnt;
					//showMap(map);
					return true; 
				}
			}
			return false;
		}

		int tmp2[][] = new int[D][W];

		//		//약품을 0으로 칠했을 경우 
		setTmp(map);
		mapChange(depth,tmp,0);
		for(int i=0;i<D;i++){
			for(int j=0;j<W;j++){
				tmp2[i][j] = tmp[i][j];
			}
		}
		if(dfs(depth+1,tmp2,cnt+1,num)){
			return true;
		}

		//약품을 1으로 칠했을 경우
		setTmp(map);
		//	mapChange(depth,tmp,1);
		for(int j=0;j<W;j++){
			tmp2[depth][j] = 1;
		}

		if(dfs(depth+1,tmp2,cnt+1,num)){
			return true;
		}

		//약품 칠 안했을 경우 
		//setTmp(map);
		for(int j=0;j<W;j++){
			tmp2[depth][j] = map[depth][j];
		}
		if(dfs(depth+1,map,cnt,num)){
			return true;
		}
		return false;
	}
	public static void setTmp(int map[][]){
		for(int i=0;i<D;i++){
			for(int j=0;j<W;j++){
				tmp[i][j] = map[i][j];
			}
		}
	}

	public static void showMap(int map[][]){
		//	System.out.println("-----------------------");
		for(int i=0;i<D;i++){
			for(int j=0;j<W;j++){
				System.out.print(map[i][j]+" ");
			}
			System.out.println("");
		}
	}
	//성능 검사 
	public static boolean check(int map[][]){
		boolean flag = true;
		for(int j=0;j<W;j++){
			int cur = map[0][j];
			int cnt = 1;

			for(int i=1;i<D;i++){
				if(cur==map[i][j]){
					cnt++;
					if(cnt == K){ // 연속된 조건 충족될 경우.
						flag = true;
						break;
					}
				}
				else{
					cur = map[i][j];
					cnt = 1;
				}
			}
			if(cnt<K){
				flag = false;
				return flag;
			}
		}
		return flag;
	}
	//약품 투여 
	public static void mapChange(int index, int map[][],int num){
		for(int j=0;j<W;j++){
			map[index][j] = num;
		}
	}
}
