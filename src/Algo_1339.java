import java.util.ArrayList;
import java.util.Scanner;

public class Algo_1339 {
	static int N;
	static String arr[];
	static int al[];
	static boolean visited[];
	static ArrayList<String> list;
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
		
		N = in.nextInt();
		arr = new String[N];
		list = new ArrayList<String>();

		for(int i=0;i<N;i++){
			arr[i] = in.next();
			for(int j=0;j<arr[i].length();j++){
				if(!list.contains(arr[i].charAt(j)+"")){
					list.add(arr[i].charAt(j)+"");
				}
			}
		}
		
		System.out.println(list.size());
		visited = new boolean[list.size()];
		al = new int[list.size()];
		
		factorial(0);
	}
	public static void factorial(int index){
		if(index == list.size()){
			for(int i=0;i<list.size();i++){
				System.out.print(al[i]);
			}
			System.out.println("");
			return;
		}
		
		for(int i=0;i<list.size();i++){
			if(!visited[i]){
				al[index] = 9-i;
				visited[i] = true;
				factorial(index+1);
				visited[i]= false;
			}
		}
	}
}
class Alphabet{
	String alpha;
	int value;
	
	Alphabet(String alpha){
		this.alpha = alpha;
	}
	
	public void setValue(int value){
		this.value = value;
	}
}
