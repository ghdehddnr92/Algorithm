import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo_1120 {
	static String X,Y;
	static String line;
	public static void main(String []args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		line = br.readLine();
		
		StringTokenizer st = new StringTokenizer(line);
		
		X = st.nextToken();
		Y = st.nextToken();
	
		int cnt=0;
		int min= 99999;
		for(int i=0;i<Y.length()-X.length()+1;i++){
			for(int j=0;j<X.length();j++){
				if(X.charAt(j)!=Y.charAt(j+i)){
					cnt++;
				}
			}
			System.out.println(cnt);
			if(min>cnt){
				min = cnt;
			}
			cnt=0;
		}
		System.out.println(min);
	}
}
