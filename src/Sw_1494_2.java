

import java.util.ArrayList;
import java.util.Scanner;

public class Sw_1494_2 {
   static int N;
   static ArrayList<warm> w;
   static long Minimum;
   
   public static void main(String...msg) {
      Scanner sc = new Scanner(System.in);
      
      int TestCase = sc.nextInt();

      for(int T = 1 ; T<= TestCase ; T++) {
         w = new ArrayList<warm>();
         N = sc.nextInt();
         Minimum = Long.MAX_VALUE;
         for(int i = 0 ; i < N; i++) {
            w.add(new warm(i,sc.nextInt(),sc.nextInt()));
         }
         DFS(0,0);
         System.out.println("#"+T+" "+Minimum);
      }
   }
   public static void DFS(int index,int num) {

      if(index == N/2) {
         calcMin();
         return;
      }
      for(int i = num; i<N; i++) {
         
         warm wa = w.get(i);
         if(wa.isMatching())
            continue;
         wa.setMatching(true);
         DFS(index+1,i+1);
         wa.setMatching(false);
 
      }
   }
   public static void calcMin() {
      long x = 0;
      long y = 0;
      for(warm wa : w) {
         if(!wa.isMatching()) {
            x += wa.x;
            y += wa.y;
         }else { 
            x -= wa.x;
            y -= wa.y;
         }
      }   
      
      Minimum = Math.min(Minimum, y*y + x*x);
   }
}
class warm{
   int num,x,y;
   private boolean matching = false;

   public boolean isMatching() {
      return matching;
   }
   public void setMatching(boolean t) {
      matching = t;
   }
   public warm(int a,int b,int c) {
      num = a;
      x = b;
      y = c;
   }
}









