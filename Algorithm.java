import java.util.*;
public abstract class Algorithm {

	ArrayList<Request> list;
	
	public Algorithm(ArrayList<Request> list){
		Disk.changes = 0;
		this.list=list;
	}
	public abstract Request activeRequest();
	
	public abstract void updateList(ArrayList<Request> list);
}