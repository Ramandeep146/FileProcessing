import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SortData {
	
	private ReadFile readFile;
	private HashMap<String, Double> hashMap;
	
	SortData(ReadFile myReadFile){
		this.readFile = myReadFile;
	}
	
	public void sortFileRead() {
		this.hashMap = readFile.getHashMap();
		
		List<Map.Entry<String, Double> > list = new LinkedList<Map.Entry<String, Double> >(hashMap.entrySet());

		
		Collections.sort(list, new Comparator<Map.Entry<String, Double> >() {
			public int compare(Map.Entry<String, Double> o1,
			Map.Entry<String, Double> o2)
			{
				return (o2.getValue()).compareTo(o1.getValue());
			}
		});
				
		HashMap<String, Double> temp = new LinkedHashMap<String, Double>();
		for (Map.Entry<String, Double> aa : list) {
			temp.put(aa.getKey(), aa.getValue());
		}
		
		readFile.setHashMap(temp);
	}

}
