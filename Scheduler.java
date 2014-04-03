import java.util.ArrayList;

public class Scheduler {
	private Algorithm activeAlgorithm;
	public ArrayList<Process> processList;
	public ArrayList<Process> statpList;
	private Generator gen;
	
	public Scheduler(Generator g)
	{
		activeAlgorithm = null;
		processList = new ArrayList<Process>();
		statpList = new ArrayList<Process>();
		gen = g;
	}
	
	public void assignProcess()
	{
		checkGenerator();
		for(int i = 0; i < processList.size(); i++)
		{
			if(processList.get(i).isDone())
			{
				statpList.add(processList.get(i));
				processList.remove(i);
				i--;
			}
			else
			{
				processList.get(i).waitTime++;
			}
		}
		activeAlgorithm.updateList(processList);
		if(!processList.isEmpty())
		{
			Process p = activeAlgorithm.activeProcess();
			p.doOnce();
			p.waitTime--;
		}
	}
	
	public void checkGenerator()
	{
		if(Generator.isActive() && gen.isReady())
		{
			processList.add(gen.getNext());
		}
	}
	
	public void SetAlgorithm(Algorithm algorithm)
	{
		this.activeAlgorithm = algorithm;
	}
	public void clearList()
	{
		statpList.clear();
		processList.clear();
	}
}
