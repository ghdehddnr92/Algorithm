import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Algo_1342 {
	static String S;
	static String tmp[];
	static String al[]={"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
	static boolean visited[];
	static int arr[];
	static int res =0;
	static Queue<String> q = new LinkedList<String>();
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);

		S= in.next();
		arr = new int[26];

		for(int i=0;i<S.length();i++){
			arr[S.charAt(i)-'a']++;
		}

		tmp = new String[S.length()];
		visited = new boolean[S.length()];
		dfs(0);
		System.out.println(res);
		//	factorial(0);
		//	System.out.println(q.size());
	}
	public static void dfs(int depth){
		if(depth==S.length()){

			if(check()){
			//	for(int i=0;i<tmp.length;i++){
					//System.out.print(tmp[i]+" ");
			//	}
				//System.out.println("");
				res++;
			}
			return;
		}

		for(int i=0;i<26;i++){
			if(arr[i]>0){
				tmp[depth] = al[i];
				arr[i]--;
				dfs(depth+1);
				arr[i]++;
			}
		}
	}
	public static boolean check(){
		boolean flag = true;
		for(int i=1;i<tmp.length;i++){
			if(tmp[i-1].equals(tmp[i])){
				return false;
			}
		}
		return flag;
	}
	//	public static void factorial(int index){
	//		if(index == S.length()){
	//			//System.out.println("");
	//			String line="";
	//			for(int i=0;i<tmp.length;i++){
	//				line+=tmp[i];
	//			}
	//			if(!q.contains(line)){
	//				q.add(line);
	//			}
	//
	//			return;
	//		}
	//
	//		for(int i=0;i<S.length();i++){
	//			if(!visited[i]){
	//				if(index>=1 && tmp[index-1].equals(S.charAt(i)+"")){
	//					continue;
	//				}
	//				tmp[index] = S.charAt(i)+"";
	//				visited[i] = true;
	//				factorial(index+1);
	//				visited[i] = false;
	//			}
	//		}
	//	}
}
