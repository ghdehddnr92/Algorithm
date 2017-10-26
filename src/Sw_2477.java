//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//public class Sw_2477 {
//
//	static int T;
//	static int N,M,K,A,B;
//	static int a[];
//	static int b[];
//	static Queue<People>timeQ;
//	static Queue<People>waitA;
//	static Queue<People>waitB;
//	static Queue<People>endQ;
//	static People jubsu[];
//	static People jeongbi[];
//	static int Acnt;
//	static int Bcnt;
//	static int currentA=0;
//	static int currentB=0;
//	static int res=0;
//	public static void main(String[]arsgs) throws NumberFormatException, IOException{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//		T = Integer.parseInt(br.readLine());
//
//		for(int tc=1;tc<=T;tc++){
//			String line= br.readLine();
//			StringTokenizer st = new StringTokenizer(line);
//			N = Integer.parseInt(st.nextToken());
//			M = Integer.parseInt(st.nextToken());
//			K = Integer.parseInt(st.nextToken());
//			A = Integer.parseInt(st.nextToken());
//			B = Integer.parseInt(st.nextToken());
//
//			a = new int[N+1];
//			b = new int[M+1];
//
//			line = br.readLine();
//			st = new StringTokenizer(line);
//			for(int aInput=1;aInput<=N; aInput++){
//				a[aInput] = Integer.parseInt(st.nextToken());
//			}
//			line = br.readLine();
//			st = new StringTokenizer(line);
//			for(int bInput=1;bInput<=M; bInput++){
//				b[bInput] = Integer.parseInt(st.nextToken());
//			}
//			timeQ = new LinkedList<>();
//			line = br.readLine();
//			st = new StringTokenizer(line);
//			for(int k=1;k<=K;k++){
//				timeQ.add(new People(k,Integer.parseInt(st.nextToken()),0,0,-1,-1));
//			}
//			waitA = new LinkedList<>();
//			waitB = new LinkedList<>();
//			endQ = new LinkedList<>();
//			jubsu = new People[N+1];
//			jeongbi = new People[M+1];
//
//			int timer=0;
//			while(!(waitA.isEmpty() && waitB.isEmpty() && timeQ.isEmpty() && Acnt==K && Bcnt==K)){
//				// 1. timerq 에서 t에 맞게 접수 창고에 배치, 꽉찼을 경우 wait
//				// 2. 배치까지 끝냄 
//				People person=null;
//				if(!timeQ.isEmpty() && timeQ.peek().time==timer){
//					while(timeQ.peek().time==timer){
//						person = timeQ.poll();
//						System.out.println("person time Q에서뺌"+person.num);
//						if(currentA<N){
//							currentA+=1;
//							System.out.println("A배열이 꽉차지 않아서 "+currentA+" 인덱스 에다가 집어넣음 ");
//							jubsu[currentA]=person;
//							person.aNumber = currentA;
//						}
//						else{
//							System.out.println("waitQ 에 추가"+person.num);
//							waitA.add(person);
//						}
//						if(timeQ.size()==0){
//							break;
//						}
//					}
//				}
//
//				// 접수 창고를 검사해서 뺄 애들이 있는지 확인
//				for(int jub=1;jub<=currentA;jub++){
//					System.out.println("jubsu[jub].startTime : "+jubsu[jub].AstartTime+"a[jub]-1 :"+(a[jub]-1));
//					if(jubsu[jub].AstartTime==(a[jub]-1)){ // 만약에 접수 시간이 완료 되었을경우 뺌 그담에 정비 창고로 보내야함.
//						System.out.println(""+jub+" 번째 자리가 빔");
//						person = jubsu[jub];
//						jubsu[jub]=null;
//						currentA--;
//						Acnt++;
//						if(!waitA.isEmpty()){
//							currentA++;
//							System.out.println("waitQ에서 빼고 currentA 자리에 넣음 "+currentA);
//							jubsu[currentA]=waitA.poll();
//						}
//						if(currentB<M){//정비창고의 자리가 비어있는지 확인
//							currentB++;
//							jeongbi[currentB]=person;
//							person.bNumber = currentB;
//						}
//						else{ //꽉찼을 경우 
//							waitB.add(person);
//						}
//					}
//				}
//				//정비 창고의 시간이 다 되었는지 확인
//				for(int jeong=1;jeong<=currentB;jeong++){
//					System.out.println("jeongbi[jub].startTime : "+jeongbi[jeong].BstartTime+"b[jeong]-1 :"+(b[jeong]-1));
//					if(jeongbi[jeong].BstartTime==(b[jeong]-1)){ // 만약에 정비 시간이 완료 되었을경우 완료.
//						System.out.println(""+jeong+"번 째 자리가 빔");
//						person =  jeongbi[jeong];
//						endQ.add(person);
//						jeongbi[jeong]=null;
//						currentB--;
//						Bcnt++;
//						if(!waitB.isEmpty()){
//							currentB++;
//							jeongbi[currentB]=waitB.poll();
//							System.out.println("waitQ에서 빼고 currentB 자리에 넣음 "+currentB);
//						}
//					}
//				}
//				for(int i=1;i<=currentA;i++){
//					if(jubsu[i]!=null){
//						jubsu[i].AstartTime++;
//					}
//				}
//				for(int j=1;j<=currentB;j++){
//					if(jeongbi[j]!=null){
//						jeongbi[j].BstartTime++;
//					}
//				}
//				System.out.println("timer Q size"+timeQ.size());
//				System.out.println("waitA Q size"+waitA.size());
//				System.out.println("waitB Q size"+waitB.size());
//				System.out.println("end Q size"+endQ.size());
//				System.out.println("currentA : "+currentA);
//				if(jubsu[1]!=null){
//					System.out.print("jubsu[1].num : "+ jubsu[1].num);
//				}
//				if(jubsu[2]!=null){
//					System.out.print("jubsu[2].num : "+ jubsu[2].num);
//				}
//				
//				System.out.println("");
//				System.out.println("currentB : "+currentB);
//				for(int j=1;j<=currentB;j++){
//					System.out.print(jeongbi[j].num+" ");
//				}
//				System.out.println("");
//				System.out.println("timer :---------------------- "+timer);
//		
//				timer++;
//			}
//			for(int i=0;i<endQ.size();i++){
//				if(endQ.peek().aNumber==A || endQ.peek().bNumber==B){
//					res+=endQ.peek().num;
//					endQ.poll();
//				}
//			}
//			System.out.println("#"+tc+" "+res);
//		}
//	}
//}
//class People{
//	int num;
//	int time;
//	int aNumber;
//	int bNumber;
//	int AstartTime;
//	int BstartTime;
//	People(int num, int time, int AstartTime, int BstartTime,int aNumber, int bNumber){
//		this.num =num;
//		this.time = time;
//		this.aNumber = aNumber;
//		this.bNumber= bNumber;
//		this.AstartTime = AstartTime;
//		this.BstartTime = BstartTime;
//	}
//}
