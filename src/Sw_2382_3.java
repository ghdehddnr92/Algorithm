import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Sw_2382_3 {
	static int T;
	static int N,M,K;
	static int res = 0;

	static ArrayList<Me> list;
	static ArrayList<Me> list2;
	
	public static void main(String[]args) throws NumberFormatException, IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;

		for(int t=1;t<=T;t++){
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			list = new ArrayList<Me>();
			list2 = new ArrayList<Me>();

			for(int i=0;i<K;i++){
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int miNum = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				Me tmp = new Me(y,x,miNum,dir);
				list.add(tmp);
			}
			int time = 0;
			while(time <M){
				play();
				list.clear();
				for(int i=0;i<list2.size();i++){
					list.add(list2.get(i));
				}
				list2.clear();

				time++;
			}

			sum();

			System.out.println("#"+t+" "+res);
			res=0;
		}
	}
	public static void sum(){
		for(int i=0;i<list.size();i++){
			res += list.get(i).miNum;
		}
	}
	public static void play(){
		for(int i=0;i<list.size();i++){
			Me tmp = list.get(i);

			if(tmp.dir == 1){
				tmp.y  = tmp.y-1;
			}
			else if(tmp.dir == 2){
				tmp.y = tmp.y +1;
			}
			else if(tmp.dir == 3){
				tmp.x = tmp.x-1;
			}
			else{
				tmp.x = tmp.x+1;
			}

			if(areaCheck(tmp.y,tmp.x)){
				if(tmp.dir == 1){
					tmp.dir = 2;
				}
				else if(tmp.dir == 2){
					tmp.dir = 1;
				}
				else if(tmp.dir == 3){
					tmp.dir = 4;
				}
				else{
					tmp.dir = 3;
				}
				tmp.miNum /= 2;
			}

			if(tmp.miNum!=0){
				boolean flag = false;
				for(int j=0;j<list2.size();j++){
					if(list2.get(j).y == tmp.y && list2.get(j).x == tmp.x){
					//	System.out.println("같은 경우 :"+tmp.x+" "+tmp.y+" "+list2.get(j).miNum+" "+tmp.miNum);
						flag = true;
						if(list2.get(j).miNum < tmp.miNum){
							list2.get(j).dir = tmp.dir;
							list2.get(j).sum += list2.get(j).miNum;
							list2.get(j).miNum = tmp.miNum;
						}
						else{
							list2.get(j).sum += tmp.miNum;
						}
					}
				}

				//같은게 없을 경우 
				if(flag == false){
					list2.add(tmp);
				}
			}		
		}
		for(int j=0;j<list2.size();j++){
			list2.get(j).miNum += list2.get(j).sum;
			list2.get(j).sum =0;
		}
	}
	public static boolean areaCheck(int y, int x){
		boolean flag = false;

		if(y == 0 || x == 0 || y == N-1 || x == N-1){
			flag = true;
		}
		else{
			flag = false;
		}
		return flag;
	}
}
class Me{
	int y;
	int x;
	int miNum;
	int dir;
	int sum;

	Me(int y, int x, int miNum, int dir){
		this.y = y;
		this.x = x;
		this.miNum = miNum;
		this.dir = dir;
	}
}

