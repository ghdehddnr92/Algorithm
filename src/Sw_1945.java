import java.util.Scanner;

class Sw_1945 {
	static int T=0;
	static int N=0;
	static int a=0,b=0,c=0,d=0,e=0;
	public static void main(String[]args) throws Exception{
		Scanner in= new Scanner(System.in);
		T = in.nextInt();
		
		for(int t=0;t<T;t++){
			N= in.nextInt();
			while(N%11==0){
				N=N/11;
				e++;
			}
			while(N%7==0){
				N=N/7;
				d++;
			}
			while(N%5==0){
				N=N/5;
				c++;
			}
			while(N%3==0){
				N=N/3;
				b++;
			}
			while(N%2==0){
				N=N/2;
				a++;
			}	
			System.out.println("#"+(t+1)+" "+a+" "+b+" "+c+" "+d+" "+e);
			a=0;b=0;c=0;d=0;e=0;
		}
	}
}