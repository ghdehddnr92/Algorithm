import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Sw_2477_3 {
	static int T;
	static int N,M,K,A,B;
	static int a[];
	static int b[];
	static Queue<People>timeQ;
	static Queue<People>waitA;
	static Queue<People>waitB;
	static Queue<People>endQ;
	static Queue<People>tmpQ;
	static People jubsu[];
	static People jeongbi[];
	static int Acnt;
	static int Bcnt;
	static int currentA=0;
	static int currentB=0;
	static int res=0;
	public static void main(String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for(int tc=1;tc<=T;tc++){
			String line= br.readLine();
			StringTokenizer st = new StringTokenizer(line);
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());

			a = new int[N+1];
			b = new int[M+1];

			line = br.readLine();
			st = new StringTokenizer(line);
			for(int aInput=1;aInput<=N; aInput++){
				a[aInput] = Integer.parseInt(st.nextToken());
			}
			line = br.readLine();
			st = new StringTokenizer(line);
			for(int bInput=1;bInput<=M; bInput++){
				b[bInput] = Integer.parseInt(st.nextToken());
			}
			timeQ = new LinkedList<>();
			line = br.readLine();
			st = new StringTokenizer(line);
			for(int k=1;k<=K;k++){
				timeQ.add(new People(k,Integer.parseInt(st.nextToken()),0,0,-1,-1));
			}
			waitA = new LinkedList<>();
			waitB = new LinkedList<>();
			endQ = new LinkedList<>();
			tmpQ = new LinkedList<>();
			jubsu = new People[N+1];
			jeongbi = new People[M+1];
			int timer=0;
		
			while(!(Acnt==K && Bcnt==K)){ // 접수 창고와 정비 창고를 통과한 사람이 모두 K일경우 종료 
				//1.time q 빼기

				//시간 다된 사람들 접수창고에서 정비 창고로 옮기는 함수.
				for(int i=1;i<=N;i++){
					if(jubsu[i]!=null){
						if(jubsu[i].AstartTime==a[i]){
						//	System.out.println("접수 창고에서 나와야할 애 : "+jubsu[i].num);
							People person = jubsu[i];
							jubsu[i]=null;
							Acnt++;
							//tmpQ.add(person);
							if(currentB<M){
								for(int j=1;j<=M;j++){
									if(jeongbi[j]==null){
										jeongbi[j]=person;
										person.bNumber=j;
										currentB++;
										break;
									}
								}
							}
							else{
							//	System.out.println("꽉차서 wiat b 에다가넣기 : "+person.num);
								waitB.add(person);
							}
							//wait A큐에서 접수 로 넣음.
							if(!waitA.isEmpty()){
								person = waitA.poll();
								for(int a=1;a<=N;a++){
									if(jubsu[a]==null){
										person.aNumber=a; //접수 창고에 번호 저장 
										jubsu[a]=person;
										currentA++;
										break;
									}
								}
							}
						}
					}
				}
				//정비 창고에서 다된 애들은 endQ로 보내기
				for(int i=1;i<=M;i++){
					if(jeongbi[i]!=null){
						if(jeongbi[i].BstartTime==b[i]){
						//	System.out.println("정비 창고에서 나와야할 애 : "+jeongbi[i].num);
							People person = jeongbi[i];
							jeongbi[i]=null;
							Bcnt++;
							currentB--;
						//	System.out.println("완료된 애들 : "+person.num);
							endQ.add(person);
						}
					}

				}
				if(!waitB.isEmpty() && currentB<M){
					People person = waitB.poll();
					for(int a=1;a<=M;a++){
						if(jeongbi[a]==null){
							person.bNumber=a; //접수 창고에 번호 저장 
							jeongbi[a]=person;
							currentB++;
							break;
						}
					}
				}
			

				People person=null;
				if(!timeQ.isEmpty() && timeQ.peek().time==timer){	
					while(!timeQ.isEmpty() && timeQ.peek().time==timer){
						person = timeQ.poll();
					//	System.out.println("person time Q에서뺌"+person.num);
						if(currentA<N){ // 꽉차지 않았을 경우 
							for(int i=1;i<=N;i++){
								if(jubsu[i]==null){
									jubsu[i]=person;
									person.aNumber=i; //접수 창고의번 호 저장 
									currentA++;
									break;
								}
							}
						}
						else{
					//		System.out.println("꽉차서 wiat a 에다가넣기 : "+person.num);
							waitA.add(person);
						}
					}
				}
				for(int i=1;i<=N;i++){
					if(jubsu[i]!=null){
						jubsu[i].AstartTime++;
					}
				}
				for(int i=1;i<=M;i++){
					if(jeongbi[i]!=null){
						jeongbi[i].BstartTime++;
					}
				}

				timer++;
			}

			while(!endQ.isEmpty()){
				if(endQ.peek().aNumber==A && endQ.peek().bNumber==B){
					res+=endQ.peek().num;
				}
				endQ.poll();
			}
			if(res!=0){
				System.out.println("#"+tc+" "+res);
			}
			else{
				System.out.println("#"+tc+" "+-1);
			}
			Acnt=0;
			Bcnt=0;
			currentA=0;
			currentB=0;
			res=0;
		}
	}
}
class People{
	int num;
	int time;
	int aNumber;
	int bNumber;
	int AstartTime;
	int BstartTime;

	People(int num, int time, int AstartTime,int BstartTime, int aNumber, int bNumber){
		this.num =num;
		this.time = time;
		this.aNumber = aNumber;
		this.AstartTime = AstartTime;
		this.BstartTime =BstartTime;
		this.bNumber= bNumber;
	}
}

