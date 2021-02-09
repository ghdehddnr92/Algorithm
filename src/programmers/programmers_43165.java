package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class programmers_43165 {
	static int result = 0;
	public static void main(String[]args) {
		int []numbers = {1,1,1,1,1};

		solution(numbers,3);
		
	}
	
	public static int solution(int[] numbers, int target) {
        int answer = 0;
        
        dfs(numbers, numbers[0], target, 1);
        dfs(numbers, -numbers[0], target, 1);
       
        System.out.println(result);
        answer = result;
        return answer;
	}
	public static void dfs(int []numbers, int sum, int target, int depth) {
		//System.out.println(sum +" "+target +" "+depth);
		if(depth == numbers.length) {
			if(target == sum) {
				result++;
			}
			return;
		}
		
		dfs(numbers, sum+numbers[depth], target, depth+1);
		dfs(numbers, sum-numbers[depth], target, depth+1);
		
	}
//	
//	public static int solution(int[] numbers, int target) {
//        int answer = 0;
//        
////        dfs(numbers,true, target, 0, 0);
////        dfs(numbers,false, target, 0, 0);
////      
//        
////        answer = result;
////        System.out.println(result);
//        
//        Queue<Set> q = new LinkedList<Set>();
//        q.add(new Set(1,numbers[0]));
//        q.add(new Set(1,-numbers[0]));
//        
//        
//        while(!q.isEmpty()) {
//        	Set tmp = q.poll();
//        	if(tmp.depth ==  numbers.length) {
//        		if(tmp.num == target) {
//        			result++;
//        		}
//        	}else {
//        		q.add(new Set(tmp.depth+1, tmp.num + numbers[tmp.depth]));
//        		q.add(new Set(tmp.depth+1, tmp.num - numbers[tmp.depth]));
//        	}
//        }
//        
//        System.out.println(result);
//        answer = result;
//        return answer;
//	}
}
class Set{
	int depth;
	int num;
	
	Set(int depth, int num){
		this.depth = depth;
		this.num = num;
	}
}