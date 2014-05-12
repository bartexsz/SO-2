
public class Request {

	private int id;
	public int waitTime;
	public int position;
	
	public Request()
	{
		id=-1;
		position=-1;
		waitTime = 0;
	}
	
	public Request(int id, int position)
	{
		this.id = id;
		this.position=position;
		waitTime = 0;
	}
	
	public int getPosition()
	{
		return position;
	}
	
	public String toString()
	{
		return id + " " + position + " " + waitTime;
	}
}
