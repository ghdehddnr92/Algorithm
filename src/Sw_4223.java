import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Sw_4223 {
	static int T;
	static int N;
	static int arr[][];
	static int L;
	static boolean flag = false;
	static int min = Integer.MAX_VALUE;

	public static void main(String[]args) throws NumberFormatException, IOException{
		//Scanner in = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T =Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t=1;t<=T;t++){
			N =Integer.parseInt(br.readLine());
			arr = new int[N][27];

			for(int i=0;i<N;i++){
				L = Integer.parseInt(br.readLine());
				String line = br.readLine();
				st = new StringTokenizer(line);
				for(int j=0;j<L;j++){
					arr[i][st.nextToken().charAt(0)-'A']++;
				}
				int score = Integer.parseInt(br.readLine());
				arr[i][26] = score;
			}

			//			for(int i=0;i<N;i++){
			//				for(int j=0;j<27;j++){
			//					System.out.print(arr[i][j]+" ");
			//				}
			//				System.out.println("");
			//			}
			for(int i=0;i<(1<<N);i++){
				int sum = 0;
				int res[] = new int[27];
				for(int j=0;j<N;j++){
					if((i & (1<<j)) >0){
						sum += arr[j][26];
						for(int k=0;k<26;k++){
							res[k] += arr[j][k];
						}
					}
			//		System.out.println("");
				}
//				for(int k=0;k<27;k++){
//					System.out.print(res[k]+" ");
//				}
//				System.out.println("");
				if(res['S'-'A']>=2  && res['A'-'A']>=1 && res['M'-'A']>=1 && res['U'-'A']>=1 && res['N'-'A']>=1 &&
						res['G'-'A']>=1){
					flag = true;
					if(min > sum){
						min = sum;
					}
				}
				sum =0;
			}

			if(!flag){
				System.out.println("#"+t+" "+-1);
			}
			else{
				System.out.println("#"+t+" "+min);
			}
			min = Integer.MAX_VALUE;
			flag = false;
		}
	}
}
