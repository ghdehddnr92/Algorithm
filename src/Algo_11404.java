import java.util.Scanner;

public class Algo_11404{
	static int n;
	static int m;
	static int dist[][]; //첫번째는 : 시작. 두번째는 : 도착, 세번째는 값
	static int INF =1000000;
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
		
		n=in.nextInt();
		m=in.nextInt();
		dist=new int[100][100];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				dist[i][j]= i==j ?0:INF; //자기 자신으로 가는 값은 0 , 아니면 INF 그래프 초기화 부분 
			}
		}
		
		//입력 받은 간선 정보 입력 
		for(int i=0;i<m;i++){
			int a,b,c;
			a=in.nextInt();
			b=in.nextInt();
			c=in.nextInt();
			dist[a-1][b-1]= Math.min(dist[a-1][b-1],c);
		}
		//플로이드 와샬 적용 부분 
		 for(int k=0; k<n; k++)
		        for(int i=0; i<n; i++)
		            for(int j=0; j<n; j++)
		                dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]); //어떤 두 정점 i, j에 대해, k번 정점을 사용해 우회하면 지금까지보다 최단거리가 짧아지는가?
		 
		 for(int i=0;i<n;i++){
			 for(int j=0;j<n;j++){
				 System.out.print(dist[i][j]+" ");
			 }
			 System.out.println();
		 }
		    
	}
}
