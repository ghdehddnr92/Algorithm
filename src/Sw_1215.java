import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sw_1215 {
	static String arr[][];
	static int length;
	static int cnt=0;
	public static void main(String []args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t= 0;t<10;t++){
			length = Integer.parseInt(br.readLine());
			arr = new String[8][8];
			for(int i=0;i<8;i++){
				String line = br.readLine();
				for(int j=0;j<8;j++){
					arr[i][j] = line.charAt(j)+"";
				}
			}
			solution(t+1);
		}	
	}
	public static void solution(int t){
		//가로 방향 
		
		for(int i=0;i<8;i++){
			int start = 0;
			int flag  = 0;
			String line = "";
			for(int k=start;k<8-length+1;k++){
				for(int j=k;j<k+length;j++){
					line+=arr[i][j];
				}
				//System.out.println(line);
				for(int a=0;a<line.length()/2;a++){
			//		System.out.println("첫 :"+ line.charAt(a)+"마지막 :"+line.charAt(line.length()-1-a));
					if(line.charAt(a)!=line.charAt(line.length()-1-a)){
						flag=1;
					}
				}
				if(flag==0){
					cnt++;
				}
				line ="";
				flag=0;
			}
			start++;
		}
		// 세로 방향 
		//System.out.println("===========================");
		for(int i=0;i<8;i++){
			int start =0;
			int flag =0;
			String line = "";
			for(int k=start;k<8-length+1;k++){
				for(int j=k;j<k+length;j++){
					line+=arr[j][i];
				}
			//	System.out.println(line);
				for(int a=0;a<line.length()/2;a++){
					//System.out.println("첫 :"+ line.charAt(a)+"마지막 :"+line.charAt(line.length()-1-a));
					if(line.charAt(a)!=line.charAt(line.length()-1-a)){
						flag=1;
					}
				}
				if(flag==0){
					cnt++;
				}
				line ="";
				flag=0;
			}
			
		}
		System.out.println("#"+t+" "+cnt);
		cnt=0;
	}
	public static void showArr(){
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				System.out.print(arr[i][j]);
			}
			System.out.println("");
		}
	}
}
