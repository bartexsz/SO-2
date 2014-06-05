import java.util.ArrayList;

public class Scheduler {
	private Algorithm activeAlgorithm;
	private RealAlgorithm realAlgorithm;
	public ArrayList<Request> requestList;
	public ArrayList<Request> realRequestList;
	public ArrayList<Request> statrList;
	private Generator gen;
	
	public Scheduler(Generator g)
	{
		activeAlgorithm = null;
		requestList = new ArrayList<Request>();
		realRequestList = new ArrayList<Request>();
		statrList = new ArrayList<Request>();
		gen = g;
	}
	
	public void assignRequest() throws InterruptedException
	{
		checkGenerator();
		if(requestList.size() < 1) return;
		Thread.sleep(100);
		for(int i = 0; i < requestList.size(); i++)
		{
			if(requestList.get(i)==null) 
			{
				requestList.remove(i);
				i--;
				continue;
			}
			requestList.get(i).waitTime++;
			
		}
		activeAlgorithm.updateList(requestList);
		realAlgorithm.updateList(requestList);
		realAlgorithm.updateRealList(realRequestList);
		if(!requestList.isEmpty() || !realRequestList.isEmpty())
		{
			if(!realRequestList.isEmpty())
			{
				Request p = realAlgorithm.activeRequest();
				if(p==null) return;
				if(p.deadline == -2)
				{
					for(int i = 0; i< requestList.size(); i++)
					{
						if(p.equals(requestList.get(i)))
						{
							requestList.remove(i);
							statrList.add(p);
							break;
						}
					}
				}
				else if(p.deadline > -1) 
				{
					for(int i = 0; i< realRequestList.size(); i++)
					{
						if(p.equals(realRequestList.get(i)))
						{
							realRequestList.remove(i);
							statrList.add(p);
							break;
						}
					}
				}
				for(int i = 0; i < realRequestList.size(); i++)
				{
					Request r = realRequestList.get(i);
					r.deadline--;
					if(r.deadline < 0)
					{
						realRequestList.remove(i);
						requestList.add(r);
						i--;
					}
				}
			}
			else 
			{
				Request p = activeAlgorithm.activeRequest();
				if(activeAlgorithm instanceof FCFS) requestList.remove(0);
				else if(p!= null)
				{
					for(int i = 0; i< requestList.size(); i++)
					{
						if(p.equals(requestList.get(i)))
						{
							requestList.remove(i);
							break;
						}
					}
				}
				else return;
				p.waitTime--;
				statrList.add(p);
				
			}
		}
	}
	
	public void checkGenerator()
	{
		while(Generator.isActive() && gen.isReady())
		{
			Request n = gen.getNext();
			if(n.deadline > -2) realRequestList.add(n);
			else requestList.add(gen.getNext());
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
		realRequestList.clear();
	}
	public void setRealAlgorithm(RealAlgorithm alg)
	{
		realAlgorithm = alg;
	}
	
	public int abs(int a)
	{
		return (a < 0) ? -a : a;
	}
}
