package accidentpack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Author Philip Lane
 */

public class program5 {
	public static List<AccidentRecord> reader(String state, String city, String fileName) {
		ArrayList<AccidentRecord> Report = new ArrayList<>();

		// regex for pattern validation
		Pattern statePat = Pattern.compile("^[A-Z]{2}$");
		Pattern cityPat = Pattern.compile("^[a-zA-Z ]+$");
		Matcher stateMatch = statePat.matcher(state);
		Matcher cityMatch = cityPat.matcher(city);

		if ((stateMatch.matches() == true) && (cityMatch.matches() == true)) {
			try (FileReader fileReader = new FileReader("src\\accidentpack\\" + fileName)) {
				BufferedReader reader = new BufferedReader(fileReader);
				String line = "";
				String[] data;
				while ((line = reader.readLine()) != null) {
					data = line.split(",");
					if (data[5].equals(city) && data[7].equals(state)) {
						AccidentRecord entry = new AccidentRecord(data[0], Integer.parseInt(data[1]), data[2], data[3],
								data[4], data[5], data[6], data[7], Double.parseDouble(data[8]),
								Double.parseDouble(data[9]), Double.parseDouble(data[10]), data[11], data[12]);

						Report.add(entry);
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return Report;
	}
	
	
	// Unimplemented functions
	
	public static void main(String[] args) {
		// String[] args2 = { "CA", "Los Angeles", "accidents.csv" }; reference list. I
		// was not able to test the program via command prompt.
		Long startTime;
		Long endTime;
		String state = args[0];
		String city = args[1];
		String fileName = args[2];

		List<AccidentRecord> Report = new ArrayList<>();

		startTime = System.nanoTime();
		Report = reader(state, city, fileName);
		endTime = System.nanoTime();
		System.out.println((endTime - startTime) / 1000000000.0 + " seconds to read the records");

		if (Report.isEmpty() != true) {

			Comparator<AccidentRecord> byStartTime = (s1, s2) -> s1.getStartTime().compareTo(s2.getStartTime());
			startTime = System.nanoTime();
			Collections.sort(Report, byStartTime);
			endTime = System.nanoTime();


		} else {
			System.out.println("No Records Found");
		}

	}
}
