import java.util.Scanner;

public class Sw_3314 {
	static int T;
	static int arr[];
	
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
		
		T= in.nextInt();
		
		for(int t=1;t<=T;t++){
			arr =new int[5];
			int sum= 0;
			for(int i=0;i<5;i++){
				arr[i] = in.nextInt();
				if(arr[i]<40){
					arr[i]=40;
				}
				sum+=arr[i];
			}
			System.out.println("#"+t+" "+sum/5);
		}
	}
	public static void cutCheck(){
		
	}
	public static void cut(){
		
	}
}
