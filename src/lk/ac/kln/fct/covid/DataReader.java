package lk.ac.kln.fct.covid;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONObject;

public class DataReader {
	private static final String JSON_ARRAY = "records";
	private static final String COUNTRY = "countriesAndTerritories";
	private static final String DATE = "dateRep";
	private static final String CASES = "cases";
	private static final String DEATHS = "deaths";
	
	
	/**
	 * This method reads the contents form a JSON file and prints the required data.
	 *
	 * @param filePath the path to JSON file.
	 */
	public void readData(String filePath) {
		try {
			String fileContent = new String (Files.readAllBytes(Paths.get(filePath)));
			JSONObject obj  = new JSONObject(fileContent);
			JSONArray arr = obj.getJSONArray(JSON_ARRAY);

			System.out.println("\t   Date\t\t|\tReported cases\t|\tDeaths");
			for(int i = 0; i < arr.length(); i ++) {
				if (arr.getJSONObject(i).getString(COUNTRY).equals("Sri_Lanka")){
					System.out.println("\t" + arr.getJSONObject(i).getString(DATE) + " \t\t\t" + arr.getJSONObject(i).getString(CASES) + "\t\t\t\t" + arr.getJSONObject(i).getString(DEATHS));
				}

				//TODO Improve this to print required data.
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
