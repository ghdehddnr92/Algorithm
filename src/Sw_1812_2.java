//import java.awt.Point;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.PriorityQueue;
//import java.util.StringTokenizer;
//
//public class Sw_1812_2 {
//   static int count=1;
//   public static void main(String...msg) throws IOException {
//      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//      
//      int TestCase = Integer.parseInt(br.readLine());
//      
//      for(int T = 1; T<=TestCase; T++) {
//         count = 1;
//         StringTokenizer st = new StringTokenizer(br.readLine());
//         int N = Integer.parseInt(st.nextToken());
//         int M = Integer.parseInt(st.nextToken());
//         
//         PriorityQueue<High> q = new PriorityQueue<High>();
//         ArrayList<Point> place = new ArrayList<Point>();
//         
//       
//         st = new StringTokenizer(br.readLine());
//         for(int i = 0 ; i < N; i++) {
//            q.add(new High((int)Math.pow(2, Integer.parseInt(st.nextToken()))));
//         }
//         System.out.println(q.poll().k);
//         place.add(new Point(M,M));
//         while(!q.isEmpty()) {
//            int k = q.poll().k;
//            
//            int size = place.size();
//            boolean create = true;
//            Point p;
//            
//            //공간이 있는지 체크
//            int idx = 0;
//            for(int i = 0 ; i < size; i++) {
//               p = place.get(idx);
//               if(p.x >= k && p.y >= k) {
//                  create = false;
//                  if(p.x-k >0 && k > 0)
//                     place.add(new Point(p.x - k,k));
//                  if(p.x >0 && p.y- k > 0)
//                     place.add(new Point(p.x,p.y-k));
//                  place.remove(p);
//                  idx--;
//                  break;
//               }
//               idx++;
//            }
//      
//            if(create) {
//               count++;
//               place.add(new Point(M-k , k));
//               place.add(new Point(M , M-k));
//            }
//         }
//         System.out.println("#"+T+" "+count);
//      }
//   }
//}
//class High implements Comparable<High>{
//   int k;
//   public High(int a) {
//      k = a;
//   }
//   @Override
//   public int compareTo(High arg0) {
//      
//      return k >= arg0.k ? -1:1;
//   }
//}