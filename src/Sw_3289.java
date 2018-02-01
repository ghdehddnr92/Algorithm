import java.util.ArrayList;
import java.util.Scanner;

public class Sw_3289 {
	static int T;
	static int N,M;
	static int select, a,b;

	static ArrayList<boolean[]> list;
	//static LinkedList<boolean[]> list;
	static String result="";

	public static void main(String[]args){
		Scanner in = new Scanner(System.in);

		T= in.nextInt();

		for(int t=1;t<=T;t++){
			N = in.nextInt();
			M = in.nextInt();
			list = new ArrayList<boolean[]>();
			boolean arr[] = new boolean[N+1];
			arr[1]=true;
			list.add(0,arr);
			for(int i=2;i<=N;i++){
				arr[i-1]= false;
				arr[i] = true;
				
//				for(int j=1;j<=N;j++){
//					System.out.print(arr[j]+" ");
//				}
//				System.out.println("");
				list.add(i-1, arr);
			}
			showList();
			for(int m=0;m<M;m++){
				select = in.nextInt();
				a = in.nextInt();
				b = in.nextInt();
			
				if(select == 0 && a!=b){
					sum(a,b);
				}
				else if(select ==1 && a==b){
					continue;
				}
				else{
					check(a,b);
				}
			}
			System.out.println("#"+t+" "+result);
			result="";
		}
	}
	public static void sum(int a, int b){
		int aIndex = 0;
		int bIndex = 0;
		boolean flag[] = new boolean[N+1];
		for(int i=0;i<list.size();i++){
			flag = list.get(i);
			if(flag[a]==true || flag[b]==true){
				if(flag[a]==true){
					aIndex = i;
				}
				if(flag[b]==true){
					bIndex = i;
				}
			}
			if(aIndex !=0 && bIndex!=0){
				break;
			}
		}

		if(aIndex>bIndex){
			int tmp = bIndex;
			bIndex = aIndex;
			aIndex = tmp;
		}
		flag = list.get(aIndex);
		boolean flag2[] = new boolean[N+1];
		flag2 = list.get(bIndex);
		for(int i=1;i<=N;i++){
			if(flag2[i]==true){
				flag[i]= true;
			}
		}
		list.remove(aIndex);
		list.remove(bIndex-1);
		list.add(flag);
	}
	public static void check(int a, int b){
		//System.out.println("check");
		boolean flag[] = new boolean[N+1];
		for(int i=0;i<list.size();i++){
			flag = list.get(i);
			if(flag[a]==true){
				if(flag[b]==true){
					result+="1";
					break;
				}
				else{
					result+="0";
					break;
				}
			}
		}
	}
	public static void showList(){
		for(int i=0;i<list.size();i++){
			boolean flag[] = new boolean[N+1];
			flag = list.get(i);
			
			for(int j=1;j<=N;j++){
				System.out.print(flag[j]+" ");
			}
			System.out.println("");
		}
	}
}


