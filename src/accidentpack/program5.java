package accidentpack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Author Philip Lane
 */

public class program5 {
	/**
	 * Accepts a file name and constructs a HashMap of Binary Search Trees of
	 * AccidentRecords for each state, and returns the new HashMap.
	 * 
	 * @param filePath
	 * @return
	 */

	public static HashMap<String, BST> reader(String filePath) {
		HashMap<String, BST> stateBSTMap = new HashMap<String, BST>();

		try (FileReader fileReader = new FileReader(filePath)) {
			BufferedReader reader = new BufferedReader(fileReader);
			String line = "";
			String[] data;
			reader.readLine();
			while ((line = reader.readLine()) != null) {
				data = line.split(",");
				String state = data[7];
				AccidentRecord entry = new AccidentRecord(data[0], Integer.parseInt(data[1]), data[2], data[3], data[4],
						data[5], data[6], data[7], Double.parseDouble(data[8]), Double.parseDouble(data[9]),
						Double.parseDouble(data[10]), data[11], data[12]);

				if (stateBSTMap.containsKey(state)) {
					stateBSTMap.get(state).add(entry);
				} else {
					stateBSTMap.put(state, new BST(entry));
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return stateBSTMap;
	}
	
	public static void searchMenu(HashMap<String, BST> reports) {
		Timer t = new Timer();
		int s, rs;
		BST tree;
		String date, state;
		boolean tryAgain = true;
		try (BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));) {
			while (tryAgain) {
				System.out.print("Enter the state (e.g., IL): ");
				state = inputReader.readLine();
				if (!reports.containsKey(state)) {
					System.out.println("Unable to find state " + state);
					System.out.print("Would you like to try again? (y to continue) ");
					tryAgain = inputReader.readLine().equalsIgnoreCase("y");
				} else {
					tree = reports.get(state);
					System.out.print("Enter the date (e.g., 2022-09-08): ");
					date = inputReader.readLine();
					
					Long startTime;
					Long endTime;
					startTime = System.nanoTime();
					s = tree.search(date);
					endTime = System.nanoTime();
				
					System.out.printf("%d reports are available for %s on and after the date %s\n", s, state, date);
					System.out.println((endTime - startTime) / 1000000000.0 + " seconds to read the records");
					
					t.start();
					rs = tree.recurSearch(date);
					t.stop();
					System.out.printf("%d reports are available for %s on and after the date %s\n", rs, state, date);
					System.out.printf("%.10f seconds to calculate this using recursive method\n", t.getTime());

					System.out.print("Would you like to search again? (y to continue) ");
					tryAgain = inputReader.readLine().equalsIgnoreCase("y");
				}

			}
		} catch (IOException ex) {
				ex.printStackTrace();
		}
	}

	/**
	 * Main method that accepts a file name through the command line arguments list.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// String[] args2 = { "CA", "Los Angeles", "accidents.csv" }; reference list. I
		Long startTime;
		Long endTime;
		String filePath = args[0];

		HashMap<String, BST> reports = new HashMap<String, BST>();

		startTime = System.nanoTime();
		reports = reader(filePath);
		endTime = System.nanoTime();
		System.out.println((endTime - startTime) / 1000000000.0 + " seconds to read the records");
		
		searchMenu(reports);
	}
}
