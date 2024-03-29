package accidentpack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Author Philip Lane + Charles Winkelman
 */

public class program5 {
	/**
	 * Accepts a file name and constructs a HashMap of Binary Search Trees of
	 * AccidentRecords for each state, and returns the new HashMap.
	 * 
	 * @param filePath path to file
	 * @return AccidentRecords in CSV parsed into BSTs, keyed to their states in a HashMap
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
	
	/**
	 * Accepts a HashMap (key of abbreviated states, value of BST of AccidentRecords) and 
	 * prompts the user for a state abbrev and date in the form of yyyy-mm-dd. If the state is 
	 * found in the HashMap keys, it will use the recursive and nonrecursive search methods in
	 * BST to find the number of AccidentReports after the provided date in the provided state.
	 * Repeated searches can be made by typing 'y' when prompted.
	 * @param reports  a HashMap with state abbrev as keys and a BST of AccidentRecords as values
	 */
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
					
					t.start();
					s = tree.search(date);
					t.stop();
					System.out.printf("%d reports are available for %s on and after the date %s\n", s, state, date);
					System.out.printf("%.10f seconds to calculate this using children count fields\n", t.getSeconds());
					
					t.start();
					rs = tree.recurSearch(date);
					t.stop();
					System.out.printf("%d reports are available for %s on and after the date %s\n", rs, state, date);
					System.out.printf("%.10f seconds to calculate this using recursive method\n", t.getSeconds());

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
	 * @param args  command line arguments
	 */
	public static void main(String[] args) {
		Timer t = new Timer();
		String filePath = args[0];

		HashMap<String, BST> reports = new HashMap<String, BST>();

		t.start();
		reports = reader(filePath);
		t.stop();
		System.out.printf("%.10f seconds to read the records\n", t.getSeconds());
		
		searchMenu(reports);
	}
}
