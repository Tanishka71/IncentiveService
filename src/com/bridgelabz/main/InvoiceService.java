package com.bridgelabz.main;

import java.util.HashMap;
import java.util.Map;

import com.brudgelabz.test.Ride;

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

}
