import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Parses worldcities.csv to populate the program's cityList ArrayList, which holds information
 * for each city. 
 * @author Prasoon Tandon and Evan Burnside
 *
 */
public class CityList {
    public static ArrayList<City> cityList = new ArrayList<City>();
       
	public static void fillCityList(int numCities) {
		String pathToCSVFile = "worldcities.csv";
		String dataLine = "";
		
		try {
		    
			BufferedReader br = new BufferedReader(new FileReader(pathToCSVFile));
			
			int i = 0;
			while ((dataLine = br.readLine()) != null && i < numCities) {
				String[] values = dataLine.split(",");

				for (int j = 0; j < 4; j++) {
					if (values[j].charAt(0) == '"' ) {
					values[j] = values[j].substring(1, values[j].length() - 1);
					}
				}

				if (values[1].equals("city_ascii") || values[2].equals("lat") || 
				    values[3].equals("lng")) { continue; }
					
				else {
				    
					i = i + 1;
					double latitude = Double.parseDouble(values[2]);
					double longitude = Double.parseDouble(values[3]);
					City newCity = new City(values[1], latitude, longitude);
					cityList.add(newCity);
				}
			}
			br.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException f) {
			f.printStackTrace();
		}
	}

}
