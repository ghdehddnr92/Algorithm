import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Sw_2477_6{
	static int T;
	static int totalJubsu, totalJungbi, totalPeople, aNum, bNum;
	static int aTable[], bTable[];
	static ArrayList<Custom> peopleTable;

	static PriorityQueue<Custom> jubsuWaitTable;
	static PriorityQueue<Custom> jubsuTable;
	static PriorityQueue<Custom> jungbiWaitTable;
	static PriorityQueue<Custom> jungbiTable;

	static ArrayList<Custom> finishTable;
	static Custom jubsu[];
	static Custom jungbi[];
	static int res =0;
	public static void main(String[]args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;

		for(int t=1;t<=T;t++){
			st = new StringTokenizer(br.readLine());

			totalJubsu = Integer.parseInt(st.nextToken());
			totalJungbi = Integer.parseInt(st.nextToken());
			totalPeople = Integer.parseInt(st.nextToken());
			aNum = Integer.parseInt(st.nextToken());
			bNum = Integer.parseInt(st.nextToken());

			aTable = new int[totalJubsu+1];
			bTable = new int[totalJungbi+1];
			jubsu = new Custom[totalJubsu+1];
			jungbi = new Custom[totalJungbi+1];

			peopleTable = new ArrayList<Custom>();
			jubsuTable = new PriorityQueue<Custom>();
			finishTable = new ArrayList<Custom>();
			jubsuWaitTable = new PriorityQueue<Custom>(new Comparator<Custom>(){
				@Override
				public int compare(Custom o1, Custom o2) {
					// TODO Auto-generated method stub
					if(o1.customerNum > o2.customerNum){
						return 1;
					}
					else{
						return -1;
					}
				}
			});
			jungbiTable = new PriorityQueue<Custom>();
			jungbiWaitTable = new PriorityQueue<Custom>(new Comparator<Custom>(){

				@Override
				public int compare(Custom o1, Custom o2) {
					// TODO Auto-generated method stub
					if(o1.finishJubsuTime > o2.finishJubsuTime){
						return 1;
					}
					else if(o1.finishJubsuTime == o2.finishJubsuTime){
						if(o1.jubsuNum > o2.jubsuNum){
							return 1;
						}
						else{
							return -1;
						}
					}
					else{
						return -1;
					}
				}
			});

			st = new StringTokenizer(br.readLine());
			for(int i=1;i<=totalJubsu;i++){
				aTable[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=1;i<=totalJungbi;i++){
				bTable[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=1;i<=totalPeople;i++){
				peopleTable.add(new Custom(i, Integer.parseInt(st.nextToken())));
			}
			solve();
			if(res !=0){
				System.out.println("#"+t+" "+res);
			}
			else{
				System.out.println("#"+t+" "+-1);
			}
			res =0;
		}
	}
	public static void solve(){
		int time = 0;
		while(true){
			//	System.out.println("---------------time "+time+" --------------");

			if(finishTable.size() == totalPeople){
				//		System.out.println("종료" );
				break;
			}

			playJungbi();
			playJubsu(time);

			goJubsuWait(time); //테이블에서 고객을 접수 대기 창구로 보냄. 
			goJubsu();
			goJungbi();

			//	showJubsu();
			//	showJungbi();

			time++;
		}

		for(int i=0;i<finishTable.size();i++){
			//System.out.println(finishTable.get(i).customerNum+" "+finishTable.get(i).jubsuNum+" "+finishTable.get(i).jungbiNum);
			if(finishTable.get(i).jubsuNum == aNum && finishTable.get(i).jungbiNum == bNum){
				res+=finishTable.get(i).customerNum;
			}
		}

	}
	public static void goJungbi(){
		for(int i=1;i<jungbi.length;i++){
			if(jungbi[i]==null){ // 비어 있을 경우.
				if(!jungbiWaitTable.isEmpty()){
					jungbi[i] = jungbiWaitTable.poll();
					jungbi[i].jungbiNum = i;
					jungbi[i].remainB = bTable[i];
				}
			}
		}
	}
	public static void playJubsu(int time){
		for(int i=1;i<=totalJubsu;i++){
			if(jubsu[i]!=null){
				jubsu[i].remainA--;
				if(jubsu[i].remainA==0){
					jubsu[i].finishJubsuTime = time;
					jungbiWaitTable.add(jubsu[i]);
					jubsu[i] = null;
				}
			}
		}
	}

	public static void playJungbi(){
		for(int i=1;i<=totalJungbi;i++){
			if(jungbi[i]!=null){
				jungbi[i].remainB--;
				if(jungbi[i].remainB == 0){
					finishTable.add(jungbi[i]);
					jungbi[i] = null;
				}
			}
		}
	}
	public static void goJubsuWait(int time){
		int size = peopleTable.size();
		int i =0;
		while(!peopleTable.isEmpty()){
			if(peopleTable.get(i).arriveTime == time){
				jubsuWaitTable.add(peopleTable.get(i));
				peopleTable.remove(i);
			}
			else{
				break;
			}
		}
	}
	public static void goJubsu(){
		//우선 빈창구가 있는지 확인 
		for(int i=1;i<jubsu.length;i++){
			if(jubsu[i]==null){ // 비어 있을 경우.
				if(!jubsuWaitTable.isEmpty()){
					jubsu[i] = jubsuWaitTable.poll();
					jubsu[i].jubsuNum = i;
					jubsu[i].remainA = aTable[i];
				}
			}
		}
	}
	public static void showJubsu(){
		System.out.println("=======접수 창구 ========");
		for(int i=1;i<jubsu.length;i++){
			if(jubsu[i]!=null){
				System.out.print(jubsu[i].customerNum+" 남은 시간 "+jubsu[i].remainA+" ");
			}
			else{
				System.out.print("X ");
			}
		}
		System.out.println("");
	}
	public static void showJungbi(){
		System.out.println("=======정비 창구 ========");
		for(int i=1;i<jungbi.length;i++){
			if(jungbi[i]!=null){
				System.out.print(jungbi[i].customerNum+" 남은 시간 "+jungbi[i].remainB+" ");
			}
			else{
				System.out.print("X ");
			}
		}
		System.out.println("");
	}

}
class Custom{
	int customerNum;
	int arriveTime;
	int jubsuNum;
	int jungbiNum;
	int remainA;
	int remainB;
	int finishJubsuTime;
	Custom(int customerNum, int arriveTime){
		this.customerNum = customerNum;
		this.arriveTime = arriveTime;
	}
}