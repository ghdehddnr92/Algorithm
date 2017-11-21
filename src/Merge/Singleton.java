package Merge;

public class Singleton {
	private volatile static Singleton instance = new Singleton();
	
	private Singleton(){
		System.out.println("call Singleton 생성자");
	}
	public static Singleton getInstance(){
		return instance;
	}
	public void print(){
		
	}
}
