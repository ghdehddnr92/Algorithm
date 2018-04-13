import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Sw_4168 {
	static int T;
	static int N,M;
	static int price[];
	static int value[];
	static int max =0;
	static ArrayList<Integer> list;
	static ArrayList<Integer> finalList;
	public static void main(String[]args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T= Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++){
			st = new StringTokenizer(br.readLine());
			list = new ArrayList<Integer>();
			finalList = new ArrayList<Integer>();
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			value = new int[M];
			price = new int[M];
			
			for(int i=0;i<M;i++){
				st = new StringTokenizer(br.readLine());
				
				price[i] = Integer.parseInt(st.nextToken());
				value[i] = Integer.parseInt(st.nextToken());
			}
			dfs(0,0,0);
		
			System.out.print("#"+t+" ");
			for(int i=0;i<finalList.size();i++){
				System.out.print(finalList.get(i)+" ");
			}
			System.out.println(max);
			max =0;
		}
	}
	public static void dfs(int index, int  sumValue, int sumPrice){
		if(index == M){
			if(sumValue > max){
				finalList.clear();
				max = sumValue;
				for(int i=0;i<list.size();i++){
					finalList.add(list.get(i));
				}
				//System.out.println("");
			}
			list.clear();
			return;
		}
		
		if(sumPrice + price[index] <=N){
			list.add(index);
			dfs(index+1,sumValue+value[index],sumPrice+price[index]);
		}
		dfs(index+1,sumValue, sumPrice);
	}
}
