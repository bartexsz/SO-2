import java.util.ArrayList;


public class SJF extends Algorithm{

	int index=0;
	
	public SJF(ArrayList<Process> list){
		super(list);
	}
	public Process activeProcess(){
		int shortest =0;
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