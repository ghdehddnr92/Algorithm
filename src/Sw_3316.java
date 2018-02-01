import java.util.Scanner;

public class Sw_3316 {
	static int T;
	static int result;
	static int N;
	static int arr[];
	static boolean visited[];
	static boolean first[];
	static boolean second[];
	static int keyPerson =0;
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);

		T = in.nextInt();

		for(int t=1;t<=T;t++){

			String line = in.next();
			N = line.length();
			arr =new int [N];
			visited =new boolean[4];
			first = new boolean[4];
			second  = new boolean[4];
			for(int i=0;i<N;i++){
				if(line.charAt(i) == 'A'){
					arr[i] = 0;
				}
				else if(line.charAt(i) == 'B'){
					arr[i] = 1;
 				}
				else if(line.charAt(i) == 'C'){
					arr[i] = 2;
				}
				else{
					arr[i] = 3;
				}
			}

			bubun(0);

			System.out.println("#"+t+" "+(result));
			result=0;
		}
	}
	public static void bubun(int day){
	//	System.out.println("day : "+day);
		if(day == N-1){
			return;
		}
		for(int i=0;i<(1<<4);i++){
			boolean personCheck = false;
			boolean keyCheck = false;
			for(int j=0;j<4;j++){
				if((i & (1<<j)) >0){
					first[j] = true;
					if(j == arr[day]){
						personCheck = true;
					}
				}
			}
			if(first[keyPerson]){
				keyCheck = true;
			}
			if(personCheck && keyCheck){ //책임자가 포함되어있을 경우 
				for(int a=0;a<(1<<4);a++){
					keyCheck = false;
					personCheck = false;
					for(int j=0;j<4;j++){
						if((a & (1<<j)) >0){
							second[j] = true;
							if(first[j]==true){
								keyCheck = true;
							}
							if(j==arr[day+1]){
								personCheck = true;
							}
						}
					}
					if(keyCheck == true && personCheck == true){
						result++;
						result = result%1000000007;
					}
				}
			}
			resetFirst();
			resetSecond();
			
			bubun(day+1);
		}
	}

	public static void resetFirst(){
		for(int i=0;i<4;i++){
			first[i] = false;
		}
	}
	public static void resetSecond(){
		for(int i=0;i<4;i++){
			second[i] = false;
		}
	}
}
