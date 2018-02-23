package individual.user;

import java.util.ArrayList;
import java.util.List;

public class ListResetClass {

	public List<GetSet> set(List<GetSet> tasks) {
		
		// if task is not part of label then don't include in list
		List<GetSet> list = null ; 
		list = new ArrayList<>();
		
		for(GetSet li : tasks ) {
			if(li.getLabel().equals("")){
				continue;
			}
			else if(li.getLabel()==null) {
					continue;
			}else {
				list.add(li);
			}
		}
		return list;
	}
	
}
