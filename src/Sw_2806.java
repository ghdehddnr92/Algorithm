import java.util.Scanner;
public class Sw_2806 {
	
	static int path[];
	static int n;
	static int ans;
	static int T;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int t=1;t<=T;t++){
			n = sc.nextInt();
			path = new int[n*n];
			for(int i=0; i<n; i++){
				path[0] = i;
				nQueen(i,0);
			}
			System.out.println("#"+t+" "+ans);
			ans=0;
		}
	}
	private static void nQueen(int x, int y) {
		for(int i=0;i<y;i++){
	        if(path[i]==x || Math.abs(x-path[i])==y-i)
	        	 return;
	    }
	    if(y==n-1){
	        ans++;
	        return;
	    }
	    for(int i=0;i<n;i++){
	        path[y+1]=i;
	        nQueen(i,y+1);
	    }
	}
}