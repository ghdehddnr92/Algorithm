import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class line1 {
	static int T;
	static String alpha[]={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V"
			,"W","X","Y","Z"};
	static int alphabet[];
	static String res="";
	public static void main(String[]args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int t= 0; t<T;t++){
			alphabet = new int[26];
			
			String word = br.readLine();
			for(int i=0;i<word.length();i++){
				alphabet[word.charAt(i)-'0'-17]++;
			}
			String index=word.charAt(0)+"";
			
			int cnt = 1;
			for(int i=1;i<word.length();i++){
				if(index.equals(word.charAt(i)+"")){
					cnt++;
				}
				else{
					res+=cnt;
					res+=index;
					cnt =1;
					index = word.charAt(i)+"";
				}
			}
			res+=cnt;
			res+=index;
			System.out.println(res);
			res ="";
		}
	}
}
