import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Sw_1907 {

	static int T;
	static int H,W;
	static int arr[][];
	static boolean visited[][];
	static int dy[] = {1,-1,0,0,1,-1,-1,1};
	static int dx[] = {0,0,1,-1,-1,1,-1,1};
	static int turn=0;
	static boolean sameFlag;
	
	public static void main(String[]args) throws NumberFormatException, IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;

		for(int t =1;t<=T;t++){
			st =new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());

			arr= new int[H][W];
			visited = new boolean[H][W];

			for(int i=0;i<H;i++){
				String line = br.readLine();
				for(int j=0;j<W;j++){
					if(line.charAt(j) == '.'){
						arr[i][j] = -1;
					}
					else{
						arr[i][j]=Integer.parseInt(line.charAt(j)+"");
					}
				}
			}
			
			while(true){
				sameFlag = true;
				for(int i=1;i<H-1;i++){
					for(int j=1;j<W-1;j++){
						if(arr[i][j]!= -1 && arr[i][j] != 9){
							bfs(i,j);
						}
					}
				}
				resetVisited();
	
				if(sameFlag == true){
					break;
				}
				else{
					turn++;
				}
			}
			System.out.println("#"+t+" "+turn);
			turn=0;
		}
	}

	public static void bfs(int y, int x){
		
		Queue<Castle> q = new LinkedList<Castle>();
		q.add(new Castle(y,x));	
		visited[y][x] = true;
		Castle tmp = q.poll();
		
		int cnt = 0;
		for(int i=0;i<8;i++){

			int ny = tmp.y+dy[i];
			int nx = tmp.x+dx[i];

			if(arr[ny][nx] == -1 && visited[ny][nx] == false){
				cnt++;
				if(cnt==arr[y][x]){
					arr[y][x] = -1;
					sameFlag = false;
					return;
				}
			}
		}
	}
	
	public static void resetVisited(){
		for(int i=1;i<H-1;i++){
			for(int j=1;j<W-1;j++){
				visited[i][j] = false;
			}
		}
	}

	public static void showArr(){
		for(int i=0;i<H;i++){
			for(int j=0;j<W;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println("");
		}
	}
	
}
class Castle{
	int x;
	int y;

	Castle(int y, int x){
		this.y = y;
		this.x = x;
	}
}

/*
import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
   static int H,W;
   static int map[][]; //맵
   static int wavemap[][]; //파도치는 갯수
   static int answer = 0; //답
   static boolean delete[][]; //삭제한 모래
   public static void main(String...msg) {
      Scanner sc = new Scanner(System.in);
      int TestCase = sc.nextInt();
      
      for(int T = 1 ; T<= TestCase; T++) {
         H = sc.nextInt();
         W = sc.nextInt();
         map = new int[H][W];
         wavemap = new int[H][W];
         answer = 0;
         delete = new boolean[H][W];
          for(int i = 0 ; i < H; i++) {
             String s = sc.next();
             for(int j = 0; j< W; j++) {
                if(s.charAt(j)=='.')
                   map[i][j] = -1;
                else
                   map[i][j] = Character.getNumericValue(s.charAt(j));
             }
          }
          newMap();
          BFS();
          System.out.println("#"+T+" "+answer);
      }
   }
   public static void BFS() {
      Queue<Point> q = new LinkedList<Point>();
      for(int i = 1; i <H-1; i++) {
         for(int j = 1; j < W-1; j++) {
            if(wavemap[i][j] >=map[i][j] && map[i][j]!=-1) { //파도가 지정된 강도보다 크고 모래가 아닐경우
               delete[i][j] = true; //삭제처리
               q.add(new Point(j,i)); //큐에 추가
            }
         }
      }
      while(!q.isEmpty()) {
         int size = q.size();
         
         for(int c=0 ; c < size; c++) {
         int y = q.peek().y;
         int x = q.poll().x;
         
         //맵 삭제
         if(map[y][x] == -1)
            continue;
         map[y][x] = -1;

         //주변검색해서 삭제될 맵이있는지 검색
         for(int i = y-1; i<= y+1; i++) {
            for(int j = x-1; j <=x+1; j++) {
               if(map[i][j] == -1)
                  continue;
               if(i==y && x==j)
                  continue;
               if(delete[i][j])
                  continue;
               wavemap[i][j]++;
                  
               if(wavemap[i][j] >= map[i][j]){
                  delete[i][j] = true;
                  q.add(new Point(j,i));
               }
               
            }
         }
      
         }
         answer++;
      }
   }
   public static void newMap() {
      for(int i = 1; i < H-1; i++) {
         for(int j = 1; j < W-1;j++) {
            if(map[i][j]==-1)
               wavemap[i][j] = 0;
            else
               wavemap[i][j] = CheckAround(i,j);
         }
      }
   }

   public static int CheckAround(int y,int x) {
      int count=0;
      for(int i = y-1; i<= y+1; i++) {
         for(int j = x-1; j <=x+1; j++) {
            if(i==y && j==x)
               continue;
            if(map[i][j]==-1)
               count++;
         }
      }
      return count;
   }
   
}
*/
