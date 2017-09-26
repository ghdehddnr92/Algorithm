import java.util.Scanner;

public class Algo_1094 {
	static int X;
	static int arr[];
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
		X =in.nextInt();
		arr= new int[7];
		arr[0]=64;
		for(int i=1;i<7;i++){
			arr[i]=arr[i-1]/2;
		}
		int cnt=0;
		int res=0;
		for(int i=0;i<7;i++){
			if(X==arr[i]){
				System.out.println("1");
				return;
			}
		
			else if(X-res>=arr[i]){
				res+=arr[i];
				//System.out.println("res "+ res);
				cnt++;
				if(res==X){
					System.out.println(cnt);
				}
			}
		}
		
		
	}
}
