import java.util.Arrays;
import java.util.Scanner;

public class Sw_1952 {
	static int T;
	static int day,oneMonth,threeMonth,year;
	static int arr[];
	static int res=0;
	static int min=1<<30;
	public static void main(String[]ags){
		Scanner in = new Scanner(System.in);
		arr = new int[13];
		T = in.nextInt();
		for(int i=1;i<=T;i++){
			day = in.nextInt();
			oneMonth = in.nextInt();
			threeMonth = in.nextInt();
			year = in.nextInt();
			
			for(int j=0;j<12;j++){
				arr[j]=in.nextInt();
			}
			
			Search(0,0);
			System.out.println("#"+i+" "+min);
			min=1<<30;
		}
	}
	public static void Search(int month, int cost){
		//System.out.println(month+" "+cost);
		if(month>=12){
			if(cost<min){
				min= cost;
			}
			return;
		}
		Search(month+1,cost+day*arr[month]);
		Search(month+1,cost+oneMonth);
		Search(month+3,cost+threeMonth);
		Search(month+12,cost+year);
	}
}
