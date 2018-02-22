import java.util.Scanner;

public class test{
	static boolean visited[];
	static int tmp[];
	public static void main(String[]args){
		
		visited = new boolean[4];
		tmp = new int[4];
		
		combination(0,4,2,0);

	}
	public static void combination(int index, int n, int r, int target){
		if(r==0){ // 출력할 경우 
 			
		}
		else if(target == n){// return할 경우 
			return; 
		}
		else{ // 조합을 구할 경우 .
			tmp[index] = target;
			combination(index+1, n, r-1, target+1);
			combination(index, n, r, target+1);
		}
	}
}