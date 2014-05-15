import java.util.ArrayList;


public class SSTF extends Algorithm {

	public SSTF(ArrayList<Request> list) {
		super(list);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Request activeRequest() {
		int shortest = 0;
		for(int i = 1; i < list.size(); i++)
		{
			if(abs(list.get(shortest).position - Disk.pos) > abs(list.get(i).position - Disk.pos))
			{
				shortest = i;
			}
		}
		Request r = list.get(shortest);
		Disk.changes += abs(r.position - Disk.pos);
		list.remove(shortest);
		return r;
	}

	@Override
	public void updateList(ArrayList<Request> list) {
		// TODO Auto-generated method stub

	}

	public int abs(int a)
	{
		return (a < 0) ? -a : a;
	}
}
