
public class CPU {

	Generator g;
	Scheduler s;
	
	public void doCycle(){
		while(g.isActive()){
		g.updateTime();
		s.assignProcess();	
		}
	}
}
