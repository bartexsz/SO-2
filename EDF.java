import java.util.ArrayList;


public class EDF extends RealAlgorithm {

	public EDF(ArrayList<Request> list) {
		super(list);
		
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
		if(realRequest.size() < 1) return null;
		int shortest = 0;
		for(int i = 1; i < realRequest.size(); i++)
		{
			if(realRequest.get(i).deadline < realRequest.get(shortest).deadline) shortest = i;
		}
		int dis = abs(realRequest.get(shortest).position - Disk.pos);
		Disk.changes+=dis;
		for(Request r : realRequest) r.deadline-=dis;
		return realRequest.get(shortest);
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
