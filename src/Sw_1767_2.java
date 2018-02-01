import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;

public class Sw_1767_2 {
   
   static int map[][];
   static int N;
   static int LineCount = 0; //라인의 갯수
   static int Answer = 0; //가장 많은 연결된 프로세서 갯수
   static int Answer2 =0 ; //가장 적은 라인의 갯수
   public static void main(String...msg) {
      Scanner sc = new Scanner(System.in);
      
      int TestCase = sc.nextInt();
      
      for(int T =1 ; T<=TestCase; T++) {
         map = new int[13][13];
         N = sc.nextInt();
         LineCount = 0;
         Answer = 0;
         Answer2 = Integer.MAX_VALUE;
         ArrayList<Point> semi = new ArrayList<Point>();
         for(int i = 1; i <= N; i++) {
            for(int j = 1; j <=N; j++) {
               map[i][j] = sc.nextInt();
               if((i==1 || j==1 || i == N || j==N) && map[i][j]==1) {
                  Answer++;
                  continue;
               }
               if(map[i][j]==1)
               semi.add(new Point(j,i)); //선을 이을 반도체리스트에 넣는다
            }
         }
         Execute(0,semi,Answer);

         System.out.println("#"+T+" "+Answer2);
      }
   }
   public static void PrintMap() {
      for(int i = 1; i <=N ; i++) {
         for(int j =1 ; j<=N; j++) {
            System.out.print(map[i][j]+" ");
         }
         System.out.println();
      }
      System.out.println("-----------------------");
   }


   public static void Execute(int index,ArrayList<Point> semi,int sc) {
   
      if(index==semi.size()) {
         if(Answer < sc) {
         
         //   System.out.println("SC : "+sc+" LINECOUNT : "+LineCount);
            Answer = sc;
            //Answer2 = Math.min(Answer2, LineCount);
            Answer2 = LineCount;
            //PrintMap();
         }else if(Answer==sc) {
            Answer2 = Math.min(Answer2, LineCount);
         }
         return;
      }

      
   

      Point pos = semi.get(index);
      for(int i = 0; i < 5; i++) { //4방향 탐색 + 선택안하고 넘기기
         if(i==4) { //넘기기{
            Execute(index+1,semi,sc);
            break;
         }
         if(SearchLine(i,pos.y,pos.x)) {
            FillLine(i, pos.y, pos.x, 2);
            Execute(index+1,semi,sc+1);
            FillLine(i, pos.y, pos.x, 0);
         }
      }
   
   }
   public static boolean SearchLine(int dir,int y,int x) {
      boolean res = true;
      switch(dir) {
         case 0: //상
            for(int i = y-1; i>=1; i--) {
               if(map[i][x]!=0)
                  return false;
            }
            break;
         case 1:// 하
            for(int i = y+1; i<=N; i++) {
               if(map[i][x]!=0)
                  return false;
            }
            break;
         case 2:// 좌
            for(int i = x-1; i>=1; i--) {
               if(map[y][i]!=0)
                  return false;
            }
            break;
         case 3://우
            for(int i = x+1; i<=N; i++) {
               if(map[y][i]!=0)
                  return false;
            }
            break;
      }
      return res;
   }
   
   public static void FillLine(int dir,int y,int x,int type) {

      switch(dir) {
         case 0: //상
            for(int i = y-1; i>=1; i--) {
               LineCount = type==2 ? LineCount+1 : LineCount-1;
               map[i][x]=type;
            }
            break;
         case 1:// 하
            for(int i = y+1; i<=N; i++) {
               LineCount = type==2 ? LineCount+1 : LineCount-1;
               map[i][x]=type;
            }
            break;
         case 2:// 좌
            for(int i = x-1; i>=1; i--) {
               LineCount = type==2 ? LineCount+1 : LineCount-1;
               map[y][i]=type;
            }
            break;
         case 3://우
            for(int i = x+1; i<=N; i++) {
               LineCount = type==2 ? LineCount+1 : LineCount-1;
               map[y][i]=type;
            }
            break;
      }
   }
}