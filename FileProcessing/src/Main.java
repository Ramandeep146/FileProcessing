import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int chooseOption = 0;
		String fileName = null;
		ReadFile readFile = null;
		SortData sortData = null;
		MergeData mergeData;
		FilterData filterData;
		
		
		do {
			System.out.println("==========Please choose one of the options==========");
			System.out.println("To read the data from external files, press 1");
			System.out.println("To sort files, press 2");
			System.out.println("To merge files, press 3");
			System.out.println("To filter files, press 4");
			System.out.println("To exit, press 5");
			System.out.print("Enter here: ");
			
			chooseOption = scanner.nextInt();
			
			if(chooseOption == 1) {
				fileName = chooseFile();
				readFile = new ReadFile(fileName);
				readFile.printFile();
				
			}else if(chooseOption == 2) {
				fileName = chooseFile();
				readFile = new ReadFile(fileName);
				sortData = new SortData(readFile);
				sortData.sortFileRead();
				readFile.printFile();
				
			}else if(chooseOption == 3) {
				String[] fileNames = {"USA.csv", "India.csv", "Germany.txt", "UnitedKingdom.txt"};
				mergeData = new MergeData(fileNames);
				try {
					mergeData.outputMergedData();
					System.out.println("\nData Successfully Merged in file Popularity_Index.txt!\n");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}else if(chooseOption == 4) {
				fileName = chooseFile();
				readFile = new ReadFile(fileName);
				sortData = new SortData(readFile);
				sortData.sortFileRead();
				filterData = new FilterData(readFile);
				int i=0;
				double value;
				String val;
				do {
					System.out.println();
					System.out.println("Filter data below a certain percentage? Press 1");
					System.out.println("Filter data above a certain percentage? Press 2");
					System.out.println("Find percentage of a particular language? Press 3");
					System.out.print("Enter value here: ");
					i = scanner.nextInt();
					
				}while(i!=1 && i!=2 && i!=3);
				
				if(i == 1) {
					System.out.print("Please input the max value: ");
					value = scanner.nextDouble();
					filterData.filterByMaxValue(value);
				}else if(i == 2) {
					System.out.print("Please input the min value: ");
					value = scanner.nextDouble();
					filterData.filterByMinValue(value);
				}else {
					System.out.print("Please input the value you want to find: ");
					val = scanner.next();
					filterData.filterByEqualValue(val);
				}
				
			}else if(chooseOption == 5) {
				continue;
			}else {
				System.out.println("PLEASE INPUT A VALID OPTION!");
			}
			
			
		}while(chooseOption !=5);
		
		System.out.println("Thank You!");
		
		scanner.close();

	}
	
	public static String chooseFile() {
		
		int chooseFile;
		String fileName;
		do {
			System.out.println("\nThe following files contain popularity data for different programming languages for different countries:");
			System.out.println("For USA's data, please enter 1");
			System.out.println("For India's data, please enter 2");
			System.out.println("For Germany's data, please enter 3");
			System.out.println("For UnitedKingdom's data, please enter 4");
			System.out.print("Enter here: ");
			
			Scanner scanner = new Scanner(System.in);
			
			chooseFile = scanner.nextInt();
			
		}while(chooseFile != 1 && chooseFile != 2 && chooseFile != 3 && chooseFile != 4);
		
		if(chooseFile == 1) {
			fileName = "USA.csv";
		} else if(chooseFile == 2) {
			fileName = "India.csv";
		} else if(chooseFile == 3) {
			fileName = "Germany.txt";
		} else {
			fileName = "UnitedKingdom.txt";
		}

		return fileName;
	}

}
