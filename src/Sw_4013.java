import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sw_4013 {
	static int arr[][];
	static int rotate[][];
	static int T;
	static int K;
	static int res =0;
	static boolean flag[];

	public static void main(String[]args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t=1;t<=T;t++){
			K = Integer.parseInt(br.readLine());
			arr = new int[4][8];
			rotate = new int [K][2];
			flag = new boolean[3];
			for(int i=0;i<4;i++){
				st = new StringTokenizer(br.readLine());

				for(int j=0;j<8;j++){
					arr[i][j] = Integer.parseInt(st.nextToken()); // 0 이면 N극 1이면 S극, 배열 0번재 배열이 화살표,그다음 시계순
				}
			}

			for(int k=0;k<K;k++){
				st = new StringTokenizer(br.readLine());

				for(int i=0;i<2;i++){
					rotate[k][i] = Integer.parseInt(st.nextToken()); //1이면 시계방향 -1이면 반시계방향 
				}
			}

			solve();
			//showArr();

			System.out.println("#"+t+" "+res);
			res = 0;
		}
	}
	public static void solve(){
		for(int k=0;k<K;k++){
			int num = rotate[k][0];
			int dir = rotate[k][1];

			Arrays.fill(flag, false);

			flagCheck();

			if(num==1){
				if(dir==1){
					clock(0);
					if(flag[0]){
						reverse(1);
						if(flag[1]){
							clock(2);
							if(flag[2]){
								reverse(3);
							}
						}
					}
				}
				else{
					reverse(0);
					if(flag[0]){
						clock(1);
						if(flag[1]){
							reverse(2);
							if(flag[2]){
								clock(3);
							}
						}
					}
				}
			}
			else if(num==2){
				if(dir==1){
					clock(1);
					if(flag[0]){
						reverse(0);
					}
					if(flag[1]){
						reverse(2);
						if(flag[2]){
							clock(3);
						}
					}
				}
				else{
					reverse(1);
					if(flag[0]){
						clock(0);
					}
					if(flag[1]){
						clock(2);
						if(flag[2]){
							reverse(3);
						}
					}
				}
			}
			else if(num==3){
				if(dir==1){
					clock(2);
					if(flag[1]){
						reverse(1);
						if(flag[0]){
							clock(0);
						}
					}
					if(flag[2]){
						reverse(3);
					}
				}
				else{
					reverse(2);
					if(flag[1]){
						clock(1);
						if(flag[0]){
							reverse(0);
						}
					}
					if(flag[2]){
						clock(3);
					}
				}
			}
			else{
				if(dir==1){
					clock(3);
					if(flag[2]){
						reverse(2);
						if(flag[1]){
							clock(1);
							if(flag[0]){
								reverse(0);
							}
						}
					}
				}
				else{
					reverse(3);
					if(flag[2]){
						clock(2);
						if(flag[1]){
							reverse(1);
							if(flag[0]){
								clock(0);
							}
						}
					}
				}
			}

		}
		sum();
	}
	public static void sum(){
		if(arr[0][0]==1){
			res+=1;
		}
		if(arr[1][0]==1){
			res+=2;
		}
		if(arr[2][0]==1){
			res+=4;
		}
		if(arr[3][0]==1){
			res+=8;
		}
	}
	public static void flagCheck(){
		if(arr[0][2]!=arr[1][6]){
			flag[0]=true;
		}
		if(arr[1][2]!=arr[2][6]){
			flag[1]=true;
		}
		if(arr[2][2]!=arr[3][6]){
			flag[2]=true;
		}
	}
	public static void clock(int num){
		int tmp = arr[num][7];
		for(int i=6;i>=0;i--){
			arr[num][i+1] = arr[num][i];
		}
		arr[num][0] = tmp;
	}
	public static void reverse(int num){
		int tmp = arr[num][0];
		for(int i=1;i<8;i++){
			arr[num][i-1] = arr[num][i];
		}
		arr[num][7] = tmp;
	}
	public static void showArr(){
		for(int i=0;i<4;i++){
			for(int j=0;j<8;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println("");
		}
	}
	public static void showVisited(){
		for(int i=0;i<3;i++){
			System.out.print(flag[i]+" ");
		}
		System.out.println("");
	}
}
