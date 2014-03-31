import java.util.ArrayList;


public class Rot extends Algorithm {
	int index;
	public Rot(ArrayList<Process> list) {
		super(list);
		index = 0;
	}

	@Override
	public Process activeProcess() {
		if(index >= list.size()) index = 0;
		index++;
		return list.get(index-1);
	}

	@Override
	public void updateList(ArrayList<Process> list) {
		this.list = list;

	}

}
