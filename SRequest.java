
public class SRequest extends Request implements Comparable<SRequest>{

	int delay;
	public SRequest() {
		delay = 0;
	}

	public SRequest(int id, int position,int deadline) {
		super(id, position, deadline);
		delay = 0;
	}
	public SRequest(int id, int position, int deadline, int delay)
	{
		super(id, position, deadline);
		this.delay = delay;
	}

	@Override
	public int compareTo(SRequest arg0) {
		return this.delay-arg0.delay;
	}
}
