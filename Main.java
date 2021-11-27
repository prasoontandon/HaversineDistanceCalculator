///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           WorldCitiesDistanceCalc
// Author(s):       Prasoon Tandon and Evan Burnside
// Email:           ptandon3@wisc.edu
//
///////////////////////////////// COMMENTS ////////////////////////////////////
//
//      
// This was a collaborative project with Evan Burnside; 
// 
//
/////////////////////////////// 80 COLUMNS WIDE ////////////////////////////////

import java.util.Scanner;
/**
 * This is the main file for the entire program. It calculates the distance in miles
 * between two cities using the Haversine Formula.
 * 
 * Haversine Formula: 
 * https://en.wikipedia.org/wiki/Haversine_formula#Formulation
 * 
 * Cities List CSV credit:
 * https://simplemaps.com/data/world-cities
 * 
 * @author Prasoon Tandon and Evan Burnside
 *
 */
public class Main {

    /**
     * Prompts user for input. Calls CityList class for reference.
     * Calls getCityCoordinates for appropriate values for calculations.
     * Calls Caclulations.java for results.
     * 
     * @param args
     */
	public static void main(String[] args) {
		
		CityList.fillCityList(40000);
		
		
		Scanner scnr = new Scanner(System.in);
		System.out.print("Enter the first city: ");
		String userInput1 = scnr.nextLine();
		System.out.print("Enter the second city: ");
		String userInput2 = scnr.nextLine();
		
		
		double[] firstCoords = getCityCoords(userInput1);
		double[] secondCoords = getCityCoords(userInput2);
		
		double finalDistance = Calculations.getDistance(firstCoords[0],firstCoords[1],
                                                        secondCoords[0],secondCoords[1]);
		
		System.out.printf("\nDistance between " + userInput1 + " and " + userInput2 + ":\n~" 
		                  + "%.2f" + " miles", finalDistance);
		
		scnr.close();
		
	}
	
	/**
	 * Checks to see if user input is valid and gathers coordinates from CityList.
	 * Returns error coordinates otherwise. 
	 * 
	 * @param userInput is the city name user provides. 
	 * @return coordinates of cities user is interested in. 
	 */
	public static double[] getCityCoords(String userInput) {
	    
		for (int i = 0; i < CityList.cityList.size(); i++ ) {
			if (CityList.cityList.get(i).getName().equals(userInput)) {
				double[] coords = {CityList.cityList.get(i).getLatitude(), 
				                   CityList.cityList.get(i).getLongitude()};
				
				return coords;
			}
		}
		double[] errorCoordinates = {0,0};
		return errorCoordinates;
	}

}
