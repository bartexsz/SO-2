import java.util.ArrayList;

public class CSCAN extends Algorithm {

	
	int position=1;
	int preposition=0;
	
	public CSCAN(ArrayList<Request> list){
		super(list);
	}
	
	public Request activeRequest(){
		Disk.changes++;
		if(position==200){
			position=1;
			preposition=0;
			for(int i=0; i<list.size(); i++){
				if(list.get(i).position==position) return list.get(i);
			}
			return null;
		}else{
			position++;
			preposition++;
			for(int i=0; i<list.size(); i++){
				if(list.get(i).position==position) return list.get(i);
			}
			return null;
		}
	}
	
	public void updateList(ArrayList<Request> list){
		this.list=list;
	}
}
