import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Algo_1764{
	public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Set<String> set1=new HashSet<String>(); //듣도 못한 잡을 저장하는 set
        Set<String> result=new HashSet<String>();   //듣보잡을 저장하는 set
         
        int N=sc.nextInt();
        int M=sc.nextInt();
        String[] set2=new String[M];    //보도 못한 잡을 저장하는 배열
         
        for(int i=0;i<N;i++){
            String tmp=sc.next();
            set1.add(tmp);  //듣도 못한 잡의 값을 set에 넣어줌
        }
        for(int i=0;i<M;i++){
            String tmp=sc.next();
            set2[i]=tmp;    //보도 못한 잡을 배열에 넣어줌
        }
        for(int i=0;i<M;i++){    //보도 못한 잡에 있는 사람이 듣도 못한 잡에 포함되면 result에 넣어줌
            if(set1.contains(set2[i])==true)   
                result.add(set2[i]);
        }
         
        //set을 배열로 바꾸어줌(오름차순 정렬을 하기 위해)
        String[] tmp=result.toArray(new String[result.size()]);
        Arrays.sort(tmp);   //오름차순 정렬
        System.out.println(tmp.length); //길이 출력
        for(int i=0; i<tmp.length;i++)
            System.out.println(tmp[i]); //듣보잡 출력
    }
}
