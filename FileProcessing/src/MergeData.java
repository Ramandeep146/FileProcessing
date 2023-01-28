import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MergeData {
	
	private ReadFile[] readDifferentFiles;
	private ArrayList<HashMap<String, Double>> hashMaps;
	
	MergeData(String[] fileNames){
		readDifferentFiles = new ReadFile[fileNames.length];
		hashMaps = new ArrayList<HashMap<String,Double>>();
		for(int i=0; i<fileNames.length; i++) {
			readDifferentFiles[i] = new ReadFile(fileNames[i]);
			hashMaps.add(readDifferentFiles[i].getHashMap());
		}
	}
	
	public void outputMergedData() throws IOException {
		
		if(hashMaps.isEmpty()) {
			return;
		}
		
		FileWriter fw = new FileWriter("Popularity_Index.txt");
		int l = 15;
		String heading = fixedLengthString("Languages", l);
		
		for(int i=0; i<hashMaps.size(); i++) {
			heading+= fixedLengthString(readDifferentFiles[i].getFileName().split("\\.")[0], l);
		}
		
		fw.write(heading + "\n");
		
		for(Map.Entry<String, Double> entry : hashMaps.get(0).entrySet()) {
			
			String line="";
			String keyCompare = entry.getKey();
			String key = fixedLengthString(entry.getKey(), l);
			String value = fixedLengthString(Double.toString(entry.getValue()) + "%", l);
			
			line = key + value;
			
			for(int i=1; i < hashMaps.size(); i++) {
				for(Map.Entry<String, Double> e : hashMaps.get(i).entrySet()) {
					String k = e.getKey();
					String v = fixedLengthString(Double.toString(e.getValue()) + "%", l);
					if(keyCompare.equals(k)) {
						line+= v;
						break;
					}	
				}
			}
			
			
			fw.write(line + "\n");
		}
		
		fw.close();
		
	}
	
	private static String fixedLengthString(String string, int length) {
	    return String.format("%1$-"+length+ "s", string);
	}

}
