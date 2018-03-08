import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Sw_1953_2 {
	static int T;
	static int N,M,startY, startX, time;
	static int map[][];
	static boolean visited[][];
	static int cnt=0;
	public static void main(String[]args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for(int t=1;t<=T;t++){
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			startY = Integer.parseInt(st.nextToken());
			startX = Integer.parseInt(st.nextToken());
			time = Integer.parseInt(st.nextToken());

			map = new int[N][M];
			visited = new boolean[N][M];
			
			for(int i=0;i<N;i++){
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<M;j++){
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			cnt++;
			bfs(startY,startX ,0);

			System.out.println("#"+t+" "+cnt);
			cnt=0;
		}
	}
	public static void bfs(int y,int x,int turn){
		Queue<Talju> q = new LinkedList<Talju>();
		visited[y][x] = true;
		q.add(new Talju(y,x,turn));
		int ny=0,nx=0;
		
		while(!q.isEmpty()){
			//System.out.println("큐사이즈 :"+q.size());
			Talju tmp = q.poll();
			//System.out.println(tmp.y+" "+tmp.x+" "+tmp.turn);
			if(tmp.turn ==time-1){
				return;
			}
			if(map[tmp.y][tmp.x]==1){
				//상 
				ny= -1;
				nx= 0;
				if(((tmp.y+ny>=0 && tmp.x+nx>=0 && tmp.y+ny<N && tmp.x+nx<M)) && !visited[tmp.y+ny][tmp.x+nx]){
					if(map[tmp.y+ny][tmp.x+nx]==1 || map[tmp.y+ny][tmp.x+nx]==2 || map[tmp.y+ny][tmp.x+nx]==5
							|| map[tmp.y+ny][tmp.x+nx]==6){
						//if(turn+1<=time){
							q.add(new Talju(tmp.y+ny,tmp.x+nx,tmp.turn+1));
							visited[tmp.y+ny][tmp.x+nx]=true;
							cnt++;
					//	}
					}
				}
			
				//하 
				ny = 1;
				nx =0;
				if(((tmp.y+ny>=0 && tmp.x+nx>=0 && tmp.y+ny<N && tmp.x+nx<M)) && !visited[tmp.y+ny][tmp.x+nx]){
					if(map[tmp.y+ny][tmp.x+nx]==1 || map[tmp.y+ny][tmp.x+nx]==2 || map[tmp.y+ny][tmp.x+nx]==4
							|| map[tmp.y+ny][tmp.x+nx]==7){
						if(turn+1<=time){
							q.add(new Talju(tmp.y+ny,tmp.x+nx,tmp.turn+1));
							visited[tmp.y+ny][tmp.x+nx]=true;
							cnt++;
						}
					}
				}
				//좌
				nx = -1;
				ny = 0;
				if(((tmp.y+ny>=0 && tmp.x+nx>=0 && tmp.y+ny<N && tmp.x+nx<M)) && !visited[tmp.y+ny][tmp.x+nx]){
					if(map[tmp.y+ny][tmp.x+nx]==1 || map[tmp.y+ny][tmp.x+nx]==3 || map[tmp.y+ny][tmp.x+nx]==4
							|| map[tmp.y+ny][tmp.x+nx]==5){
						if(turn+1<=time){
							q.add(new Talju(tmp.y+ny,tmp.x+nx,tmp.turn+1));
							visited[tmp.y+ny][tmp.x+nx]=true;
							cnt++;
						}
					}
				}
				//우
				nx = 1;
				ny =0;
				if(((tmp.y+ny>=0 && tmp.x+nx>=0 && tmp.y+ny<N && tmp.x+nx<M)) && !visited[tmp.y+ny][tmp.x+nx]){
					if(map[tmp.y+ny][tmp.x+nx]==1 || map[tmp.y+ny][tmp.x+nx]==3 || map[tmp.y+ny][tmp.x+nx]==6
							|| map[tmp.y+ny][tmp.x+nx]==7){
						if(turn+1<=time){
							q.add(new Talju(tmp.y+ny,tmp.x+nx,tmp.turn+1));
							visited[tmp.y+ny][tmp.x+nx]=true;
							cnt++;
						}
					}
				}
			}
			else if(map[tmp.y][tmp.x]==2){
				//상
				ny = -1;
				nx =0;
				if(((tmp.y+ny>=0 && tmp.x+nx>=0 && tmp.y+ny<N && tmp.x+nx<M)) && !visited[tmp.y+ny][tmp.x+nx]){
					if(map[tmp.y+ny][tmp.x+nx]==1 || map[tmp.y+ny][tmp.x+nx]==2 || map[tmp.y+ny][tmp.x+nx]==5
							|| map[tmp.y+ny][tmp.x+nx]==6){
						if(turn+1<=time){
							q.add(new Talju(tmp.y+ny,tmp.x+nx,tmp.turn+1));
							visited[tmp.y+ny][tmp.x+nx]=true;
							cnt++;
						}
					}
				}
				//하 
				ny = 1;
				nx =0;
				if(((tmp.y+ny>=0 && tmp.x+nx>=0 && tmp.y+ny<N && tmp.x+nx<M)) && !visited[tmp.y+ny][tmp.x+nx]){
					if(map[tmp.y+ny][tmp.x+nx]==1 || map[tmp.y+ny][tmp.x+nx]==2 || map[tmp.y+ny][tmp.x+nx]==4
							|| map[tmp.y+ny][tmp.x+nx]==7){
						if(turn+1<=time){
							q.add(new Talju(tmp.y+ny,tmp.x+nx,tmp.turn+1));
							visited[tmp.y+ny][tmp.x+nx]=true;
							cnt++;
						}
					}
				}

			}
			else if(map[tmp.y][tmp.x]==3){
				//좌
				nx = -1;
				ny =0;
				if(((tmp.y+ny>=0 && tmp.x+nx>=0 && tmp.y+ny<N && tmp.x+nx<M)) && !visited[tmp.y+ny][tmp.x+nx]){
					if(map[tmp.y+ny][tmp.x+nx]==1 || map[tmp.y+ny][tmp.x+nx]==3 || map[tmp.y+ny][tmp.x+nx]==4
							|| map[tmp.y+ny][tmp.x+nx]==5){
						if(turn+1<=time){
							q.add(new Talju(tmp.y+ny,tmp.x+nx,tmp.turn+1));
							visited[tmp.y+ny][tmp.x+nx]=true;
							cnt++;
						}
					}
				}
				//우
				nx = 1;
				ny= 0;
				if(((tmp.y+ny>=0 && tmp.x+nx>=0 && tmp.y+ny<N && tmp.x+nx<M)) && !visited[tmp.y+ny][tmp.x+nx]){
					if(map[tmp.y+ny][tmp.x+nx]==1 || map[tmp.y+ny][tmp.x+nx]==3 || map[tmp.y+ny][tmp.x+nx]==6
							|| map[tmp.y+ny][tmp.x+nx]==7){
						if(turn+1<=time){
							q.add(new Talju(tmp.y+ny,tmp.x+nx,tmp.turn+1));
							visited[tmp.y+ny][tmp.x+nx]=true;
							cnt++;
						}
					}
				} 
			}
			else if(map[tmp.y][tmp.x]==4){
				//상
				ny= -1;
				nx =0;
				if(((tmp.y+ny>=0 && tmp.x+nx>=0 && tmp.y+ny<N && tmp.x+nx<M)) && !visited[tmp.y+ny][tmp.x+nx]){
					if(map[tmp.y+ny][tmp.x+nx]==1 || map[tmp.y+ny][tmp.x+nx]==2 || map[tmp.y+ny][tmp.x+nx]==5
							|| map[tmp.y+ny][tmp.x+nx]==6){
						if(turn+1<=time){
							q.add(new Talju(tmp.y+ny,tmp.x+nx,tmp.turn+1));
							visited[tmp.y+ny][tmp.x+nx]=true;
							cnt++;
						}
					}
				}
				//우 
				nx = 1;
				ny =0;
				if(((tmp.y+ny>=0 && tmp.x+nx>=0 && tmp.y+ny<N && tmp.x+nx<M)) && !visited[tmp.y+ny][tmp.x+nx]){
					if(map[tmp.y+ny][tmp.x+nx]==1 || map[tmp.y+ny][tmp.x+nx]==3 || map[tmp.y+ny][tmp.x+nx]==6
							|| map[tmp.y+ny][tmp.x+nx]==7){
						if(turn+1<=time){
							q.add(new Talju(tmp.y+ny,tmp.x+nx,tmp.turn+1));
							visited[tmp.y+ny][tmp.x+nx]=true;
							cnt++;
						}
					}
				}
			}
			else if(map[tmp.y][tmp.x]==5){
				//하 
				ny = 1;
				nx =0;
				if(((tmp.y+ny>=0 && tmp.x+nx>=0 && tmp.y+ny<N && tmp.x+nx<M)) && !visited[tmp.y+ny][tmp.x+nx]){
					if(map[tmp.y+ny][tmp.x+nx]==1 || map[tmp.y+ny][tmp.x+nx]==2 || map[tmp.y+ny][tmp.x+nx]==4
							|| map[tmp.y+ny][tmp.x+nx]==7){
						if(turn+1<=time){
							q.add(new Talju(tmp.y+ny,tmp.x+nx,tmp.turn+1));
							visited[tmp.y+ny][tmp.x+nx]=true;
							cnt++;
						}
					}
				}

				//우 
				nx = 1;
				ny =0;
				if(((tmp.y+ny>=0 && tmp.x+nx>=0 && tmp.y+ny<N && tmp.x+nx<M)) && !visited[tmp.y+ny][tmp.x+nx]){
					if(map[tmp.y+ny][tmp.x+nx]==1 || map[tmp.y+ny][tmp.x+nx]==3 || map[tmp.y+ny][tmp.x+nx]==6
							|| map[tmp.y+ny][tmp.x+nx]==7){
						if(turn+1<=time){
							q.add(new Talju(tmp.y+ny,tmp.x+nx,tmp.turn+1));
							visited[tmp.y+ny][tmp.x+nx]=true;
							cnt++;
						}
					}
				}
			}
			else if(map[tmp.y][tmp.x]==6){
				//하 
				ny = 1;
				nx =0;
				if(((tmp.y+ny>=0 && tmp.x+nx>=0 && tmp.y+ny<N && tmp.x+nx<M)) && !visited[tmp.y+ny][tmp.x+nx]){
					if(map[tmp.y+ny][tmp.x+nx]==1 || map[tmp.y+ny][tmp.x+nx]==2 || map[tmp.y+ny][tmp.x+nx]==4
							|| map[tmp.y+ny][tmp.x+nx]==7){
						if(turn+1<=time){
							q.add(new Talju(tmp.y+ny,tmp.x+nx,tmp.turn+1));
							visited[tmp.y+ny][tmp.x+nx]=true;
							cnt++;
						}
					}
				}
				//좌
				nx = -1;
				ny =0;
				if(((tmp.y+ny>=0 && tmp.x+nx>=0 && tmp.y+ny<N && tmp.x+nx<M)) && !visited[tmp.y+ny][tmp.x+nx]){
					if(map[tmp.y+ny][tmp.x+nx]==1 || map[tmp.y+ny][tmp.x+nx]==3 || map[tmp.y+ny][tmp.x+nx]==4
							|| map[tmp.y+ny][tmp.x+nx]==5){
						if(turn+1<=time){
							q.add(new Talju(tmp.y+ny,tmp.x+nx,tmp.turn+1));
							visited[tmp.y+ny][tmp.x+nx]=true;
							cnt++;
						}
					}
				}
				
			}
			else if(map[tmp.y][tmp.x]==7){
				//상
				ny = -1;
				nx =0;
				if(((tmp.y+ny>=0 && tmp.x+nx>=0 && tmp.y+ny<N && tmp.x+nx<M)) && !visited[tmp.y+ny][tmp.x+nx]){
					if(map[tmp.y+ny][tmp.x+nx]==1 || map[tmp.y+ny][tmp.x+nx]==2 || map[tmp.y+ny][tmp.x+nx]==5
							|| map[tmp.y+ny][tmp.x+nx]==6){
						if(turn+1<=time){
							q.add(new Talju(tmp.y+ny,tmp.x+nx,tmp.turn+1));
							visited[tmp.y+ny][tmp.x+nx]=true;
							cnt++;
						}
					}
				}
				//좌
				nx = -1;
				ny =0;
				if(((tmp.y+ny>=0 && tmp.x+nx>=0 && tmp.y+ny<N && tmp.x+nx<M)) && !visited[tmp.y+ny][tmp.x+nx]){
					if(map[tmp.y+ny][tmp.x+nx]==1 || map[tmp.y+ny][tmp.x+nx]==3 || map[tmp.y+ny][tmp.x+nx]==4
							|| map[tmp.y+ny][tmp.x+nx]==5){
						if(turn+1<=time){
							q.add(new Talju(tmp.y+ny,tmp.x+nx,tmp.turn+1));
							visited[tmp.y+ny][tmp.x+nx]=true;
							cnt++;
						}
					}
				}	
			}
			//showVisited();
		}
	}
	public static void showVisited(){
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				System.out.print(visited[i][j]+" ");
			}
			System.out.println("");
		}
	}
}
class Talju{
	int y;
	int x;
	int turn;
	public Talju(int y, int x,int turn){
		this.y = y;
		this.x = x;
		this.turn = turn;
	}
}
