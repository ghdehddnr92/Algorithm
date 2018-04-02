import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class line2 {

	public static void main(String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(br.readLine().trim());
		int userX = Integer.parseInt(tokens.nextToken());
		int userY = Integer.parseInt(tokens.nextToken());
		int shopCount = Integer.parseInt(tokens.nextToken());
		PriorityQueue<Shop> q = new PriorityQueue<Shop>();
		for (int i = 0; i < shopCount; i++) {
			tokens = new StringTokenizer(br.readLine().trim());
			int shopX = Integer.parseInt(tokens.nextToken());
			int shopY = Integer.parseInt(tokens.nextToken());
			String name = tokens.nextToken();
			int coupon = Integer.parseInt(tokens.nextToken());
			int distance = calDistance(userX,userY,shopX,shopY);
			q.add(new Shop(shopX,shopY,name,coupon,distance));
		}
		
		while(!q.isEmpty()){
			Shop tmp = q.poll();
			
			System.out.println(tmp.shopX+" "+tmp.shopY+" "+tmp.name+" "+tmp.coupon);
		}
	}
	public static int calDistance(int userX, int userY, int shopX, int shopY){
		int distance =0;

		distance = (int)Math.sqrt(Math.pow(userX- shopX,2) +(int)Math.pow(userY-shopY,2));
		distance -= distance%100;

		return distance;
	}
}
class Shop implements Comparable<Shop>{
	int shopY;
	int shopX;
	String name;
	int coupon;
	int distance;

	Shop(int shopX, int shopY, String name, int coupon, int distance){
		this.shopX = shopX;
		this.shopY = shopY;
		this.name =name;
		this.coupon = coupon;
		this.distance =distance;
	}
	public boolean nameCompare(String first,String second){
		for(int i = 0 ; i < 6; i++){
			if((int)first.charAt(i) > (int)second.charAt(i)){
				return false;
			}
			else if((int)first.charAt(i) < (int)second.charAt(i)){
				return true;
			}
		}
		return false;
	}

	@Override
	public int compareTo(Shop o) {
		// TODO Auto-generated method stub
		if(this.distance > o.distance){
			return 1;
		}
		else if(this.distance < o.distance){
			return -1;
		}
		else{//거리가 같을 경우.
			if(this.coupon < o.coupon){
				return 1;
			}
			else if(this.coupon > o.coupon){
				return -1;
			}
			else{ //알 파벳 순으로.
				if(nameCompare(this.name, o.name)){
					return -1;
				}
				else{
					return 1;
				}
			}
		}
	}
}
