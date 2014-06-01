import java.util.ArrayList;


public abstract class RealAlgorithm extends Algorithm {
	ArrayList<Request> realRequest;

	public RealAlgorithm(ArrayList<Request> list) {
		super(list);
		// TODO Auto-generated constructor stub
	}

	@Override
	public abstract Request activeRequest();

	@Override
	public abstract void updateList(ArrayList<Request> list);
	
	public abstract void updateRealList(ArrayList<Request> list);
}
