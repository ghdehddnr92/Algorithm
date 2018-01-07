	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.util.Arrays;
	import java.util.Comparator;
	
	public class Algo_1431 {
		
		static int N;
		static String arr[];
		
		public static void main(String[]args) throws NumberFormatException, IOException{
	
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			N = Integer.parseInt(br.readLine());
			arr = new String[N];
			
			for(int i=0;i<N;i++){
				arr[i] = br.readLine();
			}
			//길이 대로 정렬
			Arrays.sort(arr,new Comparator<Object>(){
				@Override
				public int compare(Object o1, Object o2) {
					
					// TODO Auto-generated method stub
					if(o1.toString().length() > o2.toString().length()){
						return 1;
					}
					else if(o1.toString().length() == o2.toString().length()){
						int o1Sum=0;
						int o2Sum=0;
						
						for(int i=0;i<o1.toString().length();i++){
							if(o1.toString().charAt(i) >= '0' && o1.toString().charAt(i) <= '9'){
								o1Sum+=Integer.parseInt(o1.toString().charAt(i)+"");
							}
						}
						for(int i=0;i<o2.toString().length();i++){
							if(o2.toString().charAt(i) >= '0' && o2.toString().charAt(i) <= '9'){
								o2Sum+=Integer.parseInt(o2.toString().charAt(i)+"");
							}
						}
						if(o1Sum > o2Sum){
							return 1;
						}
						else if(o1Sum == o2Sum){
							for(int i=0;i<o1.toString().length();i++){
								for(int j=0;j<o2.toString().length();j++){
//									if(o1.toString().charAt(i) > o2.toString().charAt(j)){
//								
//										return 1;
//									}
//									else if(o1.toString().charAt(i) == o2.toString().charAt(j)){
//										return 0;
//									}
//									else{
//										return -1;
//									}
									if(o1.toString().charAt(i) != o2.toString().charAt(j)){
										return o1.toString().length() - o2.toString().length();
									}
								}
							}
							return 0;
						}
						else{
							return -1;
						}
					}
					else{
						return -1;
					}
				}
			});
		
			for(int i=0;i<N;i++){
				System.out.println(arr[i]);
			}
		}
	}
