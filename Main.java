import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 * @throws InterruptedException 
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws FileNotFoundException, InterruptedException {
		CPU cpu = new CPU(new Scheduler(new Generator()));
		cpu.s.SetAlgorithm(new SSTF(cpu.s.requestList));
		cpu.s.setRealAlgorithm(new EDF(cpu.s.realRequestList));
		cpu.active = true;
		Scanner f = new Scanner(System.in);
		String a = f.next();
		while(a.charAt(0) != 'q')
		{
			if(a.equals("start")) // Uruchamia cpu
			{	
				cpu.start();
			}
			else if(a.equals("stop")) // Zatrzymuje cpu
			{
				cpu.t.suspend();
				int srednia = 0;
				for(Request r : cpu.s.statrList)
				{
					srednia+=r.waitTime;
				}
				if(!cpu.s.statrList.isEmpty())srednia/=cpu.s.statrList.size();
				System.out.println("Średni czas: " + srednia);
				System.out.println("Ilość żądań: " + cpu.s.statrList.size());
				System.out.println("Ilość przesunięć głowicy: " + Disk.changes);
			}
			else if(a.equals("startstoptime")) // Uruchamia cpu na określny czas w milisekundach
			{
				int t = f.nextInt();
				cpu.start();
				Thread.sleep(t);
				cpu.t.suspend();
				int srednia = 0;
				for(Request r : cpu.s.statrList)
				{
					srednia+=r.waitTime;
				}
				if(!cpu.s.statrList.isEmpty())srednia/=cpu.s.statrList.size();
				System.out.println("Średni czas: " + srednia);
				System.out.println("Ilość żądań: " + cpu.s.statrList.size());
				System.out.println("Ilość przesunięć głowicy: " + Disk.changes);
			}
			else if(a.equals("switch")) // Zmienia algorytm przydzialający zasoby
			{
				a = f.next();
				if(a.compareTo("SSTF") == 0) cpu.s.SetAlgorithm(new SSTF(cpu.s.requestList));
				else if(a.compareTo("FCFS") == 0) cpu.s.SetAlgorithm(new FCFS(cpu.s.requestList));
				else if(a.compareTo("SCAN") == 0) cpu.s.SetAlgorithm(new SCAN(cpu.s.requestList));
				else if(a.compareTo("CSCAN") == 0) cpu.s.SetAlgorithm(new CSCAN(cpu.s.requestList));
				else if(a.compareTo("EDF") == 0) cpu.s.setRealAlgorithm(new EDF(cpu.s.realRequestList));
				else if(a.compareTo("FD-SCAN") == 0) cpu.s.setRealAlgorithm(new FDSCAN(cpu.s.realRequestList));
				cpu.s.clearList();
				Disk.pos = 100;
			}
			else if(a.equals("load")) // Wczytuje generator z gotowym zestawem procesów
			{
				a = f.next();
				cpu.s  = new Scheduler(new SGenerator(a));
				cpu.s.SetAlgorithm(new SSTF(cpu.s.requestList));
				cpu.s.setRealAlgorithm(new EDF(cpu.s.realRequestList));
			}
			else if(a.equals("loadgen")) // Wczytuje generator losowych procesów
			{
				cpu.s = new Scheduler(new Generator());
				cpu.s.SetAlgorithm(new SSTF(cpu.s.requestList));
				cpu.s.setRealAlgorithm(new EDF(cpu.s.realRequestList));
			}
			else if(a.equals("showlist")) // wyświetla listę procesów
			{
				System.out.println("Aktywne: ");
				for(Request r : cpu.s.requestList)
				{
					System.out.println(r);
				}
				System.out.println("Ukończone: ");
				for(Request r : cpu.s.statrList)
				{
					System.out.println(r);
				}
			}
			else if(a.equals("genconfig")) //Zmienia ustawienia generatora procesów
			{
				Generator.maxPosition = f.nextInt();
				Disk.size = Generator.maxPosition;
				Generator.maxTimeNext = f.nextInt();
			}
			a = f.next();
		}
		
		f.close();
	}

}
