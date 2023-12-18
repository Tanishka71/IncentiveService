package com.bridgelabz.main;

import java.util.HashMap;
import java.util.Map;

import com.bridgelabz.test.Ride;

public class InvoiceService {

	private static final double MINIMUM_FARE_PER_KM = 10;
	private static final int MINIMUM_FARE_PER_MINUTE = 1;
	private static final double MINIMUM_FARE = 5;
	

    
	Map<Double, Double> invoiceService = new HashMap<>();

	// <-----------------------USE CASE 1-------------------------->
	/**
	 * Calculates the fare for a single ride based on distance and time.
	 *
	 * @desc This method takes the distance and time of a ride and calculates the
	 *       fare, ensuring it is not below the minimum fare.
	 * @param distance The distance traveled in kilometers.
	 * @param time     The time traveled in minutes.
	 * @return The calculated fare for the ride, ensuring it is not below the
	 *         minimum fare.
	 */
	public double calculateFare(double distance, int time) {
		double fare = distance * MINIMUM_FARE_PER_KM + time * MINIMUM_FARE_PER_MINUTE;
		return Math.max(fare, MINIMUM_FARE);
	}
	

	// <-----------------------USE CASE 2-------------------------->
	/**
	 * Calculates the total fare for multiple rides.
	 *
	 * @desc This method takes an array of Ride objects and calculates the total
	 *       fare for all rides.
	 * @param rides An array of Ride objects, each representing a ride with distance
	 *              and time.
	 * @return The total fare for all rides.
	 */
	public double calculateMultipleRideFair(Ride[] rides) {
		double fare = 0.0;
		for (Ride ride : rides) {
			fare += calculateFare(ride.distance, ride.time);
		}
		return fare;
	}
	

	// <-----------------------USE CASE 3-------------------------->
	/**
	 * Calculates the total fare and average fare per ride for multiple rides and
	 * returns an InvoiceSummary.
	 *
	 * @desc This method takes an array of Ride objects and calculates the total
	 *       fare and average fare per ride.
	 * @param rides An array of Ride objects, each representing a ride with distance
	 *              and time.
	 * @return An InvoiceSummary object containing the total number of rides, total
	 *         fare, and average fare per ride.
	 */
	public InvoiceSummary calculateMultipleRideFairReturnSummary(Ride[] rides) {
		double totalFare = calculateMultipleRideFair(rides);
		return new InvoiceSummary(rides.length, totalFare, (totalFare / rides.length));
	}
	
	// <-----------------------USE CASE 4-------------------------->
		/**
		 * Calculates and stores the fare for each ride in a map with distance as the
		 * key and fare as the value.
		 *
		 * @desc This method takes a user ID and an array of Ride objects, calculates
		 *       the fare for each ride, and stores it in a map.
		 * @param userId The user ID associated with the rides.
		 * @param rides  An array of Ride objects, each representing a ride with
		 *               distance and time.
		 * @return A map containing the distance as the key and fare as the value for
		 *         each ride.
		 */
		public Map<Double, Double> calculateRideInvoice(String userId, Ride[] rides) {
			for (Ride ride : rides) {
				double fare = calculateFare(ride.distance, ride.time);
				invoiceService.put(ride.distance, fare);
			}
			return invoiceService;
		}
		

}
