import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
 
public class Sw_2112_2 {
    static int D,W,K;
    static int Map[][],CopyMap[][];
    static int answer = 0;
    static boolean search = false;
    public static void main(String...msg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TestCase = Integer.parseInt(br.readLine());
        for(int T = 1; T<=TestCase; T++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            Map = new int[D][W];
            CopyMap = new int[D][W];
            answer = Integer.MAX_VALUE;
            search = false;
            for(int i = 0 ; i < D; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0 ; j < W; j++) {
                    Map[i][j] =Integer.parseInt(st.nextToken());
                    CopyMap[i][j] = Map[i][j];
                }
            }
            for(int i = 0 ; i <= D; i++) {
                if(DFS(0,0,i))break;
            }
            System.out.println("#"+T+" "+answer);
        }
    }
    public static boolean DFS(int index,int count,int modify) {
        if(index==D || count == modify) {
            if(CheckFilm()) {
                answer = Math.min(count, answer);
                return true;
            }
            return false;
        }
         
        for(int i = 0 ; i < W; i++) 
            Map[index][i] = 0; //A로 채우기
         
        if(DFS(index+1,count+1,modify))
            return true;
         
        for(int i = 0 ; i < W; i++) 
            Map[index][i] = 1; //B로 채우기
         
        if(DFS(index+1,count+1,modify))
            return true;
         
        for(int i = 0 ; i < W; i++)
            Map[index][i] = CopyMap[index][i]; //원상복구
         
        if(DFS(index+1,count,modify)) return true; //채우지 않고 넘기기
     
        return false;
    }
    public static boolean CheckFilm() {
        W:for(int j = 0 ; j < W; j++) {
            int type = Map[0][j]; 
            int count = 0;
            for(int i = 0 ; i < D; i++) {
                if(Map[i][j]==type) {
                    count++;
                }else {
                    count = 1;
                    type = Map[i][j];
                }
                if(count >= K)
                    continue W;
            }
            if(count < K)
                return false;
        }
        return true;
    }
}