import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Sw_2383_2 {
	static int T;
	static int N;
	static int arr[][];
	static ArrayList<Integer> A;
	static ArrayList<Integer> B;
	static ArrayList<Lunch> start;
	static PriorityQueue<Lunch> total;
	static ArrayList<Lunch> one;
	static ArrayList<Lunch> two;
	static Queue<Lunch> oneWait;
	static Queue<Lunch> twoWait;
	static Queue<Lunch> end;
	static int aY,aX, bY,bX;
	static int aTime = 0;
	static int bTime = 0;
	static int totalPeople = 0;
	static int min = Integer.MAX_VALUE;
	public static void main(String[]args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;

		for(int t=1;t<=T;t++){
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			A = new ArrayList<Integer>();
			B = new ArrayList<Integer>();
			one = new ArrayList<Lunch>();
			two = new ArrayList<Lunch>();
			oneWait = new LinkedList<Lunch>();
			twoWait = new LinkedList<Lunch>();
			start = new ArrayList<Lunch>();
			total = new PriorityQueue<Lunch>();
			end = new LinkedList<Lunch>();
			for(int i=0;i<N;i++){
				st = new StringTokenizer(br.readLine());

				for(int j=0;j<N;j++){
					arr[i][j] = Integer.parseInt(st.nextToken());
					if(arr[i][j] == 1){
						start.add(new Lunch(totalPeople,i,j));
						totalPeople++;
					}
					if(arr[i][j]>1){
						if(aTime ==0){
							aTime = arr[i][j];
							aY = i;
							aX = j;
						}
						else{
							bTime = arr[i][j];
							bY = i;
							bX = j;
						}
					}
				}
			}

			solve();

			System.out.println("#"+t+" "+min);
			min = Integer.MAX_VALUE;
			aTime = 0;
			bTime =0;
			totalPeople  = 0;
		}
	}
	public static void solve(){
		bubun();
	}
	public static void bubun(){
		for(int i=0;i<(1<<totalPeople);i++){
			for(int j=0;j<totalPeople;j++){
				if((i & (1<<j))>0){
					//	System.out.print(j+" ");
					A.add(j);
				}
			}
			for(int j=0;j<totalPeople;j++){
				if(!A.contains(j)){
					B.add(j);
				}
			}
			for(int a= 0;a<start.size();a++){
				if(A.contains(start.get(a).num)){
					start.get(a).dist = calDist(aY,aX,start.get(a).y,start.get(a).x);
					start.get(a).time = aTime; 
					start.get(a).resNum = 0;
				}
				else{
					start.get(a).dist = calDist(bY,bX,start.get(a).y,start.get(a).x);
					start.get(a).time= bTime;
					start.get(a).resNum =1;
				}
				total.add(start.get(a));
			}
			System.out.println("A팀");
			for(int a =0;a<A.size();a++){
				System.out.print(A.get(a)+" ");
			}
			System.out.println("B팀 ");
			for(int a=0;a<B.size();a++){
				System.out.print(B.get(a)+" ");
			}
			System.out.println("");

			play();

			A.clear();
			B.clear();
			//System.out.println("");
		}
	}
	public static void play(){
		int time = 0;
		while(end.size()!=totalPeople){
			System.out.println("시간 : -----"+time);
			if(!one.isEmpty()){
				int size = one.size();
				for(int i=0;i<size;i++){
					one.get(i).time -=1;
					if(one.get(i).time==0){
						end.add(one.get(i));
						one.remove(i);
						if(!oneWait.isEmpty()){
							one.add(oneWait.poll());
						}
					}
				}
			}
			if(!two.isEmpty()){
				int size= two.size();
				System.out.println(two.size()+" two의 사이즈");
				System.out.println(twoWait.size()+"two 대기의 사이즈 ");
				for(int j=0;j<size;j++){
					System.out.println(two.get(j).time+"의시간 "+j);
					two.get(j).time -=1;
					if(two.get(j).time==0){
						end.add(two.get(j));
						two.remove(j);
						if(!twoWait.isEmpty()){
							two.add(twoWait.poll());
						}
					}
				}
			}
			if(!total.isEmpty()){
				while(!total.isEmpty() && total.peek().dist==time){
					Lunch tmp = total.poll();
					System.out.println(tmp.num +" 거리 :"+ tmp.dist +"갈 계단번호 "+tmp.resNum);
					if(tmp.resNum==0){
						if(one.size()<3){
							System.out.println("계단 1에 감 ");
							one.add(tmp);
						}
						else{
							System.out.println("꼐단 1 위에서 대기 ");
							oneWait.add(tmp);
						}
					}
					else{
						if(two.size()<3){
							System.out.println("계단 2에 감");
							two.add(tmp);
						}
						else{
							System.out.println("계단 2 위에서 대기 ");
							twoWait.add(tmp);
						}
					}
				}
			}
			time++;
			System.out.println(end.size()+" 도착한 인원 "+total.size()+"출발안한 인원");
		}
		if(min>time){
			min = time;
		}
		end.clear();
	}
	public static int calDist(int pr, int pc, int sr, int sc){
		int sum = 0;
		sum = Math.abs(pr-sr)+Math.abs(pc-sc);
		return sum;
	}
}
class Lunch implements Comparable<Lunch>{
	int y;
	int x;
	int time;
	int num;
	int dist;
	int resNum;
	Lunch(int num, int y , int x){
		this.num = num;
		this.y = y;
		this.x = x;
	}
	@Override
	public int compareTo(Lunch o) {
		// TODO Auto-generated method stub
		if(o.dist > this.dist){
			return -1;
		}
		else{
			return 1;
		}
	}
}
