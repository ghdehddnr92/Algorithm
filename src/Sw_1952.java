import java.util.Arrays;
import java.util.Scanner;

public class Sw_1952 {
	static int T;
	static int day,oneMonth,threeMonth,year;
	static int arr[];
	static int res=0;
	static int zeroFlag=0;
	public static void main(String[]ags){
		Scanner in = new Scanner(System.in);
		arr = new int[12];
		T = in.nextInt();
		for(int i=1;i<=T;i++){
			day = in.nextInt();
			oneMonth = in.nextInt();
			threeMonth = in.nextInt();
			year = in.nextInt();
			
			for(int j=0;j<12;j++){
				arr[i]=in.nextInt();
				if(arr[i]!=0){
					zeroFlag++;
				}
			}
			if(year<threeMonth && year<oneMonth){ //year가 가장 쌀 경우 
				System.out.println("year가 가장 쌀경");
				res = year;
			}
			else if(threeMonth < year && threeMonth < oneMonth){ // 3달이 가장 쌀 경우 
				System.out.println("3달가 가장 쌀경");
				if(zeroFlag%3!=0){
					res = zeroFlag/3 * threeMonth + threeMonth;
				}
				else{
					res = zeroFlag/3;
				}
				if(res > year){
					res = year;
				}
			}
			else if(oneMonth < year && oneMonth < threeMonth){ // 1달이 가장 쌀 경우
				System.out.println("1달가 가장 쌀경");
//				if(oneMonth*3 < threeMonth){
//					if(oneMonth * zeroFlag < year){
//						res = zeroFlag *oneMonth;
//					}
//					else{
//						res = year;
//					}
//				}
//				else{
//					if(zeroFlag<3){
//						res = zeroFlag * oneMonth;
//					}
//					else{
//						if(zeroFlag!=0){
//							res = zeroFlag/3 * threeMonth + oneMonth * zeroFlag%3;
//						}
//						else{
//							res = zeroFlag/3 * threeMonth;
//						}
//						if(res > year){
//							res = year;
//						}
//					}
//				}
				if(zeroFlag >=3){
					if(oneMonth *3 < threeMonth){
						for(int l=0;l<12;l++){
							if(arr[l]*day < oneMonth){
								res += arr[l]*day;
							}
							else{
								res += oneMonth;
							}
						}
					}
					else{ 
						Arrays.sort(arr);
						res = zeroFlag/3 + threeMonth;
						if(zeroFlag%3==1){
							if(arr[12-zeroFlag+1]*day<oneMonth){
								res += arr[12-zeroFlag+1]*day;
							}
							else{
								res += oneMonth;
							}
						}
						else if(zeroFlag%3 == 2){
							if(arr[12-zeroFlag+1]*day<oneMonth){
								res += arr[12-zeroFlag+1]*day;
							}
							else{
								res += oneMonth;
							}
							if(arr[12-zeroFlag+2]*day<oneMonth){
								res += arr[12-zeroFlag+2]*day;
							}
							else{
								res += oneMonth;
							}
						}
					}
					if(res > year){
						res = year;
					}
				}
				else{
					for(int l=0;l<12;l++){
						if(arr[l]*day < oneMonth){
							res += arr[l]*day;
						}
						else{
							res += oneMonth;
						}
					}
				}
			}
			System.out.println("#"+i+" "+res);
			zeroFlag=0;
			res=0;
		}
	}
}
