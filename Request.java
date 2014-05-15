
public class Request {

	private int id;
	public int waitTime;
	public int position;
	int deadline; // -2 - nonRealTime, -1 - missed realTime, 0+ - realTime
	
	public Request()
	{
		id=-1;
		position=-1;
		waitTime = 0;
		deadline = -2;
		
	}
	
	public Request(int id, int position, int deadline)
	{
		this.id = id;
		this.position=position;
		this.deadline = deadline;
		waitTime = 0;
	}
	
	public int getPosition()
	{
		return position;
	}
	
	public String toString()
	{
		return id + " " + position + " " + waitTime + " " + deadline;
	}
}
