//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//public class Sw_2477_2 {
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
//				timeQ.add(new People(k,Integer.parseInt(st.nextToken()),0,-1,-1));
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
//							for(int i=1;i<=N;i++){
//								if(jubsu[i]==null){
//									jubsu[i]=person;
//									person.aNumber=i;
//									currentA++;
//									break;
//								}
//							}
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
//	int startTime;
//
//	People(int num, int time, int startTime, int aNumber, int bNumber){
//		this.num =num;
//		this.time = time;
//		this.aNumber = aNumber;
//		this.bNumber= bNumber;
//	}
//}
