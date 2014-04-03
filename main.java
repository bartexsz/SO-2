import java.util.Scanner;


public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CPU cpu = new CPU(new Scheduler(new Generator()));
		cpu.s.SetAlgorithm(new FCFS(cpu.s.processList));
		cpu.active = true;
		cpu.start();
		Scanner f = new Scanner(System.in);
		String a = f.next();
		while(a.charAt(0) != 'q')
		{
			if(a.compareTo("start") == 0)
			{	
				cpu.start();
			}
			else if(a.compareTo("stop") == 0)
			{
				cpu.t.suspend();
				int srednia = 0;
				for(Process p : cpu.s.statpList)
				{
					srednia+=p.waitTime;
				}
				if(!cpu.s.statpList.isEmpty())srednia/=cpu.s.statpList.size();
				System.out.println("Średni czas" + srednia);
				System.out.println("Ilość  procesów" + cpu.s.statpList.size());
			}
			else if(a.compareTo("switch") == 0)
			{
				a = f.next();
				if(a.compareTo("FCFS") == 0) cpu.s.SetAlgorithm(new FCFS(cpu.s.processList));
				else if(a.compareTo("ROT") == 0) cpu.s.SetAlgorithm(new Rot(cpu.s.processList));
				else if(a.compareTo("SJF") == 0) cpu.s.SetAlgorithm(new SJF(cpu.s.processList));
				else if(a.compareTo("SJFw") == 0) cpu.s.SetAlgorithm(new SJFw(cpu.s.processList));
				cpu.s.clearList();
			}
			a = f.next();
		}
		
		f.close();
	}

}
