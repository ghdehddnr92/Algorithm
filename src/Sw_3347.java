import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Sw_3347 {
	static int T;
	static int N,M;
	static ArrayList<Integer>A;
	static ArrayList<Integer>B;
	static int arr[];
	static int max =0;
	static int maxIndex =0;
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);

		T = in.nextInt();

		for(int t=1;t<=T;t++){
			N = in.nextInt();
			M = in.nextInt();
			A= new ArrayList<Integer>();
			B = new ArrayList<Integer>();
			arr = new int[N];

			for(int i=0;i<N;i++){
				A.add(in.nextInt());
			}

			for(int j=0;j<M;j++){
				B.add(in.nextInt());
			}

			for(int j=0;j<M;j++){
				for(int i=0;i<N;i++){
					if(B.get(j)>=A.get(i)){
					//	System.out.println(j+"일때 "+i);
						arr[i]++;
						if(arr[i]>arr[maxIndex]){
							maxIndex = i;
							max = arr[i];
						}
						break;
					}
				}
			}
			
//			for(int i=0;i<N;i++){
//				System.out.println(arr[i]);
//			}
			System.out.println("#"+t+" "+(maxIndex+1));
			max =0;
			maxIndex =0;
		}
	}
}
