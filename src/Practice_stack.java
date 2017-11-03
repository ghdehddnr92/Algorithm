import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Practice_stack {
	static LinkedList<Integer> stack;
	static int N;
	public static void main(String[]args) throws NumberFormatException, IOException{

		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		stack = new LinkedList<>();
		String line="";
		for(int i=0;i<N;i++){
			line = br.readLine();
		//	System.out.println(line);
			switch(line){
			case "top":
				top();
				break;
			case "pop":
				pop();
				break;
			case "size":
				size();
				break;
			case "empty":
				empty();
				break;
			default:
				st = new StringTokenizer(line);
				st.nextToken();
				push(Integer.parseInt(st.nextToken()));
				break;
			}
		}

	}
	public static void push(int num){
		stack.add(num);
	}
	public static void pop(){
		if(stack.size()!=0){
			System.out.println(stack.get(stack.size()-1));
			stack.removeLast();
		}
		else{
			System.out.println("-1");
		}
	}
	public static void top(){
		if(stack.size()==0){
			System.out.println("-1");
		}
		else{
			System.out.println(stack.get(stack.size()-1));
		}
	}
	public static void size(){
		System.out.println(stack.size());
	}
	public static void empty(){
		if(stack.size()==0){
			System.out.println("1");
		}
		else{
			System.out.println("0");
		}
	}
}
