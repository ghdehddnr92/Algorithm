//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.PriorityQueue;
//import java.util.StringTokenizer;
//
//public class Solution {
//	static int N,M,K,A,B;
//	static int Ai[],Bi[];
//	static int UsedA[],UsedB[];
//	static int answer = 0;
//	public static void main(String...msg) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int TestCase = Integer.parseInt(br.readLine());
//		for(int T = 1; T<= TestCase; T++) {
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			N = Integer.parseInt(st.nextToken());
//			M = Integer.parseInt(st.nextToken());
//			K = Integer.parseInt(st.nextToken());
//			A = Integer.parseInt(st.nextToken());
//			B = Integer.parseInt(st.nextToken());
//			Ai = new int[N];
//			Bi = new int[M];
//			answer = 0;
//			st = new StringTokenizer(br.readLine());
//			for(int i = 0 ; i < N; i++) {
//				Ai[i] = Integer.parseInt(st.nextToken());
//			}
//			st = new StringTokenizer(br.readLine());
//			for(int i = 0 ; i < M; i++) {
//				Bi[i] = Integer.parseInt(st.nextToken());
//			}
//			UsedA = new int[N];
//			UsedB = new int[M];
//			PriorityQueue<Member> q = new PriorityQueue<Member>();
//			st = new StringTokenizer(br.readLine());
//			for(int i = 0 ; i < K; i++) {
//				q.add(new Member(i+1,Integer.parseInt(st.nextToken()),-1,-1));
//			}
//			PriorityQueue<Member> q2 = new PriorityQueue<Member>();
//			Execute1(q,q2,true);
//			PriorityQueue<Member> q3 = new PriorityQueue<Member>();
//			Execute1(q2,q3,false);
//			while(!q3.isEmpty()) {
//				Member mem = q3.poll();
//				if(mem.A == A && mem.B==B) {
//					answer+=mem.Id;
//				}
//			}
//			if(answer==0)
//				answer=-1;
//			System.out.println("#"+T+" "+answer);
//		}
//	}
//	public static void Execute1(PriorityQueue<Member> q,PriorityQueue<Member> out,boolean first) {
//		int min = Integer.MAX_VALUE;
//		int A = -1;
//		aa:while(!q.isEmpty()) {
//			Member mem = q.poll();
//			min = Integer.MAX_VALUE;
//			for(int i = 0 ;i < (first? N : M); i++) {
//				if((first ? UsedA[i] : UsedB[i])<=mem.Time) {
//					if(first) UsedA[i] = mem.Time+Ai[i];
//					else   UsedB[i] = mem.Time+Bi[i];
//					out.add(new Member(mem.Id,(first ? UsedA[i]: UsedB[i]), (first ? i+1 : mem.A ),(first ? -1 : i+1)));
//					continue aa;
//				}else {
//					if(min > (first ? UsedA[i] : UsedB[i])) {
//						min = (first ? UsedA[i] : UsedB[i]);
//						A = i;
//					}
//				}
//			}
//			if(first) UsedA[A] =UsedA[A]+Ai[A];
//			else UsedB[A] =UsedB[A]+Bi[A];
//			out.add(new Member(mem.Id,(first ? UsedA[A]: UsedB[A]),(first ? A+1 : mem.A),(first ? -1: A+1)));
//		}
//	}
//}
//class Member implements Comparable<Member>{
//	int Id,Time,A,B;
//	public int compareTo(Member o) {
//		return Time < o.Time ? -1 : Time==o.Time ? (A==-1 ? (Id <o.Id ? -1 : 1) : A <o.A ? -1 : 1 ) : 1 ;
//
//	}
//	public Member(int a,int d,int b,int c) {
//		Id = a;
//		A = b;
//		B = c;
//		Time = d;
//	}
//}