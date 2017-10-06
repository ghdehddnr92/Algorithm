import java.util.Scanner;

public class Algo_1076 {
	static String arr[];
	static String res="";
	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
		arr= new String[3];
		
		for(int i=0;i<3;i++){
			arr[i]=in.nextLine();
		}
		
		searchValue(arr[0],0);
		searchValue(arr[1],0);
		searchValue(arr[2],1);
	
		System.out.println(res);
	}
	public static void searchValue(String value,int flag){
		 switch (value) {
	      case "black"   :
	    	  if(flag==0){
	    		  res+=0;
	    	  }
	    	  else{
	    		 res=Long.parseLong(res)*1+"";
	    	  }
	          break;
	      case "brown"   : 
	    	  if(flag==0){
	    		  res+=1;
	    	  }
	    	  else{
	    		  res=Long.parseLong(res)*10+"";
	    	  }
	          break;
	      case "red"  : 
	    	  if(flag==0){
	    		  res+=2; 
	    	  }
	    	  else{
	    		  res=Long.parseLong(res)*100+"";
	    	  }
	    	  break;
	      case "orange"  : 
	    	  if(flag==0){
	    		  res+=3;
	    	  }
	    	  else{
	    		  res=Long.parseLong(res)*1000+"";
	    	  }
	    	  break;
	      case "yellow"  : 
	    	  if(flag==0){
	    		  res+=4;
	    	  }
	    	  else{
	    		  res=Long.parseLong(res)*10000+"";
	    	  }
	    	  break;
	      case "green"  : 
	    	  if(flag==0){
	    		  res+=5;
	    	  }
	    	  else{
	    		  res=Long.parseLong(res)*100000+"";
	    	  }
	    	  break;
	      case "blue"  : 
	    	  if(flag==0){
	    		  res+=6;
	    	  }
	    	  else{
	    		  res=Long.parseLong(res)*1000000+"";
	    	  }
	    	  break;
	      case "violet"  : 
	    	  if(flag==0){
	    		  res+=7;
	    	  }
	    	  else{
	    		  res=Long.parseLong(res)*10000000+"";
	    	  }
	    	  break;
	      case "grey"  : 
	    	  if(flag==0){
	    		  res+=8;
	    	  }
	    	  else{
	    		  res=Long.parseLong(res)*100000000+"";
	    	  }
	    	  break;
	      default    :
	    	  if(flag==0){
	    		  res+=9;
	    	  }
	    	  else{
	    		  res=Long.parseLong(res)*1000000000+"";
	    	  }
	    	  break;
	    }
	}
}