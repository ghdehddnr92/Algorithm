import java.util.LinkedList;
import java.util.Scanner;

public class Sw_1225 {
	static int N;
	static int arr[];
	static LinkedList l;
	static boolean flag = false;
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);

		for(int i=0;i<10;i++){
			N= in.nextInt();
			arr =new int[8];
			l = new LinkedList<Integer>();
			for(int j=0;j<8;j++){
				arr[j] = in.nextInt();
			}
			for(int j=0;j<8;j++){
				l.add(arr[j]);
			}
			int tmp;
			int minus = 1;
			while(flag==false){
				if(minus == 6){
					minus = 1;
				}
//				System.out.println("minus"+ minus);
//				System.out.println(l);
				if((int)l.get(0)>minus){
					l.addLast((int)l.get(0)-minus);
				}
				else{
					l.addLast(0);
					flag= true;
				}
				minus++;
				l.removeFirst();
			}
			System.out.print("#"+N+" ");
			for(int m=0;m<l.size();m++){
				System.out.print(l.get(m)+" ");
			}
			System.out.println("");
			flag=false;
		}
	}
}