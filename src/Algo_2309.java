import java.util.Arrays;
import java.util.Scanner;

public class Algo_2309 {
	static int arr[];
	public static void main(String[]args){
		arr=new int[9];
		
		Scanner in  = new Scanner(System.in);
		for(int i=0;i<9;i++){
			arr[i]=in.nextInt();
		}
		Arrays.sort(arr);
		
		check();
	}
	public static void check(){
		for(int i=0;i<9;i++){//제외할 첫번째 난쟁이 선택 
			for(int j=0;j<9;j++){//제외할 두번째 난쟁이 선택
				int sum=0;
				if(i==j){
					continue;
				}
				for(int k=0;k<9;k++){
					if(k!=i && k!=j){
						sum+=arr[k];
					}
				}
				if(sum==100){
					for(int k=0;k<9;k++){
						if(k!=i && k!=j){
							System.out.println(arr[k]);
						}
					}
					return;
				}
			}
		}
	}
}
