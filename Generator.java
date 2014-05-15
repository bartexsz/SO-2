import java.util.Random;
public class Generator {
	
	public int id=0;
	Request next = null;
	static boolean active;
	static int timeNext = 0;
	public static int maxPosition = 99;
	public static int maxTimeNext = 30;
	
	public Generator()
	{
		active = true;
	}
	
	public void generate(){
		
		Random random = new Random();
		next = new Request(id, 1+random.nextInt(maxPosition), -2);
		id++;
	}
	public Request getNext(){
		
		generate();
		Random random = new Random();
		timeNext=random.nextInt(maxTimeNext);
		return next;	
	}
	public boolean isReady(){
		
		if(timeNext<=0) return true;
		return false;
	}
	public static boolean isActive(){
		
		return active;
	}
	public static void switchOn(){
		
		active=true;
	}
	public static void switchOff(){
		
		active=false;
	}
	public static void updateTime(){
		
		if(timeNext>0)
			timeNext--;
	}
}
