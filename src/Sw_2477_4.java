import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

//차량정비소 
public class Sw_2477_4 {
	
	static int T;
	static int jubsu,jungbi,K,A,B;
	static int jubsuTime[];
	static int jungbiTime[];

	static Queue<Customer>timeQ;
	static PriorityQueue<Customer>jubsuWaitQ;
	static PriorityQueue<Customer>jungbiWaitQ;
	static Queue<Customer> finish;
	
	static Customer jungbiArr[];
	static Customer jubsuArr[];
	static int turn = 0;
	static int res = 0;
	
	public static void main(String[]args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t=1;t<=T;t++){
			st = new StringTokenizer(br.readLine());

			jubsu = Integer.parseInt(st.nextToken());
			jungbi =  Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			jubsuTime = new int[jubsu+1];
			jungbiTime = new int[jungbi+1];

			timeQ = new LinkedList<Customer>();
			jubsuWaitQ = new PriorityQueue<Customer>(new JubsuComparator());
			jungbiWaitQ = new PriorityQueue<Customer>(new JungbiComparator());
			jubsuArr = new Customer[jubsu+1];
			jungbiArr = new Customer[jungbi+1];

			finish = new LinkedList<Customer>();
			st = new StringTokenizer(br.readLine());

			for(int i=1;i<=jubsu;i++){
				jubsuTime[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=1;i<=jungbi;i++){
				jungbiTime[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<K;i++){
				timeQ.add(new Customer(i+1,Integer.parseInt(st.nextToken()),-1,-1)); // 고객번호,도착 시간, 이용접수, 이용정
			}

			while(finish.size()!=K){  //사람이 모두 빠져나갔을 경우 종료 .
				System.out.println(turn+" -------------------");
				jubsuPlay();
				addJungbi();
				jungbiPlay();
				addJubsu();
				showJubsu();
				showJungbi();
				
				turn++;
			}
			while(!finish.isEmpty()){
				Customer tmp = finish.poll();
				if(tmp.aNum == A && tmp.bNum == B){
					res += tmp.cusNum;
				}
			}
			if(res !=0){
				System.out.println("#"+t+" "+res);
			}
			else{
				System.out.println("#"+t+" "+-1);
			}
			res =0;
			turn =0;
		}
	}
	public static int checkJubsu(){
		// 빈자리가 있을경우 가장 작은곳의 빈자리 창구 번호를 return, 꽉찼을 경우 -1 return
		for(int i=1;i<jubsuArr.length;i++){
			if(jubsuArr[i]==null){
				return i;
			}
		}
		return -1;
	}
	public static int checkJungbi(){
		// 빈자리가 있을경우 가장 작은곳의 빈자리 창구 번호를 return, 꽉찼을 경우 -1 return
		for(int i=1;i<jungbiArr.length;i++){
			if(jungbiArr[i]==null){
				return i;
			}
		}
		return -1;
	}
	public static void addJubsu(){
		Customer tmp = null;
		if(!timeQ.isEmpty()){
			while(true){ //arriveTime보다 전일 경우에만 뺸다.
				if(timeQ.isEmpty()){
					break;
				}
				if(timeQ.peek().arriveTime>turn){
					break;
				}
				tmp = timeQ.poll();
	
				if(checkJubsu()!=-1){ //자리가있을 경우, 빈자리로 바로 넣음
					jubsuWaitQ.add(tmp);
					tmp = jubsuWaitQ.poll();
					int index = checkJubsu();
					jubsuArr[index]=tmp;
					tmp.aNum = index;
					tmp.aNumTime = jubsuTime[index];
				}
				else{//없을경우. waitQ 넣음 
					jubsuWaitQ.add(tmp);
				}
			}
		}
	}
	public static void showJubsu(){
		System.out.println("=======접수 창구 ========");
		for(int i=1;i<jubsuArr.length;i++){
			if(jubsuArr[i]!=null){
				System.out.print(jubsuArr[i].cusNum+" 남은시간 "+jubsuArr[i].aNumTime+" ");
			}
			else{
				System.out.print("X ");
			}
		}
		System.out.println("");
	}
	public static void showJungbi(){
		System.out.println("=======정비 창구 ========");
		for(int i=1;i<jungbiArr.length;i++){
			if(jungbiArr[i]!=null){
				System.out.print(jungbiArr[i].cusNum+" 남은시간 "+jungbiArr[i].bNumTime+" ");
			}
			else{
				System.out.print("X ");
			}
		}
		System.out.println("");
	}
	public static void addJungbi(){
		Customer tmp = null;
		if(!jungbiWaitQ.isEmpty()){
			while(checkJungbi()!=-1){

				if(!jungbiWaitQ.isEmpty()){
					tmp = jungbiWaitQ.poll();
					int index = checkJungbi();
					jungbiArr[index]=tmp;
					tmp.bNum = index;
					tmp.bNumTime = jungbiTime[index];
				}
				if(jungbiWaitQ.isEmpty()){
					break;
				}
			}
		}
	}
	public static void jubsuPlay(){
		for(int i=1;i<jubsuArr.length;i++){
			if(jubsuArr[i]!=null){
				jubsuArr[i].aNumTime--;
				if(jubsuArr[i].aNumTime == 0){
					jubsuArr[i].waitTurn = turn;
					jungbiWaitQ.add(jubsuArr[i]);

					if(!jubsuWaitQ.isEmpty()){
						Customer tmp = jubsuWaitQ.poll();
						jubsuArr[i] = tmp;
						tmp.aNum = i;
						tmp.aNumTime = jubsuTime[i];
					}
					else{
						jubsuArr[i] = null;
					}
				}
			}
		}
	}
	public static void jungbiPlay(){
		for(int i=1;i<jungbiArr.length;i++){
			if(jungbiArr[i]!=null){
				jungbiArr[i].bNumTime--;
				if(jungbiArr[i].bNumTime==0){
					finish.add(jungbiArr[i]);
					if(!jungbiWaitQ.isEmpty()){
						Customer tmp = jungbiWaitQ.poll();
						jungbiArr[i] = tmp;
						tmp.bNum = i;
						tmp.bNumTime = jungbiTime[i];
					}
					else{
						jungbiArr[i] = null;
					}
				}
			}
		}
	}
	public static boolean jubsuIsEmpty(){
		for(int i=1;i<jubsuArr.length;i++){
			if(jubsuArr[i]!=null){
				return false;
			}
		}
		return true;
	}
	public static boolean jungbiIsEmpty(){
		for(int i=1;i<jungbiArr.length;i++){
			if(jungbiArr[i]!=null){
				return false;
			}
		}
		return true;
	}
}
class Customer{
	int cusNum;
	int arriveTime;
	int aNum;
	int bNum;
	int aNumTime;
	int bNumTime;
	int waitTurn;
	Customer(int cusNum, int arriveTime, int aNum, int bNum){
		this.cusNum =cusNum;
		this.arriveTime = arriveTime;
		this.aNum = aNum;
		this.bNum= bNum;
	}
}
class JubsuComparator implements Comparator<Customer>{

	@Override
	public int compare(Customer o1, Customer o2) {
		// TODO Auto-generated method stub
		if(o1.cusNum <= o2.cusNum){
			return -1;
		}
		else{
			return 1;
		}
	}

}
class JungbiComparator implements Comparator<Customer>{

	@Override
	public int compare(Customer o1, Customer o2) {
		// TODO Auto-generated method stub
		if(o1.waitTurn < o2.waitTurn){
			return -1;
		}
		else if(o1.waitTurn > o2.waitTurn){
			return 1;
		}
		else{ // 같을 경우 .
			if(o1.aNum <= o2.aNum){
				return -1;
			}
			else{
				return 1;
			}
		}
	}
}
