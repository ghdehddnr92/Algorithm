import java.util.Scanner;

public class Algo_6603 {
	static int k;
	static int arr[];
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
		
		while(true){
			k= in.nextInt();
			if(k==0){
				return;
			}
			arr  = new int[k];
			for(int i = 0; i<k; i++){
				arr[i] = in.nextInt();
			}
			// k개 중에서 6개를 고르는 모든 경우에서 kC6
			combination(0, arr.length,0,0);
			//solve();
		}
	}
	public static void solve(){
		for(int a=0;a<arr.length-5;a++){
			for(int b=1;b<arr.length-4;b++){
				for(int c=2;c<arr.length-3;c++){
					for(int d=3;d<arr.length-2;d++){
						for(int e=4;e<arr.length-1;e++){
							for(int f=5;f<arr.length;f++){
								if(a<b && a<c && a<d && a<e && a<f 
										&& b<c && b<d && b<e &&b<f 
										&& c<d && c<e && c<f 
										&& d<e && d<f
										&& e<f){
									System.out.print(arr[a]+" ");
									System.out.print(arr[b]+" ");
									System.out.print(arr[c]+" ");
									System.out.print(arr[d]+" ");
									System.out.print(arr[e]+" ");
									System.out.println(arr[f]);
								}
							}
						}
					}
				}
			}
		}
		System.out.println("");
	}
	public static void combination(int start, int end, int target, int resCnt){
		
	}
}
