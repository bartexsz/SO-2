
public class CPU implements Runnable {
	public boolean active = false;
	Scheduler s;
	public Thread t;
	
	public CPU(Scheduler s)
	{
		this.s = s;
		Generator.switchOn();
	}
	
	public void doCycle(){
		while(Generator.isActive()){
		Generator.updateTime();
		s.assignProcess();	
		}
	}

	@Override
	public void run() {
		while(active)
		{
			doCycle();
		}
	}
	public void start()
	{
		t = new Thread(this, "CPUSym");
		t.start();
	}
}
