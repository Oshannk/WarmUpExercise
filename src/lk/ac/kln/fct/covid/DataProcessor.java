package lk.ac.kln.fct.covid;

public class DataProcessor {
	private static final String FILE_PATH = "src/covid19data.json";

	public static void main(String[] args) {
		DataReader reader = new DataReader();
		reader.readData(FILE_PATH);
	}
}
