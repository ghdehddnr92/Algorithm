public class test2{
	static int tmp[];
	static boolean visited[];
	static int arr[] ={0,2,4,8,10};
	public static void main(String[]args){
		tmp = new int[3];
		visited = new boolean[5];
	//	bubun();
	//	factorial(0);
		
	//	combination(0,5,3,0);
		int total =0;
		for(int i=1;i<=5;i++){
			for(int j=1;j<=i;j++){
				System.out.print(j);
				total++;
			}
			System.out.println("");
		}
		System.out.println(total);
		//dfs(0,0);
	}
	public static void bubun(){
		for(int i=0;i<(1<<3);i++){
			for(int j=0;j<3;j++){
				if((i &(1<<j))>0){
					System.out.print(j+" ");
				}
			}
			System.out.println("");
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
				visited[i] = true;
				tmp[index] = i;
				factorial(index+1);
				visited[i] = false;
			}
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
	//조합 bfs
	public static void dfs(int depth, int index){
		if(depth ==3) {
			for(int i=0;i<3;i++){
				System.out.print(tmp[i]+" ");
			}
			System.out.println("");
			return;
		}
		
		for(int i=index;i<5;i++){
			tmp[depth] = arr[i];
			dfs(depth+1,i+1);
		}
	}
}