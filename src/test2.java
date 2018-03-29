import java.util.Scanner;

class test2{

	static int tmp[];
	static boolean visited[];
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);

		tmp = new int[3];
		visited = new boolean[5];

		//factorial(0);
		dfs(0);
	}
	public static void dfs(int depth){
		if(depth == 3){
			for(int i=0;i<3;i++){
				System.out.print(tmp[i]+" ");
			}
			System.out.println("");
		}

		for(int i=0;i<5;i++){
			tmp[depth] = i;
			dfs(depth+1);
		}
		
	}

	public static void factorial(int index){
		if(index == 3){
			for(int i=0;i<3;i++){
				System.out.print(tmp[i]+" ");
			}
			System.out.println("");
			return;
		}

		for(int i=0;i<3;i++){
			if(!visited[i]){
				tmp[index] = i;
				visited[i] = true;
				factorial(index+1);
				visited[i] = false;
			}
		}
	}
	public static void dfs(){

	}
}