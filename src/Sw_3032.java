import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sw_3032 {
	static int T, A, B;
	static int resultX;
	static int resultY;
	public static void main(String[]args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++){
			st = new StringTokenizer(br.readLine());
			
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			int invers;
			
			invers = Extended_Euclid(A,B);
			if(invers != 0){
				System.out.println("#"+t+" "+resultX+" "+resultY);
			}
			else{
				System.out.println("#"+t+" "+"-1");
			}
		}	
	}
	private static int Extended_Euclid(int r1, int r2) {
        int r, q = 0, s, s1= 1, s2 = 0, t, t1 = 0, t2 = 1, tmp = r1;
 
        while (r2 != 0) {
            q = r1 / r2;
            r = r1 % r2;
            s = s1 - q * s2;
            t = t1 - q * t2;
 
            r1 = r2;
            r2 = r;
            s1 = s2;
            s2 = s;
            t1 = t2;
            t2 = t;
        }
         
        resultX = s1;
        resultY = t1;
        
        if (r1 == 1) // 역원이 있음
        {
            if (t1 < 0)
                t1 += tmp;
            return t1;
        }
 
        return 0;
    }
}
