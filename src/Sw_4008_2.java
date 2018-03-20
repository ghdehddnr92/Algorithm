import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
public class Sw_4008_2 {
    static int N;
    static int OPER[] = new int[4];
    static boolean visited[];
    static int NUM[];
    static int Max,Min;
    public static void main(String...msg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Tes = Integer.parseInt(br.readLine());
         
        for(int T = 1 ; T<=Tes; T++) {
             
            N = Integer.parseInt(br.readLine());
            NUM = new int[N];
            Max = -Integer.MAX_VALUE;
            Min = Integer.MAX_VALUE;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < 4; i++) {
                OPER[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < N; i++) {
                NUM[i] = Integer.parseInt(st.nextToken());
            }
            DFS(0,NUM[0]);
            System.out.println("#"+T+" "+(Max-Min));
             
        }
    }
    public static void DFS(int index,int result) {
    	System.out.println("index"+index);
        if(index==N-1) {
            Max = Math.max(result, Max);
            Min = Math.min(result, Min);
            return;
        }
        for(int i = 0 ; i < 4; i++) {
        	System.out.println(OPER[i]);
            if(OPER[i]==0)
                continue;
            OPER[i]--;
            DFS(index+1,Calc(result,index+1,i));
            OPER[i]++;
        }
    }
 
    public static int Calc(int value,int index,int OPER) {
        switch(OPER) {
            case 0: return value+NUM[index];
            case 1: return value-NUM[index];
            case 2: return value*NUM[index];
            case 3: return value/NUM[index];
        }
        return 0;
    }
}