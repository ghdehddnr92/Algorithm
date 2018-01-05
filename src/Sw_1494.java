import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Sw_1494 {
	
	static long result;
	static long min;
	static long totalX,totalY;
	static int T,N;
	static int arr[][];
	static int tmp[];
	static Queue<Integer> tmpQ;
	static Queue<Integer> tmp2Q;
	
	public static void main(String[]args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for(int t = 1;t<=T;t++){
			N = Integer.parseInt(br.readLine());
			arr = new int[N][2];
			tmp = new int[N/2];
			tmpQ = new LinkedList<Integer>();
			tmp2Q = new LinkedList<Integer>();
		
			for(int n=0;n<N;n++){
				st = new StringTokenizer(br.readLine());
				arr[n][0] = Integer.parseInt(st.nextToken());
				arr[n][1] = Integer.parseInt(st.nextToken());
			}
			
			min = Long.MAX_VALUE;
			combination(0,N,N/2,0);
			System.out.println("#"+t+" "+min);
		}
	}
	
	public static void combination(int index, int n, int r, int target){
		if(r == 0){
			for(int i=0;i< index;i++){
				tmpQ.add(tmp[i]);
			}  
			for(int i=0;i<N;i++){
				if(!tmpQ.contains(i)){
					tmp2Q.add(i);
				}
			}
			int qsize = tmpQ.size();
			
			totalX = 0;
			totalY = 0;
			
			for(int i=0;i<qsize;i++){
				int num = tmpQ.poll();
				int num2 = tmp2Q.poll();
				totalX += arr[num][0] - arr[num2][0];
				totalY += arr[num][1] - arr[num2][1];
			}

			result = totalX*totalX + totalY*totalY;
			
			if(min > result){
				min = result;
			}	
		}
		else if(target == n){
			return;
		}
		else{
			tmp[index] = target;
	
			combination(index+1,n,r-1,target+1); 
			combination(index,n,r, target+1);
		}
	}	
}

