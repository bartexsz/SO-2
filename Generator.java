import java.util.*;
public class Generator {
	
	public int id=0;
	Process next;
	boolean active;
	int timeNext;
	
	public void generate(){
		
		Random random = new Random();
		next = new Process(id, random.nextInt(30));
		id++;
	}
	public Process getNext(){
		
		generate();
		Random random = new Random();
		timeNext=random.nextInt(6);
		return next;	
	}
	public boolean isReady(){
		
		if(timeNext==0)
			return true;
		return false;
	}
	public boolean isActive(){
		
		return active;
	}
	public void switchOn(){
		
		active=true;
	}
	public void switchOff(){
		
		active=false;
	}
	public void updateTime(){
		
		if(timeNext>0)
			timeNext--;
	}
}
