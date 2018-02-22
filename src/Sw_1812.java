import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Sw_1812 {
	static int T;
	static int N,M;
	static PriorityQueue<Tile> q;
	static ArrayList<Point> map;
	static int res=1;
	public static void main(String[]args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		T = Integer.parseInt(br.readLine());
	
		StringTokenizer st;
		
		for(int t=1;t<=T;t++){
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			q = new PriorityQueue<Tile>();
			map = new ArrayList<Point>();
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++){
				int value = (int)Math.pow(2, Integer.parseInt(st.nextToken()));
				q.add(new Tile(value));
			}
			
			map.add(new Point(M,M));
			
			solve();
			
			System.out.println("#"+t+" "+res);
			res =1;
		}
	}
	public static void solve(){

		while(!q.isEmpty()){
			int tileCnt = map.size();
			int tileSize = q.poll().tileSize;
			
			int mapIndex = 0;
			boolean checkFlag = true;
			Point tmp;
			for(int i=0;i<tileCnt;i++){
				tmp = map.get(mapIndex);
				if(tmp.x -tileSize >=0 && tmp.y - tileSize >=0){ // 자를 수 있을 경우 
					checkFlag = false;
					if(tmp.x - tileSize>0 && tileSize>0){
						map.add(new Point(tmp.x - tileSize, tileSize));
					}
					if(tmp.x >0 && tmp.y - tileSize>0){
						map.add(new Point(tmp.x, tmp.y-tileSize));
					}
					map.remove(tmp);
					mapIndex--;
					break;
				}
				mapIndex++;
			}
			if(checkFlag){
				res++;
				map.add(new Point(M-tileSize,tileSize));
				map.add(new Point(M,M-tileSize));
			}
		}
	}

}
class Tile implements Comparable<Tile>{
	int tileSize;
	
	public Tile(int tileSize){
		this.tileSize = tileSize;
	}
	
	@Override
	public int compareTo(Tile o) {
		// TODO Auto-generated method stub
		return o.tileSize - tileSize;
	}
	
}
