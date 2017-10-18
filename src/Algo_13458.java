import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo_13458 {
	static int N;
	static int arr[];
	static int B,C;
	static long res=0;
	public static void main(String[]args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		String line = br.readLine();
		StringTokenizer st = new StringTokenizer(line);
		for(int i=0;i<N;i++){
			arr[i]=Integer.parseInt(st.nextToken());
		}
		line = br.readLine();
		st = new StringTokenizer(line);
	
		B= Integer.parseInt(st.nextToken());
		C =Integer.parseInt(st.nextToken());
		
		for(int i=0;i<N;i++){
			if(arr[i]-B>0){
				if((arr[i]-B)%C!=0){ 
					res+=(arr[i]-B)/C+1;
				}
				else{
					res+=(arr[i]-B)/C;
				}
			}
		}
		System.out.println(res+N);
	}
}
