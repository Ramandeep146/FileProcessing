import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ReadFile {
	
	private String fileName;
	private File file;
	private HashMap<String, Double> hashMap;
	
	ReadFile(){
		
	}
	
	ReadFile(String fileName){
		this.fileName = fileName;
		file = new File(fileName);
		hashMap = new HashMap<String, Double>();
		try {
			Scanner scan = new Scanner(file);
			while(scan.hasNext()) {
				String line = scan.nextLine();
				String[] myString = line.split(",");
				
				hashMap.put(myString[0], Double.parseDouble(myString[1]));
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public HashMap<String, Double> getHashMap(){
		return this.hashMap;
	}
	
	public void setHashMap(HashMap<String, Double> hashMap) {
		this.hashMap = hashMap;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	public void printFile() {
		String[] countryName = fileName.split("\\.");
		System.out.println("\nThe popularity of different programming languages for the country " + countryName[0] + " are: ");
		for(Map.Entry<String, Double> entry : hashMap.entrySet()) {
			String key = entry.getKey();
			Double value = entry.getValue();
			System.out.printf("%-15s%.2f%%\n", key, value);
		}
		System.out.println();
	}
}
