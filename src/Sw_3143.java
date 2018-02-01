import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sw_3143 {
	static int T;
	static int result=0;
	static String A,B;
	
	public static void main(String[]args) throws NumberFormatException, IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			A =st.nextToken();
			B =st.nextToken();

			boolean flag = false;
			for(int i=0;i<A.length();i++){
				int j=0;
				if(A.charAt(i)==B.charAt(j) && B.length() <=A.length()-i){
					for(j=0;j<B.length();j++){
						if(A.charAt(i+j)!=B.charAt(j)){
							flag =true;
							break;
						}
					}
					if(flag == false){ //계속 같을 경우 
						i=i+B.length()-1;
						result++;
					}
					else{ //중간에 달라졌을 경우 
						result+=j;
						i=i+j-1;
					}
					flag= false;
				}
				else{
					result++;
				}
			}
			System.out.println("#"+t+" "+result);
			result=0;
		}
	}
}


