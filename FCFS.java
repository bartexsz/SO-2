import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class FCFS extends Algorithm {

	private Queue<Request> queue;
	public FCFS(ArrayList<Request> list) {
		super(list);
		queue = new LinkedList<Request>(list);
	}

	@Override
	public Request activeRequest() {
		Request r = queue.remove();
		int diff = abs(r.position - Disk.pos);
		Disk.changes += diff;
		for(Request p : list)p.waitTime+=diff;
		Disk.pos = r.position;
		return r;
	}

	@Override
	public void updateList(ArrayList<Request> list) {
		queue = new LinkedList<Request>(list);

	}
	public int abs(int a)
	{
		return (a < 0) ? -a : a;
	}

}
