import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Algo_1759 {
	static int L,C;
	static ArrayList<String> list;
	static int moCnt =0;
	static int jaCnt =0;
	static boolean check[];
	static String tmp[];
	public static void main(String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<String>();
		st = new StringTokenizer(br.readLine());
		check= new boolean[C];
		tmp = new String[L];
		for(int i=0;i<C;i++){
			String tmp = st.nextToken();
			list.add(tmp);
		}
		
		Collections.sort(list);
		
		combination(0,C,L,0);
	}
	public static boolean checkMo(String line){
		if(line.equals("a") || line.equals("e") || line.equals("i")|| line.equals("o")||line.equals("u")){
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void combination(int index, int n, int r, int target){
		if(r ==0){
			for(int i=0;i<L;i++){
				if(checkMo(tmp[i])==true){
					moCnt++;
				}
				else{
					jaCnt++;
				}
			}
			if(moCnt>=1 && jaCnt>=2){
				for(int i=0;i<L;i++){
					System.out.print(tmp[i]);	
				}
				System.out.println("");
			}
			moCnt=0;
			jaCnt=0;
			return;
		}
		else if(target == n){
			return;
		}
		else{
			tmp[index] = list.get(target);
			combination(index+1,n,r-1,target+1);
			combination(index,n,r,target+1);
		}
	}
}