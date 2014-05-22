import java.util.ArrayList;


public class FDSCAN extends RealAlgorithm {

	public FDSCAN(ArrayList<Request> list) {
		super(list);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Request activeRequest() {
		for(int i = 0; i < realRequest.size(); i++)
		{
			if(realRequest.get(i).deadline < abs(realRequest.get(i).position - Disk.pos))
			{
				realRequest.get(i).deadline = -1;
				realRequest.remove(i);
				i--;
			}
		}
		int nearest = 0;
		for(int i = 1; i < realRequest.size(); i++)
		{
			if(abs(realRequest.get(i).position - Disk.pos) < realRequest.get(nearest).position - Disk.pos) nearest = i;
		}
		if(realRequest.get(nearest).position < Disk.pos)
		{
			Disk.pos--;
			Disk.changes++;
		}
		else if(realRequest.get(nearest).position == Disk.pos) return realRequest.get(nearest);
		else
		{
			Disk.pos--;
			Disk.changes++;
		}
		Request r = null;
		for(int i = 0; i < list.size(); i++)
		{
			if(list.get(i).position == Disk.pos) r = list.get(i);
		}
		for(Request p : realRequest) p.deadline--;
		return r;
	}

	@Override
	public void updateList(ArrayList<Request> list) {
		this.list = list;

	}

	@Override
	public void updateRealList(ArrayList<Request> list) {
		this.realRequest = list;

	}
	public int abs(int a)
	{
		return (a < 0) ? -a : a;
	}
}
