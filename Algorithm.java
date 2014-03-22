
import java.util.*;
public abstract class Algorithm {

	ArrayList<Process> list;
	
	public Algorithm(ArrayList<Process> list){
		
		this.list=list;
	}
	public Process activeProcess(){
	
		return list.get(0);
	}
}
//cus takiego?