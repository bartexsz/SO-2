import java.util.ArrayList;

public class SCAN extends Algorithm {

	int index=0;
	int preindex=-1;
	
	public SCAN(ArrayList<Request> list){
		super(list);
	}
	
	public Request activeRequest(){
		if(index==list.size()-1){
			index=list.size()-2;
			preindex=list.size()-1;
			return list.get(index);
		}else if(index==0){
			index=1;
			preindex=0;
			return list.get(index);
		}else if(preindex>index){
			index--;
			preindex--;
			return list.get(index);
		}else{
			index++;
			preindex++;
			return list.get(index);
		}
	}
	
	public void updateList(ArrayList<Request> list){
		this.list=list;
	}
}
