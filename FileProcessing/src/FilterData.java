import java.util.HashMap;
import java.util.Map;

public class FilterData {
	
	private ReadFile readFile;
	
	FilterData(ReadFile myReadFile){
		this.readFile = myReadFile;
	}
	
	public void filterByMinValue(double min) {
		HashMap<String, Double> hashMap = readFile.getHashMap();
		String fileName = readFile.getFileName();
		boolean bool = false;
		System.out.println("\nPopularity above " + min + "% are: " );
		for(Map.Entry<String, Double> entry : hashMap.entrySet()) {
			String key = entry.getKey();
			Double value = entry.getValue();
			if(value > min) {
				System.out.printf("%-15s%.2f%%\n", key, value);
				bool = true;
			}
		}
		if(!bool) {
			System.out.println("No Data!");
		}
		System.out.println();
	}
	
	public void filterByMaxValue(double max) {
		HashMap<String, Double> hashMap = readFile.getHashMap();
		String fileName = readFile.getFileName();
		boolean bool = false;
		System.out.println("\nPopularity below " + max + "% are: " );
		for(Map.Entry<String, Double> entry : hashMap.entrySet()) {
			String key = entry.getKey();
			Double value = entry.getValue();
			if(value < max) {
				System.out.printf("%-15s%.2f%%\n", key, value);
				bool = true;
			}
		}
		if(!bool) {
			System.out.println("No Data!");
		}
		System.out.println();
	}
	
	public void filterByEqualValue(String val) {
		HashMap<String, Double> hashMap = readFile.getHashMap();
		String fileName = readFile.getFileName();
		boolean bool = false;
		System.out.println("\nPopularity of " + val + " is: " );
		for(Map.Entry<String, Double> entry : hashMap.entrySet()) {
			String key = entry.getKey();
			Double value = entry.getValue();
			if(key.toLowerCase().equals(val.toLowerCase())) {
				System.out.printf("%-15s%.2f%%\n", key, value);
				bool = true;
			}
		}
		if(!bool) {
			System.out.println("No Data!");
		}
		System.out.println();
	}

}
