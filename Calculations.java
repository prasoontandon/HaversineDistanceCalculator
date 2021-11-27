/**
 * Carries out the calculation of the Haversine formula:
 * https://en.wikipedia.org/wiki/Haversine_formula#Formulation
 * 
 * 
 * @author Prasoon Tandon and Evan Burnside
 */
public class Calculations {
	
	/**
	 * Converts latitude and longitude values to radians.
	 * calc1-calc3 are parts of the Haversine Formula
	 * distance in miles is the final calculation which is then returned to Main.java. 
	 * 
	 * @param lat1 City 1's Latitude
	 * @param long1 City 1's Longitude
	 * @param lat2 City 2's Latitude
	 * @param long2 City 2's Longitude
	 * 
	 * @return distance in MILES
	 */
	public static double getDistance(double lat1, double long1, double lat2, double long2) {
		lat1 = Math.toRadians(lat1);
		lat2 = Math.toRadians(lat2);
		long1 = Math.toRadians(long1);
		long2 = Math.toRadians(long2);
		
		final double MILES_CONSTANT = 3958.8;
		
		double calc1 = Math.pow((Math.sin((lat2 - lat1)/2)), 2.0);
		double calc2 = Math.cos(lat1) * Math.cos(lat2) * Math.pow((Math.sin((long2 - long1)/2)), 2.0);
		double calc3 = Math.sqrt(calc1 + calc2);
		
		
		double distance = 2 * (MILES_CONSTANT) * Math.asin(calc3);
		return distance;
	}
	
	
	//For testing purposes only.
	public static void main(String[] args) {
		/*
		System.out.println(getDistance(43.0731, -89.4012, 18.5204, 73.8567));
        */
	    
	}

    
    
}
