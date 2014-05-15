import java.util.ArrayList;

public class Scheduler {
	private Algorithm activeAlgorithm;
	public ArrayList<Request> requestList;
	public ArrayList<Request> statrList;
	private Generator gen;
	
	public Scheduler(Generator g)
	{
		activeAlgorithm = null;
		requestList = new ArrayList<Request>();
		statrList = new ArrayList<Request>();
		gen = g;
	}
	
	public void assignRequest()
	{
		checkGenerator();
		for(int i = 0; i < requestList.size(); i++)
		{
			requestList.get(i).waitTime++;
			
		}
		activeAlgorithm.updateList(requestList);
		if(!requestList.isEmpty())
		{
			Request p = activeAlgorithm.activeRequest();
			if(activeAlgorithm instanceof FCFS) requestList.remove(0);
			if(p == null) return;
			p.waitTime--;
			statrList.add(p);
		}
	}
	
	public void checkGenerator()
	{
		if(Generator.isActive() && gen.isReady())
		{
			requestList.add(gen.getNext());
		}
	}
	
	public void SetAlgorithm(Algorithm algorithm)
	{
		this.activeAlgorithm = algorithm;
		requestList.clear();
		gen.id = 0;
	}
	public void clearList()
	{
		statrList.clear();
		requestList.clear();
	}
}
