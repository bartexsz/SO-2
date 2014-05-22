import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SGenerator extends Generator {
	Queue<SRequest> list;
	
	public SGenerator() {
	}
	
	public SGenerator(String filename) throws FileNotFoundException
	{
		active = true;
		Scanner f = new Scanner(new File(filename));
		list = new LinkedList<SRequest>();
		int id, position, deadline, delay;
		while(f.hasNext())
		{
			id = f.nextInt();
			position = f.nextInt();
			deadline = f.nextInt();
			delay = f.nextInt();
			list.add(new SRequest(id,position, deadline, delay));
		}
		f.close();
		timeNext = list.peek().delay;
	}
	
	public Request getNext()
	{
		if(list.isEmpty())
		{
			switchOff();
			return null;
		}
		Request a = list.poll();
		if(list.isEmpty())
		{
			switchOff();
			timeNext = 0;
		}
		else timeNext = list.peek().delay;
		return a;
	}
}
