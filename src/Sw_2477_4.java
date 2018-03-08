import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

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

			boolean flag = true;
			while(flag){  //사람이 모두 빠져나갔을 경우 종료 .
				if(timeQ.isEmpty() && jubsuWaitQ.isEmpty() && jungbiWaitQ.isEmpty() && jubsuIsEmpty() && jungbiIsEmpty()){
					flag = false;
				}
				System.out.println("turn : "+turn+"---------------------------");
				Customer tmp= null;
				System.out.println("테이블 사이즈:"+timeQ.size());
				if(!timeQ.isEmpty()){
					while(!timeQ.isEmpty() && timeQ.peek().arriveTime<=turn){ //arriveTime보다 전일 경우에만 뺸다.
						tmp = timeQ.poll();
						System.out.println("고객번호:"+tmp.cusNum);
						//-----------접수 창고에 자리가 있는지 확인------------
						if(checkJubsu()!=-1){ //자리가있을 경우, 빈자리로 바로 넣음
							jubsuWaitQ.add(tmp);
							tmp = jubsuWaitQ.poll();
							int index = checkJubsu();
							System.out.println("자리가 있어서  "+index+"에 "+tmp.cusNum+"넣음 ");
							jubsuArr[index]=tmp;
							tmp.aNum = index;
							System.out.println("접수시간:"+jubsuTime[index]);
							tmp.aNumTime = jubsuTime[index];
						}
						else{//없을경우. waitQ 넣음 
							System.out.println("자리가 없어 서"+tmp.cusNum+"은 대기 큐로 이동");
							jubsuWaitQ.add(tmp);
						}
						System.out.println("접수 대기 창고 크기 :"+jubsuWaitQ.size());
					}
				}
				// ---------- 접수 창고 일 처리 -------------
				jubsuPlay();
				//	showJubsu();
				if(!jungbiWaitQ.isEmpty()){
					if(checkJungbi()!= -1){ // 빈자리가 있을 경우 
						tmp = jungbiWaitQ.poll();
						int index = checkJungbi();
						System.out.println("자리가 있어서 정비창구 "+index+"에 "+tmp.cusNum+"넣음 ");
						jungbiArr[index]=tmp;
						tmp.bNum = index;
						System.out.println("접수시간:"+jungbiTime[index]);
						tmp.bNumTime = jungbiTime[index];
					}
				}
				jungbiPlay();
				turn++;
			}
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
	public static void jubsuPlay(){
		for(int i=1;i<jubsuArr.length;i++){
			if(jubsuArr[i]!=null){
				System.out.println(i+"고객은 :"+jubsuArr[i].cusNum+"의 접수 시간은 "+jubsuArr[i].aNumTime);
				jubsuArr[i].aNumTime--;
				if(jubsuArr[i].aNumTime == 0){
					System.out.println("시간 완료 되서 "+jubsuArr[i].cusNum+"은 정비 대기로 이동");
					System.out.println("정비 대기 사이즈 :"+jungbiWaitQ.size());
					jubsuArr[i].waitTurn = turn;
					jungbiWaitQ.add(jubsuArr[i]);

					if(!jubsuWaitQ.isEmpty()){
						Customer tmp = jubsuWaitQ.poll();
						jubsuArr[i] = tmp;
						tmp.aNum = i;
						tmp.aNumTime = jubsuTime[i];
					}
				}
			}
		}
	}
	public static void jungbiPlay(){
		for(int i=1;i<jungbiArr.length;i++){
			if(jungbiArr[i]!=null){
				System.out.println(i+"고객은 :"+jungbiArr[i].cusNum+"의 접수 시간은 "+jungbiArr[i].bNumTime);
				jungbiArr[i].bNumTime--;
				if(jungbiArr[i].bNumTime==0){
					System.out.println("시간 완료 되서 "+jungbiArr[i].cusNum+"은 완료 큐 이동");
					finish.add(jungbiArr[i]);
					if(!jungbiWaitQ.isEmpty()){
						Customer tmp = jungbiWaitQ.poll();
						jungbiArr[i] = tmp;
						tmp.bNum = i;
						tmp.bNumTime = jungbiTime[i];
					}
				}
			}
		}
	}
	public static void showJubsu(){
		System.out.println("현재 접수 창고 ----");
		for(int i=1;i<jubsuArr.length;i++){
			if(jubsuArr[i]!=null){
				System.out.print(jubsuArr[i].cusNum+" ");
			}
			else{
				System.out.print("X ");
			}
		}
		System.out.println("");
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
