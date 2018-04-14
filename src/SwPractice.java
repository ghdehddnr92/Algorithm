
public class SwPractice {
	static boolean visited[];
	static int tmp[];
	public static void main(String[]args){
		tmp = new int[4];
		visited = new boolean[4];
		
		//bubun(0);
		//bubunBit();
		//combination(0,5,3,0);
		//combinationDfs(0,0);
		//factorial(0);
	}
	public static void bubun(int depth){
		if(depth == 3){
			for(int i=0;i<3;i++){
				if(visited[i]){
					System.out.print(i+" ");
				}
			}
			System.out.println("");
			return;
		}
	
		visited[depth]= false;
		bubun(depth+1);
		visited[depth]= true;
		bubun(depth+1);
	}
	public static void bubunBit(){
		for(int i=0;i<(1<<4);i++){
			for(int j=0;j<4;j++){
				if((i & (1<<j))>0){
					System.out.print(j+" ");
				}
			}
			System.out.println("");
		}
	}
	public static void combination(int index, int n, int r , int target){
		if(r == 0){
			for(int i=0;i<3;i++){
				System.out.print(tmp[i]+" ");
			}
			System.out.println("");
			return;
		}
		else if(n == target){
			return;
		}
		else{
			tmp[index] = target;
			combination(index+1,n,r-1,target+1);
			combination(index,n,r,target+1);
		}
	}
	public static void combinationDfs(int depth , int index){
		if(depth== 3){
			for(int i=0;i<3;i++){
				System.out.print(tmp[i]+" ");
			}
			System.out.println("");
			return;
		}
		
		for(int i=index;i<5;i++){
			tmp[depth]= i;
			combinationDfs(depth+1,i+1);
		}
	}
	public static void factorial(int depth){
		if(depth == 4){
			for(int i=0;i<4;i++){
				System.out.print(tmp[i]+" ");
			}
			System.out.println("");
			return;
		}
		
		for(int i=0;i<4;i++){
			if(!visited[i]){
				visited[i]= true;
				tmp[depth] = i;
				factorial(depth+1);
				visited[i] = false;
			}
		}
	}
}