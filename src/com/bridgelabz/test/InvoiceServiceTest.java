package com.bridgelabz.test;

import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.bridgelabz.main.InvoiceService;
import com.bridgelabz.main.InvoiceSummary;
import com.brudgelabz.test.Ride;

class InvoiceServiceTest {
	// @desc: Setup method to initialize common objects or perform setup tasks
	// before each test.
	InvoiceService invoice;
	
	@BeforeEach
	public void setUp() {
		invoice = new InvoiceService();
	}
	
	
	@Test
	// @desc: Test to check the calculation of fare based on distance and time.
	// @params: Distance (double), Time (int)
	// @return: None

	void givenDistanceAndTimeCheckTheFare() {
		double distance = 5.0;
		int time = 10;
		double fare = invoice.calculateFare(distance, time);
		Assert.assertEquals(60.0, fare, 0.0);
	}

	@Test
	// @desc: Test to check the minimum fare when the given distance and time are
	// very low.
	// @params: Distance (double), Time (int)
	// @return: None

	void givenDistanceAndTimeCheckTheMinimumFare() {
		double distance = 0.1;
		int time = 1;
		double fare = invoice.calculateFare(distance, time);
		Assert.assertEquals(5, fare, 0.0);
	}



	@Test
	// @desc: Test to check the total fare for multiple rides.
	// @params: Array of Ride objects
	// @return: None

	void givenMultipleDistanceAndTimeCheckTotalFare() {
		InvoiceService invoice = new InvoiceService();
		Ride[] rides = { new Ride(2.0, 5), new Ride(5.0, 10), new Ride(1.0, 10) };
		double fare = invoice.calculateMultipleRideFair(rides);
		Assert.assertEquals(105, fare, 0.0);
	}
	
	@Test
	// @desc: Test to check the InvoiceSummary for multiple rides.
	// @params: Array of Ride objects
	// @return: None

	void givenMultipleDistanceAndTimeCheckSummary() {
		InvoiceService invoice = new InvoiceService();
		Ride[] rides = { new Ride(5.0, 10), new Ride(5.0, 10) };
		InvoiceSummary summary = invoice.calculateMultipleRideFairReturnSummary(rides);
		InvoiceSummary expectedSummary = new InvoiceSummary(2, 120.0, 60.0);

		Assert.assertEquals(summary.toString(), expectedSummary.toString());
	}
	

	@Test
	// @desc: Test to check the total fare for multiple rides.
	// @params: Array of Ride objects
	// @return: None

	void givenMultipleDistanceAndTimeCheckTotalFare() {
		InvoiceService invoice = new InvoiceService();
		Ride[] rides = { new Ride(2.0, 5), new Ride(5.0, 10), new Ride(1.0, 10) };
		double fare = invoice.calculateMultipleRideFair(rides);
		Assert.assertEquals(105, fare, 0.0);
	}

}
