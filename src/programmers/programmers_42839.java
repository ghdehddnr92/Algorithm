package programmers;
import java.util.LinkedList;
import java.util.List;

public class programmers_42839 {

	static boolean[] visited;
	static String result="";
	static List<Integer> list;
	
	public static void main(String[] args) {
		solution("011");
	}

	public static int solution(String numbers) {
        int answer = 0;
        visited = new boolean[numbers.length()];
        int arr[] =new int[numbers.length()];
        list = new LinkedList<Integer>();

		for(int i=0;i<numbers.length();i++) {
        	arr[i] = Integer.parseInt(numbers.charAt(i)+"");
        }
        
        int output[] = new int[numbers.length()];
        
        for(int i=1;i<=numbers.length();i++) {
        	 dfs(arr,visited,0,numbers.length(),i,output);
        }
        
        //System.out.println(list);
        
      
        for(int i=0;i<list.size();i++){
        	if(check(list.get(i))) {
        		//System.out.println(list.get(i)+"가 투");
        		answer++;
        	}
        }
        //System.out.println(answer);
        return answer;
    }

	// 모든 경우의수 뽑아내기
	public static void dfs(int[] arr, boolean[] visited, int depth, int n, int r, int[] output) {
		 if (depth == r) {
			 	result ="";
		    	for(int i =0 ; i < r; i++) {
		    		result += output[i];
		    	}


		    	int checkInt = Integer.parseInt(result);

		    	if(!list.contains(checkInt)) {
		    		list.add(checkInt);
		    	}
		        return;
		    }
		 
		 for (int i=0; i<n; i++) { 
		        if (visited[i] != true) {
		            visited[i] = true;
		            output[depth] = arr[i];
		            dfs(arr, visited, depth + 1, n, r,output);       
		            visited[i] = false;;
		        }
		  }
	}

	// 소수인지 체크
	public static boolean check(int num) {
		if(num==1 || num==0) {
			return false;
		}
		boolean flag = true;
		int n =2;
		
		while(n<num) {
			if(num%n == 0) {
				flag = false;
				break;
			}
			n++;
		}
	
		return flag;
	}
}
