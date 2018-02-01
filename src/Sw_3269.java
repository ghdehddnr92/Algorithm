//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.Scanner;
//import java.util.Stack;
//
//public class Sw_3269{
//	static int MAX = 10000;
//	static int V,E;//정점 ,간선 
//	static int dfsn[]; //방문 순서 
//	static int SN; //SCC 의 갯수 
//	static ArrayList<Integer> adj[];
//	static ArrayList<ArrayList<Integer>> SCC;
//	static int cnt=0;
//	static Stack<Integer> S;
//	static boolean finished[];
//	static int T;
//	
//	public static void main(String []args){
//		Scanner in = new Scanner(System.in);
//		T = in.nextInt();
//		for(int t=1;t<=T;t++){
//			 
//			Ascending ascending = new Ascending();
//
//				dfsn =new int[MAX];
//				finished = new boolean[MAX];
//				adj=new ArrayList[MAX];
//				for(int i=0;i<MAX;i++){
//					adj[i]=new ArrayList<Integer>();
//				}
//				SCC = new ArrayList<ArrayList<Integer>>(MAX);
//				S= new Stack<Integer>();
//				V=in.nextInt();
//				E=in.nextInt();
//
//				for(int i=0;i<E;i++){
//					int A,B;
//					A= in.nextInt();
//					B= in.nextInt();
//					adj[A-1].add(B-1);
//				}
//				for(int i=0;i<MAX;i++){
//					finished[i]=false;
//				}
//				for(int i=0;i<V;i++){
//					if(dfsn[i]==0)
//						DFS(i);
//				}
//				System.out.println("#"+t+" "+SN);
//				Collections.sort(SCC, new Comparator<ArrayList<Integer>>() {
//				    @Override
//				    public int compare(ArrayList<Integer> one, ArrayList<Integer> two) {
//				        return one.get(0).compareTo(two.get(0));
//				    }
//				});
//				
//				SN =0;
//				MAX = 10000;
//		}
//
//	}
//	public static int DFS(int curr){
//        Ascending ascending = new Ascending();
//
//		dfsn[curr]=++cnt;
//		S.push(curr);
//		int result=dfsn[curr];
//
//		for(int next : adj[curr]){
//			 // 아직 방문하지 않은 이웃
//			if(dfsn[next] == 0) result = Math.min(result, DFS(next));
//	        // 방문은 했으나 아직 SCC로 추출되지는 않은 이웃
//	        else if(!finished[next]) result = Math.min(result, dfsn[next]);
//		}
//		// 자신, 자신의 자손들이 도달 가능한 제일 높은 정점이 자신일 경우 SCC 추출
//	    if(result == dfsn[curr]){
//	        ArrayList<Integer> currSCC=new ArrayList<Integer>(MAX);
//	        // 스택에서 자신이 나올 때까지 pop
//	        while(true){
//	            int t = S.peek();
//	            S.pop();
//	            currSCC.add(t);
//	            finished[t] = true;  
//	            if(t == curr) break;
//	        }
//	        Collections.sort(currSCC,ascending);
//	       // System.out.println(currSCC);
////	        for(int i=0;i<currSCC.size();i++){
////	        	System.out.print(currSCC.get(i)+1);
////	        }
////	        System.out.println("");
//	        SCC.add(currSCC);
//	        SN++;
//	    }
//		return result;
//	}
//}
////오름차순
//class Ascending implements Comparator<Integer> {
//
//	@Override
//	public int compare(Integer o1, Integer o2) {
//		return o1.compareTo(o2);
//	}
//}
//
//
//
