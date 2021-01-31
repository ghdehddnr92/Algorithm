package programmers;


public class programmers_42842 {

	public static void main(String[] args) {
		solution(10,2);
	}

	public static int[] solution(int brown, int yellow) {
		int[] answer = {};

		answer = check(brown, yellow);
	
		return answer;
	}

	public static int[] check(int brown, int yellow) {
		int totalSize = brown + yellow;
		int answer[] = new int[2];
		
		for(int i=2;i<=(totalSize / 2); i++) {
			if(totalSize % i ==0) {
				
				int y = totalSize / i;
				int x = i;
				int arr[][]= new int[y][x];
				int result = (y-2)*(x-2);
				
				if(result == yellow) {
					answer[0]=y;
					answer[1]=x;
					
					break;
				}
			}
		}
		return answer;
	}
}
