
import java.util.*;
public abstract class Algorithm {

	ArrayList<Process> list;
	
	public Algorithm(ArrayList<Process> list){
		
		this.list=list;
	}
	public abstract Process activeProcess();
	
	public abstract void updateList(ArrayList<Process> list);
}