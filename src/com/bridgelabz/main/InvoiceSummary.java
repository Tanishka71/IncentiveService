package com.bridgelabz.main;

public class InvoiceSummary {

	public int noOfRides;
	public double totalFare;
	public double averageFare;
	public String userId;
    
	public InvoiceSummary(int noOfRides, double totalFare, double averageFare) {
		this.noOfRides = noOfRides;
		this.totalFare = totalFare;
		this.averageFare = averageFare;

	}
	@Override
	public String toString(){
		return this.noOfRides+" "+this.totalFare+" "+this.averageFare;
	}

}
