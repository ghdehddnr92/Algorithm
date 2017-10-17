import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Sw_2842_3 {
	static int T;
	static int N,M,K; // N 셀 크기 , M 은 시간 , K는 미생물 수 
	static int arr[][];
	static Mi map[][];
	static Mi nextMap[][];
	static int miTmp[][];
	static int res=0;
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
		T = in.nextInt();
		for(int t=0;t<T;t++){

			N = in.nextInt();
			M = in.nextInt();
			K = in.nextInt();
			arr = new int[K][4];
			map = new Mi[N][N];
			nextMap = new Mi[N][N];
			for(int i=0;i<K;i++){
				for(int j=0;j<4;j++){
					arr[i][j]= in.nextInt();
				}
				miTmp = new int[K][2];
				miTmp[1][0]=arr[i][2];
				miTmp[1][1]=arr[i][3];
				Mi mi = new Mi(arr[i][2],arr[i][3],1,miTmp,0);
				map[arr[i][0]][arr[i][1]]=mi;
			}
			int time=1;
			while(time<=M){
				//한 싸이클
				time++;
				for(int i=0;i<N;i++){
					for(int j=0;j<N;j++){
						if(map[i][j]!=null && map[i][j].flag==0){ //그 칸에 미생물이 있을 경우.
							map[i][j].flag=1;
							if(map[i][j].dir==1){
								if(nextMap[i-1][j]==null){ // 이동해야할 곳이 비어있는지 확인.  비어 있을 경우
									System.out.println("비어 있을 경우 i-1 은 "+(i-1)+" j"+j);
									if(i-1==0){//약품 지역
										//System.out.println("약품 지역 ");
										if(map[i][j].num%2==0){
											map[i][j].num= map[i][j].num/2;
										}
										else{
											double d = (double)map[i][j].num/2;
											map[i][j].num= (int)d;
										}
										map[i][j].dir=2;
									}
									nextMap[i-1][j]=map[i][j];
									map[i][j]=null;
								}
								else{ // 다른 미생물이 있을 경우!!!
									if(map[i-1][j].flag==1){
										map[i-1][j].miCnt+=1;
											System.out.println("i-1 : "+(i-1)+"j : "+j+" miCnt : "+map[i-1][j].miCnt);
												System.out.println("map num"+map[i][j].num+"map dir"+map[i][j].dir);
										map[i-1][j].miTmp[map[i-1][j].miCnt][0]=map[i][j].num;
										map[i-1][j].miTmp[map[i-1][j].miCnt][1]=map[i][j].dir;
										map[i][j]=null;
										map[i-1][j].num=0;
										for(int c =1; c<=map[i-1][j].miCnt;c++){
											nextMap[i-1][j].num+=map[i-1][j].miTmp[c][0];// 동시에 들어오는 미생물을 모두 합치는 소스.
														 System.out.println(" 상으로 가서 합쳤을 경우 : "+map[i-1][j].num);
										} 
										int max=map[i-1][j].miTmp[1][0];
										for(int c=1;c<=map[i-1][j].miCnt;c++){
											if(max<map[i-1][j].miTmp[c][0]){
												max = map[i-1][j].miTmp[c][0];
											}
										}
										for(int c=1;c<=map[i-1][j].miCnt;c++){
											if(map[i-1][j].miTmp[c][0]==max){
												nextMap[i-1][j].dir=map[i-1][j].miTmp[c][1];
											}
										}
									}
								}
							}
							else if(map[i][j].dir==2){
								if(nextMap[i+1][j]==null){
											System.out.println("비어 있을 경우 i+1 은 "+(i+1)+" j"+j);
									if(i+1==N-1){//약품 지역 
										if(map[i][j].num%2==0){
											map[i][j].num= map[i][j].num/2;
										}
										else{
											double d = (double)map[i][j].num/2;
											map[i][j].num= (int)d;
										}
										map[i][j].dir=1;
									}
									nextMap[i+1][j]=map[i][j];
									map[i][j]=null;
								}
								else{
									if(map[i+1][j].flag==1){
										map[i+1][j].miCnt+=1;
												System.out.println("i+1 : "+(i+1)+"j : "+j+" miCnt : "+map[i+1][j].miCnt);
												System.out.println("map num"+map[i][j].num+"map dir"+map[i][j].dir);
										map[i+1][j].miTmp[map[i+1][j].miCnt][0]=map[i][j].num;
										map[i+1][j].miTmp[map[i+1][j].miCnt][1]=map[i][j].dir;
										map[i][j]=null;
										map[i+1][j].num=0;
										for(int c =1; c<=map[i+1][j].miCnt;c++){
											nextMap[i+1][j].num+=map[i+1][j].miTmp[c][0];// 동시에 들어오는 미생물을 모두 합치는 소스.
													 System.out.println(" 하로 가서 합쳤을 경우 : "+map[i+1][j].num);
										} 
										int max=map[i+1][j].miTmp[1][0];
										for(int c=1;c<=map[i+1][j].miCnt;c++){
											if(max<map[i+1][j].miTmp[c][0]){
												max = map[i+1][j].miTmp[c][0];
											}
										}
										for(int c=1;c<=map[i+1][j].miCnt;c++){
											if(map[i+1][j].miTmp[c][0]==max){
												nextMap[i+1][j].dir=map[i+1][j].miTmp[c][1];
											}
										}

									}
								}
							}
							else if(map[i][j].dir==3){
								if(nextMap[i][j-1]==null){
										System.out.println("비어 있을 경우 i 은 "+i+" j-1"+(j-1));
									if(j-1==0){//약품 지역 
										if(map[i][j].num%2==0){
											map[i][j].num= map[i][j].num/2;
										}
										else{
											double d = (double)map[i][j].num/2;
											map[i][j].num= (int)d;
										}
										map[i][j].dir=4;
									}
									nextMap[i][j-1]=map[i][j];
									map[i][j]=null;
								}
								else{
									nextMap[i][j-1].miCnt+=1;
										System.out.println("i: "+i+"j : "+(j-1)+" miCnt : "+map[i][j-1].miCnt);
										System.out.println("map num"+map[i][j].num+"map dir"+map[i][j].dir);
									map[i][j-1].miTmp[map[i][j-1].miCnt][0]=map[i][j].num;
									map[i][j-1].miTmp[map[i][j-1].miCnt][1]=map[i][j].dir;
									map[i][j]=null;
									map[i][j-1].num=0;
									for(int c =1; c<=map[i][j-1].miCnt;c++){
										nextMap[i][j-1].num+=map[i][j-1].miTmp[c][0];// 동시에 들어오는 미생물을 모두 합치는 소스.
												 System.out.println(" 좌로 가서 합쳤을 경우 : "+map[i][j-1].num);
									} 
									int max=map[i][j-1].miTmp[1][0];
									for(int c=1;c<=map[i][j-1].miCnt;c++){
										if(max<map[i][j-1].miTmp[c][0]){
											max = map[i][j-1].miTmp[c][0];
										}
									}
									for(int c=1;c<=map[i][j-1].miCnt;c++){
										if(map[i][j-1].miTmp[c][0]==max){
											nextMap[i][j-1].dir=map[i][j-1].miTmp[c][1];
										}
									}
								}

							}
							else{
								if(nextMap[i][j+1]==null){
										System.out.println("비어 있을 경우 i 은 "+i+" j+1"+(j+1));
									if(j+1==N-1){//약품 지역 
										if(map[i][j].num%2==0){
											map[i][j].num= map[i][j].num/2;
										}
										else{
											double d = (double)map[i][j].num/2;
											map[i][j].num= (int)d;
										}
										map[i][j].dir=3;
									}
									nextMap[i][j+1]=map[i][j];
									map[i][j]=null;
								}
								else{
									if(map[i][j+1].flag==1){
										map[i][j+1].miCnt+=1;
												System.out.println("i: "+i+"j : "+(j+1)+" miCnt : "+map[i][j+1].miCnt);
												System.out.println("map num"+map[i][j].num+"map dir"+map[i][j].dir);
										map[i][j+1].miTmp[map[i][j+1].miCnt][0]=map[i][j].num;
										map[i][j+1].miTmp[map[i][j+1].miCnt][1]=map[i][j].dir;
										map[i][j]=null;
										map[i][j+1].num=0;
										for(int c =1; c<=map[i][j+1].miCnt;c++){
											nextMap[i][j+1].num+=map[i][j+1].miTmp[c][0];// 동시에 들어오는 미생물을 모두 합치는 소스.
														 System.out.println("우로 가서 합쳤을 경우 : "+map[i][j+1].num);
										} 
										int max=map[i][j+1].miTmp[1][0];
										for(int c=1;c<=map[i][j+1].miCnt;c++){
											if(max<map[i][j+1].miTmp[c][0]){
												max = map[i][j+1].miTmp[c][0];
											}
										}
										for(int c=1;c<=map[i][j+1].miCnt;c++){
											if(map[i][j+1].miTmp[c][0]==max){
												nextMap[i][j+1].dir=map[i][j+1].miTmp[c][1];
											}
										}
									}
								}

							}
						}
					}
				}
				for(int i=0;i<N;i++){
					for(int j=0;j<N;j++){
						map[i][j]=nextMap[i][j];
						nextMap[i][j]=null;
					}
				}
				for(int i=0;i<N;i++){
					for(int j=0;j<N;j++){
						if(map[i][j]!=null){
								System.out.println("i : "+i+" j : "+j +"map dir :"+map[i][j].dir+"map num : "+map[i][j].num);
							//res+=map[i][j].num;
							map[i][j].flag=0;
						}
					}
				}
			
			}
			for(int i=0;i<N;i++){
				for(int j=0;j<N;j++){
					if(map[i][j]!=null){
						res+=map[i][j].num;
					}
				}
			}
			System.out.println(res);
			res=0;
		}
	}
}
class Mi{
	int num;
	int dir;
	int miCnt;
	int miTmp[][];
	int flag;
	Mi(int num, int dir, int miCnt, int miTmp[][], int flag){
		this.num = num;
		this.dir = dir;
		this.miCnt = miCnt;
		this.miTmp = miTmp;
		this.flag =flag;
	}
}