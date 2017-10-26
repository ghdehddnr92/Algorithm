import java.util.Scanner;

public class Sw_1952_2 {
	static int T;
	static int arr[];
	static int input[];
	static int min=9999999;
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
		T = in.nextInt();

		for(int tc=1;tc<=T;tc++){
			arr = new int[4];
			input = new int[12];
			for(int i=0;i<4;i++){
				arr[i]=in.nextInt();
			}
			for(int i=0;i<12;i++){
				input[i] =in.nextInt();
			}
			
			Search(0,0);
			System.out.println(min);
			min=999999;
		}
	}
	public static void Search(int month, int cost){
		if(month>=12){
			if(cost<min){
				min =cost;
			}
			return;
		}
		Search(month+1,cost+input[month]*arr[0]);
		Search(month+1,cost+arr[1]);
		Search(month+3,cost+arr[2]);
		Search(month+12,cost+arr[3]);
	}
}
