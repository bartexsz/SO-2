
import java.util.*;
public abstract class Algorithm {

	ArrayList<Request> list;
	
	public Algorithm(ArrayList<Request> list){
		
		this.list=list;
	}
	public abstract Request activeRequest();
	
	public abstract void updateList(ArrayList<Request> list);
}