import java.util.ArrayList;


public class SJFw extends Algorithm{

int index=0;
	
	public SJFw(ArrayList<Process> list){
		super(list);
	}
	public Process activeProcess(){
		int shortest =0;
		if(list.get(index).getremaining()<list.get(index).getprocTime()) return list.get(index);
		for(int i=0; i<list.size(); i++){
			if(list.get(i).getremaining()<shortest){
				shortest=list.get(i).getremaining();
				index=i;
			}
		}
		return list.get(index);
	}
	public void updateList(ArrayList<Process> list) {
		this.list = list;

	}
}
