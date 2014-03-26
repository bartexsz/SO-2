import java.util.ArrayList;

public class Scheduler {
	private Algorithm activeAlgorithm;
	private ArrayList<Process> processList;
	private Generator gen;
	
	public Scheduler()
	{
		activeAlgorithm = null;
		processList = new ArrayList<Process>();
	}
	
	public void assignProcess()
	{
		checkGenerator();
		if(!processList.isEmpty())
		{
			activeAlgorithm.activeProcess().doOnce();
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
}
