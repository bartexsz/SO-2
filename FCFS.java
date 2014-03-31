import java.util.ArrayList;
import java.util.Queue;


public class FCFS extends Algorithm {
	
	Queue<Process> listq;
	
	public FCFS(ArrayList<Process> list) {
		super(list);
		listq=(Queue<Process>) list;
	}

	@Override
	public Process activeProcess() {
		if(listq.peek().isDone())listq.poll();
		return listq.peek();
	}

	@Override
	public void updateList(ArrayList<Process> list) {
		listq=(Queue<Process>) list;
		
	}

}
